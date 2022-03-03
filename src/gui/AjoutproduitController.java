/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.FileChooser;

import javax.swing.JFileChooser;
import models.Produit;
import service.ServiceProduit;
import service.ServiceCatégorie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author chedi
 */
public class AjoutproduitController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

   
    //var
    ServiceProduit sp = new ServiceProduit();
    ServiceCatégorie sc = new ServiceCatégorie();
    
    
    @FXML
    private TextField nomTXT;
    @FXML
    private TextField prixTXT;
    @FXML
    private TextField categorieTXT;
    @FXML
    private TextField promotionTXT;
    @FXML
    private Button ajouterproduit;
    File selectedFile;
    private Label afficherlabel;
    @FXML
    private ImageView screenshotView;
    @FXML
    private Button image;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    

        
        
    }    

    @FXML
    private void ajouterporduit(ActionEvent event) {
        
       
            if (nomTXT.getText().length() == 0 || prixTXT.getText().length() == 0 || categorieTXT.getText().length() == 0 || promotionTXT.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
           
            alert.show();

        } else {
           
            sp.ajouterProduit(new Produit(sc.retrivecatégorie(Integer.parseInt(categorieTXT.getText())),nomTXT.getText(), Integer.parseInt(prixTXT.getText()),this.image.getText(),Integer.parseInt(promotionTXT.getText())));
        }
            
    }
    private String path;

 

    

 

    @FXML
    private void image(ActionEvent event) throws MalformedURLException {
        
        
               FileChooser fc = new FileChooser();
        fc.setTitle("Veuillez choisir l'image");
        String userDirectoryString = System.getProperty("user.home") + "\\Desktop";
        File userDirectory = new File (userDirectoryString);
        
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", ".jpg", ".png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            path = selectedFile.getName();
            screenshotView.setImage(new Image(selectedFile.toURI().toURL().toString()));
            screenshotView.setFitHeight(150);
            screenshotView.setFitWidth(250);
            image.setText(path);
    
    }
    }
    
    @FXML
    public void switchtoAfficher(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("mainFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void switchToCategorie(ActionEvent event) throws IOException {
          root = FXMLLoader.load(getClass().getResource("ajoutcategorie.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    
 
    


   
    
}
