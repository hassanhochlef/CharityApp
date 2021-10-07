/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edu.esprit.services;

import Edu.esprit.entities.Produit;
import Edu.esprit.tools.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class produitservice {
    public Connection cnx;
    private PreparedStatement ste;

    public produitservice() {
        cnx = Myconnection.getInstance().getConnection();
    }
    
    public void ajouterProduit(Produit p){
        String req ="INSERT INTO person (id,nom)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, p.getId_prod());
            ste.setString(2, p.getNom_prod());
            ste.executeUpdate();
            System.out.println("Produit ajouté");
            
        } catch (SQLException ex) {
            
        }
        
    }
    public List<Produit> afficherProduit(){
    List<Produit> Produits = new ArrayList<>();
   
        try {
             String sql = "select * from produit";
     
             ste = cnx.prepareStatement(sql);
             ResultSet rs = ste.executeQuery();
             while (rs.next()) {   
                 Produit p = new Produit();
                 p.setId_prod(rs.getString("id"));
                 p.setNom_prod(rs.getString(20));
                 Produits.add(p);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    return  Produits;
    
}
  
    public List<Produit> SupprimerProduit(){
        List<Produit> Produits = new ArrayList<>() ;
    try {

       String sql = "DELETE FROM Produit WHERE id_prod=?";

PreparedStatement statement = cnx.prepareStatement(sql);


int rowsDeleted = statement.executeUpdate();
if (rowsDeleted > 0) {
    System.out.println("A product was deleted ");
}


        System.out.println(Produits);
    } 
        catch (SQLException ex) {
        Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Produits;
}
public List<Produit> ModifierProduit(){
        List<Produit> Produits = new ArrayList<>() ;
    try {

       String sql = "UPDATE Produit SET id_prod=?,nom_prod=? where id_prod=?";

PreparedStatement statement = cnx.prepareStatement(sql);


int rowsDeleted = statement.executeUpdate();
if (rowsDeleted > 0) {
    System.out.println("A product was updated");
}


        System.out.println(Produits);
    } 
        catch (SQLException ex) {
        Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Produits;
}


}
