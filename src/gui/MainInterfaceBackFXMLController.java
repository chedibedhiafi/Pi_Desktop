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
import javafx.scene.control.MenuItem;
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
    @FXML
    private MenuItem btnCommande;
    @FXML
    private MenuItem btnLivr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Acceuil.fxml"));
        try {
            root = loader.load();
             borderpane.setCenter(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
    private void employesClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EmployesBackFXML.fxml"));
            root = loader.load();

           //The following both lines are the only addition we need to pass the arguments
           EmployesBackFXMLController ecb = loader.getController();
           ecb.setEmploye(e);
           borderpane.setCenter(root);
    }

    @FXML
    private void produitsClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("gestionProduitFXML.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

    @FXML
    private void categoriesClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("gestionCatégorieFXML.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

    @FXML
    private void onEvenementClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GestionEvents.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

    @FXML
    private void onReservationClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AfficherListReservation.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

    @FXML
    private void onGestionBlogClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("gestionBlogFXML.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

    @FXML
    private void onGestionPointDeVentes(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("whoAreWeInterfaceBack.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

    @FXML
    private void fnCommande(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLHistoriqueCommande.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

    @FXML
    private void fnLivr(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLHistoriqueLivraison.fxml"));
            root = loader.load();
           borderpane.setCenter(root);
    }

}
