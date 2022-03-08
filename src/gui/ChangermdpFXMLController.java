/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iutilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ChangermdpFXMLController implements Initializable {

    Utilisateur u;
    Iutilisateur su = new ServiceUtilisateur();
    
    @FXML
    private Button confimer;
    @FXML
    private PasswordField ancienmdp;
    @FXML
    private PasswordField nouvmdp;
    @FXML
    private PasswordField verifnouvmdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confimer(ActionEvent event) {
        Utilisateur u1 = new Utilisateur(verifnouvmdp.getText(),u.getId());
        if(u.getMdp().equals(u.encrypt(ancienmdp.getText())) && nouvmdp.getText().equals(verifnouvmdp.getText()))
        {
            if(su.modifierMdp(u1))
               JOptionPane.showMessageDialog(null, "Mot de passe modifié");
           else
               JOptionPane.showMessageDialog(null, "Echec de modification");
        }
           
        else
            JOptionPane.showMessageDialog(null, "Vérifiez vos paramètres");
    }
    
    public void setUtilisateur(Utilisateur u)
    {
        this.u = u;
        //System.out.println(u.getMdp());
    }
    
}
