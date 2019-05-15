
package modeloDB;


import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Equipo;

public class EquipoDB {
    
    private static GenericoDB gdb;
    private static ResultSet resultado;

    public EquipoDB() {
        
        gdb = new GenericoDB();    
    }
    public void insertarEquipo(String nombre,int presupuesto,int puntos) throws Exception{
        
        gdb.conectar();
        
        String plantilla = "insert into equipos values (?,?,?)";
        PreparedStatement sentenciaPre = gdb.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(0, nombre);
        sentenciaPre.setInt(1, presupuesto);
        sentenciaPre.setInt(2, puntos);
        
        int insercion = sentenciaPre.executeUpdate();
        System.out.println(insercion);
        
       gdb.cerrarCon();
    }
    public void modificarEquipo(int id_equipo,String nombre,int presupuesto,int puntos) throws Exception{
    
        gdb.conectar();
        
        String plantilla = "update equipos set nombre=?,presupuesto=?,puntos=? where id_equipo=?";
        PreparedStatement sentenciaPre = gdb.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setString(0, nombre);
        sentenciaPre.setInt(1, presupuesto);
        sentenciaPre.setInt(2, puntos);
        sentenciaPre.setInt(3, id_equipo);
    
        int update = sentenciaPre.executeUpdate();
        System.out.println(update);
        
        gdb.cerrarCon();
    }
    public void borrarEquipo(int id_equipo) throws Exception{
    
        gdb.conectar();
        
        String plantilla = "delete from equipos where id_equipo=?";
        PreparedStatement sentenciaPre = gdb.getCon().prepareStatement(plantilla);
        
        sentenciaPre.setInt(0, id_equipo);
        
        int delete = sentenciaPre.executeUpdate();
        System.out.println(delete);        
    
        gdb.cerrarCon();   
    }
    
    public ArrayList<Equipo> consultarTodos() throws Exception{
        
        
        gdb.conectar(); 
        
        Statement sentencia = gdb.getCon().createStatement();
        
        resultado = sentencia.executeQuery("select * from equipos");
        
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        while(resultado.next()){
            Equipo e = new Equipo();
            
            e.setIdEquipo(resultado.getInt("id_equipo"));
            e.setNombre(resultado.getString("nombre"));
            e.setPresupuesto(resultado.getInt("presupuesto"));
            e.setPuntos(resultado.getInt("puntos"));
            
            listaEquipos.add(e);
        }
        
        gdb.cerrarCon();
        
        return listaEquipos; 
    }
    
}