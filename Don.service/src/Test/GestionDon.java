/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Connection.MyConnection;
import Entité.DoneService;
import Service.DonService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lotfi
 */
public class GestionDon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
            DoneService d1 = new DoneService(10,"Médicale","Manouba", "1er janvier 2021 de 08h à 12h ");
            DoneService d2= new DoneService( 20,"Médicale","Mourouj", "15 janvier 2021 de 08h à 17h");
            DoneService d3= new DoneService( 30,"Construction","Ariana", "1er Mars 2021 de 08h à 12h");
            
           DonService ds = new DonService();
           ds.ajouterDon(d1);
           ds.ajouterDon(d2);
           ds.ajouterDon(d3);
           ds.supprimerDone("10");
           d2.setLieu("Ariana");
           d2.setDateDisponibilité("20 Avril 2021 de 08h à 15h");
           d2.setTypeService("Construction");
           ds.modifierDone(d2);
           ds.afficherDoneService();
        
        
        
        
        
        
        
        
        
    }
    
    
}
