/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondons;
import Connection.MyConnection;
import Service.DonationCrud;
import esprit1.Don;
import static java.awt.SystemColor.window;
import java.io.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Date;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage; 
import Service.DonationCrud;

import esprit1.Service;
import java.sql.SQLException;
/**
 *
 * @author Hassan
 */
public class GestionDons extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("DonsScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
     
      

        
      
   
    }

    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
             
           
        launch(args);
       
    }

    
    
}
