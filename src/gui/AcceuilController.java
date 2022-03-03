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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.Produit;
import services.ServiceHistoriqueStock;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class AcceuilController implements Initializable {

    IhistoriqueStock interfaceHistorique = new ServiceHistoriqueStock();
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Pane paneId;
    @FXML
    private ScrollPane scrollPaneID;
    @FXML
    private GridPane ptGP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadGP();
    }    

    @FXML
    private void onGP_clicked(MouseEvent event) {
    }
    
    private void loadGP(){
        int maxColumns = 3;
        
        int column = 0;
        int row = 0;
        
        ptGP.getChildren().clear();
    
        for (Produit p : interfaceHistorique.bestSellersThisMonth(Date.valueOf(LocalDate.now()))){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("recommendedProduct.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
                
            
            RecommendedProductController recommendedController = fxmlLoader.getController();
            recommendedController.setData(p);
            
            if(column < 3)
                ptGP.add(anchorPane,column++,0);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }

    }
    
    
}
