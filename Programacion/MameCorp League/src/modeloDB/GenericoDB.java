/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.*;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;


public class GenericoDB {
    
    private static  Connection con;
    /**
     * Con el metodo conectar nos conectamos a la bd de egibide, las lineas comentadas hacen referencia a otras bd
     */
    public static void conectar(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //String url="jdbc:oracle:thin:@SrvOracle:1521:orcl";
            // String url="jdbc:oracle:thin:oracle_clase:1521:db12102";
            //con = DriverManager.getConnection(url,"eqdaw01","eqdaw01");
            // con = DriverManager.getConnection(url,"sys","oracle");
            
            //Conexiones adri

           String url="jdbc:oracle:thin:@localhost:1521:xe";
           con = DriverManager.getConnection(url,"course","myipod12");
                    
           
            //Casa Casti
        // OracleDataSource ods = new OracleDataSource();
        // ods.setURL("jdbc:oracle:thin:@//localhost:1521/XEPDB1"); // jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
        // ods.setUser("course"); // [username]
        // ods.setPassword("course"); // [password]
        // con = ods.getConnection();
        
          //// con = DriverManager.getConnection(url,"course","course");
                


            //Casa PETO
            //String url="jdbc:oracle:thin:@10.10.10.9:1521:db12102";
            //con = DriverManager.getConnection(url,"eqdaw01","eqdaw01");

            //Clase
//            String url="jdbc:oracle:thin:@SrvOracle:1521:orcl";
//            con = DriverManager.getConnection(url,"eqdaw01","eqdaw01");
            
    } catch (Exception e){
        System.out.println("Problemas con la base de datos, no es culpa nuestra, es de egibide");
        System.out.println(e.getClass() + e.getMessage());
        System.exit(0);
    }
}
    /**
     * con este metodo obtenemos la conexion
     * @return  retornamos la conexion
     */
    public static Connection getCon(){
        return con;
    }
    /**
     * con este metodo cerramos la conexion de la bd
     * @throws Exception controlamos las excepciones por si hubiese algun tipo de error
     */
    public static void cerrarCon()throws Exception{
        con.close();
    }    
}