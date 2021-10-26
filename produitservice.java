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
        String req ="INSERT INTO produit (donorId,name,quantite,prix_approx)values (?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, p.getDonorId());
            ste.setString(2, p.getName());
            ste.setInt(3, p.getQuantite());
            ste.setInt(4, p.getPrix_approx());
            ste.executeUpdate();
            System.out.println("Produit ajouté");
            
        } catch (SQLException ex) {
            System.out.println("Erreur Ajout produit");
            System.out.println(ex.getMessage());
        }
        
    }
   public List<Produit> afficherProduit(){
    List<Produit> Produits = new ArrayList<>();
            String sql = "select * from produit";
        try {
             
     
             ste = cnx.prepareStatement(sql);
             ResultSet rs = ste.executeQuery();
              Produit p = new Produit();
             while (rs.next()) {   
                
                 p.setProductId(rs.getInt("productId"));
                 p.setDonorId(rs.getInt("donorId"));
                 p.setName(rs.getString("name"));
                 p.setQuantite(rs.getInt("quantite"));
                 p.setPrix_approx(rs.getInt("prix_approx"));
                 Produits.add(p);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    return  Produits;
    
}
  /*
    public void SupprimerProduit(int ProductId){
        
            String req = "DELETE FROM Produit WHERE p.ProductId="+ProductId;
            try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            
            System.out.println("product deleted");
        } catch (SQLException ex) {
                System.out.println("Erreur suppression produit");
        }
    }*/
    
    public List<Produit> SupprimerProduit(int productId){
        List<Produit> Produits = new ArrayList<>() ;
    try {

       String sql = "DELETE FROM Produit WHERE productId=?";
       

PreparedStatement statement = cnx.prepareStatement(sql);
statement.setInt(1,productId);

int rowsDeleted = statement.executeUpdate();
if (rowsDeleted ==1) {
    System.out.println("A product was deleted ");
}


        System.out.println(Produits);
    } 
        catch (SQLException ex) {
        Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
    }
    return Produits;
}
    
public List<Produit> ModifierProduit(int donorId, String Name,int quantite,int prix_approx){
        List<Produit> Produits = new ArrayList<>() ;
    try {

       String sql = "UPDATE Produit SET productId='"+donorId+"',"+"Name='"+Name+"'where productId='"+donorId+"'";

PreparedStatement statement = cnx.prepareStatement(sql);


int rowsDeleted = statement.executeUpdate();
if (rowsDeleted ==1) {
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
