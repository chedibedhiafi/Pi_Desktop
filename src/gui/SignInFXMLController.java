/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iemploye;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Employe;
import models.Utilisateur;
import services.ServiceEmploye;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class SignInFXMLController implements Initializable {

    private MediaPlayer mediaPlayer;
    private Media media;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Iutilisateur su = new ServiceUtilisateur();
    Iemploye se = new ServiceEmploye();

    @FXML
    private MediaView mediaView;
    @FXML
    private TextField loginTF;
    @FXML
    private TextField mdpTF;
    @FXML
    private Label loginlabel;
    @FXML
    private Label signup;
    @FXML
    private Label mdpoublie;
    @FXML
    private CheckBox showpwd;
    @FXML
    private TextField mdpshow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void signup(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void mdpoublie(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ForgotpwdFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        Utilisateur u = new Utilisateur(loginTF.getText(), mdpTF.getText());
        Employe e = new Employe(loginTF.getText(), mdpTF.getText());
        e = se.retrieveEmploye(e);
        System.out.println(e);
        if (e.getId() != 0) 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainInterfaceBackFXML.fxml"));
                root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
                MainInterfaceBackFXMLController mcb = loader.getController();
                mcb.setEmploye(e);

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
        else 
        {
            u = su.login(u);

            if (u.getId() != 0) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("mainInterfaceFXML.fxml"));
                root = loader.load();
                //The following both lines are the only addition we need to pass the arguments
                MainInterfaceFXMLController mc = loader.getController();
                mc.setUtilisateur(u);

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                loginlabel.setText(u.getMsg());
            }
        }

    }


    @FXML
    private void showpwd(ActionEvent event) {
        if(showpwd.isSelected())
        {
            mdpshow.setText(mdpTF.getText());
            mdpshow.setVisible(true);
            mdpTF.setVisible(false);
            return;
            
        }
            mdpTF.setText(mdpshow.getText());
            mdpTF.setVisible(true);
            mdpshow.setVisible(false);
    }

}
