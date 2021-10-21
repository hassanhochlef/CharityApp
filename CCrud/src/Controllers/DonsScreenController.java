/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connection.MyConnection;
import Service.DonationCrud;
import Service.progressCalculator;
import Entities.Besoin;
import Entities.Don;
import Entities.Evenement;
import Entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author Hassan
 */

public class DonsScreenController implements Initializable {
public ComboBox ComboBesoin ;
public ComboBox ComboBesoinTransport;
    @FXML
    private ProgressBar prog2;
    @FXML
    private Label labelbesoin2;
    @FXML
    private Label labelacc2;
    @FXML
    private Label labeldesc2;
    @FXML
    private ComboBox<?> ComboBesoin2;
    @FXML
    private TableView<?> table2;
    @FXML
    private TableColumn<?, ?> col_id2;
    @FXML
    private TableColumn<?, ?> col_desc2;
    @FXML
    private TextField montantHosp;
    @FXML
    private Button btnconfirm1;
    @FXML
    private Button print1;
    @FXML
    private Button btnconfirm2;
    @FXML
    private Button print2;
    @FXML
     private Button print;
    @FXML
    private TextField montant;
    @FXML
    private Button btnconfirm;
    @FXML
    private Label labeldesc;
    @FXML
    private Label labelacc;
    @FXML
    private Label labelbesoin;
    @FXML
    private Label labeldesc1;
    @FXML
    private Label labelacc1;
    @FXML
    private Label labelbesoin1;
    @FXML
    private ProgressBar prog;
    @FXML
    private ProgressBar prog1;
    @FXML
    private TableView<Besoin> table;
    @FXML
    private TableView<Besoin> table1;
    @FXML
    private TableColumn<Besoin,Integer> col_id;
    @FXML
    private TableColumn<Besoin,String> col_desc ;
    @FXML
    private TableColumn<Besoin,Integer> col_id1;
    @FXML
    private TableColumn<Besoin,String> col_desc1 ; 
    @FXML
    private Button statsbutton;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
       increaseprogress2();
       FillBesoincombo();
       FillBesoincomboTransport();
       FillTableView();
       increaseprogress();
       FilltextField();
       FilltextField1();
       FillTableView1();
       print1.setVisible(false);
       print.setVisible(false);
      
    }   
     ObservableList<Besoin> oblist = FXCollections.observableArrayList();
     ObservableList<Besoin> Transport = FXCollections.observableArrayList();
     
    @FXML
    private void getmontant(ActionEvent event){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        DonationCrud dc = new DonationCrud();
        Don d = new Don();      
            float montantdonne = Float.parseFloat(montant.getText());
            d.setDonorId(1);
            d.setEventId(2);
            d.setCategorie("Transport");
            d.setDonationDate(date.format(formatter));
            d.setMontant(montantdonne);
            dc.AjouterDons(d);
            System.out.println("clicked");
           String x = (String)ComboBesoinTransport.getValue();
          
           float y=montantdonne;
            dc.ModifierBesoin(x,y);
            FilltextField1();
            increaseprogress2();
            print.setVisible(true);
            
            
    }
    @FXML
    public void FilltextField(){
        try {
            Statement ste ;
          
            String sql = "Select montantactuel,montant,description from Besoin where categorie='Hopiteaux' order by montant desc LIMIT 1 ";
            ResultSet rs ;
           MyConnection cnx = MyConnection.getInstance();
            ste = cnx.getConnection().prepareStatement(sql);
            rs = ste.executeQuery(sql);
            
            while (rs.next()) {
               float montantac = (rs.getFloat("montantactuel"));
               float montant =(rs.getFloat("montant"));
               String desc = rs.getString("description");
                labelacc.setText(String.format("%.0f",montantac));
                labelbesoin.setText(String.format("%.0f",montant));
                labeldesc.setText(desc);
                
                
            }  
                 
        
    } catch (SQLException ex) {
        Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
    }}
    @FXML
    public void FilltextField1(){
        try {
            Statement ste ;
          
            String sql = "Select montantactuel,montant,description from Besoin where categorie='Transport' order by montant desc LIMIT 1 ";
            ResultSet rs ;
           MyConnection cnx = MyConnection.getInstance();
            ste = cnx.getConnection().prepareStatement(sql);
            rs = ste.executeQuery(sql);
            
            while (rs.next()) {
               float montantac = (rs.getFloat("montantactuel"));
               float montant =(rs.getFloat("montant"));
               String desc = rs.getString("description");
                labelacc1.setText(String.format("%.0f",montantac));
                labelbesoin1.setText(String.format("%.0f",montant));
                labeldesc1.setText(desc);
                
                
            }  
                 
        
    } catch (SQLException ex) {
        Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
    }}
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
        }}    
    @FXML
    public void FillTableView1(){
        col_id1.setCellValueFactory(new PropertyValueFactory<>("idBesoin"));
        col_desc1.setCellValueFactory(new PropertyValueFactory<>("description"));
        /**************************************************************/
         try {
            Statement ste ;
            
            
            String sql = "Select idBesoin,description from Besoin where categorie='Transport' ";
            ResultSet rs ;
            MyConnection cnx = MyConnection.getInstance();
            ste = cnx.getConnection().prepareStatement(sql);
            rs = ste.executeQuery(sql);
            
            while (rs.next()) {
               
               
                Transport.add(new Besoin(rs.getInt("idBesoin"),rs.getString("description")));
                
            }  
            table1.setItems(Transport);
        } catch (SQLException ex) {
            Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        /****************************************************************/
    }     
    @FXML
    public void increaseprogress() {
       
    try {
        Statement ste ;
        String sql = "Select montant,montantactuel,description from Besoin where categorie='Hopiteaux'  order by montant desc  LIMIT 1 ";
        ResultSet rs ;
        MyConnection cnx = MyConnection.getInstance();
        ste = cnx.getConnection().prepareStatement(sql);
        rs = ste.executeQuery(sql);
        while(rs.next()){
         Float montant = rs.getFloat("montant");
         Float montantac = rs.getFloat("montantactuel");
          progressCalculator pc = new progressCalculator();
          float x = pc.progressCalculator(montant, montantac);
          prog.setProgress(x);

         
      
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
    }

}
    @FXML
    public void increaseprogress2() {
       
    try {
        Statement ste ;
        String sql = "Select montant,montantactuel,description from Besoin where categorie='Transport'  order by montant desc  LIMIT 1 ";
        ResultSet rs ;
        MyConnection cnx = MyConnection.getInstance();
        ste = cnx.getConnection().prepareStatement(sql);
        rs = ste.executeQuery(sql);
        while(rs.next()){
         float montant = rs.getFloat("montant");
         float montantac = rs.getFloat("montantactuel");
         progressCalculator pc = new progressCalculator();
         float x = pc.progressCalculator(montant, montantac);                  
         prog1.setProgress(x);
       
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
    }

}
    @FXML
    public void FillBesoincomboTransport(){
          ObservableList Transport = FXCollections.observableArrayList();
        try {
            Statement ste ;
          
            String sql = "Select description from Besoin where categorie='Transport' ";
            ResultSet rs ;
            MyConnection cnx = MyConnection.getInstance();
            ste = cnx.getConnection().prepareStatement(sql);
            rs = ste.executeQuery(sql);
            
            while (rs.next()) {
               
               
                Transport.add(rs.getString("description"));
                
            }  
            ComboBesoinTransport.setItems(Transport);
        } catch (SQLException ex) {
            Logger.getLogger(DonsScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDonsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void persist1(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDonsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void persist2(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionDonsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    @FXML
    public void openscene(ActionEvent event) throws IOException{
         Parent part = FXMLLoader.load(getClass().getResource("/Views/Item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void getmontant1(ActionEvent event) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        DonationCrud dc = new DonationCrud();
        Don d = new Don();      
            float montantdonne = Float.parseFloat(montantHosp.getText());
            d.setDonorId(1);
            d.setEventId(2);
            d.setCategorie("Hopiteaux");
            d.setDonationDate(date.format(formatter));
            d.setMontant(montantdonne);
            dc.AjouterDons(d);
            System.out.println("clicked");
           String x = (String)ComboBesoin.getValue();
          
           float y=montantdonne;
            dc.ModifierBesoin(x,y);
            FilltextField();
            increaseprogress();
            print1.setVisible(true);
    }

    @FXML
    private void openscenestat(ActionEvent event) throws IOException {
         Parent part = FXMLLoader.load(getClass().getResource("/Views/StatsDash.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

}