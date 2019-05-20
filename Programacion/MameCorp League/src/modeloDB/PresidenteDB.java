/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Equipo;
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
}