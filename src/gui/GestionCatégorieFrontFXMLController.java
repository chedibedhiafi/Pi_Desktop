/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Icatégorie;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Catégorie;
import services.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class GestionCatégorieFrontFXMLController implements Initializable {

    @FXML
    private ImageView screenshotView;
    @FXML
    private GridPane ptGP;
    private Stage stage;
    private Scene scene;
    private Parent root;
         Icatégorie interfacecategorie = new ServiceCatégorie();


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
            fxmlLoader.setLocation(getClass().getResource("Affichage de catégorieFront.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
            AffichagedeCatégorieFrontController affichagedecategoriefrontcontroller = fxmlLoader.getController();
            affichagedecategoriefrontcontroller.setData(ct);
            
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

    @FXML
    private void SwitchtoProduit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionProduitFrontFXML.fxml"));
        ((BorderPane)ptGP.getParent().getParent()).setLeft(null);
           ((BorderPane)ptGP.getParent().getParent()).setCenter(root);
    }
    
}
