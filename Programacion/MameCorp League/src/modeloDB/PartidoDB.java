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
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Jornada;
import modelo.Liga;
import modelo.Partido;

/**
 *
 * @author 1gdaw03
 */
public class PartidoDB {
    
    private static ResultSet resultado;
    private static Statement st;
    
    public static int insertarPartido(Partido oPartido) throws SQLException, Exception{

        GenericoDB.conectar();
        
        String plantilla = "insert into partido (equipo_id_equipo, jornada_id_jornada, equipo_visitante, vencedor, fecha_inicio)values (?,?,?,?,?)";
        PreparedStatement ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, oPartido.getEquipoLocal().getIdEquipo());
        ps.setInt(2, oPartido.getoJornada().getIdJornada());
        ps.setInt(3, oPartido.getEquipoVisitante().getIdEquipo());
        ps.setInt(4, oPartido.getEquipoVencedor().getIdEquipo());
        LocalDate sysdate = LocalDate.now();
        ps.setDate(5, Date.valueOf(sysdate));
         
        int insercion = ps.executeUpdate();
        
        //GenericoDB.cerrarCon(); //Desactivada por problemas tecnicos

        return insercion;
    }
    
    public static ArrayList<Partido> consultarPartidos(Liga oLiga) throws SQLException, Exception{
        
        GenericoDB.conectar(); 
        
        st = GenericoDB.getCon().createStatement();
        resultado = st.executeQuery("select * from partido");
        
        ArrayList<Partido> listaPartidos = new ArrayList();
        Partido oPartido;
        
        while(resultado.next()){
            oPartido = new Partido();
          //  oPartido.setEquipoLocal(resultado.getInt("equipo_id_equipo"));
            
          //  select de ese equipo

            
            listaPartidos.add(oPartido);
        }

        GenericoDB.cerrarCon();
        return listaPartidos;      
    }
}
