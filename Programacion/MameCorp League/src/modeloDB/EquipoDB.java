
package modeloDB;


import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Equipo;
import modelo.Partido;

public class EquipoDB {
    
    private static ResultSet resultado;
    private static PreparedStatement ps;
    private static Equipo oEquipo;
    private static Statement st;

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
    public static int modificarEquipo(int id_equipo,String nombre,int presupuesto,int puntos) throws Exception{
    
        GenericoDB.conectar();
        
        String plantilla = "update equipo set nombre=?,presupuesto=?,puntos=? where id_equipo=?";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, nombre);
        sentenciaPre.setInt(2, presupuesto);
        sentenciaPre.setInt(3, puntos);
        sentenciaPre.setInt(4, id_equipo);
    
        int update = sentenciaPre.executeUpdate();
        System.out.println(update);
        
        GenericoDB.cerrarCon();
        return update;
    }
    public static int borrarEquipo(int id_equipo,String nombre,int presupuesto,int puntos) throws Exception{
    
        GenericoDB.conectar();
        
        String plantilla = "delete from equipo where nombre=?";
        PreparedStatement sentenciaPre = GenericoDB.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(1, nombre);
        
        int delete = sentenciaPre.executeUpdate();
        System.out.println(delete);        
    
        GenericoDB.cerrarCon(); 
        
        return delete;

    }
    public static Equipo buscarEquipo(String nombre) throws Exception{
        
        GenericoDB.conectar();
        
        String plantilla = "Select * from equipo where nombre=?";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        resultado = ps.executeQuery();
        
        oEquipo = new Equipo();
        if(resultado.next()){
            oEquipo.setIdEquipo(resultado.getInt("id_equipo"));
            oEquipo.setNombre(resultado.getString("nombre"));
            oEquipo.setPresupuesto(resultado.getInt("presupuesto"));
            oEquipo.setPuntos(resultado.getInt("puntos"));  
        }
        return oEquipo;
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
    
     public static ArrayList<Equipo> consultarEquipoSinPresidente() throws Exception{

        GenericoDB.conectar(); 
        
        Statement sentencia = GenericoDB.getCon().createStatement();
        
        resultado = sentencia.executeQuery("select * from equipo where id_equipo NOT in (select equipo_id_equipo from presidente)");
        
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
     
    public static boolean updatePuntosEquipo(Partido oPartido) throws SQLException, Exception{
        
        GenericoDB.conectar();
        
        String plantilla = "update equipo set puntos = puntos + 3 where id_equipo = ?";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        
        ps.setInt(1, oPartido.getEquipoVencedor().getIdEquipo());
        int update = ps.executeUpdate();
        
        GenericoDB.cerrarCon();
        return update == 1;
    } 
    public static Equipo consultarEquipoPresidente(String idEquipo) throws SQLException{
        GenericoDB.conectar();
        String plantilla = "select * from equipo where nombre = ?";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        ps.setString(1, idEquipo);
        
        resultado = ps.executeQuery();
        Equipo e = new Equipo();
        
        if(resultado.next()){
            
            e.setIdEquipo(resultado.getInt("id_equipo"));
            e.setNombre(resultado.getString("nombre"));
            e.setPresupuesto(resultado.getInt("presupuesto"));
            e.setPuntos(resultado.getInt("puntos"));
            
        }
        return e;
    }
    
    public static ArrayList<Equipo> getClasificacion() throws SQLException, Exception{
        GenericoDB.conectar(); 
        
        Statement sentencia = GenericoDB.getCon().createStatement();
        
        resultado = sentencia.executeQuery("select e.id_equipo, e.nombre,e.presupuesto, e.puntos from equipo e join partido p ON e.id_equipo = p.vencedor where e.id_equipo = p.vencedor group by e.nombre, e.puntos, e.id_equipo, e.presupuesto order by count(p.vencedor) desc");
        
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
    public static Equipo consultarEquipoDelJugador(int equipo_id_equipo) throws SQLException, Exception{
        GenericoDB.conectar(); 

        st = GenericoDB.getCon().createStatement();
        String plantilla = "select * from equipo where id_equipo = ?";
        ps = GenericoDB.getCon().prepareStatement(plantilla);
        ps.setInt(1,equipo_id_equipo);

        resultado = ps.executeQuery();
        
        
        if(resultado.next()){
            oEquipo = new Equipo();
            oEquipo.setIdEquipo(resultado.getInt("id_equipo"));
            oEquipo.setNombre(resultado.getString("nombre"));
            oEquipo.setPresupuesto(resultado.getInt("presupuesto"));
            oEquipo.setPuntos(resultado.getInt("puntos"));
        }
        GenericoDB.cerrarCon();
        return oEquipo;
    }
    
    
}
