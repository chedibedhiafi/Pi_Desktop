/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iemploye;
import interfaces.IpointDeVente;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import models.Employe;
import models.InputValidation;
import services.ServiceEmploye;
import services.ServicePointDeVente;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class AjouterEmployeBackFXMLController implements Initializable {

    Employe e;
    Iemploye se = new ServiceEmploye();
    IpointDeVente sp = new ServicePointDeVente();
    
    @FXML
    private TextField loginTF;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField emailTF;
    @FXML
    private DatePicker dateDP;
    @FXML
    private PasswordField mdpTF;
    @FXML
    private PasswordField mdpverifTF;
    @FXML
    private TextField pdvTF;
    @FXML
    private Label loginMsg;
    @FXML
    private Label prenomMsg;
    @FXML
    private Label nomMsg;
    @FXML
    private Label mdpMsg;
    @FXML
    private Label mdpvMsg;
    @FXML
    private Label emailMsg;
    @FXML
    private Label dateMsg;
    @FXML
    private Label pdvMsg;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setEmploye(Employe e) {
        this.e = e;
    }

    @FXML
    private void submitBT(ActionEvent event) {
      boolean testPrenom =  InputValidation.textFilledIsNull(prenomTF, prenomMsg, "Le prénom est requis");
      boolean testNom =  InputValidation.textFilledIsNull(nomTF, nomMsg, "Le nom est requis");
      boolean testLogin = InputValidation.textFilledIsNull(loginTF, loginMsg, "Le login est requis");
      boolean testMdp = InputValidation.textFilledIsNull(mdpTF, mdpMsg, "Le mot de passe est requis");
      boolean testMdpv = InputValidation.textFilledIsNull(mdpverifTF, mdpvMsg, "Le mot de passe est requis");
      boolean testEmail = InputValidation.textFilledIsNull(emailTF, emailMsg, "L'adresse email est requise");
      boolean testEmailFormat = InputValidation.emailFormat(emailTF, emailMsg, "Exemple: quantech@gmail.com");
      boolean testMdpFormat = InputValidation.dataLength(mdpTF, mdpMsg, "Doit contenir 8 caractères", "8");
      boolean testMdpvFormat = InputValidation.dataLength(mdpverifTF, mdpvMsg, "Doit contenir 8 caractères", "8");
      boolean testPdv = InputValidation.textFilledIsNull(pdvTF, pdvMsg, "le point de vente est requis");
      
      Employe e;
      if(!testPrenom && !testNom && !testLogin && !testMdp && !testMdpv && !testEmail && testEmailFormat && testMdpFormat && testMdpvFormat && !testPdv)
      {
          e = new Employe(sp.retrievePointDeVente(pdvTF.getText()),"employe",loginTF.getText(),mdpTF.getText(),Date.valueOf(dateDP.getValue()),nomTF.getText(),prenomTF.getText(),emailTF.getText());
          System.out.println(e);
      
            if (mdpTF.getText().equals(mdpverifTF.getText()))
        {
            if(se.ajouterEmploye(e).getEtat().equals("succes"))
                JOptionPane.showMessageDialog(null, "Employé Ajouté");
            else
                JOptionPane.showMessageDialog(null, "Echec d'ajout");
        }       
            else
                JOptionPane.showMessageDialog(null, "Vérifiez la similarité des mots de passe");

      }
    }
    
}
