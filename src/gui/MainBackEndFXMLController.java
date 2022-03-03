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
import interfaces.*;
import java.io.IOException;



import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import models.Utilisateur;
import services.*;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class MainBackEndFXMLController implements Initializable {

    
    Utilisateur utilisateur;
    IpointDeVente interfacePointDeVente = new ServicePointDeVente();
    @FXML
    private Button pointDeVenteBTN;
    @FXML
    private BorderPane mainborderPane;
    @FXML
    private Button acceuilButton;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mainborderPane.setCenter(getPage("acceuil.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void PointDeVente_clicked(ActionEvent event) throws IOException {
        mainborderPane.setCenter(getPage("gestionPointDeVente.fxml"));
        
    }
    
    private AnchorPane getPage(String path) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(path));
            
            AnchorPane anchorPane = fxmlLoader.load();
            return anchorPane;
        
    }


    @FXML
    private void aceuilClicked(ActionEvent event) throws IOException {
        mainborderPane.setCenter(getPage("acceuil.fxml"));
    }
    }
    
    

