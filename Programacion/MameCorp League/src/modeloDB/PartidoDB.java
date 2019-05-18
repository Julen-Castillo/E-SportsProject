/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.PreparedStatement;
import modelo.Partido;

/**
 *
 * @author 1gdaw03
 */
public class PartidoDB {
    
    public static int insertarPartido(Partido oPartido){

        GenericoDB.conectar();
        
        String plantilla = "insert into partido (nombre,presupuesto,puntos)values (?,?,?)";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, e.getNombre());
        sentenciaPre.setInt(2, e.getPresupuesto());
        sentenciaPre.setInt(3, e.getPuntos());
        
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
       GenericoDB.cerrarCon();
       
       return insercion;
        
    }
    
}
