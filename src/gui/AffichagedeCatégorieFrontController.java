/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.Catégorie;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class AffichagedeCatégorieFrontController implements Initializable {

    @FXML
    private Label nomLBL;
    @FXML
    private Label idLBL;
     private Catégorie categorie;


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
    
}
