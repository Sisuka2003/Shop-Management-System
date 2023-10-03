/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class dbConnection {
    private static Connection conn;
    
    static Logger log = Logger.getLogger(dbConnection.class.getName());
    public static Connection getConnection(){
    String url="jdbc:mysql://localhost:3307/lkcarvings_software?useSSL=false";
    String username="root";
    String pswd="20030909";
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,pswd);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
        return conn;
    }
    
    
    public static void main(String[] args) {
        try {
            System.out.println("Database :" + getConnection().getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
}
