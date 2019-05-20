  /**
   * @author MameCorp
   * CONTROLADOR DE VISTAS
   * EL OBJETIVO DE ESTE CONTROLADOR ES MOSTRAR Y OCULTAR LAS VENTANAS 
   * DE NUESTRO PROYECTO, LIBERANDO ASI EL MAIN DEL PROYECTO
   */
package vistas;


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
    }
    public static void OcultarVentanaCategoria(){
        vCategoria.dispose();
    }
    public static void mostrarVentanaEquipos(String operacionActiva){
        vEquipos = new VentanaEquipos(operacionActiva);
        vEquipos.setVisible(true);
    }
    public static void OcultarVentanaEquipos(){
        vEquipos.dispose();
    }
    public static void mostrarVentanaJugador(String operacionActiva) throws Exception{
        vJugador = new VentanaJugador(operacionActiva);
        vJugador.setVisible(true);
    } 
    public static void OcultarVentanaJugador(){
        vJugador.dispose();
    }
    public static void mostrarVentanaLiga(String operacionActiva){
        vLiga = new VentanaLiga(operacionActiva);
        vLiga.setVisible(true);
    } 
    public static void OcultarVentanaLiga(){
        vLiga.dispose();
    }
    public static void mostrarVentanaModUsuarios(){
        vModUsuarios = new VentanaModUsuarios();
        vModUsuarios.setVisible(true);
    }
    public static void OcultarVentanaModUsuarios(){
        vModUsuarios.dispose();
    }
    public static void mostrarVentanaPresidente(String operacionActiva) throws Exception{
        vModPresidente = new VentanaPresidente(operacionActiva);
        vModPresidente.setVisible(true);
    }
    public static void OcultarVentanaPresidente(){
        vModPresidente.dispose();
    }
    public static void mostrarVentanaUsuarios(){
        vUsuarios = new VentanaUsuarios();
        vUsuarios.setVisible(true);
    }
    
    public static void OcultarVentanaUsuarios(){
        vUsuarios.dispose();
    }
    public static void mostrarVentanaVisualizarJornada() throws Exception{
        vVisualizarJornada = new VentanaVisualizarJornada();
        vVisualizarJornada.setVisible(true);
    }
    public static void mostrarVentanaVisualizarEquipos(){
        vVisualizarEquipos = new VentanaVisualizarEquipos();
        vVisualizarEquipos.setVisible(true);
    }
    public static void mostrarVentanaVisualizarLiga(){
        vVisualizarLiga = new VentanaVisualizarLiga();
        vVisualizarLiga.setVisible(true);
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
    }
    public static void OcultarLogin(){
        vLogin.dispose();
    }
    public static void mostrarVentanaRegistroUsuarios(){
        vRegistroUsuarios = new VentanaRegistroUsuarios();
        vRegistroUsuarios.setVisible(true);
    }
        public static void OcultarVentanaRegistroUsuarios(){
        vRegistroUsuarios.dispose();
    }

    
    
}
