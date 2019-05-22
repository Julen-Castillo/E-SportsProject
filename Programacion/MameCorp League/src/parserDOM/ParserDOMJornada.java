package parserDOM;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import modelo.Equipo;
import modelo.Jornada;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author N3Essential
 */
public class ParserDOMJornada {
    private static Element elementoRaiz;
    private static ArrayList<Jornada> jornadas;
    
    
    public static void main(String args[]) throws Exception {
        run();
    }

    public static void run() {
        System.out.println("--- DOM (lectura) ---\n");

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            //InputSource datos = new InputSource(new StringReader(ReadXML.datosEquipos("../clasificacion.xml")));
            
            File datos = new File("../Jornada.xml");
            
            Document doc = dBuilder.parse(datos);
            doc.getDocumentElement().normalize();

            System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());
            
            elementoRaiz = doc.getDocumentElement();
            NodeList nodos = doc.getElementsByTagName("jornada");

            jornadas = new ArrayList<>();
            for (int i = 0; i < nodos.getLength(); i++) {
                System.out.println("jornada " + i);
                //Guardamos en el array de jornadas cada objeto jornada
                jornadas.add(getJornadas(nodos.item(i)));
            }
            
            //Mostramos por consola el array de jornadas
            for (Jornada oJornada : jornadas){
                System.out.println(oJornada.getIdJornada());
                System.out.println(oJornada.getFechaInicio());
                System.out.println(oJornada.getFechaFin());
            }

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
    
   

    private static Jornada getJornadas(Node nodo) {

        Jornada oJornada = new Jornada();

        if (nodo.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) nodo;
            
            //Atributos de jornada -> id, fecha inicio, fecha fin
            oJornada.setIdJornada(Integer.parseInt(element.getAttribute("id")));
            oJornada.setFechaInicio(LocalDate.parse(element.getAttribute("fecha_inicio")));
            oJornada.setFechaFin(LocalDate.parse(element.getAttribute("fecha_fin")));
            
            //set ArrayList partidos del objeto jornada
        }

        return oEquipo;
    }

    /**
     * Obtener el valor (#PCDATA) de un elemento del Ã¡rbol XML
     *
     * @param tag     La etiqueta del elemento
     * @param element Nodo de partida
     * @return Texto recuperado
     */
    
    
    private static String obtenerValor(String tag, Element element) {
        
        Node nodo;
        
        try{
            NodeList nodos = element.getElementsByTagName(tag).item(0).getChildNodes();
            nodo = nodos.item(0);
            System.out.println(tag);
        }
        catch(Exception e){
            System.out.println("NO EXISTE ESA ETIQUETA");
            return null;
        }
        
        return nodo.getNodeValue();
    }

    /**
     * Obtener un subelemento anidado a partir de otro dado
     *
     * @param tag     La etiqueta del elemento
     * @param element Nodo de partida
     * @return Subelemento recuperado
     */
    
    //NO LA ESTAMOS UTILIZANDO PORQUE NO HAY SUBNODOS
    private static Element obtenerSubelemento(String tag, Element element) {
        return (Element) element.getElementsByTagName(tag).item(0);
    }

    /**
     * Obtener el valor (#PCDATA) de un elemento del Ã¡rbol XML usando una expresiÃ³n XPath
     *
     * @param path    La ruta relativa del elemento
     * @param element Nodo de partida
     * @return Texto recuperado
     */
    private static String obtenerValorXPath(String path, Element element) {

        // REF: Obtener un valor XPath: https://stackoverflow.com/a/6539024

        XPath xPath = XPathFactory.newInstance().newXPath();

        String valor = null;

        try {
            NodeList nodes = (NodeList) xPath.evaluate(path, element, XPathConstants.NODESET);
            if (nodes.getLength() > 0) {
                Node node = nodes.item(0).getChildNodes().item(0);
                valor = node.getNodeValue();
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return valor;
    }
    
    public static ArrayList<Equipo> getListaEquipos(){
        return listaEquipos;
    }
    
    public static LocalDate getFechaActualizado(){
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActualizado = LocalDate.parse(elementoRaiz.getAttribute("fecha_actualizado"));
        return fechaActualizado;
    }
}
