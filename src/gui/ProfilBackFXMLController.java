/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iemploye;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Employe;
import models.Utilisateur;
import services.ServiceEmploye;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ProfilBackFXMLController implements Initializable {

    Employe e;
    Iemploye se = new ServiceEmploye();
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
    private TextField pdvTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

public boolean afficher(Employe e)
    {
        loginTF.setText(e.getLogin());
        prenomTF.setText(e.getPrenom());
        nomTF.setText(e.getNom());
        DateTF.setText(e.getDate_naissance().toString());
        EmailTF.setText(e.getEmail());
        pdvTF.setText(e.getPdv().getName());
        this.e=e;
        return true;
    }    

    @FXML
    private void modifier(ActionEvent event) {
        Employe e1 = new Employe(e.getPdv(),e.getRole(),e.getId(),loginTF.getText(),e.getMdp(),Date.valueOf(DateTF.getText()),nomTF.getText(),prenomTF.getText(),EmailTF.getText());
        e1 = se.modifierEmploye(e1);
        if(e1.getEtat().equals("succes"))
        {
           JOptionPane.showMessageDialog(null, "Votre profil a été modifié"); 
           this.e = e1;
        }
        
        else
            JOptionPane.showMessageDialog(null, "Echec de modification");
    }

    @FXML
    private void changermdp(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("changermdpBackFXML.fxml"));
           Parent anchorPane = (AnchorPane) loader.load();
           //The following both lines are the only addition we need to pass the arguments
           ChangermdpBackFXMLController pcb = loader.getController();
           System.out.println(pcb);
           pcb.setEmploye(this.e);

        
           ((BorderPane)((Node)event.getSource()).getParent().getParent()).setCenter(anchorPane);
    }
    
}
