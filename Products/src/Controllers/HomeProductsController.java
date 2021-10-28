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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomeProductsController implements Initializable {

    @FXML
    private TextField txtiddonor;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtqualite;
    @FXML
    private TextField txtprx;
    @FXML
    private Button valideradd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveAdd(ActionEvent event) {
        
            int rdonorid = Integer.parseInt(txtiddonor.getText());
            String rname = txtnom.getText();
            int rqt = Integer.parseInt(txtqualite.getText());
            int rprix = Integer.parseInt(txtprx.getText());
            Product p = new Product(rdonorid, rname, rqt, rprix);
            ProductService ps = new ProductService();
            ps.ajouterProduit(p);
    }
    
}
