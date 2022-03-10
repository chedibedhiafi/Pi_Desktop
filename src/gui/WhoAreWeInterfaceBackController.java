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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JFrame;
import models.PointDeVente;
import services.ServicePointDeVente;


/**
 * FXML Controller class
 *
 * @author 21624
 */
public class WhoAreWeInterfaceBackController implements Initializable{
    
    IpointDeVente interfaceDeVente = new ServicePointDeVente();
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();


    @FXML
    private Pane mapPane;
    @FXML
    private GridPane pointdeventeGP;
    @FXML
    private ScrollPane scrollpane;
  
    @FXML
    private BorderPane mapBorderPane;
    @FXML
    private Button plusButton;
   

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
        File f = new File("index.html");
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<Worker.State>() {
              @Override public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                  if (newState == Worker.State.SUCCEEDED) {
                      for (PointDeVente point : interfaceDeVente.afficherPointDeVentes())
                        webEngine.executeScript("addMarker("+point.getLongitude()+",'"+point.getLatitude()+"')");                    
                }
                }
            });

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

    @FXML
    private void onGP_clicked(MouseEvent event) throws IOException, InterruptedException {
        PointDeVente targetPoint;
        Node source = (Node)event.getTarget() ;
        if(source.getParent() instanceof Pane){
         targetPoint = getDataFromScene(source.getParent());
        }
        else{
            targetPoint = getDataFromScene(source.getParent().getParent());
        }
       
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editPointDeVente.fxml"));
        Parent root = loader.load();
        //The following both lines are the only addition we need to pass the arguments
        EditPointDeVenteFXMLController editController = loader.getController();
        editController.setData(targetPoint);
        ((BorderPane)mapPane.getParent().getParent()).setCenter(root);
    }
    
    private PointDeVente getDataFromScene(Parent scene){
        PointDeVente pt = new PointDeVente();
        Label idLBL = (Label) scene.lookup("#idLBL");
        pt.setReference(Integer.parseInt(idLBL.getText()));
        
        return pt; 
    }

    @FXML
    private void onPlusButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editPointDeVente.fxml"));
        Parent root = loader.load();
        //The following both lines are the only addition we need to pass the arguments
        EditPointDeVenteFXMLController editController = loader.getController();
        editController.setData(new PointDeVente());
        ((BorderPane)mapPane.getParent().getParent()).setCenter(root);
            editController.loadMap();

    }
}