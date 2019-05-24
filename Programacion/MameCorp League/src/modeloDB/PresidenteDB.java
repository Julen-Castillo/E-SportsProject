/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Presidente;

/**
 *
 * @author 1gdaw03
 */
public class PresidenteDB {
    
     private static ResultSet resultado;
     private static PreparedStatement sentencieaPre;
     private static ArrayList<Presidente> listaPresidentes;
     

/**
 * Con este metodo insertamos un presidente
 * @param oPresidente recibimos un objeto
 * @return retornamos el numero de filas afectadas
 * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
 */
    public static int insertarPresi(Presidente oPresidente)throws Exception{
        GenericoDB.conectar();

        String plantilla = "insert into presidente (nombre,apellido,equipo_id_equipo) values (?,?,?)";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, oPresidente.getNombre());
        sentenciaPre.setString(2, oPresidente.getApellido());
        sentenciaPre.setInt(3,oPresidente.getoEquipo().getIdEquipo());
        
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
       GenericoDB.cerrarCon();
      
       return insercion;
} 
  /**
   * con este metodo cosultamos un presidente
   * @param nombre nombre del presidente(String)
   * @param apellido apellido del presidente(String)
   * @return retornamos el objeto
   * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
   * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
   */        
    public static Presidente consultarPresidente(String nombre,String apellido) throws SQLException, Exception{
 
        GenericoDB.conectar();
    
        String plantilla = "select NOMBRE from presidente where NOMBRE = ? and APELLIDO = ?";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
         
          sentenciaPre.setString(1,nombre);
          sentenciaPre.setString(2, apellido);
          Presidente oPresidente = new Presidente();
          resultado = sentenciaPre.executeQuery();
          if(resultado.next()){
              oPresidente.setNombre(resultado.getString("NOMBRE"));

              PresidenteDB OPresidenteDB = new PresidenteDB();
            //  Equipo oEquipo = oEquipoDB.consultarTodos()
            //  oJugador.setoEquipo(resultado.getObject("EQUIPO"));
              
            GenericoDB.cerrarCon();
            return oPresidente;
          }
          GenericoDB.cerrarCon();
          return null;
    }
    /**
     * con este metodo borramos un presidente
     * @param nombre nombre del presidente a borrar(String)
     * @param apellido apellido del presidente a boorar(String)
     * @return retornamos el numero de finas afectadas
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static boolean borrarPresi(String nombre, String apellido) throws SQLException, Exception{

            GenericoDB.conectar();
            String plantilla = "delete from presidente where nombre = ? and apellido = ?";
            PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
            sentenciaPre.setString(1, nombre);
            sentenciaPre.setString(2, apellido);

            int delete = sentenciaPre.executeUpdate();
            System.out.println(delete);        

             GenericoDB.cerrarCon();   

            return delete == 1;
    }
    /**
     * consultamos el presidente del equipo
     * @param idEquipo id del equipo a buscar(int)
     * @return retornamos un arraylist de presidenet
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static ArrayList<Presidente> consultarPresidentesDelEquipo(int idEquipo) throws SQLException, Exception{
    
    GenericoDB.conectar();
    
    String plantilla = "select * from presidente where equipo_id_equipo = ?";
    sentencieaPre = GenericoDB.getCon().prepareStatement(plantilla);
    
    sentencieaPre.setInt(1, idEquipo);
    
    resultado = sentencieaPre.executeQuery();
    listaPresidentes = new ArrayList<>();
    while(resultado.next()){
        
       Presidente oPresidente = new Presidente();
        
        oPresidente.setIdPresidente(resultado.getInt("id_presidente"));
        oPresidente.setNombre(resultado.getString("nombre"));
        oPresidente.setApellido(resultado.getString("nombre"));

        listaPresidentes.add(oPresidente);
    } 
    GenericoDB.cerrarCon();
   
      return listaPresidentes;
}
}