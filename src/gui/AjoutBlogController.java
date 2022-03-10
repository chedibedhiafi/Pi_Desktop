/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iblog;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Blog;
import models.Utilisateur;
import services.ServiceBlog;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class AjoutBlogController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    Utilisateur u;
    
    

    @FXML
    private Label titreBlog;
    @FXML
    private TextField BlogTitreTF;
    @FXML
    private Label sujetBlog;
    @FXML
    private TextField BlogSujetTF;
    @FXML
    private Label ContenuBlog;
    @FXML
    private TextField BlogContenuTF;
    @FXML
    private Label idLBL;
    @FXML
    private Button finishAjout;
    @FXML
    private Button SwitchToGestionBlogBTN;
    
    
    Iblog sb = new ServiceBlog();
    @FXML
    private Button AjouterBlogBTN;
    @FXML
    private GridPane ptGP;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutBlog(ActionEvent event) throws IOException {
        //java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(datePicker.getValue());
        //sb.ajouterBlog(new Blog(BlogTitreTF.getText(),BlogSujetTF.getText(),BlogContenuTF.getText(),java.sql.Date.valueOf(datePicker.getValue())));
        sb.ajouterBlog(new Blog(BlogTitreTF.getText(),BlogSujetTF.getText(),BlogContenuTF.getText(),java.sql.Date.valueOf(LocalDate.now())));
        
        root = FXMLLoader.load(getClass().getResource("mainInterfaceFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
            
    }

    @FXML
    private void SwitchToGestionBlog(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainInterfaceFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SwitchToAjouterBlog(ActionEvent event) {
    }
    
}
