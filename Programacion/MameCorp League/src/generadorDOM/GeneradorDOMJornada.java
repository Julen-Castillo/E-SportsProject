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
import modelo.Jornada;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Adrian
 */
public class GeneradorDOMJornada {
    
private List<Jornada> listaJornadas;
    private Document dom;
    private int idPartido;
    
    public static void main(String args[]) throws Exception {
        System.out.println("--- DOM (escritura) ---\n");
        new GeneradorDOMClasificacion().run();
    }
    
    //Constructor
    public GeneradorDOMJornada() throws Exception {

        // Lista para almacenar los objetos
        listaJornadas = new ArrayList<>();

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
        //Guardamos en el main el ArrayList con las jornadas
        MainEsports.consultarJornadas(); 
        //Lo llenamos con los partidos y lo devolvemos aqui
        listaJornadas = MainEsports.consultarPartidosDeCadaJornada();
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
        
        Element raiz = dom.createElement("jornadas");
        dom.appendChild(raiz);
        
        //<jornada>        
        for (Jornada oJornada : listaJornadas) {
            Element elementoJornada = crearElementoJornada(oJornada);
            raiz.appendChild(elementoJornada);
            idPartido++;
        }
    }

    private Element crearElementoJornada(Jornada oJornada) {
        
        
        // <jornada>
        Element elementoJornada = dom.createElement("jornada");
        elementoJornada.setAttribute("id", String.valueOf(idPartido));
        elementoJornada.setAttribute("fecha_inicio", oJornada.getFechaInicio().toString());
        elementoJornada.setAttribute("fecha_fin", oJornada.getFechaFin().toString());

        // <partidos>
        Element elementoPartidos = dom.createElement("partidos");

        // #PCDATA text nombre
//        Text textoNombre = dom.createTextNode(oEquipo.getNombre());
//        elementoNombre.appendChild(textoNombre);

       // 
       for(int i = 0; i < listaJornadas.size(); i++){
           for(int x = 0; i < listaJornadas.get(i).getListaPartidos().size()){
           
           }
           Element elementoPartido = crearElementoPartido(listaJornadas.get(i).getListaPartidos().get(i));
           elementoPartidos.appendChild(elementoPartido);
       }
       
       
       Element elementoJornada = crearElementoJornada(oJornada);
        for (Partido oPartido : listaJornadas.get(i)listaPartidos) {
            Element elementoJornada = crearElementoJornada(oJornada);
            raiz.appendChild(elementoJornada);
            idPartido++;
        }
        
        elementoPartido.appendChild(elementoPartidos);

        // </partidos>
        elementoJornada.appendChild(elementoPartidos);

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

