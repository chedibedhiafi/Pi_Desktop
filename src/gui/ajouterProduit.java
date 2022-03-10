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
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
 * @author chedi
 */
public class ajouterProduit implements Initializable {

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
    private Label profitLBL;
    @FXML
    private TextField nomTXT;
    @FXML
    private TextField prixTXT;
    @FXML
    private ComboBox comboCategorie;
    @FXML
    private ComboBox comboPromotion;
    @FXML
    private TextArea descriptionTXT;
    @FXML
    private TextField profitTXT;
    @FXML
    private Button image;
    @FXML
    private ImageView screenshotView;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ServiceProduit sp = new ServiceProduit();
    ServiceCatégorie sc = new ServiceCatégorie();
    ServicePromotion ip = new ServicePromotion();
    @FXML
    private Button btngr;
    private String path;
    File selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCatégorie sc = new ServiceCatégorie();
        
        List <Catégorie> cat = sc.afficherCatégorie();
        for (Catégorie c : cat  ){
            comboCategorie.getItems().addAll(c.getNom());
        }
        ServicePromotion ip = new ServicePromotion();
        List <Promotion> pro = ip.afficherPromotion();
        for (Promotion pr : pro  ){
            comboPromotion.getItems().addAll(pr.getPercentage());
        }
        
        
        // TODO
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
    

    

    @FXML
    private void switchToafficher(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionProduitFXML.fxml"));
     
           ((BorderPane)comboCategorie.getParent().getParent().getParent()).setCenter(root);
    }

    @FXML
    private void ajouterProduits(ActionEvent event) {
          if (nomTXT.getText().length() == 0 || prixTXT.getText().length() == 0 || descriptionTXT.getText().length() == 0 || profitTXT.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
           
            alert.show();

        } else {
        Produit p = new Produit(sc.rechercheCatégorie(String.valueOf(comboCategorie.getValue())).get(0),ip.retrievePromotionBypercentage((int) comboPromotion.getValue()),nomTXT.getText(),Integer.parseInt(prixTXT.getText()),this.image.getText(),descriptionTXT.getText(),Integer.parseInt(profitTXT.getText()));
        System.out.println(p);
        sp.ajouterProduit(p);
          }
    }

    @FXML
    private void generateQRCode(MouseEvent event) throws WriterException, IOException {
         String qrCodeText = "Le nom du produi est est : "
                + nomTXT.getText() + ". \n Sa Prix est : "
                + prixTXT.getText() + ". \n Sa Description est : "
                 +descriptionTXT.getText()+"";

        // Vérification de l'emplacement de l'image
        String filePath = "C:\\Users\\21694/Desktop/QR.png";
        // Change path not to ecrase old file
        int size = 500;
        String fileType = "png";
        File qrFile = new File(filePath);
        createQRImage(qrFile, qrCodeText, size, fileType);
        createQRImage(qrFile, qrCodeText, size, fileType);

        System.out.println(
                " Création de l'image avec succés ");
    }
    private static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
            throws WriterException, IOException {
        // Create the ByteMatrix for the QR-Code that encodes the given String
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, 500, 500, hintMap);
        // Make the BufferedImage that are to hold the QRCode
        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        // Paint and save the image using the ByteMatrix
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        ImageIO.write(image, fileType, qrFile);

    }

    
    
}
