/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iproduits;
import interfaces.Istock;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.Stock;
import services.ServiceProduit;
import services.ServiceStock;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class StockProduitController implements Initializable {

    Stock stock;
    Istock interfaceStock = new ServiceStock();
    Iproduits interfaceProduit = new ServiceProduit();
    
    
    @FXML
    private ImageView imgIV;
    @FXML
    private Label nameLBL;
    @FXML
    private Label referenceLBL;
    @FXML
    private Label quantiteLBL;
    @FXML
    private Label idLBL;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setData(Stock stck){
        this.stock = stck;
        this.idLBL.setText(String.valueOf(stck.getPointdevente().getReference()));
        this.referenceLBL.setText(String.valueOf(stck.getProduit().getId()));
        this.nameLBL.setText(stck.getProduit().getNom());
        
        this.quantiteLBL.setText(String.valueOf(stck.getQuantite()));
        
    }

    
}
