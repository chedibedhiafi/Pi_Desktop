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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceCatégorie;
import models.Catégorie;
/**
 * FXML Controller class
 *
 * @author chedi
 */
public class ModifierCategorieController implements Initializable {
ServiceCatégorie sc = new ServiceCatégorie();
    @FXML
    private Label idLBL;
    @FXML
    private Label nomLBL;
    @FXML
    private TextField nomTXT;
     private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void idcategorie (String idcategorie){
        
        this.idLBL.setText(idcategorie);
        System.out.println(idLBL.getText());
        
    }
    @FXML
    private void modifiercategorie(ActionEvent event) {
        
        sc.modifierCatégorie(new Catégorie(Integer.parseInt(this.idLBL.getText()),nomTXT.getText()));
    }

    @FXML
    private void switchToCategorie(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("gestionCatégorieFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
