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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Blog;
import models.Utilisateur;
import services.ServiceBlog;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class BlogController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Blog b;
    Utilisateur u;
    @FXML
    private Label titreBlog;
    @FXML
    private Label sujetBlog;
    @FXML
    private Label dateBlog;
    @FXML
    private Label ContenuBlog;
    @FXML
    private Label idLBL;
    @FXML
    private Button searchCommentBTN;
    @FXML
    private Button deleteBlogButton;
    @FXML
    private Button updateBlogButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Blog b, Utilisateur u){
        this.b = b;
        this.idLBL.setText(String.valueOf(b.getId()));
        this.titreBlog.setText(b.getTitre());
        this.sujetBlog.setText(b.getSujet());
        this.dateBlog.setText(b.getDate().toString());
        this.ContenuBlog.setText(b.getContenu());
        this.u = u;
        
    }
    @FXML
    private void finishDeleteBlog(ActionEvent event) {
        Blog b = new Blog();
        b.setId(Integer.parseInt(this.idLBL.getText()));
        Iblog sb = new ServiceBlog();
        sb.supprimerBlog(b);
    }

    @FXML
    private void finishSearchCommentBTN(ActionEvent event) throws IOException {
        String idBlog = idLBL.getText();
        System.out.println(idLBL.getText());
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("commentaire.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gestionCommentaire.fxml"));
        root = loader.load();
        GestionCommentaireController commentairecontroller = loader.getController();
        System.out.println(idBlog);
        System.out.println(u);
        commentairecontroller.idBlog(idBlog);
        commentairecontroller.loadComments(u);
        
        ((BorderPane)searchCommentBTN.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent()).setCenter(root);

    }

    @FXML
    private void switchToUpdateBlog(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("modifierBlog.fxml"));
        String idBlog = idLBL.getText();
        System.out.println(idLBL.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierBlog.fxml"));
        root = loader.load();
        modifierBlogController modifierblogcontroller = loader.getController();
        modifierblogcontroller.idBlog(idBlog);
        
                ((BorderPane)searchCommentBTN.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent()).setCenter(root);

    }
    
}
