/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IhistoriqueStock;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Produit;
import models.Stock;
import services.ServiceHistoriqueStock;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class AcceuilController implements Initializable {

    @FXML
    private GridPane bestSellersGP;
    IhistoriqueStock interfaceHistorique = new ServiceHistoriqueStock();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadGP();
    }    
    
    public void loadGP(){
        
        int maxColumns = 2;
        
        
        int column = 0;
        int row = 0;
        
        bestSellersGP.getChildren().clear();
        List<Stock> list = null;
        
        
        for (Produit p : interfaceHistorique.bestSellersThisMonth(Date.valueOf(LocalDate.now()))){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("produitStock.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
                
            
            ProduitStockController recommendedController = fxmlLoader.getController();
            recommendedController.setData(p);
            recommendedController.hideQuantite();
            
            if(column < 3)
                bestSellersGP.add(anchorPane,column++,0);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }
        
            
        

    }

    
}
