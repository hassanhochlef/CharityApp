/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Evenement;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author SeifD
 */
public class EventsListController implements Initializable {

    @FXML
    private TableView<Evenement> eventTable;
    @FXML
    private TableColumn<Evenement, Integer> colID;
    @FXML
    private TableColumn<Evenement, String> colCategorie;
    @FXML
    private TableColumn<Evenement, String> colCause;
    @FXML
    private TableColumn<Evenement, Integer> colParticip;
    @FXML
    private TableColumn<Evenement, Date> colDate;
    @FXML
    private TableColumn<Evenement, Integer> colMontant;
    @FXML
    private TableColumn<Evenement, Integer> colDescription;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showEvents();
    } 
    
    
    public void showEvents(){
        
        ObservableList<Evenement> eventList= FXCollections.observableArrayList();
        EvenementService es = new EvenementService();
        eventList = es.showAllEvents();
        
        colID.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        colCategorie.setCellValueFactory(new PropertyValueFactory<>("donCategorie"));
        colCause.setCellValueFactory(new PropertyValueFactory<>("cause"));
        colParticip.setCellValueFactory(new PropertyValueFactory<>("num_participants"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        colMontant.setCellValueFactory(new PropertyValueFactory<>("montant_collecte"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        eventTable.setItems(eventList);
        

    }
    
}
