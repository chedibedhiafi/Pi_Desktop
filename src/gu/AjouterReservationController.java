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
import javafx.scene.control.TextField;
import models.Event;
import models.Reservation;
import services.ServiceEvent;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class AjouterReservationController implements Initializable {

    @FXML
    private TextField total;
    @FXML
    private TextField nb;
    @FXML
    private Button reserver;
    @FXML
    private Button retour;
    @FXML
    private DatePicker dateachat;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert total != null : "fx:id=\"total\" was not injected: check your FXML file 'AjouterReservation.fxml'.";
		assert nb != null : "fx:id=\"nb\" was not injected: check your FXML file 'AjouterReservation.fxml'.";
		assert dateachat != null : "fx:id=\"dateachat\" was not injected: check your FXML file 'AjouterReservation.fxml'.";
		assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'AjouterReservation.fxml'.";
		assert reserver != null : "fx:id=\"reserver\" was not injected: check your FXML file 'AjouterReservation.fxml'.";
                assert modifier != null : "fx:id=\"modifier\" was not injected: check your FXML file 'AjouterReservation.fxml'.";
    }    

    @FXML
    private void reserver(ActionEvent event) {
        
        ServiceReservation sb = new ServiceReservation();
        
       Reservation p = new Reservation();
       
        p.setNb_Places(nb.getText());
        p.setTotal(total.getText());
        p.setDate_Achat(Date.valueOf(dateachat.getValue()));
        
        sb.ajout(p);
        
    System.out.println("addde");
    }

    @FXML
    private void retour(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("evenements.fxml"));
            Parent root = loader.load();
           
          retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierReservation.fxml"));
            Parent root = loader.load();
           
          modifier.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
