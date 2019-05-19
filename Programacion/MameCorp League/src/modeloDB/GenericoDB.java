/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDB;

import java.sql.*;


public class GenericoDB {
    
    private static  Connection con;

    public static void conectar(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //String url="jdbc:oracle:thin:@SrvOracle:1521:orcl";
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            // String url="jdbc:oracle:thin:oracle_clase:1521:db12102";
            con = DriverManager.getConnection(url,"course","x");
            //con = DriverManager.getConnection(url,"eqdaw01","eqdaw01");
            // con = DriverManager.getConnection(url,"sys","oracle");

            //Casa
            //String url="jdbc:oracle:thin:@10.10.10.9:1521:db12102";
            //con = DriverManager.getConnection(url,"eqdaw01","eqdaw01");

            //Clase
            //String url="jdbc:oracle:thin:@SrvOracle:1521:orcl";
            // //con = DriverManager.getConnection(url,"sys","oracle");
    } catch (Exception e){
        System.out.println("Problemas con la base de datos, no es culpa nuestra, es de egibide");
        System.out.println(e.getClass() + e.getMessage());
        System.exit(0);
    }
}

    public static Connection getCon(){
        return con;
    }
    public static void cerrarCon()throws Exception{
        con.close();
    }    
}