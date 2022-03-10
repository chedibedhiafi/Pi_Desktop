/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iutilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Employe;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class UtilisateursBackFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Employe e;
    Iutilisateur su = new ServiceUtilisateur();
    
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private GridPane gridpane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadGP();
    }  
    
    public void setEmploye(Employe e)
    {
        this.e=e;
    }   
    
    private void loadGP(){
        
        gridpane.getChildren().clear();
        int column = 0;
        int row = 0;
        int maxColumn = 3;
        for (Utilisateur u : su.afficherUtilisateurs()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UtilisateurFXML.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();               
            
            UtilisateurFXMLController uc = fxmlLoader.getController();
            uc.setData(u);
            if(column == maxColumn){
                column =0;
                row++;
            }
            
            gridpane.add(anchorPane,column++,row);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }
    }
    
}
