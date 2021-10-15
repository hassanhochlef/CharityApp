/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import utils.MyConnection;
import java.sql.Connection;
import entities.User;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class UserServices {
        private Connection cnx;
        private PreparedStatement ste;

        
        
        public UserServices() {
        cnx = MyConnection.getInstance().getConnection();
    }

        
        public void addUser(User u){
        String req ="INSERT INTO user (name,password,city,gouvernorat,phone,mail,role,montant_donne)"+"values (?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, u.getName());
            ste.setString(2, u.getPassword());
            ste.setString(3, u.getCity());
            ste.setString(4, u.getGouvernorat());
            ste.setString(5, u.getPhone());
            ste.setString(6, u.getMail());
            ste.setString(7, u.getRole());
            ste.setFloat(8, u.getMontant_donne());
            ste.executeUpdate();
            System.out.println("User added");
            
        } catch (SQLException ex) {
            System.out.println("error add");
            
        }
        
    }
        public List<User> retrieveallUser(){
    List<User> users = new ArrayList<>();
   
        try {
             String sql = "select * from user";
     
             ste = cnx.prepareStatement(sql);
             ResultSet rs = ste.executeQuery();
             while (rs.next()) {   
                 User u = new User(); 
                 u.setUserId(rs.getInt(1));
                 u.setName(rs.getString("name"));
                 u.setCity(rs.getString("city"));
                 u.setGouvernorat(rs.getString("gouvernorat"));
                  u.setPhone(rs.getString("phone"));
                 u.setMail(rs.getString("mail"));
                 u.setRole(rs.getString("role"));
                  u.setMontant_donne(rs.getFloat("montant_donne"));
                 users.add(u);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    return  users;
    
}
}
