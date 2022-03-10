/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iproduits;
import interfaces.Istock;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Produit;
import models.Stock;
import services.ServiceProduit;
import services.ServiceStock;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class ProduitStockController implements Initializable {
    private Produit produit;
    Iproduits interfaceProduits = new ServiceProduit();
    Istock interfaceStock = new ServiceStock();
    Stock stock;

    @FXML
    private ImageView image;
    @FXML
    private Label idLBL;
    @FXML
    private Label categorieLBL;
    @FXML
    private Label nomLBL;
    @FXML
    private Label prixLBL;
    @FXML
    private Label descriptionLBL;
    @FXML
    private Label profitLBL;
    @FXML
    private Label promotionLBL;
    @FXML
    private Label qteLBL;
    @FXML
    private Label quantitee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
     public void setData(Stock stck){
        this.stock = interfaceStock.retrieveStock(stck);
        this.produit = interfaceProduits.retriveproduit(stck.getProduit().getId());
        this.idLBL.setText(String.valueOf(stck.getProduit().getId()));
        this.nomLBL.setText(stck.getProduit().getNom());
        this.prixLBL.setText(String.valueOf(stck.getProduit().getPrix()));
        this.qteLBL.setText(String.valueOf(stck.getQuantite()));
        this.categorieLBL.setText(String.valueOf(stck.getProduit().getCatégorie().getId()));
        this.promotionLBL.setText(String.valueOf(stck.getProduit().getPromotion().getId()));
        this.descriptionLBL.setText(stck.getProduit().getDescription());
        this.profitLBL.setText(String.valueOf(stck.getProduit().getProfit()));
      // Image imn = new Image("file:/C:/Users/chedi/Documents/NetBeansProjects/imageproduit/download.jpg"+stck.getProduit().getImage(),false);
      // image.setImage(imn);
       Image imn;
        try {
            imn = new Image(new FileInputStream("src/gui/elements/images/produits/"+stck.getProduit().getImage()));
            image.setImage(imn);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
      
       
    }
     
     public void setData(Produit p){
       
        this.produit = interfaceProduits.retriveproduit(p.getId());
        this.idLBL.setText(String.valueOf(this.produit.getId()));
        this.nomLBL.setText(this.produit.getNom());
        this.prixLBL.setText(String.valueOf(this.produit.getPrix()));
        this.qteLBL.setText("0");
        this.categorieLBL.setText(String.valueOf(this.produit.getCatégorie().getId()));
        this.promotionLBL.setText(String.valueOf(this.produit.getPromotion().getId()));
        this.descriptionLBL.setText(this.produit.getDescription());
        this.profitLBL.setText(String.valueOf(this.produit.getProfit()));
      // Image imn = new Image("file:/C:/Users/chedi/Documents/NetBeansProjects/imageproduit/download.jpg"+stck.getProduit().getImage(),false);
      // image.setImage(imn);
       Image imn;
        try {
            imn = new Image(new FileInputStream("src/gui/elements/images/produits/"+this.produit.getImage()));
            image.setImage(imn);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
      
       
    }
     
     public void hideQuantite(){
         quantitee.setVisible(false);
         qteLBL.setVisible(false);
     }

    
}
