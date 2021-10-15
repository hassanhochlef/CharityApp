/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Connection.MyConnection;
import esprit1.Don;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

//import java.util.Date;


/**
 *
 * @author Hassan
 */
public class DonationCrud {
     public Connection cnx;
public PreparedStatement ste;
public DonationCrud(){
        cnx = MyConnection.getInstance().getConnection();
        
}
public void AjouterDons(Don d){
    try {
        String sql="insert into don(Categorie,Montant,DonationDate)" + "values(?,?,?)";
        ste =cnx.prepareStatement(sql);
        ste.setString(1,d.getCategorie());
        ste.setFloat(2,d.getMontant());
        ste.setDate(3, (Date) d.getDonationDate());
        ste.executeUpdate();
        System.out.println("\nSucces d'ajout");
    } catch (SQLException ex) {
       System.out.println(ex.getMessage());
       System.out.println("no");
    }
    }
public List<Don> afficherDons(){
        List<Don> donation = new ArrayList<>() ;
    try {
        
        String sql = "Select * from don";
        ResultSet rs ;
        ste = cnx.prepareStatement(sql);
        rs = ste.executeQuery();
        
        while (rs.next()) {
            
            Don p = new Don() ;
            p.setDonId(rs.getInt("donId"));
            p.setCategorie(rs.getString(2));
            
            p.setMontant(rs.getFloat(3));
            p.setDonationDate(rs.getDate(4));
            donation.add(p);
            
    }
        System.out.println(donation);
    } 
        catch (SQLException ex) {
        Logger.getLogger(DonationCrud.class.getName()).log(Level.SEVERE, null, ex);
    }
    return donation;
}
public List<Don> SupprimerDons(){
        List<Don> donation = new ArrayList<>() ;
    try {
        
       String sql = "DELETE FROM don WHERE donId=?";
    
PreparedStatement statement = cnx.prepareStatement(sql);
statement.setInt(1, 7);
 
int rowsDeleted = statement.executeUpdate();
if (rowsDeleted > 0) {
    System.out.println("A donation was deleted successfully!");
}
        
       
        System.out.println(donation);
    } 
        catch (SQLException ex) {
        Logger.getLogger(DonationCrud.class.getName()).log(Level.SEVERE, null, ex);
    }
    return donation;
}
public List<Don> ModifierDons(){
        List<Don> donation = new ArrayList<>() ;
    try {
        
       String sql = "UPDATE don SET Categorie=?,Montant=?,DonationDate=? where donId=5";
    
PreparedStatement statement = cnx.prepareStatement(sql);

statement.setInt(1,300);
statement.setFloat(2,800);

 
int rowsDeleted = statement.executeUpdate();
if (rowsDeleted > 0) {
    System.out.println("A donation was updated!");
}
        
       
        System.out.println(donation);
    } 
        catch (SQLException ex) {
        Logger.getLogger(DonationCrud.class.getName()).log(Level.SEVERE, null, ex);
    }
    return donation;
}

       
   

    
}
