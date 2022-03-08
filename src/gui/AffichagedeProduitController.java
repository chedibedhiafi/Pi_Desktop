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
import models.Produit;
import services.ServiceProduit;
import services.ServiceCatégorie;
import services.ServicePromotion;


/**
 * FXML Controller class
 *
 * @author chedi
 */
public class AffichagedeProduitController implements Initializable {

    
    private Produit produit;
    private Label imageView;
    @FXML
    private Label nomLBL;
    @FXML
    private Label prixLBL;
    @FXML
    private Label categorieLBL;
    @FXML
    private Label promotionLBL;
    @FXML
    private Label descriptionLBL;
    @FXML
    private Label profitLBL;
    @FXML
    private Button supprimerproduit;
    @FXML
    private Label idLBL;
    @FXML
    private Button modifierBTN;
    private Label imageLBL;
    @FXML
    private ImageView image;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
       Image imn = new Image("file:/C:/Users/chedi/Documents/NetBeansProjects/imageproduit/"+pt.getImage(),false);
      image.setImage(imn);
       
    }
      

    @FXML
    private void supprimerBTN(ActionEvent event) {
        Produit p = new Produit();
          p.setId(Integer.parseInt(this.idLBL.getText()));
          ServiceProduit sp = new ServiceProduit();
          
          sp.supprimerProduit(p);
    }

    @FXML
    private void modifierBTN(ActionEvent event) {
    }

    @FXML
    private void Promotion(ActionEvent event) {
        Produit p = new Produit();
      
          ServiceProduit sp = new ServiceProduit();
          ServiceCatégorie sc = new ServiceCatégorie();
          ServicePromotion ip = new ServicePromotion();
          p.setId(Integer.parseInt(this.idLBL.getText()));
          p.setCatégorie(sc.retrivecatégorie(Integer.parseInt(this.categorieLBL.getText())));
          p.setPromotion(ip.retrivepromotion(Integer.parseInt(this.promotionLBL.getText())));
         p.setNom(this.nomLBL.getText());
         p.setPrix(Integer.parseInt(this.prixLBL.getText()));
         p.setDescription(this.descriptionLBL.getText());
         p.setProfit(Integer.parseInt(this.profitLBL.getText()));
//       System.out.println(idLBL.getText());
//       System.out.println(categorieLBL.getText());
//      System.out.println(promotionLBL.getText());
//      System.out.println(nomLBL.getText());
//        System.out.println(prixLBL.getText());
//        System.out.println(descriptionLBL.getText());
       
//        System.out.println(profitLBL.getText());
sp.calculerPromotion(new Produit(Integer.parseInt(idLBL.getText()),sc.retrivecatégorie(Integer.parseInt(categorieLBL.getText())),ip.retrivepromotion(Integer.parseInt(promotionLBL.getText())),nomLBL.getText(),Integer.parseInt(this.prixLBL.getText()),descriptionLBL.getText(),Integer.parseInt(profitLBL.getText())));
    }
        
    

    

    
    
}
