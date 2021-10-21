/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connection.MyConnection;
import Entities.Besoin;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

/**
 * FXML Controller class
 *
 * @author Hassan
 */
public class StatsDashController implements Initializable {

    @FXML
    private PieChart chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        piechartSetup();
        
    }
    ObservableList<PieChart.Data> pieChartData;
    public void piechartSetup(){
   pieChartData = FXCollections.observableArrayList();
        try {
            Statement ste ;                  
            String sql = "Select montantactuel,description from Besoin";
            ResultSet rs ;
            MyConnection cnx = MyConnection.getInstance();
            ste = cnx.getConnection().prepareStatement(sql);
            rs = ste.executeQuery(sql);
            while (rs.next()) {            
            pieChartData.add(new PieChart.Data(rs.getString("description"),rs.getFloat("montantactuel")));       
           chart.setLabelsVisible(true);
           chart.setTitle("Dons Collectés");
            }
            chart.setData(pieChartData);
        } catch (SQLException e) {
            System.out.println("erour");
        }
        
        
    }
    
}
