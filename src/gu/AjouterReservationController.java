/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import models.Event;
import models.Reservation;
import services.ServiceEvent;
import services.ServiceReservation;
import utils.AlertBox;

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
    private Label nameLabel;
    @FXML
    private Label notez;
    @FXML
    private Label prixLBL;
    
    Event e;

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
                
    }    

    @FXML
    private void reserver(ActionEvent event) {
        try{
        
        ServiceReservation sb = new ServiceReservation();
        
       Reservation p = new Reservation();
       
        p.setNb_Places(nb.getText());
        p.setTotal(total.getText());
        p.setDate_Achat(Date.valueOf(LocalDate.now()));
        p.setFK_Event(e.getEvent_Id());

        sb.ajout(p);
            AlertBox.display("Success", "votre reservation a été faite avec succes");
    System.out.println("added");
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EventsUtilisateurs.fxml"));
            Parent root = loader.load();
    ((BorderPane)total.getParent().getParent().getParent()).setCenter(root);
      }catch(Exception Ex ){
            AlertBox.display("error", "veuillez faire votre reservation");


      }
        
    System.out.println("addde");
    }

    @FXML
    private void retour(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EventsUtilisateurs.fxml"));
            Parent root = loader.load();
           ((BorderPane)total.getParent().getParent().getParent()).setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(EventsUtilisateursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void calculerTotal(KeyEvent event) {
        Integer nb_places = Integer.parseInt(nb.getText());
        Double prixu = Double.parseDouble(prixLBL.getText());
        Double totalP = nb_places*prixu;
        total.setText(totalP.toString());
    }
    
    public void setEvent(Event e)
    {
        this.dateachat.setValue(LocalDate.now());
        this.e=e;
        System.out.println(e);
        prixLBL.setText(e.getPrix());
    }
}
