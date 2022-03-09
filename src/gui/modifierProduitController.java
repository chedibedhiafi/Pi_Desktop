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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Catégorie;
import service.ServiceProduit;
import models.Produit;
import models.Promotion;
import service.ServiceCatégorie;
import service.ServicePromotion;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class modifierProduitController implements Initializable {
ServiceProduit sp = new ServiceProduit();
 ServicePromotion ip = new ServicePromotion();
         ServiceCatégorie sc = new ServiceCatégorie();

    @FXML
    private Label nomLBL;
    @FXML
    private Label prixLBL;
    @FXML
    private Label categorieLBL;
    @FXML
    private Label promotionLBL;
    @FXML
    private Label descriptionLBL;
    @FXML
    private TextField nomTXT;
    @FXML
    private TextField prixTXT;
    @FXML
    private ComboBox  categorieCOMBO;
    @FXML
    private ComboBox  promotionCOMBO;
    @FXML
    private TextArea descriptionTXT;
    @FXML
    private Button image;
    @FXML
    private ImageView screenshotView;
    @FXML
    private Label profitLBL;
    @FXML
    private TextField profitTXT;
    private String path;
    File selectedFile;
    @FXML
    private Label idLBL;
    @FXML
    private Button ModifierBTN;
     private Stage stage;
    private Scene scene;
    private Parent root;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceCatégorie sc = new ServiceCatégorie();
        
        List <Catégorie> cat = sc.afficherCatégorie();
        for (Catégorie c : cat  ){
            categorieCOMBO.getItems().addAll(c.getNom());
        }
        ServicePromotion ip = new ServicePromotion();
        List <Promotion> pro = ip.afficherPromotion();
        for (Promotion pr : pro  ){
            promotionCOMBO.getItems().addAll(pr.getPercentage());
        }
    }    

    @FXML
    private void image(ActionEvent event) throws MalformedURLException {
          FileChooser fc = new FileChooser();
        fc.setTitle("Veuillez choisir l'image");
        String userDirectoryString = System.getProperty("user.home") + "\\Desktop";
        File userDirectory = new File(userDirectoryString);

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
    public void idproduit (String idproduit){
        
       this.idLBL.setText(idproduit);
        System.out.println(idLBL.getText());
    }

    @FXML
    private void ModifierBtn(ActionEvent event) {
        sp.modifierProduit(new Produit(Integer.parseInt(this.idLBL.getText()),sc.rechercheCatégorie(String.valueOf(categorieCOMBO.getValue())).get(0),ip.retrievePromotionBypercentage((int) promotionCOMBO.getValue()),nomTXT.getText(),Integer.parseInt(prixTXT.getText()),this.image.getText(),descriptionTXT.getText(),Integer.parseInt(profitTXT.getText())));
        
    }

    @FXML
    private void switchtoafficher(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionProduitFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
}
