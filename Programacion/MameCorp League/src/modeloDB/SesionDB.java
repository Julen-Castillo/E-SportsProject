
package modeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Sesion;


public class SesionDB {


    private static ResultSet resultado;
    private static PreparedStatement sentenciaPre;

     public SesionDB() {
         
       
    }
    
     /**
      * con este metodo consultamos un usuario de la bd
      * @param usuario nombre del usuario(String)
      * @param password contraseña del usuario(String)
      * @return retornamos el objeto sesion 
      * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
      */
    public static Sesion consultarUsuario(String usuario, String password) throws Exception{
       
        GenericoDB.conectar();

        String plantilla = "select * from usuario where nombre = ? and password = ?";
        sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);

        sentenciaPre.setString(1,usuario);
        sentenciaPre.setString(2,password);

        Sesion oSesion = new Sesion();
        resultado = sentenciaPre.executeQuery();
        if(resultado.next()){
            oSesion.setNombreUsuario(resultado.getString("nombre"));
            oSesion.setPassword(resultado.getString("password"));
            oSesion.setTipoUsuario(resultado.getString("tipo"));
            GenericoDB.cerrarCon();
            return oSesion;
        }
        GenericoDB.cerrarCon();
        return null;

    }
    /**
     * insertamos un usuario administrador
     * @param nombre nombre del admin(String)
     * @param password contraseña del admin(String)
     * @return retornamos el numero de filas afectadas
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarAdministrador(String nombre,String password) throws SQLException, Exception{
         GenericoDB.conectar();
         
         String plantilla = "insert into usuario (nombre,password,tipo) values(?,?,'administrador')";
         sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
          sentenciaPre.setString(1,nombre);
          sentenciaPre.setString(2,password);
          
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
        GenericoDB.cerrarCon();
       
        return insercion;
    }
    /**
     * insertamos un usuario
     * @param nombre nombre del usuario(String)
     * @param password contraseña del usuario(String)
     * @return retornamos el numero de filas afectadas
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static int insertarUsuario(String nombre,String password) throws SQLException, Exception{
         GenericoDB.conectar();
         
         String plantilla = "insert into usuario (nombre,password,tipo) values(?,?,'user')";
         sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
          sentenciaPre.setString(1,nombre);
          sentenciaPre.setString(2,password);
          
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
        GenericoDB.cerrarCon();
       
        return insercion;
    }
}
