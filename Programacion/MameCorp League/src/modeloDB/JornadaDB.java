/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Jornada;
import modelo.Liga;

/**
 *
 * @author 1gdaw03
 */
public class JornadaDB {
    
    private static ResultSet resultado;
    private static Statement st;
    private static Connection con;
    
    /**
     * Con este metodo obtenemos el objeto de la jornada
     * @param numeroJornada numero de la jornada(int)
     * @return retornamos el objeto jornada
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static Jornada getObjetoJornada(int numeroJornada) throws SQLException, Exception{
        
        GenericoDB.conectar(); 
        
        String plantilla = "select * from jornada where id_jornada = ?";
        PreparedStatement ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, numeroJornada);
        resultado = ps.executeQuery();
        
        if(resultado.next()){
            Jornada oJornada = new Jornada();
            oJornada.setIdJornada(resultado.getInt("id_jornada"));
            oJornada.setFechaInicio(resultado.getDate("fecha_inicio").toLocalDate());
            oJornada.setFechaFin(resultado.getDate("fecha_fin").toLocalDate());
            
            GenericoDB.cerrarCon();

            return oJornada;
        }
        
        GenericoDB.cerrarCon();
        return null;       
    }
    
    /**
     * Con este metodo consultamos todas las jornadas
     * @param oLiga objeto liga
     * @return retornamos un arraylist con las jorandas
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList<Jornada> consultarJornadas(Liga oLiga) throws SQLException, Exception{
        
        GenericoDB.conectar(); 
        
        st = GenericoDB.getCon().createStatement();
        resultado = st.executeQuery("select * from jornada");
        
        ArrayList<Jornada> listaJornadas = new ArrayList();
        Jornada oJornada;
        
        while(resultado.next()){
            oJornada = new Jornada();
            oJornada.setIdJornada(resultado.getInt("id_jornada"));
            oJornada.setFechaInicio(resultado.getDate("fecha_inicio").toLocalDate());
            oJornada.setFechaFin(resultado.getDate("fecha_fin").toLocalDate());
            oJornada.setoLiga(oLiga);
            
            listaJornadas.add(oJornada);
        }

        GenericoDB.cerrarCon();
        return listaJornadas;      
    }
    
    public static void generarCalendario() throws SQLException, Exception{
        System.out.println("estoy intentnado generarlo");
       GenericoDB.conectar();
       CallableStatement cStmt = GenericoDB.getCon().prepareCall("{call paquete_mamecorp.generar_calendario}");
        System.out.println("ya he hecho el callabe");
        // Parametros de entrada ´
        //cStmt. setString (1, "abcdefg");

        cStmt.execute();
        ResultSet rs = cStmt.getResultSet();
        GenericoDB.cerrarCon();
     }
        
    public static int countJornadas() throws SQLException, Exception{
        GenericoDB.conectar(); 
        
        st = GenericoDB.getCon().createStatement();
        resultado = st.executeQuery("select count(*) as contador from jornada");
        
        int countJornada = 0;
        if(resultado.next()){
            countJornada = resultado.getInt("contador");
        }

        GenericoDB.cerrarCon();
        return countJornada;
    }
}
