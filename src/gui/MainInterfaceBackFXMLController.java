/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Employe;
import models.Utilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class MainInterfaceBackFXMLController implements Initializable {

    Employe e;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private BorderPane borderpane;
    @FXML
    private MenuBar profilMB;
    @FXML
    private MenuBar categorieMB;
    @FXML
    private Menu userM;
    @FXML
    private Menu prodM;
    @FXML
    private Menu eventM;
    @FXML
    private Menu blogM;
    @FXML
    private Menu pdvM;
    @FXML
    private Menu commandesM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profilClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProfilBackFXML.fxml"));
            root = loader.load();

           //The following both lines are the only addition we need to pass the arguments
           ProfilBackFXMLController pcb = loader.getController();
           System.out.println(pcb.afficher(e));
           borderpane.setCenter(root);
    }

    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signInFXML.fxml"));
        
        stage =  (Stage) borderpane.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    void setEmploye(Employe e) {
        this.e=e;
        System.out.println(e);
    }

    @FXML
    private void clientsClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UtilisateursBackFXML.fxml"));
            root = loader.load();

           //The following both lines are the only addition we need to pass the arguments
           UtilisateursBackFXMLController ucb = loader.getController();
           ucb.setEmploye(e);
           borderpane.setCenter(root);
    }

    @FXML
    private void employesClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EmployesBackFXML.fxml"));
            root = loader.load();

           //The following both lines are the only addition we need to pass the arguments
           UtilisateursBackFXMLController ucb = loader.getController();
           ucb.setEmploye(e);
           borderpane.setCenter(root);
    }

}
