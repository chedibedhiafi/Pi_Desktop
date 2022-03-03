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
import java.sql.Date;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Blog;
import services.*;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class GestionBlogController implements Initializable {

    
    
    Iblog sb = new ServiceBlog();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private GridPane ptGP;
    @FXML
    private VBox ajoutModifPanel;
    @FXML
    private Label idLBL;
    @FXML
    private Label titreBlog;
    @FXML
    private TextField newBlogTitreTF;
    @FXML
    private TextField newBlogSujetTF;
    @FXML
    private TextField newBlogContenuTF;
    @FXML
    private Button ajouterModifierBTN;
    @FXML
    private Button switchToCommentBTN;
    @FXML
    private Button AjouterBlogClickedBTN;
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
    private void plusButtonClicked(ActionEvent event) {
    }

    @FXML
    private void onGP_clicked(MouseEvent event) {
    }


    @FXML
    private void ajouterModifierBTN_clicked(ActionEvent event) {
        //sb.modifierBlog(new Blog(Integer.parseInt(idLBL.getText()),newBlogTitreTF.getText(),newBlogSujetTF.getText(),newBlogContenuTF.getText()));
    }

    @FXML
    private void SelectClicked(MouseEvent event) {
         
         Node source = (Node)event.getTarget();
        System.out.println(getDataFromScene(source.getParent().getParent()));
    }
    private Blog getDataFromScene(Parent scene){
        
        //Label nameLBL = (Label) scene.lookup("#nameLBL");
        Label sujetBlog = (Label) scene.lookup("#sujetBlog");
        Label titreBlog = (Label) scene.lookup("#titreBlog");
        Label dateBlog = (Label) scene.lookup("#dateBlog");
        Label idLBL = (Label) scene.lookup("#idLBL");
        System.out.println(idLBL.getText());
        
       sb.modifierBlog(new Blog(Integer.parseInt(idLBL.getText()),newBlogTitreTF.getText(),newBlogSujetTF.getText(),newBlogContenuTF.getText(), Date.valueOf(dateBlog.getText())));

        
        return new Blog();
    
    }

    @FXML
    private void switchToComment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainCommentFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void AjouterBlogClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ajoutBlog.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
