/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import interfaces.Iutilisateur;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class DocumentFXMLController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    Iutilisateur su = new ServiceUtilisateur();
    @FXML
    private TextField mdpTF;
    @FXML
    private TextField loginTF;
    @FXML
    private Label loginlabel;
    @FXML
    private Label mdpoublie;
    @FXML
    private Button signup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        Utilisateur u = new Utilisateur(loginTF.getText(),mdpTF.getText());
        u = su.login(u);
        if(u.getId()!=0)
        {
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profil.fxml"));
            root = loader.load();
           //The following both lines are the only addition we need to pass the arguments
           ProfilController pc = loader.getController();
           pc.afficher(u);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
            
//            // Step 2
//            Node node = (Node) event.getSource();
//            // Step 3
//            Stage stage = (Stage) node.getScene().getWindow();
//            stage.close();
//            // Step 4
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/Profil.fxml"));
//            // Step 5
//            stage.setUserData(u);
//            // Step 6
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            // Step 7
//            stage.show();            

        }
        else
        loginlabel.setText(u.getMsg());  
        
    }

    @FXML
    private void mdpoublie(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Forgotpwd.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}