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
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ProfilController implements Initializable {

    public Utilisateur u;
    Iutilisateur su = new ServiceUtilisateur();
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField loginTF;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField DateTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private Label changermdp;
    @FXML
    private Button deconnexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setUtilisateur();
    } 
    
    public void setUtilisateur()
    {
        
//        Scene scene = receiveData.getScene();
//         // Step 1
//        Scene scene = (Scene) nomTF.getParent().getScene();
//        // Step 2
//        this.u = (Utilisateur) scene.getUserData();
//        // Step 3
//        System.out.println(u);
    }
    
    public void afficher(Utilisateur u)
    {
        loginTF.setText(u.getLogin());
        prenomTF.setText(u.getPrenom());
        nomTF.setText(u.getNom());
        DateTF.setText(u.getDate_naissance().toString());
        EmailTF.setText(u.getEmail());
        this.u=u;
    }

    @FXML
    private void modifier(ActionEvent event) {
        
        Utilisateur u1 = new Utilisateur(u.getId(),loginTF.getText(),u.getMdp(),Date.valueOf(DateTF.getText()),nomTF.getText(),prenomTF.getText(),EmailTF.getText());
        if(su.modifierUtilisateur(u1))
        
            JOptionPane.showMessageDialog(null, "Votre profil a été modifié");
           
        else
            JOptionPane.showMessageDialog(null, "Echec de modification");
    }

    @FXML
    private void changermdp(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changermdp.fxml"));
            root = loader.load();
           //The following both lines are the only addition we need to pass the arguments
           ChangermdpController pc = loader.getController();
           pc.setUtilisateur(u);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DocumentFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}
