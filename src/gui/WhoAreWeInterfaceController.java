/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import interfaces.IpointDeVente;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import models.PointDeVente;
import services.ServicePointDeVente;


/**
 * FXML Controller class
 *
 * @author 21624
 */
public class WhoAreWeInterfaceController implements Initializable{
    
    IpointDeVente interfaceDeVente = new ServicePointDeVente();

    @FXML
    private Pane mapPane;
    @FXML
    private GridPane pointdeventeGP;
    @FXML
    private ScrollPane scrollpane;
  
    @FXML
    private BorderPane mapBorderPane;
   

    /**
     * Initializes the controller class.
     */
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      scrollpane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
      scrollpane.setVbarPolicy(ScrollBarPolicy.NEVER);
      loadGP();
      loadMap();
          }
    
    //LOAD WEBVIEW
    private void loadMap(){
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        File f = new File("index.html");
        webView.getEngine().load(f.toURI().toString());
        mapBorderPane.setCenter(webView);
    }
    
    //LOAD DATA IN GRIDPANE
    private void loadGP(){
        
        pointdeventeGP.getChildren().clear();
        int column = 0;
        for (PointDeVente pt : interfaceDeVente.afficherPointDeVentes()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ptdevente.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
                
            
            PtdeventeController ptdeventeController = fxmlLoader.getController();
            ptdeventeController.setData(pt);
                        
 
            
            pointdeventeGP.add(anchorPane,column++,0);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }

    }
    
}