/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class MainInterfaceFXMLController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mainBorderPane.setTop(getPage("navbarFXML.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            mainBorderPane.setCenter(getPage("gestionBlogFrontFXML.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
    private AnchorPane getPage(String path) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(path));
            
            AnchorPane anchorPane = fxmlLoader.load();
            return anchorPane;
        
    }
}
