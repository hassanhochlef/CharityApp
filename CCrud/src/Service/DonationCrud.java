/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Connection.MyConnection;
import esprit1.Donation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public void AjouterDons(Donation d){
    try {
        String sql="insert into donsliquide(numRecu,montant,date)" + "values(?,?,?)";
        ste =cnx.prepareStatement(sql);
        ste.setString(1,d.getNum_recu());
        ste.setFloat(2,d.getMontant());
        ste.setString(3,d.getDate());
        ste.executeUpdate();
        System.out.println("\nSucces d'ajout");
    } catch (SQLException ex) {
       System.out.println(ex.getMessage());
       System.out.println("no");
    }
    }
public List<Donation> afficherDons(){
        List<Donation> donation = new ArrayList<>() ;
    try {
        
        String sql = "Select * from donsliquide";
        ResultSet rs ;
        ste = cnx.prepareStatement(sql);
        rs = ste.executeQuery();
        
        while (rs.next()) {
            
            Donation p = new Donation() ;
            p.setID(rs.getInt("donationID"));
            p.setNum_recu(rs.getString(2));
            
            p.setMontant(rs.getFloat(3));
            p.setDate(rs.getString(4));
            donation.add(p);
            
    }
        System.out.println(donation);
    } 
        catch (SQLException ex) {
        Logger.getLogger(DonationCrud.class.getName()).log(Level.SEVERE, null, ex);
    }
    return donation;
}
public List<Donation> SupprimerDons(){
        List<Donation> donation = new ArrayList<>() ;
    try {
        
       String sql = "DELETE FROM donsliquide WHERE donationID=?";
    
PreparedStatement statement = cnx.prepareStatement(sql);
statement.setInt(1, 6);
 
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
public List<Donation> ModifierDons(){
        List<Donation> donation = new ArrayList<>() ;
    try {
        
       String sql = "UPDATE donsliquide SET numRecu=?,montant=?,date=? where donationID=3";
    
PreparedStatement statement = cnx.prepareStatement(sql);

statement.setInt(1,300);
statement.setFloat(2,800);
statement.setString(3,"31/02/1995");
 
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
