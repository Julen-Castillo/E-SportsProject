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
import modelo.Equipo;
import modelo.Jornada;
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
    
    public static int insertarPartidoSinVencedor(Partido oPartido) throws SQLException, Exception{

        GenericoDB.conectar();
        
        String plantilla = "insert into partido (equipo_id_equipo, jornada_id_jornada, equipo_visitante)values (?,?,?)";
        PreparedStatement ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, oPartido.getEquipoLocal().getIdEquipo());
        ps.setInt(2, oPartido.getoJornada().getIdJornada());
        ps.setInt(3, oPartido.getEquipoVisitante().getIdEquipo());
         
        int insercion = ps.executeUpdate();
        
        //GenericoDB.cerrarCon(); //Desactivada por problemas tecnicos

        return insercion;
    }
    
    
    
    public static ArrayList<Partido> consultarPartidos(ArrayList<Jornada> listaJornadas, ArrayList<Equipo> listaEquipos) throws SQLException, Exception{
        
        GenericoDB.conectar(); 
        
        st = GenericoDB.getCon().createStatement();
        resultado = st.executeQuery("select * from partido");
        
        ArrayList<Partido> listaPartidos = new ArrayList();
        Partido oPartido;
        
        while(resultado.next()){
            oPartido = new Partido();
            
            //Buscamos en el array listaequipos que equipo tiene el id_equipo que nos ha dado la base de datos. Cuando guardamos el objeto equipo.
            for(int i = 0; i < listaEquipos.size(); i++){
                if(resultado.getInt("equipo_id_equipo") == listaEquipos.get(i).getIdEquipo()){
                    oPartido.setEquipoLocal(listaEquipos.get(i));
                }
            }
            
            //Lo mismo para la jornada
            for(int i = 0; i < listaJornadas.size(); i++){
                if(resultado.getInt("jornada_id_jornada") == listaJornadas.get(i).getIdJornada()){
                    oPartido.setoJornada(listaJornadas.get(i));
                }
            }  
            
            //Lo mismo para el equipo visitante
            for(int i = 0; i < listaEquipos.size(); i++){
                if(resultado.getInt("equipo_visitante") == listaEquipos.get(i).getIdEquipo()){
                    oPartido.setEquipoVisitante(listaEquipos.get(i));
                }
            }
            
            //Lo mismo para el vencedor
            for(int i = 0; i < listaEquipos.size(); i++){
                if(resultado.getInt("vencedor") == listaEquipos.get(i).getIdEquipo()){
                    oPartido.setEquipoVencedor(listaEquipos.get(i));
                }
            }

            listaPartidos.add(oPartido);
        }

        GenericoDB.cerrarCon();
        return listaPartidos;      
    }
    
     public static int consultarCountPartidos() throws SQLException, Exception{
        GenericoDB.conectar(); 
        
        st = GenericoDB.getCon().createStatement();
        resultado = st.executeQuery("select count(*) from partido");

        int nPartidos = 0;
        if(resultado.next()){
            nPartidos = resultado.getInt("count(*)");
        }
        
        GenericoDB.cerrarCon();
        return nPartidos;     
    }
}
