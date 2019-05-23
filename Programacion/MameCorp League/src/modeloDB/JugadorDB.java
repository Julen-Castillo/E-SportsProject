/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.MainEsports;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author 1gdaw03
 */
public class JugadorDB {
    private static ResultSet resultado;
    private static PreparedStatement sentenciaPre;
    private static Statement st;
    private static ArrayList<Jugador> listaJugador;
    private static Equipo oEquipo;
    
    /**
     * con este metodo insertamos un jugador en la bd
     * @param oJugador objeto jugador 
     * @return retornamos un boolean para controlar la insert
     * @throws SQLException  controlamos las excepciones por si hubiese algun tipo de error
     */
    public static boolean insertarJugadores(Jugador oJugador) throws SQLException, Exception{
        
        GenericoDB.conectar();
        
        String plantilla = "Insert into jugador(nombre, apellido, nickname, posicion, sueldo, titularidad, equipo_id_equipo) values(?,?,?,?,?,?,?)";
        sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, oJugador.getNombre());
        sentenciaPre.setString(2, oJugador.getApellido());
        sentenciaPre.setString(3, oJugador.getNickname());
        sentenciaPre.setString(4, oJugador.getPosicion());
        sentenciaPre.setInt(5, oJugador.getSueldo());
        if(oJugador.isTitularidad()){
            sentenciaPre.setInt(6, 1);
        }
        else{
            sentenciaPre.setInt(6, 0);
        }
        sentenciaPre.setInt(7, oJugador.getoEquipo().getIdEquipo());
        
        int insercion = sentenciaPre.executeUpdate();
        
        GenericoDB.cerrarCon();
        return insercion == 1;
    }
    /**
     * Con este metodo consultamos un jugador
     * @param nick nickname del jugador a buscar(String)
     * @return retornamos un objeto del jugador
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static Jugador consultarJugador(String nick) throws SQLException, Exception{
 
        GenericoDB.conectar();
    
        String plantilla = "select * from jugador where NICKNAME = ?";
        sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);

         sentenciaPre.setString(1,nick);
         Jugador oJugador = new Jugador();
         resultado = sentenciaPre.executeQuery();
         if(resultado.next()){
            oJugador.setNombre(resultado.getString("NOMBRE"));
            oJugador.setApellido(resultado.getString("APELLIDO"));
            oJugador.setNickname(resultado.getString("NICKNAME"));
            oJugador.setPosicion(resultado.getString("POSICION"));
            oJugador.setSueldo(resultado.getInt("SUELDO"));
            oJugador.setTitularidad(resultado.getBoolean("TITULARIDAD"));
            
            oEquipo = MainEsports.buscarEquipoDelJugador(resultado.getInt("EQUIPO_ID_EQUIPO"));
            oJugador.setoEquipo(oEquipo);

            
            GenericoDB.cerrarCon();
            return oJugador;
         }
         GenericoDB.cerrarCon();
         return oJugador;
    }
    /**
     * Con este metodo actualizamos los datos de un jugaor
     * @param nickname nickname del jugador(String)
     * @param sueldo nuevo sueldo(int)
     * @param titularidad nueva posicion(boolean)
     * @param posicion nueva posicion(String)
     * @return retornamos el objeto
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     */
    public static boolean modificarJugador(String nickname,int sueldo, boolean titularidad,String posicion, String nicknameAntiguo) throws SQLException, Exception{
        GenericoDB.conectar();
        String plantilla = "update jugador set NICKNAME = ?, SUELDO = ?, TITULARIDAD = ?, POSICION = ? where nickname = ?";
        sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1, nickname);
        sentenciaPre.setInt(2, sueldo);
        sentenciaPre.setBoolean(3, titularidad);
        sentenciaPre.setString(4, posicion);
        sentenciaPre.setString(5, nicknameAntiguo);

        Jugador oJugador = new Jugador();
        int update = sentenciaPre.executeUpdate();
        GenericoDB.cerrarCon();
        
        return update == 1;  
}
    /**
     * con este metodo damos de baja un jugador
     * @param nickname nickname del jugador a borrar(String)
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
public static void darBajaJugador(String nickname) throws SQLException, Exception{
    
    GenericoDB.conectar();
    String plantilla = "delete from jugador where NICKNAME = ?";
    sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
    sentenciaPre.setString(1, nickname);

    int delete = sentenciaPre.executeUpdate();
    System.out.println(delete);        
    
    GenericoDB.cerrarCon();   
}

//public static ArrayList<Jugador> consultarJugador() throws SQLException, Exception{
//    GenericoDB.conectar();
//    String plantilla = "select * from jugador";
//    st = GenericoDB.getCon().createStatement();
//    resultado = st.executeQuery(plantilla);
//    ArrayList<Jugador> listaJugadores = new ArrayList<>();
//    while(resultado.next()){
//        Jugador oJugador = new Jugador();
//        oJugador.setNickname(resultado.getString("nickname"));
//    
//        MainEsports.consultarEquipoDelJugador(resultado.getInt("equipo_id_equipo"));
//        
//        
//        listaJugadores.add(oJugador);
//
//        GenericoDB.cerrarCon();
//          return listaJugadores; 
//}
//        return null;
//}
/**
 * Con este metodo consultamos el equipo al que pertenece el jugador
 * @param idEquipo id del equipo
 * @return retornamos un arraylist de jugador 
 * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
 * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
 */
public static ArrayList<Jugador> consultarJugadorDelEquipo(int idEquipo) throws SQLException, Exception{
    
    GenericoDB.conectar();
    
    String plantilla = "select * from jugador where equipo_id_equipo = ?";
    sentenciaPre  = GenericoDB.getCon().prepareStatement(plantilla);
    
    sentenciaPre.setInt(1, idEquipo);
    
    resultado = sentenciaPre.executeQuery();
    listaJugador = new ArrayList<>();
    while(resultado.next()){
        
        Jugador oJugador = new Jugador();
        
        oJugador.setIdJugador(resultado.getInt("id_jugador"));
        oJugador.setNombre(resultado.getString("nombre"));
        oJugador.setApellido(resultado.getString("apellido"));
        oJugador.setNickname(resultado.getString("nickname"));
        oJugador.setPosicion(resultado.getString("posicion"));
        oJugador.setSueldo(resultado.getInt("sueldo"));
        oJugador.setTitularidad(resultado.getBoolean("titularidad")); 
        
        listaJugador.add(oJugador);
    } 
    GenericoDB.cerrarCon();
   
      return listaJugador;
}
}
