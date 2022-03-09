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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Catégorie;
import service.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class AffichagedeCatégorieController implements Initializable {
 private Catégorie categorie;
    @FXML
    private ImageView image;
    @FXML
    private Label nomLBL;
    @FXML
    private Button supprimerproduit;
    @FXML
    private Button modifierBTN;
    @FXML
    private Label idLBL;
 private Stage stage;
    private Scene scene;
    private Parent root;
    ServiceCatégorie sc = new ServiceCatégorie();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }
         public void setData(Catégorie ct){
             
         
         this.categorie = ct; 
        
        this.idLBL.setText(String.valueOf(ct.getId()));
        this.nomLBL.setText(ct.getNom());
        
      
       
    }
    

    @FXML
    private void supprimerBTN(ActionEvent event) {
        Catégorie c = new Catégorie();
          c.setId(Integer.parseInt(this.idLBL.getText()));
          ServiceCatégorie sc = new ServiceCatégorie();
          
          sc.supprimerCatégorie(c);
    }

    @FXML
    private void modifierBTN(ActionEvent event) throws IOException {
           String idcategorie = idLBL.getText();
           System.out.println(idLBL.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierCategorie.fxml"));
        root = loader.load();
        ModifierCategorieController modifiercategoriecontroller = loader.getController();
        modifiercategoriecontroller.idcategorie(idcategorie);
         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    }
    

