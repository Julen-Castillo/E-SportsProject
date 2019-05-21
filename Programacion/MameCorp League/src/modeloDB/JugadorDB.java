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
    

    public static boolean insertarJugadores(Jugador oJugador) throws SQLException{
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
        
        return insercion == 1;
    }

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
    
    public static Jugador modificarJugador(String nickname,int sueldo, boolean titularidad,String posicion) throws SQLException{
        GenericoDB.conectar();
        String plantilla = "update jugador set NICKNAME = ?, SUELDO = ?, TITULARIDAD = ?, POSICION = ? ";
        sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1, nickname);
        sentenciaPre.setInt(2, sueldo);
        sentenciaPre.setBoolean(3, titularidad);
        sentenciaPre.setString(4, posicion);

        Jugador oJugador = new Jugador();
        resultado = sentenciaPre.executeQuery();
        // duda de que hacer ahora
          
    return null; //cambiar
}
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
