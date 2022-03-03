/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import interfaces.*;
import java.io.IOException;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Blog;
import models.PointDeVente;
import services.*;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class MainFXMLController implements Initializable {

    
    
    Iblog sb = new ServiceBlog();
    @FXML
    private GridPane ptGP;
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
            fxmlLoader.setLocation(getClass().getResource("ptdevente.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
            PtdeventeController ptdeventeController = fxmlLoader.getController();
            ptdeventeController.setData(b);
            
            ptGP.add(anchorPane,column,row++);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }   

    
    private void LoadData() {
        
        
        
    }

    @FXML
    private void SelectClicked(MouseEvent event) {
        
         Node source = (Node)event.getTarget() ;
        System.out.println(getDataFromScene(source.getParent().getParent()));
    }
    private Blog getDataFromScene(Parent scene){
        
        /*Label nameLBL = (Label) scene.lookup("#nameLBL");
        Label proprietaireLBL = (Label) scene.lookup("#proprietaireLBL");
        Label adressLBL = (Label) scene.lookup("#adressLBL");*/
        Label dateBlog = (Label) scene.lookup("#dateBlog");
        Label idLBL = (Label) scene.lookup("#idLBL");
        System.out.println(idLBL.getText());
        
        return new Blog();
    }

    
}
