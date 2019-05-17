
package modeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Sesion;


public class SesionDB {

    private static GenericoDB gdb;
    private static ResultSet resultado;

     public SesionDB() {
         
         gdb = new GenericoDB();
    }
    
    public static Sesion consultarUsuario() throws Exception{
    
        gdb.conectar();
         String plantilla = "select * from usuario where usuario=? and password=?";
         PreparedStatement sentenciaPre = gdb.getCon().prepareStatement(plantilla);
         
          sentenciaPre.setString(1,"usuario");
          sentenciaPre.setString(2,"password");
         
          Sesion oSesion = new Sesion();
          
          if(!resultado.next()){
              gdb.cerrarCon();
              return null;
          }else{
              oSesion.setNombreUsuario(resultado.getString("nombre"));
              oSesion.setPassword(resultado.getString("password"));
              oSesion.setTipoUsuario(resultado.getString("tipo"));
              gdb.cerrarCon();
              return oSesion;
          }
          
        
    }
    
}
