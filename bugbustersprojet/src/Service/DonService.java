/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entité.Don;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;



/**
 *
 * @author khoubaib
 */
public class DonService {
    public Connection cnx;
    public PreparedStatement ste;
    public DonService() {  
        cnx = MyConnection.getInstance().getConnection();      
    }
    
    public void ajouterDon(Don d){ 
        
            String req = "INSERT INTO service(donorId, TypeService, lieu, DateDisponibilité)"+"VALUES(?,?,?,?)";  
        try {
            ste = cnx.prepareStatement(req); 
            ste.setInt(1,d.getDonorId()); 
            ste.setString(2,d.getTypeService()); 
            ste.setString(3,d.getLieu()); 
            ste.setString(4,d.getDateDisponibilité());         
            ste.executeUpdate();
            System.out.println("Don ajoutée");
        }catch (SQLException ex) {
            System.out.println("Don non ajoutée !!");       
    }
    }
    
    public void supprimerDone(int serviceId){
        
           String sql = "DELETE FROM service WHERE serviceId=?" ;
        try {        
            ste=cnx.prepareStatement(sql);
            ste.setInt(1,serviceId);
            ste.executeUpdate();
            System.out.println("Don supprimé");
        }catch (SQLException ex) {
            System.out.println("Echec de suppression!!");
            System.err.println(ex.getMessage());      
    }  
    }
    public void modifierDone(Don e){
        
           String sql = "UPDATE service SET TypeService  = ?, lieu = ?, DateDisponibilité  = ?  WHERE serviceId= "+e.getServiceId() ;
        try {        
            ste=cnx.prepareStatement(sql);
            ste.setString(1, e.getTypeService());
            ste.setString(2, e.getLieu());
            ste.setString(3, e.getDateDisponibilité());
            ste.executeUpdate();
            System.out.println("Don modifié");
        }catch (SQLException ex) {
            System.out.println("Modifications non établit !!!");
            System.err.println(ex.getMessage());
    }
    } 
    
    public List<Don> afficherDoneService() {
   
        List<Don> doneservices=new ArrayList<>();
           String sql ="Select * from service ";
        try {     
            ste = cnx.prepareCall(sql);
            ResultSet rs;
            rs = ste.executeQuery();
            Don e = new Don();
        while(rs.next()){
            e.setServiceId(rs.getInt("serviceId"));
            e.setDonorId(rs.getInt("donorId"));
            e.setTypeService(rs.getString("TypeService"));
            e.setLieu(rs.getString("lieu"));
            e.setDateDisponibilité(rs.getString("DateDisponibilité"));
            doneservices.add(e);
        }
    }   catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
      return  doneservices; 
    }
   
}

