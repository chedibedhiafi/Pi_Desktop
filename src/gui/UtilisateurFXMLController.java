/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iutilisateur;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import models.Employe;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class UtilisateurFXMLController implements Initializable {

    @FXML
    private Label loginLBL;
    @FXML
    private Label nomLBL;
    @FXML
    private Label emailLBL;
    @FXML
    private Label dateLBL;
    @FXML
    private Button banBT;
    @FXML
    private ComboBox<String> banCB;

    Iutilisateur su = new ServiceUtilisateur();
    @FXML
    private Label idLBL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "3 jours",
                        "2 semaines",
                        "1 mois",
                        "1 an"
                );
        banCB.setItems(options);
    }

    public void setData(Utilisateur u) {
        idLBL.setText(String.valueOf(u.getId()));
        loginLBL.setText(u.getLogin());
        nomLBL.setText(u.getNom() + " " + u.getPrenom());
        emailLBL.setText(u.getEmail());
        dateLBL.setText(u.getDate_naissance().toString());
    }
    
    public void setData(Employe e) {
        idLBL.setText(String.valueOf(e.getId()));
        loginLBL.setText(e.getLogin());
        nomLBL.setText(e.getNom() + " " + e.getPrenom());
        emailLBL.setText(e.getEmail());
        dateLBL.setText(e.getDate_naissance().toString());
        banBT.setVisible(false);
    }

    @FXML
    private void banBT(ActionEvent event) {
        banCB.setVisible(true);
    }

    @FXML
    private void selectChoix(ActionEvent event) {
        String choix = banCB.getSelectionModel().getSelectedItem();
        LocalDate d = LocalDate.now();
        if (choix.equals("3 jours")) {
            d=d.plusDays(3);
        } else if (choix.equals("2 semaines")) {
            d=d.plusWeeks(2);
        } else if (choix.equals("1 mois")) {
            d=d.plusMonths(1);
        } else {
            d=d.plusYears(1);
        }
        System.out.println(d);

        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation de ban");
        alert1.setHeaderText(null);
        alert1.setContentText(" Etes-vous sure de vouloir bannir cet utilisateur? ");
        Optional<ButtonType> action = alert1.showAndWait();

        if (action.get() == ButtonType.OK) {
            su.banUser(d, Integer.parseInt(idLBL.getText()));
        } else {
            alert1.close();
        }
    }

}
