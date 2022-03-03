/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Catégorie;
import service.ServiceProduit;
import service.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class AjoutcategorieController implements Initializable {
     private Stage stage;
    private Scene scene;
    private Parent root;
     ServiceProduit sp = new ServiceProduit();
    ServiceCatégorie sc = new ServiceCatégorie();

    @FXML
    private Label nomLBL;
    @FXML
    private TextField nomTXT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterCategorie(ActionEvent event) {
          if (nomTXT.getText().length() == 0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
           
            alert.show();

        } else {
        
        sc.ajouterCatégorie(new Catégorie(nomTXT.getText()));
          }
        
    }

    @FXML
    private void switchtoafficher(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("mainCategorieFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchtoAjoutProduit(ActionEvent event) throws IOException {
                 root = FXMLLoader.load(getClass().getResource("ajoutproduit.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
