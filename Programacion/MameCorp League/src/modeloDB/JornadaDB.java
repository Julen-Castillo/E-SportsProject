/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Jornada;

/**
 *
 * @author 1gdaw03
 */
public class JornadaDB {
    
    private static ResultSet resultado;
    
    public static Jornada getObjetoJornada(int numeroJornada) throws SQLException, Exception{
        
        GenericoDB.conectar(); 
        
        String plantilla = "select * from jornada where id_jornada = ?";
        PreparedStatement ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, numeroJornada);
        resultado = ps.executeQuery();
        
        if(resultado.next()){
            Jornada oJornada = new Jornada();
            System.out.println("METO CON RESULTADOOOOOO EEEEEL: " + resultado.getInt("id_jornada"));
            oJornada.setIdJornada(resultado.getInt("id_jornada"));
            oJornada.setFechaInicio(resultado.getDate("fecha_inicio").toLocalDate());
            oJornada.setFechaFin(resultado.getDate("fecha_fin").toLocalDate());
            
            GenericoDB.cerrarCon();
            System.out.println("jornada en dbbbbbbbbbbbb " + oJornada.getIdJornada());
            return oJornada;
        }
        
        GenericoDB.cerrarCon();
        return null;       
    }
}
