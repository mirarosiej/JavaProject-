/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polioimmunization;

import java.net.*;
import java.util.*;
import com.google.gson.*;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Slider;


/**
 *
 * @author csstudent
 */
public class poloController implements Initializable {
    
    @FXML
    private BarChart bar;
    
    @FXML 
    private Slider minimum; 
    
    @FXML
    private Slider maximum; 
    
    private Dataset data;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");  
    }
    
    @FXML
    private void close(){
        System.exit(0); 
        
    }
    
    @FXML
    private void about(){
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("About");
    alert.setHeaderText("Polio Immunization");
    alert.setContentText(" This data looks at the percentages of Polio Immunizations by Country");

    alert.showAndWait();
    
    }
    
    @FXML
    private void handleChangeFilter(Event event) {
        System.out.println("Clicked slider");
        XYChart.Series< String, Number> ImmunizationSeries = new XYChart.Series();
        Datapoint[] point= data.getFact(); 
        
        for(Datapoint xyz : point){
            if(xyz.getDim().getCountry() != null){
                if(xyz.getValue() > minimum.getValue() && xyz.getValue() < maximum.getValue()){
                    ImmunizationSeries.getData().add(new XYChart.Data(xyz.getDim().getCountry(), xyz.getValue()));     
                }
            }
        }
        bar.getData().setAll(ImmunizationSeries);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL myUrl = null;
        try {
            myUrl = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(myUrl.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
            
            
        }
        scan.close();

        Gson gson = new Gson();
        data = gson.fromJson(str, Dataset.class);
        System.out.println(data.toString());

        XYChart.Series< String, Number> ImmunizationSeries = new XYChart.Series();
        Datapoint[] point= data.getFact(); 
        for(Datapoint xyz : point){
            if(xyz.getDim().getCountry() != null){
                ImmunizationSeries.getData().add(new XYChart.Data(xyz.getDim().getCountry(), xyz.getValue()));     
        }
        }
        bar.getData().add(ImmunizationSeries);
        
    }
        
                
      
    }
