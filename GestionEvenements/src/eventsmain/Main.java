/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsmain;

import entities.Evenement;
import java.sql.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.EvenementService;
import utils.DbConnection;

/**
 *
 * @author SeifD
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/EventsMain.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Gestion des evenements");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        /*DbConnection mc= DbConnection.getInstance();
        EvenementService ev = new EvenementService();
        Date date = new Date(21, 10, 13);
        Evenement e1 = new Evenement("Transport", "Achat de bus", 100, date, 100, "test");
        //ev.ajouterEvenement(e1);
        //ev.supprimerEvenement(4);
        //System.out.println(ev.showAllEvents());*/
        
    }
    
}
