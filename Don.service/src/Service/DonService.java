/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Connection.MyConnection;
import Entité.DoneService;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author lotfi
 */
public class DonService {
    public Connection cnx;
public PreparedStatement ste;
    public DonService() {  
        cnx = MyConnection.getInstance().getConnection();
        
    }
    
    public void ajouterDon(DoneService d){
        try {
            String sql = "insert into donn(TypeService,lieu,DateDisponibilité)"+"values(?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setString(1, d.getTypeService());
            ste.setString(2, d.getLieu());
            ste.setString(3, d.getDateDisponibilité());
            ste.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Don non ajoutée !!");
        System.out.println(ex.getMessage());
    }
    }
    
    
    
    public void supprimerDone(String IdDonneurS){
    try {
        String sql = "DELETE FROM donn WHERE IdDonneurS=?" ;
        ste=cnx.prepareStatement(sql);
        ste.setString(1,IdDonneurS);
        ste.executeUpdate();
        System.out.println("Don supprimé");
        } catch (SQLException ex) {
            System.out.println("Echec de suppression!!");
            System.err.println(ex.getMessage());
        
    } 
    
    }
    public void modifierDone(DoneService e){
    try {
        String sql = "UPDATE donn SET TypeService  = ?, lieu = ?, DateDisponibilité  = ?  WHERE IdDonneurS=? " ;
        ste=cnx.prepareStatement(sql);
        ste.setString(1, e.getTypeService());
        ste.setString(2, e.getLieu());
        ste.setString(3, e.getDateDisponibilité());
        ste.executeUpdate();
        System.out.println("Don modifier");
        } catch (SQLException ex) {
          System.out.println("Updated failed !!!");
          System.err.println(ex.getMessage());
        }
    } 
    public void afficherDoneService() {
    try {
        List<DoneService>doneservices=new ArrayList<>();
        String sql ="Select * from donn ";
        ste = cnx.prepareCall(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        DoneService e = new DoneService();
        while(rs.next()){
            e.setIdDonneurS(rs.getInt("ID Donneur"));
            e.setTypeService(rs.getString("Type de service"));
            e.setLieu(rs.getString("Lieu"));
            e.setDateDisponibilité(rs.getString("Date disponibilité"));
            doneservices.add(e);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
        
    }
   
}

