package main;

import java.sql.SQLException;
import vistas.VentanaAdministradores;
import vistas.VentanaCategoria;
import vistas.VentanaUsuarios;


public class MainEsports {

    private static VentanaCategoria vCategoria;
    private static VentanaAdministradores vAdmin;
    private static VentanaUsuarios vUsuario;
    
    public static void main(String[] args) throws SQLException {
    
        //vCategoria = new VentanaCategoria();
        //vAdmin = new VentanaAdministradores();
        vUsuario = new VentanaUsuarios();
        

    }
}
