/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iblog;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Blog;
import models.Utilisateur;
import services.ServiceBlog;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class GestionBlogFrontFXMLController implements Initializable {

    @FXML
    private GridPane ptGP;
    Iblog sb = new ServiceBlog();
    Utilisateur u;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         int column = 0;
        int row = 0;
        
    
        for (Blog b : sb.afficherBlogs()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("blogFront.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
            BlogFrontController blogController = fxmlLoader.getController();
            blogController.setData(b, u);
            
            ptGP.add(anchorPane,column,row++);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }    
    
}
