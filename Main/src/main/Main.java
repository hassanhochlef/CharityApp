/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import services.EvenementService;
import entities.Evenement;
import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DbConnection;

/**
 *
 * @author SeifD
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainEvents.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        DbConnection mc= DbConnection.getInstance();
        EvenementService ev = new EvenementService();
        
        //per.ajouterPersonnes(p1);
        
        Evenement e1 = new Evenement("Construction Hopital", "Charité", 0, 0F, "testtetstqgdqsdhfhdshdqh");
        Evenement e2 = new Evenement("Construction test2", "Transport", 50, 1.5F, "test2");
        Evenement e3 = new Evenement(" test3", "Transport", 50, 1.5F, "test2");
        //ev.ajouterEvenement(e1);
        //ev.ajouterEvenement(e2);
        //ev.ajouterEvenement(e3);
        //ev.supprimerEvenement(1);
        //ev.updateEvent(1, e2);
        System.out.println(ev.showAllEvents());
        
        
    }
    
}
