package main;

import java.sql.Connection;
import java.sql.SQLException;
import modeloDB.GenericoDB;
import vistas.*;



public class MainEsports {

    private static VentanaCategoria vCategoria;
    private static VentanaAdministradores vAdmin;
    private static VentanaModUsuarios vUsuario;
    private static Connection con;
    
    
    public static void main(String[] args) throws SQLException {
    
        //La linea de abajo está comentada porque todavia no está implementado el login
       // ControladorVista.mostrarVentanaVisualizarLiga();
       GenericoDB.conectar();
          con =  GenericoDB.getCon();
          if(con != null)
            ControladorVista.mostrarVentanaCategoria();
       
  

    }
}
