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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
public class modifierBlogController implements Initializable {
    
    Iblog sb = new ServiceBlog();
    private Stage stage;
    private Scene scene;
    private Parent root;
    Utilisateur u;
    @FXML
    private Label titreBlog;
    @FXML
    private TextField newBlogTitreTF;
    @FXML
    private Label sujetBlog;
    @FXML
    private TextField newBlogSujetTF;
    @FXML
    private Label ContenuBlog;
    @FXML
    private TextField newBlogContenuTF;
    @FXML
    private Label idLBL;
    @FXML
    private Button updateBlogBTN;
    @FXML
    private Button SwitchToGestionBlogBTN;
    @FXML
    private GridPane ptGP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void idBlog(String idBlog){
        
        this.idLBL.setText(idBlog);
        System.out.println(idLBL.getText());
    }

    @FXML
    private void updateBlog(ActionEvent event) throws IOException {
        
        sb.modifierBlog(new Blog(Integer.parseInt(this.idLBL.getText()) ,newBlogTitreTF.getText(),newBlogSujetTF.getText(),newBlogContenuTF.getText(),java.sql.Date.valueOf(LocalDate.now())));
        
        root = FXMLLoader.load(getClass().getResource("gestionBlogFXML.fxml"));
        ((BorderPane)ptGP.getParent().getParent().getParent().getParent()).setCenter(root);
    }

    @FXML
    private void SwitchToGestionBlog(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionBlogFXML.fxml"));
        ((BorderPane)ptGP.getParent().getParent().getParent().getParent()).setCenter(root);
    }
    
}
