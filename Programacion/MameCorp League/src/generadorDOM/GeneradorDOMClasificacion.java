package generadorDOM;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import main.MainEsports;
import modelo.Equipo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class GeneradorDOMClasificacion {

    private List<Equipo> listaEquipos;
    private Document dom;
    private int ranking = 1;
    
    public static void main(String args[]) throws Exception {
        System.out.println("--- DOM (escritura) ---\n");
        new GeneradorDOMClasificacion().run();
    }
    
    //Constructor
    public GeneradorDOMClasificacion() throws Exception {

        // Lista para almacenar los objetos
        listaEquipos = new ArrayList<>();

        // Rellenar la lista con datos de prueba
        cargarDatos();

        // Construir un documento DOM vacÃ­o
        crearDocumento();
    }

    public void run() {
        System.out.println("Iniciando...");
        crearArbolDOM();
        exportarFichero();
        System.out.println("Fichero generado.");
    }

    private void cargarDatos() throws Exception {
        listaEquipos = MainEsports.getClasificacion();
    }

    private void crearDocumento() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();

            // REF: No hay esquema o DTD: https://stackoverflow.com/a/8438236
            dom.setXmlStandalone(true);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    private void crearArbolDOM() {
        
        LocalDate now = LocalDate.now();
        LocalDate siguienteJornada = now.plusDays(7);
        
        
        Element raiz = dom.createElement("clasificacion");
        raiz.setAttribute("fecha_actualizado", siguienteJornada.toString());
        dom.appendChild(raiz);
        
        //<equipos>
        Element elementoEquipos = dom.createElement("equipos");
        raiz.appendChild(elementoEquipos);
        
        for (Equipo oEquipo : listaEquipos) {
            Element elemento = crearElementoEquipo(oEquipo);
            elementoEquipos.appendChild(elemento);
            ranking++;
        }
    }

    private Element crearElementoEquipo(Equipo oEquipo) {
        
        
        // <equipo>
        Element elementoEquipo = dom.createElement("equipo");
        elementoEquipo.setAttribute("ranking", String.valueOf(ranking));

        // <nombre>
        Element elementoNombre = dom.createElement("nombre");

        // #PCDATA text nombre
        Text textoNombre = dom.createTextNode(oEquipo.getNombre());
        elementoNombre.appendChild(textoNombre);

        // </nombre>
        elementoEquipo.appendChild(elementoNombre);

        // <puntos>
        Element elementoPuntos = dom.createElement("puntos");

        // #PCDATA text puntos
        Text textoPuntos = dom.createTextNode(String.valueOf(oEquipo.getPuntos()));
        elementoPuntos.appendChild(textoPuntos);

        // </puntos>
        elementoEquipo.appendChild(elementoPuntos);

        
        return elementoEquipo;

        
    }

    private void exportarFichero() {

        // REF: Serializar XML: https://www.edureka.co/blog/serialization-of-java-objects-to-xml-using-xmlencoder-decoder/

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            // REF: Indentar la salida: https://stackoverflow.com/a/1264872
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            Result output = new StreamResult(new File("../clasificacion.xml"));
            Source input = new DOMSource(dom);

            transformer.transform(input, output);

        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    

}

