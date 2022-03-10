/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import interfaces.Icatégorie;
import interfaces.Iproduits;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import models.Catégorie;
import models.Produit;
import models.Promotion;
import services.ServiceCatégorie;
import services.ServiceProduit;
import services.ServicePromotion;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class GestionProduitFXMLController implements Initializable {

   ServiceProduit sp = new ServiceProduit();

    Iproduits interfaceproduit = new ServiceProduit();
    @FXML
    private GridPane ptGP;

    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int column = 0;
        int row = 0;

        for (Produit pt : interfaceproduit.afficherProduit()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Affichage de produit.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                AffichagedeProduitController affichagedeproduitcontroller = fxmlLoader.getController();
                affichagedeproduitcontroller.setData(pt);

                if (column == 2) {
                    column = 0;
                    row++;
                }
                ptGP.add(anchorPane, column++, row);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    private void LoadData() {

    }

   

   

    @FXML
    private void SwitchToCatégorie(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("gestionCatégorieFXML.fxml"));
        ((BorderPane)ptGP.getParent().getParent()).setLeft(null);
         ((BorderPane)ptGP.getParent().getParent()).setCenter(root);
    }



 

   

  

    @FXML
    private void switchToAjouter(ActionEvent event) throws IOException {
           root = FXMLLoader.load(getClass().getResource("AjoutproduitFXML.fxml"));
            ((BorderPane)ptGP.getParent().getParent()).setCenter(root);
    }

  

    
}
