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
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import models.PointDeVente;
import services.ServicePointDeVente;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class EditPointDeVenteFXMLController implements Initializable {

    PointDeVente point = new PointDeVente();
    IpointDeVente interfaceDeVente = new ServicePointDeVente();
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();

    
    @FXML
    private BorderPane mapBorderPane;
    @FXML
    private Label ajouterModifierLBL;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField proprioTF;
    @FXML
    private TextField adresseTF;
    @FXML
    private DatePicker dateOuvDP;
    @FXML
    private Label longitudeLBL;
    @FXML
    private Label latitudeLBL;
    @FXML
    private Label idLBL;
    @FXML
    private Button ajouterModifierBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    
    public void setData(PointDeVente p){
        if(p.getReference() == 0){
            fillLabelsAjouter();
        }
        else{
            this.point = interfaceDeVente.retrievePointDeVente(p.getReference());
            fillLabelsModifier();     
        }
        loadMap();
    }
    
    public void fillLabelsModifier(){
        ajouterModifierLBL.setText("Modifier un point de vente");
        nomTF.setText(this.point.getName());
        proprioTF.setText(this.point.getProprietaire());
        adresseTF.setText(this.point.getAdresse());
        longitudeLBL.setText(this.point.getLongitude());
        latitudeLBL.setText(this.point.getLatitude());
        dateOuvDP.setValue(this.point.getDate_ouverture().toLocalDate());
        idLBL.setText(String.valueOf(this.point.getReference()));
        ajouterModifierBTN.setText("MODIFIER");
        
    }
    
    public void fillLabelsAjouter(){
        ajouterModifierLBL.setText("Ajouter un point de vente");
        ajouterModifierBTN.setText("AJOUTER");
    }

    
    public void loadMap() {
        File f = new File("index.html");
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<State>() {
              @Override public void changed(ObservableValue ov, State oldState, State newState) {

                  if (newState == Worker.State.SUCCEEDED) {
                      if(point.getReference() != 0){
                    webEngine.executeScript("addMarker("+point.getLongitude()+",'"+point.getLatitude()+"')");
                    webEngine.executeScript("goTo("+point.getLongitude()+",'"+point.getLatitude()+"')");
                      }
                }
                  
                  
                  
                }
            });

        webView.getEngine().load(f.toURI().toString());
        mapBorderPane.setCenter(webView);
       // if (webView.getEngine().getLoadWorker().getState() != Worker.State.RUNNING)
    }
    
 
    @FXML
    private void onMPressed(KeyEvent event) {
        String coords = "0:0";
        if(event.getCode() == KeyCode.M){
            coords = (String) webEngine.executeScript("onClick()");
        }
        longitudeLBL.setText(coords.split(":")[0]);
        latitudeLBL.setText(coords.split(":")[1]);

    }
    
    private void updatePtDeVente(){
        this.point.setReference(Integer.parseInt(idLBL.getText()));
        this.point.setName(nomTF.getText());
        this.point.setAdresse(adresseTF.getText());
        this.point.setProprietaire(proprioTF.getText());
        this.point.setLongitude(longitudeLBL.getText());
        this.point.setLatitude(latitudeLBL.getText());
        this.point.setDate_ouverture(Date.valueOf(dateOuvDP.getValue()));
    }

    @FXML
    private void onAjouterModifierClicked(ActionEvent event) throws IOException {
        if(ajouterModifierBTN.getText() == "MODIFIER"){
            updatePtDeVente();
            interfaceDeVente.modifierPointDeVente(this.point);
        }
        if(ajouterModifierBTN.getText() == "AJOUTER"){
            updatePtDeVente();
            interfaceDeVente.ajouterPointDeVente(this.point);
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WhoAreWeInterfaceBack.fxml"));
        Parent root = loader.load();
        //The following both lines are the only addition we need to pass the arguments
        
        ((BorderPane)mapBorderPane.getParent()).setCenter(root);

        
    }

    @FXML
    private void returnBTN(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WhoAreWeInterfaceBack.fxml"));
        Parent root = loader.load();
        //The following both lines are the only addition we need to pass the arguments
        
        ((BorderPane)mapBorderPane.getParent()).setCenter(root);
    }

     
}
