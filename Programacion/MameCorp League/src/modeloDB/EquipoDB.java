
package modeloDB;


import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Equipo;
import modelo.Partido;

public class EquipoDB {
    /**
     * Variables globales para la conexion de la BD
     */
    private static ResultSet resultado;
    private static PreparedStatement ps;
    private static Equipo oEquipo;
    private static Statement st;

    /**
     * Con este metodo insertamos un equipo en la BD
     * @param e recibimos un objeto equipo del controlador
     * @return retornamos el numero de filas afectadas
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * Con este metodo modificamos un equipo de la BD
     * @param id_equipo id de la bd(int)
     * @param nombre nombre del equipo nuevo(String)
     * @param presupuesto nuevo presupuesto del equipo(int)
     * @param puntos puntos del equipo(int)
     * @return retornamos el numero de filas afectadas
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * con este metodo borramos equipos existentes en la bd
     * @param id_equipo id de la bd(int)
     * @param nombre nombre del equipo nuevo(String)
     * @param presupuesto nuevo presupuesto del equipo(int)
     * @param puntos puntos del equipo(int)
     * @return retornamos el numero de filas afectadas
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * Con este metodo buscamos un equipo de la BD
     * @param nombre nombre del equipo(String)
     * @return retornamos un objeto 
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * Con este metodo consultamos todos los equipos de la BD
     * @return retornamos un ArrayList con todos los equipos
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * Con este metodo consultamos los equipos que no tienen presidente 
     * @return retornamos un ArrayList con los equipos encontrados
     * @throws Exception  controlamos las excepciones por si hubiese algun tipo de error
     */
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
     /**
      * Con este metodo actualizamos los puntos de un equipo
      * @param oPartido paritdo a actualizar
      * @return retornamos el numero de filas afectadas
      * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
      * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
      */
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
    /**
     * Con este metodo obtenemos la clasificacion
     * @return retornamos un arraylist
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
    /**
     * Con este metodo consultamos el equipo
     * @param equipo_id_equipo id del equipo
     * @return retornamos el objeto equipo
     * @throws SQLException controlamos las excepciones por si hubiese algun tipo de error
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
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
