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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.Produit;
import service.ServiceProduit;
import service.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class modifierProduitController implements Initializable {
       ServiceProduit sp = new ServiceProduit();
       ServiceCatégorie sc = new ServiceCatégorie();

    @FXML
    private ImageView imageView;
    @FXML
    private Label nomLBL;
    @FXML
    private Label prixLBL;
    @FXML
    private Label categorieLBL;
    @FXML
    private Label promotionLBL;
    @FXML
    private Button modifierproduit;
    @FXML
    private Label idLBL;
    @FXML
    private TextField nomTXT;
    @FXML
    private TextField prixTXT;
    @FXML
    private TextField categorieTXT;
    @FXML
    private TextField promotionTXT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierBTN(ActionEvent event) {
     sp.modifierProduit(new Produit(sc.retrivecatégorie(Integer.parseInt(categorieTXT.getText())),nomTXT.getText(),Integer.parseInt(prixTXT.getText()),Integer.parseInt(promotionTXT.getText())));
        
    }
    
}
