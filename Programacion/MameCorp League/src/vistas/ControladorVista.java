  /**
   * @author MameCorp
   * CONTROLADOR DE VISTAS
   * EL OBJETIVO DE ESTE CONTROLADOR ES MOSTRAR Y OCULTAR LAS VENTANAS 
   * DE NUESTRO PROYECTO, LIBERANDO ASI EL MAIN DEL PROYECTO
   */
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;


public class ControladorVista {
    /**
     * Aquí declaramos todas las variables de nuestras ventanas
     */
    private static VentanaAdministradores vAdmin;
    private static VentanaCategoria vCategoria;
    private static VentanaEquipos vEquipos;
    private static VentanaJugador vJugador;
    private static VentanaLiga vLiga;
    private static VentanaModUsuarios vModUsuarios;
    private static VentanaPresidente vModPresidente;
    private static VentanaUsuarios vUsuarios;
    private static VentanaVisualizarLiga vVisualizarLiga;
    private static VentanaVisualizarJornada vVisualizarJornada;
    private static VentanaVisualizarEquipos vVisualizarEquipos;
    private static Login vLogin;
    private static VentanaRegistroUsuarios vRegistroUsuarios;
    
    static int height;
    static int width;
    
    public static void ventanaCompleta(){
    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        height = pantalla.height;
        width = pantalla.width;
    }
    
    public static void simulacionCorrecta(){
        vCategoria.simulacionCorrecta();
    }
    
    public static void simulacionError(){
        vCategoria.simulacionError();
    }
    
    public static void emparejamientosCorrectos(){
        vCategoria.emparejamientosCorrectos();
    }
    
    
    /**
     * Ejemplo: con este metodo creamos la ventana vAdmin
     * y mostramos la ventana, para ello la ponemos en visible
     */
    public static void mostrarVentanaAdministradores(String opcionActiva){
        vAdmin = new VentanaAdministradores(opcionActiva);
        vAdmin.setVisible(true);
        
    }
    /**
     * Ejemplo: Con este metodo ocultamos la ventana vAdmin
     * para ello hacemos un dispose de la ventana
     */
    public static void OcultarVentanaAdministradores(){
        vAdmin.dispose();
    }
    public static void mostrarVentanaCategoria(){
        vCategoria = new VentanaCategoria();
        vCategoria.setVisible(true);
        vCategoria.setResizable(false);
        vCategoria.setLocationRelativeTo(null);
       
    }
    public static void OcultarVentanaCategoria(){
        vCategoria.dispose();
    }
    public static void mostrarVentanaEquipos(String operacionActiva) throws Exception{
        vEquipos = new VentanaEquipos(operacionActiva);
        vEquipos.setVisible(true);
        vEquipos.setResizable(false);
        vEquipos.setLocationRelativeTo(null);
    }
    public static void OcultarVentanaEquipos(){
        vEquipos.dispose();
    }
    public static void mostrarVentanaJugador(String operacionActiva) throws Exception{
        vJugador = new VentanaJugador(operacionActiva);
        vJugador.setVisible(true);
        vJugador.setResizable(false);
        vJugador.setLocationRelativeTo(null);
    } 
    public static void mostrarVentanaEquipos(){
        vEquipos = new VentanaEquipos();
        vEquipos.setVisible(true);
        vEquipos.setResizable(false);
        vEquipos.setLocationRelativeTo(null);
    }
    public static void OcultarVentanaJugador(){
        vJugador.dispose();
    }
    public static void mostrarVentanaLiga(String operacionActiva){
        vLiga = new VentanaLiga(operacionActiva);
        vLiga.setVisible(true);
        vLiga.setResizable(false);
        vLiga.setLocationRelativeTo(null);
    } 
    public static void OcultarVentanaLiga(){
        vLiga.dispose();
    }
    public static void mostrarVentanaModUsuarios(){
        vModUsuarios = new VentanaModUsuarios();
        vModUsuarios.setVisible(true);
        vModUsuarios.setResizable(false);
        vModUsuarios.setLocationRelativeTo(null);
    }
    public static void OcultarVentanaModUsuarios(){
        vModUsuarios.dispose();
    }
    public static void mostrarVentanaPresidente(String operacionActiva) throws Exception{
        vModPresidente = new VentanaPresidente(operacionActiva);
        vModPresidente.setVisible(true);
        vModPresidente.setResizable(false);
        vModPresidente.setLocationRelativeTo(null);
    }
    public static void OcultarVentanaPresidente(){
        vModPresidente.dispose();
    }
    public static void mostrarVentanaUsuarios(){
        vUsuarios = new VentanaUsuarios();
        vUsuarios.setVisible(true);
        vUsuarios.setResizable(false);
        vUsuarios.setLocationRelativeTo(null);
    }
    
    public static void OcultarVentanaUsuarios(){
        vUsuarios.dispose();
    }
    public static void mostrarVentanaVisualizarJornada() throws Exception{
        vVisualizarJornada = new VentanaVisualizarJornada();
        vVisualizarJornada.setVisible(true);
        vVisualizarJornada.setResizable(false);
        vVisualizarJornada.setLocationRelativeTo(null);
    }
    public static void mostrarVentanaVisualizarEquipos() throws Exception{
        vVisualizarEquipos = new VentanaVisualizarEquipos();
        vVisualizarEquipos.setVisible(true);
        vVisualizarEquipos.setResizable(false);
        vVisualizarEquipos.setLocationRelativeTo(null);
    }
    public static void mostrarVentanaVisualizarLiga() throws Exception{
        vVisualizarLiga = new VentanaVisualizarLiga();
        vVisualizarLiga.setVisible(true);
        vVisualizarLiga.setResizable(false);
        vVisualizarLiga.setLocationRelativeTo(null);
        
    }
    public static void OcultarVentanaVisualizarLiga(){
        vVisualizarLiga.dispose();
    }
    public static void OcultarVentanaVisualizarJornada(){
        vVisualizarJornada.dispose();
    }
    public static void mostrarLogin(){
        vLogin = new Login();
        vLogin.setVisible(true);
        vLogin.setResizable(false);
        vLogin.setSize(1135,620);
        vLogin.setLocationRelativeTo(null);
    }
    public static void OcultarLogin(){
        vLogin.dispose();
    }
    public static void mostrarVentanaRegistroUsuarios(){
        vRegistroUsuarios = new VentanaRegistroUsuarios();
        vRegistroUsuarios.setVisible(true);
        vRegistroUsuarios.setResizable(false);
        vRegistroUsuarios.setLocationRelativeTo(null);       
    }
        public static void OcultarVentanaRegistroUsuarios(){
        vRegistroUsuarios.dispose();
    }

    
    
}
