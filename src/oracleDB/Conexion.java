/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracleDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Cristian
 */
public class Conexion {
 
    
    
    public static Connection conect(){
        Connection connection=null;
        try{
            String driverClassName = "oracle.jdbc.driver.OracleDriver";
            String driverUrl="jdbc:oracle:thin:@localhost:1521:XE";//Change if you dont use OracleDB
            Class.forName(driverClassName);
            connection=DriverManager.getConnection(driverUrl,"PELIS","1234Qwer");//Change USER and PASSWORD.
            System.out.println("Conexión establecida");
        }
        catch(Exception e){
            System.out.println("Conexión No establecida");
            System.out.println(e.getMessage());
            
        }
        return connection;
    }

}
