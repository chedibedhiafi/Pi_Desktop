/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class ProfilAdminController implements Initializable {

    @FXML
    private Button creerevent;
    @FXML
    private Button modifierevent;
    @FXML
    private Button afficherevent;
    @FXML
    private Button afficherres;
    @FXML
    private Button supprimerres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void creer(ActionEvent event) {
                  try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEvent.fxml"));
            Parent root = loader.load();
           
          creerevent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void modifier(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvent.fxml"));
            Parent root = loader.load();
           
          modifierevent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficher(ActionEvent event) {
        
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListEvents.fxml"));
            Parent root = loader.load();
           
          afficherevent.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerReservation.fxml"));
            Parent root = loader.load();
           
          supprimerres.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherreserv(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListReservation.fxml"));
            Parent root = loader.load();
           
          afficherres.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
