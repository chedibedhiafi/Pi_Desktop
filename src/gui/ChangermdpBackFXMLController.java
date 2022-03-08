/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iemploye;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import models.Employe;
import services.ServiceEmploye;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ChangermdpBackFXMLController implements Initializable {

    Employe e;
    Iemploye se = new ServiceEmploye();
    
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
        Employe e1 = new Employe(verifnouvmdp.getText(),e.getId());
        if(e.getMdp().equals(e.encrypt(ancienmdp.getText())) && nouvmdp.getText().equals(verifnouvmdp.getText()))
        {
            if(se.modifierMdp(e1))
               JOptionPane.showMessageDialog(null, "Mot de passe modifié");
           else
               JOptionPane.showMessageDialog(null, "Echec de modification");
        }
           
        else
            JOptionPane.showMessageDialog(null, "Vérifiez vos paramètres");
    }
    
    public void setEmploye(Employe e)
    {
        this.e = e;
        //System.out.println(u.getMdp());
    }
    
}
