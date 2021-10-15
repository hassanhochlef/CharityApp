/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondons;

import Connection.MyConnection;
import Service.DonationCrud;
import esprit1.Besoin;
import esprit1.Don;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hassan
 */

public class DonsScreenController implements Initializable {
public ComboBox ComboBesoin ;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       FillBesoincombo();
       FillTableView();
    }   

    /**
     *
     */
    @FXML
    private TableView<Besoin> table;
    @FXML
    private TableColumn<Besoin,Integer> col_id;
    @FXML
    private TableColumn<Besoin,String> col_desc ;
     ObservableList<Besoin> oblist = FXCollections.observableArrayList();
    @FXML
    public void FillTableView(){
        col_id.setCellValueFactory(new PropertyValueFactory<>("idBesoin"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        /**************************************************************/
         try {
            Statement ste ;
            
            
            String sql = "Select idBesoin,description from Besoin where categorie='Hopiteaux' ";
            ResultSet rs ;
            MyConnection cnx = MyConnection.getInstance();
            ste = cnx.getConnection().prepareStatement(sql);
            rs = ste.executeQuery(sql);
            
            while (rs.next()) {
               
               
                oblist.add(new Besoin(rs.getInt("idBesoin"),rs.getString("description")));
                
            }  
            table.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        /****************************************************************/
    }
    @FXML
    public void FillBesoincombo(){
          ObservableList besoin = FXCollections.observableArrayList();
        try {
            Statement ste ;
            
            
            String sql = "Select description from Besoin where categorie='Hopiteaux' ";
            ResultSet rs ;
            MyConnection cnx = MyConnection.getInstance();
            ste = cnx.getConnection().prepareStatement(sql);
            rs = ste.executeQuery(sql);
            
            while (rs.next()) {
               
               
                besoin.add(rs.getString("description"));
                
            }  
            ComboBesoin.setItems(besoin);
        } catch (SQLException ex) {
            Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}
