/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author SeifD
 */
public class DashBoardController implements Initializable {


    @FXML
    private Label totalEvents;
    @FXML
    private JFXButton btnParticipEvent;
    @FXML
    private Label actifEvents;
    @FXML
    private Label nbreParticipants;
    @FXML
    private Label donCollecte;
    @FXML
    private Label assocLabel1;
    @FXML
    private Label assocLabel2;
    @FXML
    private Label assocLabel3;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementService es = new EvenementService();
        totalEvents.setText(String.valueOf(es.getNombreEvents()));
        
        assocLabel1.setText(es.getAssocActive1());
        assocLabel2.setText(es.getAssocActive2());
        assocLabel3.setText(es.getAssocActive3());
 
    }    
    
    
    
}
