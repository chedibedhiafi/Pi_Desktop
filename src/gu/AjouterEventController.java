/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import models.Event;
import services.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class AjouterEventController implements Initializable {

    
    @FXML
    private TextField prix;
    @FXML
    private Button creer;
    @FXML
    private Button retour;
    @FXML
    private TextField titre;
    @FXML
    private TextArea descri;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert prix != null : "fx:id=\"prix\" was not injected: check your FXML file 'AjouterEvent.fxml'.";
		assert titre != null : "fx:id=\"titre\" was not injected: check your FXML file 'AjouterEvent.fxml'.";
		assert descri != null : "fx:id=\"descri\" was not injected: check your FXML file 'AjouterEvent.fxml'.";
		assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'AjouterEvent.fxml'.";
		assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'AjouterEvent.fxml'.";
		assert creer != null : "fx:id=\"creer\" was not injected: check your FXML file 'AjouterEvent.fxml'.";
  
    }    

      
        

    @FXML
    private void creer(ActionEvent event) {
        ServiceEvent sb = new ServiceEvent();
        
       Event p = new Event();
       
        p.setTitre(titre.getText());
        p.setPrix(prix.getText());
        p.setDescription(descri.getText());
        p.setDate_Event(Date.valueOf(date.getValue()));
        
        sb.ajout(p);
        
    System.out.println("added");

}
 @FXML
    private void retour(ActionEvent event) {
        
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilAdmin.fxml"));
            Parent root = loader.load();
           
          retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    

    }    
    
