/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iutilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ProfilFXMLController implements Initializable {
    
    public Utilisateur u;
    Iutilisateur su = new ServiceUtilisateur();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField loginTF;
    @FXML
    private Label changermdp;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField DateTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
           }   
    
    public boolean afficher(Utilisateur u)
    {
        loginTF.setText(u.getLogin());
        prenomTF.setText(u.getPrenom());
        nomTF.setText(u.getNom());
        DateTF.setText(u.getDate_naissance().toString());
        EmailTF.setText(u.getEmail());
        this.u=u;
        return true;
    }

    @FXML
    private void changermdp(MouseEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changermdpFXML.fxml"));
           Parent anchorPane = (AnchorPane) loader.load();
           //The following both lines are the only addition we need to pass the arguments
           ChangermdpFXMLController pc = loader.getController();
           System.out.println(pc);
           pc.setUtilisateur(this.u);

        
           ((BorderPane)((Node)event.getSource()).getParent().getParent()).setCenter(anchorPane);
    
    }

    @FXML
    private void modifier(ActionEvent event) {
        Utilisateur u1 = new Utilisateur(u.getId(),loginTF.getText(),u.getMdp(),Date.valueOf(DateTF.getText()),nomTF.getText(),prenomTF.getText(),EmailTF.getText());
        u1 = su.modifierUtilisateur(u1);
        if(u1.getEtat().equals("succes"))
        {
            JOptionPane.showMessageDialog(null, "Votre profil a été modifié");
            this.u= u1;
        }
         
        else
            JOptionPane.showMessageDialog(null, "Echec de modification");
    }

    
}
