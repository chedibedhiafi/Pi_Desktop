/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iutilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.InputValidation;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ResetpwdFXMLController implements Initializable {
    
    Iutilisateur su = new ServiceUtilisateur();
    private Stage stage;
    private Scene scene;
    private Parent root;
    private MediaPlayer mediaPlayer;
    private Media media;
    private String email;

    @FXML
    private MediaView mediaView;
    @FXML
    private Label erreurauthdisplay;
    @FXML
    private PasswordField txtVerResetPass;
    @FXML
    private PasswordField txtResetPass;
    @FXML
    private Label erreurauthdisplay1;
    @FXML
    private Button confirmerBT;
    @FXML
    private Label signin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String path = new File("src\\gui\\elements\\video\\final2.mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(15));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
    }    



    @FXML
    private void confirmerBT(ActionEvent event) {

            if (txtResetPass.getText().equals(txtVerResetPass.getText())) {
                String myMail= email;
                System.out.println("le mail est " + myMail);
                Utilisateur u = new Utilisateur(0,myMail,txtVerResetPass.getText());
                su.modifierMdpParMail(u);
                
                erreurauthdisplay.setText("");
                erreurauthdisplay1.setText("Votre mot de passe a été modifié");
                txtResetPass.setDisable(true);
                confirmerBT.setDisable(true);
                txtVerResetPass.setDisable(true);
               

            } else {
                erreurauthdisplay.setText("Mots de passe non similaires");
                txtResetPass.setStyle("-fx-border-color: #d53235;");
                txtVerResetPass.setStyle("-fx-border-color: #d53235;");
            }


    }

    @FXML
    private void signin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignInFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
}
