/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DbConnection;

/**
 *
 * @author SeifD
 */
public class EvenementService {
    
    private Connection cnx;
    private PreparedStatement ste;
    
    public EvenementService(){
        cnx = DbConnection.getInstance().getConnection();
    }
    
    public void ajouterEvenement(Evenement event){
        
            String req = "INSERT INTO evenement(name,cause,num_participants,montant_collecte,description)"+"VALUES (?,?,?,?,?)";
            try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, event.getName());
            ste.setString(2, event.getCause());
            ste.setInt(3, event.getNum_participants());
            ste.setFloat(4, event.getMontant_collecte());
            ste.setString(5, event.getDescription());
            ste.executeUpdate();
            System.out.println("Evenment ajouté avec succée !");
            
        } catch (SQLException ex) {
        }
          
    }
    
    public void supprimerEvenement(int id){
        
            //String req = "DELETE FROM evenement WHERE (id="+id+")";
            String req = "DELETE FROM evenement WHERE evenement.id="+id;
            try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("Event deleted");
        } catch (SQLException ex) {
                System.out.println("Erreur suppression event");
        }
    }
    
    public Evenement getEvent(int id){
        Evenement event = new Evenement();
        String req = "SELECT * from evenement WHERE evenement.id="+id;
            try {
            ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("name"));
                event.setCause(rs.getString("cause"));
                event.setNum_participants(rs.getInt("num_participants"));
                event.setMontant_collecte(rs.getFloat("montant_collecte"));
                event.setDescription(rs.getString("description"));
            }
            System.out.println("get event success");
            
        } catch (SQLException ex) {
                System.out.println("Erreur get event");
        }
        return event;
    }
    
    public void updateEvent(int id, Evenement event2){
        
        //String req = "UPDATE evenement SET WHERE evenement.id="+id;
        String req = "UPDATE evenement SET name=?,cause=?,num_participants=?,montant_collecte=?,description=? WHERE evenement.id=" + id;
        
        try{
            ste = cnx.prepareStatement(req);
            ste.setString(1, event2.getName());
            ste.setString(2, event2.getCause());
            ste.setInt(3, event2.getNum_participants());
            ste.setFloat(4, event2.getMontant_collecte());
            ste.setString(5, event2.getDescription());
            ste.executeUpdate();
            System.out.println("Event updated");
            
        }
        catch(SQLException ex){
            System.out.println("Erreur update event");
            
        }
        
    }
    
    public List<Evenement> showAllEvents(){
        List<Evenement> events = new ArrayList<>();
        try{
            String req = "select * from evenement";
            ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                Evenement e = new Evenement();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setCause(rs.getString("cause"));
                e.setNum_participants(rs.getInt("num_participants"));
                e.setMontant_collecte(rs.getInt("montant_collecte"));
                e.setDescription(rs.getString("description"));
                events.add(e);
                
            }
            
            
        }
        catch(SQLException ex){
            System.out.println("Erreur affichage evenements");
        }
        return events;
    }
    
}
    

