/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
       
        public void addUsers(User u){
        String req ="INSERT INTO user (firstname,lastname,phone,city,gouvernorat,male,role)"+"values (?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, u.getFirstname());
            ste.setString(2, u.getLastname());
            ste.setString(3, u.getPhone());
            ste.setString(4, u.getCity());
            ste.setString(5, u.getGouvernorat());
            ste.setString(6, u.getMail());
            ste.setString(7, u.getRole());
            ste.executeUpdate();
            System.out.println("Utilisateur ajouté");
            
        } catch (SQLException ex) {
            System.out.println("ereur ajout");
            
        }
        
    }
         public List<User> retrieveUser(){
    List<User> users = new ArrayList<>();
   
        try {
             String sql = "select * from user";
     
             ste = cnx.prepareStatement(sql);
             ResultSet rs = ste.executeQuery();
             while (rs.next()) {   
                 User u = new User(); 
                 u.setFirstname(rs.getString(1));
                 u.setLastname(rs.getString("lastname"));
                 u.setPhone(rs.getString("phone"));
                 u.setCity(rs.getString("city"));
                 u.setGouvernorat(rs.getString("gouvernorat"));
                 u.setMail(rs.getString("male"));
                 u.setRole(rs.getString("role"));
                 users.add(u);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    return  users;
    
}
          public void deleteUser(String phone){
        
            //String req = "DELETE FROM evenement WHERE (id="+id+")";
            String req = "DELETE FROM user WHERE user.phone="+phone;
            try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("User deleted");
        } catch (SQLException ex) {
                System.out.println("Erreur suppression user");
        }
    }
    
          
          public void updateUser(String phone, User user1){
        
        //String req = "UPDATE user SET WHERE user.phone="+phone;
        String req = "UPDATE user SET firstname=?,lastname=?,city=?,gouvernorat=?,male=? WHERE user.phone=" + phone;
        
        try{
            ste = cnx.prepareStatement(req);
            ste.setString(1, user1.getFirstname());
            ste.setString(2, user1.getLastname());
            ste.setString(3, user1.getCity());
            ste.setString(4, user1.getGouvernorat());
            ste.setString(5, user1.getMail());
            ste.executeUpdate();
            System.out.println("User updated");
            
        }
        catch(SQLException ex){
            System.out.println("Erreur update user");
            
        }
        
    }
}
