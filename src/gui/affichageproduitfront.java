/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iproduits;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Produit;
import services.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class affichageproduitfront implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Label idLBL;
    @FXML
    private Label profitLBL;
    @FXML
    private Label categorieLBL;
    @FXML
    private Label promotionLBL;
    @FXML
    private Label nomLBL;
    @FXML
    private Label prixLBL;
    @FXML
    private Label descriptionLBL;
    private Produit produit;
    Iproduits interfaceProduits = new ServiceProduit();

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
       
    }    
      public void setData(Produit pt){
          
        this.produit = pt;
        this.idLBL.setText(String.valueOf(pt.getId()));
        this.nomLBL.setText(pt.getNom());
        this.prixLBL.setText(String.valueOf(pt.getPrix()));
        this.categorieLBL.setText(String.valueOf(pt.getCatégorie().getId()));
        this.promotionLBL.setText(String.valueOf(pt.getPromotion().getId()));
        this.descriptionLBL.setText(pt.getDescription());
        this.profitLBL.setText(String.valueOf(pt.getProfit()));
      // Image imn = new Image("file:/C:/Users/chedi/Documents/NetBeansProjects/imageproduit/download.jpg"+pt.getImage(),false);
      // image.setImage(imn);
       Image imn = new Image("file:/C:/Users/21624/Desktop/Esprit 3eme/2eme Semestre/PI Dev/Quantech/"+pt.getImage(),false);
      image.setImage(imn);
       
    }
    
}
