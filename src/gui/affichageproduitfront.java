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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Commande;
import models.Produit;
import models.ProduitCommande;
import services.ServiceProduitCommande;

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
    @FXML
    private Button Addpanier;
    public static Produit pred;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    
      public void setData(Produit pt){
        pred=pt;
        this.produit = pt;
        this.idLBL.setText(String.valueOf(pt.getId()));
        this.nomLBL.setText(pt.getNom());
        this.prixLBL.setText(String.valueOf(pt.getPrix()));
        this.categorieLBL.setText(String.valueOf(pt.getCatégorie().getNom()));
        this.promotionLBL.setText(String.valueOf(pt.getPromotion().getId()));
        this.descriptionLBL.setText(pt.getDescription());
        this.profitLBL.setText(String.valueOf(pt.getProfit()));
      // Image imn = new Image("file:/C:/Users/chedi/Documents/NetBeansProjects/imageproduit/download.jpg"+pt.getImage(),false);
      // image.setImage(imn);
       Image imn = new Image("file:/C:/Users/21694/Documents/NetBeansProjects/Quantech/src/gui/elements/images/produits/"+pt.getImage(),false);
      image.setImage(imn);
       
    }

    @FXML
    private void fnAddPanier(ActionEvent event) {
        ServiceProduitCommande serp=new ServiceProduitCommande();
        ProduitCommande pc=new ProduitCommande();
        pc.setP(pred);
        Commande c=new Commande();
        c.setId(1);
        pc.setC(c);
        serp.ajouterProduitCommande(pc);
    }
    
}
