package main;

import java.sql.SQLException;
import vistas.*;



public class MainEsports {

    private static VentanaCategoria vCategoria;
    private static VentanaAdministradores vAdmin;
    private static VentanaModUsuarios vUsuario;
    
    public static void main(String[] args) throws SQLException {
    
        //La linea de abajo está comentada porque todavia no está implementado el login
       // ControladorVista.mostrarVentanaVisualizarLiga();
       
      ControladorVista.mostrarVentanaCategoria();
        

    }
}
