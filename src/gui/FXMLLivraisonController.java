/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Livraison;
import utils.AlertBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLLivraisonController implements Initializable {

    @FXML
    private ComboBox<String> typeTF;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField CinTF;
    @FXML
    private TextField compagnieTF;
    @FXML
    private TextField adresseTF;
    @FXML
    private TextField villeTF;
    @FXML
    private TextField codeTF;
    @FXML
    private TextField numTF;
    @FXML
    private TextField commTF;
    @FXML
    private Button suiv;
    @FXML
    private Button retour;
    private  ObservableList<String> Type = FXCollections.observableArrayList("Entreprise","Individuel");
    @FXML
    private RadioButton Livtf;
    @FXML
    private RadioButton enlignetf;
    public static Livraison liv;
    private ToggleGroup rbs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rbs= new ToggleGroup();
        typeTF.setItems(Type);
        
       Livtf.setUserData("7DT");
       enlignetf.setUserData("0DT");
        enlignetf.setToggleGroup(rbs);
        Livtf.setToggleGroup(rbs);
    }    

    @FXML
    private void validerlivraison(ActionEvent event) throws IOException {
          if(nomTF.getText().isEmpty() || prenomTF.getText().isEmpty()|| CinTF.getText().isEmpty()|| compagnieTF.getText().isEmpty()||adresseTF.getText().isEmpty()|| villeTF.getText().isEmpty()||codeTF.getText().isEmpty()|| numTF.getText().isEmpty()||commTF.getText().isEmpty())
        {
       AlertBox.display("error", "veuiller completez vos information");
         }else{
        String methode=String.valueOf(rbs.getSelectedToggle().getUserData());
        
        liv= new Livraison(typeTF.getValue(), nomTF.getText(), prenomTF.getText(), Long.parseLong(CinTF.getText()), compagnieTF.getText(), adresseTF.getText(), villeTF.getText(), codeTF.getText(), Long.parseLong(numTF.getText()), commTF.getText(), methode);
        
       
        
        
        Parent etab = FXMLLoader.load(getClass().getResource("FXMLPaiement.fxml"));      
        ((BorderPane)retour.getParent().getParent()).setCenter(etab);
    }
    }
    @FXML
    private void adomicile(ActionEvent event) {
         
    }

    @FXML
    private void enligne(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent etab = FXMLLoader.load(getClass().getResource("FXMLPanier.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
