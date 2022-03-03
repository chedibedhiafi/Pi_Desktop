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
import models.Produit;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class RecommendedProductController implements Initializable {

    @FXML
    private Label nameLBL;
    private Produit produit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Produit prod){
        this.produit = prod;
        nameLBL.setText(prod.getNom());
    }
}
