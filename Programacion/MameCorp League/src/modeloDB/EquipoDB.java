
package modeloDB;


import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Equipo;
import modelo.Partido;

public class EquipoDB {
    
    private static ResultSet resultado;
    private static PreparedStatement ps;


    public int insertarEquipo(Equipo e) throws Exception{
        
        GenericoDB.conectar();
        
        String plantilla = "insert into equipo (nombre,presupuesto,puntos)values (?,?,?)";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, e.getNombre());
        sentenciaPre.setInt(2, e.getPresupuesto());
        sentenciaPre.setInt(3, e.getPuntos());
        
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
       GenericoDB.cerrarCon();
       
       return insercion;
    }
    public void modificarEquipo(int id_equipo,String nombre,int presupuesto,int puntos) throws Exception{
    
        GenericoDB.conectar();
        
        String plantilla = "update equipos set nombre=?,presupuesto=?,puntos=? where id_equipo=?";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, nombre);
        sentenciaPre.setInt(2, presupuesto);
        sentenciaPre.setInt(3, puntos);
        sentenciaPre.setInt(4, id_equipo);
    
        int update = sentenciaPre.executeUpdate();
        System.out.println(update);
        
        GenericoDB.cerrarCon();
    }
    public void borrarEquipo(String nombre) throws Exception{
    
        GenericoDB.conectar();
        
        String plantilla = "delete from equipos where nombre=?";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, nombre);
        
        int delete = sentenciaPre.executeUpdate();
        System.out.println(delete);        
    
        GenericoDB.cerrarCon();   
    }
    
    public static ArrayList<Equipo> consultarTodos() throws Exception{
        
        
        GenericoDB.conectar(); 
        
        Statement sentencia = GenericoDB.getCon().createStatement();
        
        resultado = sentencia.executeQuery("select * from equipo");
        
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        while(resultado.next()){
            Equipo e = new Equipo();
            
            e.setIdEquipo(resultado.getInt("id_equipo"));
            e.setNombre(resultado.getString("nombre"));
            e.setPresupuesto(resultado.getInt("presupuesto"));
            e.setPuntos(resultado.getInt("puntos"));
            
            listaEquipos.add(e);
        }
        
        GenericoDB.cerrarCon();
        
        return listaEquipos; 
    }
    
     public ArrayList<Equipo> consultarEquipoSinPresidente() throws Exception{

        GenericoDB.conectar(); 
        
        Statement sentencia = GenericoDB.getCon().createStatement();
        
        resultado = sentencia.executeQuery("select * from equipo where id_equipo not in (select equipo_id_equipo from presidente)");
        
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        while(resultado.next()){
            Equipo e = new Equipo();
            
            e.setIdEquipo(resultado.getInt("id_equipo"));
            e.setNombre(resultado.getString("nombre"));
            e.setPresupuesto(resultado.getInt("presupuesto"));
            e.setPuntos(resultado.getInt("puntos"));
            
            listaEquipos.add(e);
        }
        
        GenericoDB.cerrarCon();
        
        return listaEquipos; 
    }
     
    public static void updatePuntosEquipo(Partido oPartido) throws SQLException, Exception{
        
        GenericoDB.conectar(); 
        
        String plantilla = "update equipo set puntos = puntos + 3 where id_equipo = ?";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, oPartido.getEquipoVencedor().getIdEquipo());
        int insercion = ps.executeUpdate();
        
        GenericoDB.cerrarCon();   
    } 
}
