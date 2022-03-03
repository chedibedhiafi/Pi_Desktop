/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iutilisateur;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Utilisateur;
import services.ServiceUtilisateur;
import utils.MaConnexion;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ResetpwdController implements Initializable {

    Connection cnx = MaConnexion.getInstance().getCnx();
    Iutilisateur su = new ServiceUtilisateur();
    @FXML
    private TextField txtResetPass;
    @FXML
    private TextField txtVerResetPass;
    @FXML
    private Button confirmerBT;
    @FXML
    private Label erreurauthdisplay;
    @FXML
    private Label erreurauthdisplay1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmerBT(ActionEvent event) {
        confirmerBT.setOnAction((ActionEvent e) -> {
            if (txtResetPass.getText().equals(txtVerResetPass.getText())) {
                String myMail= ForgotpwdController.email;
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

        });
    }
    
}
