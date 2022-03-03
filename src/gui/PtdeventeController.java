/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iblog;
import interfaces.Icommentaire;
import interfaces.Ivote;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;
import models.Blog;
import services.ServiceBlog;
import services.ServiceCommentaire;
import services.ServiceVote;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class PtdeventeController implements Initializable {

    Iblog sb = new ServiceBlog();
    Icommentaire sc = new ServiceCommentaire();
    Ivote sv = new ServiceVote();
    
    private Blog b;
    @FXML
    private ImageView imgIV;
    @FXML
    private Label idLBL;
    @FXML
    private Label titreBlog;
    @FXML
    private Label sujetBlog;
    @FXML
    private Label dateBlog;
    @FXML
    private Label ContenuBlog;
    private DatePicker datePicker;
    private TextField BlogTitreTF;
    private TextField BlogSujetTF;
    private TextField BlogContenuTF;
    @FXML
    private Button deleteBlogButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                // TODO
    }    
    
    public void setData(Blog b){
        this.b = b;
        this.idLBL.setText(String.valueOf(b.getId()));
        this.titreBlog.setText(b.getTitre());
        this.sujetBlog.setText(b.getSujet());
        this.dateBlog.setText(b.getDate().toString());
        this.ContenuBlog.setText(b.getContenu());
        
    }

    private void ajoutBlog(ActionEvent event) {
        java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(datePicker.getValue());
            sb.ajouterBlog(new Blog(BlogTitreTF.getText(),BlogSujetTF.getText(),BlogContenuTF.getText(),java.sql.Date.valueOf(datePicker.getValue())));
    }

    @FXML
    private void finishDeleteBlog(ActionEvent event) {
        Blog b = new Blog();
          b.setId(Integer.parseInt(this.idLBL.getText()));
          Iblog sb = new ServiceBlog();
          sb.supprimerBlog(b);
          
    }
        
    @FXML
    private void switchToUpdate(ActionEvent event) throws IOException {
         //int ne;
        Blog b = new Blog();
          b.setId(Integer.parseInt(this.idLBL.getText()));
          // ne = b.getId();
          
          root = FXMLLoader.load(getClass().getResource("updateBlog.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //return ne;
    }
    
    
    



    
}
