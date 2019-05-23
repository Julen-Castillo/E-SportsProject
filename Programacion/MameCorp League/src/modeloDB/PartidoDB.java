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
    private static PreparedStatement ps;
    
    /**
     * Con este metodo insertamos un partido
     * @param oPartido objeto partido
     * @return retornamos el numero de filas afectadas
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarPartido(Partido oPartido) throws SQLException, Exception{

        GenericoDB.conectar();
        
        String plantilla = "insert into partido (equipo_id_equipo, jornada_id_jornada, equipo_visitante, vencedor, fecha_inicio)values (?,?,?,?,?)";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        
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
    /**
     * con este metodo insertamos partidos sin vencedor
     * @param oPartido recibimos un partido
     * @return retornamos el numero de filas afectadas
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarPartidoSinVencedor(Partido oPartido) throws SQLException, Exception{

        GenericoDB.conectar();
        
        String plantilla = "insert into partido (equipo_id_equipo, jornada_id_jornada, equipo_visitante)values (?,?,?)";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, oPartido.getEquipoLocal().getIdEquipo());
        ps.setInt(2, oPartido.getoJornada().getIdJornada());
        ps.setInt(3, oPartido.getEquipoVisitante().getIdEquipo());
         
        int insercion = ps.executeUpdate();
        
        //GenericoDB.cerrarCon(); //Desactivada por problemas tecnicos

        return insercion;
    }
    
    
    /**
     * Con este metodo consultamos un partido
     * @param listaJornadas lista 
     * @param listaEquipos lista
     * @return retornamos un arraylist de partidos
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * Con este metodo contamos los partidos
     * @return retornamos el numero de partidos
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
     /**
      * con este metodo updateamos los vencedores no simulador
      * @param oPartido
      * @param oEquipo
      * @return retornamos un boolean
      * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
      * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
      */
    public static boolean updateVencedorNoSimulados(Partido oPartido, Equipo oEquipo) throws SQLException, Exception{
        
        GenericoDB.conectar(); 
        
        String plantilla = "update partido set vencedor = ? where equipo_id_equipo = ? AND equipo_visitante = ?";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, oEquipo.getIdEquipo()); //Puede sustituirse por el id del oEquipo que recibimos como param
        ps.setInt(2, oPartido.getEquipoLocal().getIdEquipo());
        ps.setInt(3, oPartido.getEquipoVisitante().getIdEquipo());
        
        int update = ps.executeUpdate();
        
        GenericoDB.cerrarCon(); 
        return update == 1;
        
    }
}
