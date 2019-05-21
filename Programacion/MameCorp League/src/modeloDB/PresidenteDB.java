/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Presidente;

/**
 *
 * @author 1gdaw03
 */
public class PresidenteDB {
    
     private static ResultSet resultado;
     


          public static int insertarPresi(Presidente oPresidente)throws Exception{


   GenericoDB.conectar();

        String plantilla = "insert into presidente (nombre,apellido,equipo_id_equipo) values (?,?,?)";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, oPresidente.getNombre());
        sentenciaPre.setString(2, oPresidente.getApellido());
        sentenciaPre.setInt(3,oPresidente.getoEquipo().getIdEquipo());
        
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
       GenericoDB.cerrarCon();
      
       return insercion;
} 
          
          public static Presidente consultarPresidente(String nombre,String apellido) throws SQLException, Exception{
 
    GenericoDB.conectar();
    
         String plantilla = "select NOMBRE from presidente where NOMBRE = ? and APELLIDO = ?";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
         
          sentenciaPre.setString(1,nombre);
          sentenciaPre.setString(2, apellido);
          Presidente oPresidente = new Presidente();
          resultado = sentenciaPre.executeQuery();
          if(resultado.next()){
              oPresidente.setNombre(resultado.getString("NOMBRE"));
            
         
             
              PresidenteDB OPresidenteDB = new PresidenteDB();
            //  Equipo oEquipo = oEquipoDB.consultarTodos()
            //  oJugador.setoEquipo(resultado.getObject("EQUIPO"));
              
              GenericoDB.cerrarCon();
              return oPresidente;
          }
          GenericoDB.cerrarCon();
          return null;
}
          public static int borrarPresi(String nombre, String apellido) throws SQLException, Exception{
              
                GenericoDB.conectar();
                String plantilla = "delete from presidente where nombre = ? and apellido = ?";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
         sentenciaPre.setString(1, nombre);
         sentenciaPre.setString(2, apellido);
        
        int delete = sentenciaPre.executeUpdate();
        System.out.println(delete);        
    
      GenericoDB.cerrarCon();   
              
              return delete;
          }
}