package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.*;
import modeloDB.*;
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
    public static void consultarEquipos() throws Exception{
        EquipoDB equipoDB = new EquipoDB();

        ArrayList<Equipo> listaEquipos = equipoDB.consultarTodos();

        for(int x=0; x < listaEquipos.size() ;x++){
            Equipo e = listaEquipos.get(x);
            
            System.out.println("nombre " + e.getNombre() + " presupuesto " + e.getPresupuesto()+ " puntos " + e.getPuntos() + "\n");
        }   

    }
    public static int insertarEquipos(String nombre,int presupuesto,int puntos) throws Exception{
    
        Equipo e = new Equipo(nombre,presupuesto,puntos);
        EquipoDB equipoDB = new EquipoDB();
        
        return equipoDB.insertarEquipo(e);
        

    }  
    
}
