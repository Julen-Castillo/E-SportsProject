/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Liga;

/**
 *
 * @author 1gdaw03
 */
public class LigaDB {
    
    private static ResultSet resultado;
    
    public static Liga getObjetoLiga() throws SQLException, Exception{
        
        GenericoDB.conectar(); 

        Statement sentencia = GenericoDB.getCon().createStatement();
        resultado = sentencia.executeQuery("select * from liga where id_liga = 1");
        
        if(resultado.next()){
            Liga oLiga = new Liga();
            oLiga.setIdLiga(resultado.getInt("id_liga"));
            oLiga.setNombre(resultado.getString("nombre"));
            oLiga.setFechaInicio(resultado.getDate("fecha_inicio").toLocalDate());
            oLiga.setFechaFin(resultado.getDate("fecha_fin").toLocalDate());
            oLiga.setEnCurso(resultado.getBoolean("en_curso"));
            
            GenericoDB.cerrarCon();
            return oLiga;
        }
        
        GenericoDB.cerrarCon();
        return null;       
    }
}
