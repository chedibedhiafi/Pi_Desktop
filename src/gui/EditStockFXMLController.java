/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IpointDeVente;
import interfaces.Iproduits;
import interfaces.Istock;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.PointDeVente;
import models.Stock;
import services.ServicePointDeVente;
import services.ServiceProduit;
import services.ServiceStock;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class EditStockFXMLController implements Initializable {
    Iproduits interfaceProduits = new ServiceProduit();
    Istock interfaceStock = new ServiceStock();
    IpointDeVente interfaceDeVente = new ServicePointDeVente();
    PointDeVente point;
    
    @FXML
    private GridPane stockGP;
    @FXML
    private Label nameLBL;
    @FXML
    private Label adresseLBL;
    @FXML
    private Label proprioLBL;
    @FXML
    private Label dateOuvLBL;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.point = interfaceDeVente.retrievePointDeVente(4);
        loadGP();
    }    
    
    //LOAD DATA IN GRIDPANE
    public void loadGP(){
        
        int maxColumns = 2;
        
        
        int column = 0;
        int row = 0;
        
        stockGP.getChildren().clear();
        List<Stock> list = null;
        
        if(this.point == null)
            list = interfaceStock.afficherStocks();
        else
            list = interfaceStock.findStockPointDeVente(this.point);
        
        
        for (Stock stck : list){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Affichage de produit Front.fxml"));
            
            AnchorPane anchorPane = fxmlLoader.load();
                
            
            affichageproduitfront stockProduitController = fxmlLoader.getController();
            stockProduitController.setData(stck.getProduit());
            
            
            if(column == maxColumns){
                column = 0;
                row++;
            }
            
            stockGP.add(anchorPane,column++,row);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }

    }
    
}
