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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Produit;
import interfaces.Iproduits;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.ServiceProduit;


/**
 * FXML Controller class
 *
 * @author chedi
 */
public class GestionProduitFrontFXMLController implements Initializable {

    @FXML
    private GridPane ptGP;
Iproduits interfaceproduit = new ServiceProduit();
private Stage stage;
    private Scene scene;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         int column = 0;
        int row = 0;

        for (Produit pt : interfaceproduit.afficherProduit()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Affichage de produit Front.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                affichageproduitfront affichageproduitfront = fxmlLoader.getController();
                affichageproduitfront.setData(pt);

                if (column == 1) {
                    column = 0;
                    row++;
                }
                ptGP.add(anchorPane, column++, row);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        
    }    

    @FXML
    private void SwitchTocatégorie(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionCatégorieFrontFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchtobackend(ActionEvent event) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("gestionProduitFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
