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
     private static GenericoDB gdb;
     private static ResultSet resultado;


        /*  public int insertarPresi(Presidente p)throws Exception{


   gdb.conectar();

        String plantilla = "insert into presidente values (?,?,?)";
        PreparedStatement sentenciaPre = gdb.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(0, p.getNombre());
        sentenciaPre.setString(1, p.getApellido());
        sentenciaPre.setInt(2, p.getEquipo());
        
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
       gdb.cerrarCon();
      
       return insercion;
}*/ 
}