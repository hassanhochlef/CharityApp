/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Product;
import Services.ProductService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomeController implements Initializable {

    @FXML
    private TableView<?> showT;
    @FXML
    private Button btnajoutH;
    @FXML
    private Button btnmodH;
    @FXML
    private Button btnsupH;
    @FXML
    private Button btndemandeH;
    @FXML
    private TableColumn<Product, Integer> colidD;
    @FXML
    private TableColumn<Product, String> colNOM;
    @FXML
    private TableColumn<Product, Integer> colqnt;
    @FXML
    private TableColumn<Product, Integer> colprix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tabshow() {
        
        ObservableList<Product> eventList= FXCollections.observableArrayList();
        ProductService ps = new ProductService();
        eventList = (ObservableList<Product>) ps.afficherProduit();
        
        colidD.setCellValueFactory(new PropertyValueFactory<>("donorId"));
        colNOM.setCellValueFactory(new PropertyValueFactory<>("name"));
        colqnt.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("prix_approx"));
       
        
       // ps.setItems(eventList);
        
    }

    @FXML
    private void AJOUTER(ActionEvent event) {
    }

    @FXML
    private void MODIFIER(ActionEvent event) {
    }

    @FXML
    private void SUPPRIMER(ActionEvent event) {
       //tabshow.getItems().removeAll(tabshow.getSelectionModel().getSelectedItem());
    
    }

    @FXML
    private void DEMANDE(ActionEvent event) {
    }

    private static class tabshow {

       
    }
    
}
