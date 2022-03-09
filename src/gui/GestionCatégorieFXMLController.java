/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Icatégorie;
import interfaces.Iproduits;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Catégorie;
import service.ServiceCatégorie;
import service.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class GestionCatégorieFXMLController implements Initializable {
    ServiceProduit sp = new ServiceProduit();
    ServiceCatégorie sc = new ServiceCatégorie();
     Icatégorie interfacecategorie = new ServiceCatégorie();

    @FXML
    private Label nomLBL;
    @FXML
    private ImageView screenshotView;
    @FXML
    private TextField nomTXT;
    @FXML
    private GridPane ptGP;
    
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
        
    
        for (Catégorie ct : interfacecategorie.afficherCatégorie()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Affichage de catégorie.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
            AffichagedeCatégorieController affichagedecategoriecontroller = fxmlLoader.getController();
            affichagedecategoriecontroller.setData(ct);
            
            if(column == 2){
                column = 0;
                row++;
            }
            ptGP.add(anchorPane,column++,row);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }    

    
    private void LoadData() {
        
        
        
    }
        // TODO
       

    @FXML
    private void AjouterCatégorie(ActionEvent event) {
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
    private void SwitchtoProduit(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("gestionProduitFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
