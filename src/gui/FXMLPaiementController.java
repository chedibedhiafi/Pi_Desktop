/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import static gui.FXMLPanierController.id_user;
import javafx.scene.layout.BorderPane;
import services.ServiceCommande;
import utils.AlertBox;
import utils.JavaMailUtil;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLPaiementController implements Initializable {

    @FXML
    private Button pass1;
    @FXML
    private RadioButton chequeTF;
    @FXML
    private RadioButton livTF;
    @FXML
    private RadioButton carteTF;
    @FXML
    private Button retourP;
    @FXML
    private Label idliv;
    @FXML
    private Label idliv1;
    @FXML
    private Label nomliv;
    @FXML
    private Label prenomliv;
    @FXML
    private Label numliv;
    @FXML
    private Label adresseliv;
   
    public ToggleGroup rbs;
    private ImageView imgTF;
    private ImageView IMGTF;
    private ImageView quanTF1;
    @FXML
    private Label fraisliv;
    @FXML
    private Label lbtotal;
    @FXML
    private Label lbMontantPayer;
    @FXML
    private Label tFremise;
    ServiceCommande svc= new ServiceCommande();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         rbs= new ToggleGroup();
        
       carteTF.setUserData("Paiement par carte bancaire");
       chequeTF.setUserData("chéque/mondat");
       livTF.setUserData("Paiement a la livraison");
        carteTF.setToggleGroup(rbs);
        chequeTF.setToggleGroup(rbs);
        livTF.setToggleGroup(rbs);
        if(svc.iSRemise(id_user))
        {
            AlertBox.display("felicitation cher client","apres votre 3eme commande vous avez reçu une remise de 30 %  ");
            FXMLPanierController.Total= (float) (FXMLPanierController.Total*0.7);
        }
        lbtotal.setText(String.valueOf(FXMLPanierController.Total)+ "Dt");
        int liv=Integer.parseInt(String.valueOf(FXMLLivraisonController.liv.getMethode().charAt(0)));
        lbMontantPayer.setText(String.valueOf(FXMLPanierController.Total+liv)+" Dt");
        tFremise.setText("30%");
        
     
       
        
        // TODO
        System.out.println(FXMLLivraisonController.liv.getNom());
        nomliv.setText(FXMLLivraisonController.liv.getNom());
        prenomliv.setText(FXMLLivraisonController.liv.getPrenom());
        numliv.setText(String.valueOf(FXMLLivraisonController.liv.getNumtel()));
        adresseliv.setText(FXMLLivraisonController.liv.getAdresse());
        fraisliv.setText(FXMLLivraisonController.liv.getMethode());
         
      
        
    }    

    @FXML
    private void passerlacommande(ActionEvent event) throws MessagingException {
            Twilio.init("AC268d223c5f0e79618f2a405830ee9353","c8e75eafe1faaacecc5f2ba1791e0691");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+216"+numliv.getText()),
                new com.twilio.type.PhoneNumber("+19107145409"),
                "Salut, Mr "+nomliv.getText()+" "+prenomliv.getText()+" Votre commande a été passée avec succès").create();

        System.out.println(message.getSid());
        
        JavaMailUtil.sendMail("touzri.mariem@esprit.tn"
                , "récapitulatif de votre commande "
                ,"\n Votre Adresse:"+adresseliv.getText()+" \n une total de "+lbtotal.getText()+" \n Frais Livraison: "+fraisliv.getText()+" Dt \n Montant Total à payé :"+lbMontantPayer.getText()+" \n taux de remise : 30%");
     
    }

    @FXML
    private void parcheque(ActionEvent event) {
    }

    @FXML
    private void paiementliv(ActionEvent event) {
    }


    @FXML
    private void retour(ActionEvent event) throws IOException  {
       
        
        Parent etab = FXMLLoader.load(getClass().getResource("FXMLLivraison.fxml"));      
        ((BorderPane)lbtotal.getParent().getParent()).setCenter(etab);
    }

    @FXML
    private void cartebancaire(ActionEvent event) throws IOException {
     
       
        Parent etab = FXMLLoader.load(getClass().getResource("FXMLCarte.fxml"));      
        ((BorderPane)lbtotal.getParent().getParent().getParent()).setCenter(etab);
    }
    
    
    
}
