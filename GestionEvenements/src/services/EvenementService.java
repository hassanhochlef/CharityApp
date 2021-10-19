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
import java.util.HashSet;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        
            String req = "INSERT INTO evenement(donCategorie,cause,num_participants,date_creation,montant_collecte,description)"+" VALUES (?,?,?,?,?,?)";
            try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, event.getDonCategorie());
            ste.setString(2, event.getCause());
            ste.setInt(3, event.getNum_participants());
            ste.setString(4, event.getDate_creation().toString());
            ste.setFloat(5, event.getMontant_collecte());
            ste.setString(6, event.getDescription());
            ste.executeUpdate();
            System.out.println("Evenment ajouté avec succée !");
            
        } catch (SQLException ex) {
            System.out.println("Erreur Ajout Evenement");
        }
          
    }
   
    public void supprimerEvenement(int id){
        
            String req = "DELETE FROM evenement WHERE evenement.eventId="+id;
            try {
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
            System.out.println("Event deleted");
        } catch (SQLException ex) {
                System.out.println("Erreur suppression event");
        }
    }
     
    /*public Evenement getEvent(int id){
        Evenement event = new Evenement();
        String req = "SELECT * from evenement WHERE evenement.eventId="+id;
            try {
            ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                event.setEventId(rs.getInt("eventId"));
                event.setDonCategorie(rs.getString("donCategorie"));
                event.setCause(rs.getString("cause"));
                event.setNum_participants(rs.getInt("num_participants"));
                event.setDate_creation(rs.getString("date_creation"));
                event.setMontant_collecte(rs.getFloat("montant_collecte"));
                event.setDescription(rs.getString("description"));
            }
            System.out.println("get event success");
            
        } catch (SQLException ex) {
                System.out.println("Erreur get event");
        }
        return event;
    }*/
    
    public void updateEvent(int id, Evenement event){
        
        //String req = "UPDATE evenement SET WHERE evenement.id="+id;
        String req = "UPDATE evenement SET donCategorie=?,cause=?,num_participants=?,date_creation=?,montant_collecte=?,description=? WHERE evenement.eventId=" + id;
        
        try{
            ste = cnx.prepareStatement(req);
            ste.setString(1, event.getDonCategorie());
            ste.setString(2, event.getCause());
            ste.setInt(3, event.getNum_participants());
            ste.setString(4, event.getDate_creation().toString());
            ste.setFloat(5, event.getMontant_collecte());
            ste.setString(6, event.getDescription());
            ste.executeUpdate();
            System.out.println("Event updated");           
        }
        catch(SQLException ex){
            System.out.println("Erreur update event");
            
        }
        
    }
    
    public ObservableList<Evenement> showAllEvents(){
        ObservableList<Evenement> events = FXCollections.observableArrayList();
        try{
            String req = "select * from evenement";
            ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                Evenement e = new Evenement();
                e.setEventId(rs.getInt("eventId"));
                e.setDonCategorie(rs.getString("donCategorie"));
                e.setCause(rs.getString("cause"));
                e.setNum_participants(rs.getInt("num_participants"));
                e.setDate_creation(rs.getDate("date_creation"));
                e.setMontant_collecte(rs.getFloat("montant_collecte"));
                e.setDescription(rs.getString("description"));
                events.add(e);               
            }      
        }
        catch(SQLException ex){
            System.out.println("Erreur affichage evenements");
        }
        return events;
    }
    
    
    public int getNombreEvents(){
        int nombre = 0;
        String req = "SELECT COUNT(*) from evenement";
            try {
            ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            if(rs.next()){
                nombre = rs.getInt(1);           
            }
            
        } catch (SQLException ex) {
                System.out.println("Erreur getNombreEvents");
        }
        return nombre;
    }
    
    
    
    //Suggestions for autocompletition seach field
    public Set<String> getSuggests(){
        
        Set<String> categories = new HashSet<>();
        Set<String> causes = new HashSet<>();
        Set<String> Suggests = new HashSet<>();
        try{
            String req = "select donCategorie from evenement";
            ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                String categ;
                categ = rs.getString("donCategorie");              
                categories.add(categ);               
            }      
        }
        catch(SQLException ex){
            System.out.println("Erreur Suggestion Cause");
        }
        
        
        try{
            String req = "select cause from evenement";
            ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                String cause;
                cause = rs.getString("cause");              
                causes.add(cause);               
            }      
        }
        catch(SQLException ex){
            System.out.println("Erreur Suggestion Categories");
        }
        
        Suggests.addAll(causes);
        Suggests.addAll(categories);
        
        return Suggests;

        
    }
  
}
    

