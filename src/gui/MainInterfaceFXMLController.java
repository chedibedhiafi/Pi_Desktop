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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Utilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class MainInterfaceFXMLController implements Initializable {

    Utilisateur u;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private BorderPane borderpane;
    @FXML
    private MenuBar profilMB;
    @FXML
    private MenuBar categorieMB;

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
        loader.setLocation(getClass().getResource("ProfilFXML.fxml"));
            root = loader.load();

           //The following both lines are the only addition we need to pass the arguments
           ProfilFXMLController pc = loader.getController();
           System.out.println(pc.afficher(u));
           borderpane.setCenter(root);

    }
    
    private AnchorPane getPage(String path) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(path));
            
            AnchorPane anchorPane = fxmlLoader.load();
            return anchorPane;
        
    }

    void setUtilisateur(Utilisateur u) {
        this.u=u;
    }

    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signInFXML.fxml"));
        
        stage =  (Stage) borderpane.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void changermdp() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("changermdpFXML.fxml"));
            root = loader.load();

           //The following both lines are the only addition we need to pass the arguments
           ChangermdpFXMLController pc = loader.getController();
           pc.setUtilisateur(u);
          
    }
    
}
