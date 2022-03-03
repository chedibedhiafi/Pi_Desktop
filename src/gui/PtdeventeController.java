/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.xml.bind.DatatypeConverter;
import models.Produit;
import service.ServiceProduit;
import gui.AjoutproduitController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.ServiceCatégorie;


/**
 * FXML Controller class
 *
 * @author 21624
 */
public class PtdeventeController implements Initializable {

   private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Produit produit;
    @FXML
    private Label idLBL;
    @FXML
    private Label nomLBL;
    @FXML
    private Label prixLBL;
    @FXML
    private Label categorieLBL;
    @FXML
    private Label promotionLBL;
    @FXML
    private Button supprimerproduit;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
    }    
    

    
    
    
    public void setData(Produit pt){
          
        this.produit = pt;
        this.idLBL.setText(String.valueOf(pt.getId()));
        this.nomLBL.setText(pt.getNom());
        this.prixLBL.setText(String.valueOf(pt.getPrix()));
        this.categorieLBL.setText(String.valueOf(pt.getCatégorie().getNom()));
        this.promotionLBL.setText(String.valueOf(pt.getPromotion()));
        
    }

    @FXML
    private void supprimerBTN(ActionEvent event) {
      Produit p = new Produit();
          p.setId(Integer.parseInt(this.idLBL.getText()));
          ServiceProduit sp = new ServiceProduit();
          sp.supprimerProduit(p);
        
    
         
    }

    private void modifierBTN(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("updateproduit.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         Produit p = new Produit();
          p.setId(Integer.parseInt(this.idLBL.getText()));
        
        
    }

  
    private void promotion(ActionEvent event) {
        Produit p = new Produit();
          p.setId(Integer.parseInt(this.idLBL.getText()));
          ServiceProduit sp = new ServiceProduit();
          ServiceCatégorie sc = new ServiceCatégorie();

            System.out.println(idLBL.getText());
          sp.calculerPromotion(new Produit(Integer.parseInt(idLBL.getText()),sc.retrivecatégorie(Integer.parseInt(categorieLBL.getText())),nomLBL.getText(),Integer.parseInt(prixLBL.getText()),Integer.parseInt(promotionLBL.getText())));
    }
    
}
