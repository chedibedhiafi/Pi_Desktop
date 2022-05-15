/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iblog;
import interfaces.Iutilisateur;
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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Blog;
import models.Utilisateur;
import services.ServiceBlog;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class GestionBlogFXMLController implements Initializable {
    
    Iblog sb = new ServiceBlog();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private GridPane ptGP;
    @FXML
    private Button AjouterBlogBTN;
    Utilisateur u;
    Iutilisateur su=new ServiceUtilisateur();
    @FXML
    private Button goToFrontBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    public void afficherBlog(Utilisateur u)
{
    this.u = u;
        int column = 0;
        int row = 0;
        
    
        for (Blog b : sb.afficherBlogs()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("blog.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
            BlogController BlogController = fxmlLoader.getController();
                System.out.println(u);
            BlogController.setData(b, u);
            
            ptGP.add(anchorPane,column,row++);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
}

    @FXML
    private void SwitchToAjouterBlog(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ajoutBlog.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ((BorderPane)ptGP.getParent().getParent().getParent().getParent()).setCenter(root);
    }

    @FXML
    private void goToFront(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionBlogFXML.fxml"));
        ((BorderPane)ptGP.getParent().getParent().getParent().getParent()).setCenter(root);
    }
    
}
