/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import interfaces.*;
import java.io.IOException;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Catégorie;
import service.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class MainCategorieFXMLController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
     ServiceCatégorie sc = new ServiceCatégorie();

    
    
    Icatégorie interfacecategorie = new ServiceCatégorie();
    @FXML
    private GridPane ptGP;
    @FXML
    private Label nomLBL;
    @FXML
    private TextField nomTXT;
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
            fxmlLoader.setLocation(getClass().getResource("categorie.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
                categorieController categorieController = fxmlLoader.getController();
            categorieController.setData(ct);
            
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

    @FXML
    private void switchtoAjouterCategorie(ActionEvent event) throws IOException {
           root = FXMLLoader.load(getClass().getResource("ajoutcategorie.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelectClicked(MouseEvent event) {
            Node source = (Node)event.getTarget() ;
        System.out.println(getDataFromScene(source.getParent().getParent()));
    }
    private Catégorie getDataFromScene(Parent scene){
        
        Label nomLBL = (Label) scene.lookup("#nomLBL");
//        Label promotionLBL = (Label) scene.lookup("#promotionLBL");
//        Label categorieLBL = (Label) scene.lookup("#categorieLBL");
//        Label prixLBL = (Label) scene.lookup("#prixLBL");
       Label idLBL = (Label) scene.lookup("#idLBL");
        
        System.out.println(idLBL.getText());
             sc.modifierCatégorie(new Catégorie(Integer.parseInt(idLBL.getText()),nomTXT.getText()));

        
        return new Catégorie();
        
        
    }
    

}
    

