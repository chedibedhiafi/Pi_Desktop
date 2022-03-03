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
import models.Commentaire;
import services.ServiceBlog;
import services.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class MainCommentFXMLController implements Initializable {

    
    
    Icommentaire sc = new ServiceCommentaire();
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
    private TextField CommentContenuTF;
    @FXML
    private Button SwitchToGestionBlogBTN;
    @FXML
    private Button switchToAjoutCommentBTN;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int column = 0;
        int row = 0;
        
    
        for (Commentaire c : sc.afficherCommentaires()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("commentaires.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
            CommentaireController cc = fxmlLoader.getController();
            cc.setData(c);
            
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
    private void SelectClicked(MouseEvent event) {
        
         Node source = (Node)event.getTarget();
         //System.out.println(source.getParent().getParent());
        System.out.println(getDataFromScene(source.getParent().getParent()));
        
    }
    
    private Commentaire getDataFromScene(Parent scene){
        
        //Label nameLBL = (Label) scene.lookup("#nameLBL");
        //Label sujetBlog = (Label) scene.lookup("#sujetBlog");
        Label contenuComment = (Label) scene.lookup("#contenuComment");
        Label dateComment = (Label) scene.lookup("#dateComment");
        Label blogId = (Label) scene.lookup("#blogId");
        Label idLBL = (Label) scene.lookup("#idLBL");
        System.out.println(idLBL.getText());
        
       sc.modifierCommentaire(new Commentaire(Integer.parseInt(idLBL.getText()), CommentContenuTF.getText(),Date.valueOf(dateComment.getText())));

        
        return new Commentaire();
    
    }
    

    @FXML
    private void SwitchToGestionBlog(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionBlog.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToAjoutComment(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("ajoutCommentaire.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelectClicked2(MouseEvent event) {
    }

    
}
