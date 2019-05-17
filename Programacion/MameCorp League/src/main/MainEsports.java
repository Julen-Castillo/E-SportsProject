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
    
    private static Sesion oSesion;
    
    
    public static void main(String[] args) throws SQLException {
    
        //La linea de abajo está comentada porque todavia no está implementado el login
       // ControladorVista.mostrarVentanaVisualizarLiga();
       GenericoDB.conectar();
          con =  GenericoDB.getCon();
          if(con != null)
          ControladorVista.mostrarLogin();
      //  ControladorVista.mostrarLogin();

    }
    public static void consultarEquipos() throws Exception{
        EquipoDB equipoDB = new EquipoDB();

        ArrayList<Equipo> listaEquipos = equipoDB.consultarTodos();

        for(int x=0; x < listaEquipos.size() ;x++){
            Equipo e = listaEquipos.get(x);
            
            System.out.println("nombre " + e.getNombre() + " presupuesto " + e.getPresupuesto()+ " puntos " + e.getPuntos() + "\n");
        }   
    }
         public static ArrayList consultarEquipoSinPresidente() throws Exception{
               EquipoDB equipoDB = new EquipoDB();

        ArrayList<Equipo> listaEquipos = equipoDB.consultarEquipoSinPresidente();

        for(int x=0; x < listaEquipos.size() ;x++){
            Equipo e = listaEquipos.get(x);
            
            System.out.println("nombre " + e.getNombre() + " presupuesto " + e.getPresupuesto()+ " puntos " + e.getPuntos() + "\n");
        }   
  
   return listaEquipos;
    }


    public static int insertarEquipos(String nombre,int presupuesto,int puntos) throws Exception{
    
        Equipo e = new Equipo(nombre,presupuesto,puntos);
        EquipoDB equipoDB = new EquipoDB();
        
        return equipoDB.insertarEquipo(e);  

    }  
    /* public static int insertarPresidente(String nombrePresidente, String apellidoPresidente,Equipo equipoPresidente) throws Exception {
       
        Presidente p = new Presidente(nombrePresidente,apellidoPresidente,equipoPresidente);
        PresidenteDB presidenteDB = new PresidenteDB();
       
        return presidenteDB.insertarPresi(p);
  
    }
      */

    public static Sesion comprobarLogin(String nombre,String password) throws Exception{
    
        oSesion = SesionDB.consultarUsuario(nombre,password);
        
        return oSesion;
    }
} 
