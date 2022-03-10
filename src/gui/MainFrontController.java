/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class MainFrontController implements Initializable {

    @FXML
    private BorderPane mainBRDRpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Parent root = FXMLLoader.load(getClass().getResource("../gu/AfficherListReservation.fxml"));
            mainBRDRpane.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
}
