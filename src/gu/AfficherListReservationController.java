/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Reservation;
import services.ServiceEvent;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class AfficherListReservationController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TableView <Reservation> table;
    @FXML
    private TableColumn<Reservation , Date> dateachat;
    @FXML
    private TableColumn<Reservation , Integer> total;
    @FXML
    private TableColumn<Reservation , Integer> nb;
    @FXML
    private Button supprimer;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                // TODO
        ServiceReservation sb = new ServiceReservation();
        System.out.println("err");
        List Reservation = sb.afficher();
        ObservableList list = FXCollections.observableArrayList(Reservation);
        
        table.setItems(list);
        nb.setCellValueFactory(new PropertyValueFactory<>("Nb_Places"));
        dateachat.setCellValueFactory(new PropertyValueFactory<>("Date_Achat"));
        total.setCellValueFactory(new PropertyValueFactory<>("Total"));
        // TODO
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

    @FXML
    private void supprimer(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerReservation.fxml"));
            Parent root = loader.load();
           
          supprimer.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
