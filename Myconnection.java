/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.esprit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Myconnection {
    public String url ="jdbc:mysql://localhost:3306/bugbustersprojet";
    public String login="root";
    public String pwd ="";
    public Connection cnx;
    public static Myconnection ct;

    private Myconnection() {
        try {
           cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Cnx etablie");
        } catch (SQLException ex) {
            System.out.println("Problème de cnx");
            System.out.println(ex.getMessage());
        }
    
    }
    public Connection getConnection(){
        return cnx;
    }
    public static Myconnection getInstance(){
        if(ct == null)
            ct = new Myconnection();
        return ct;
        
    } 
    
    
}


