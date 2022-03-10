/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iblog;
import interfaces.Icommentaire;
import interfaces.Iutilisateur;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Blog;
import models.Commentaire;
import models.Utilisateur;
import services.ServiceBlog;
import services.ServiceCommentaire;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class AjoutCommentaireController implements Initializable {
    Icommentaire sc = new ServiceCommentaire();
    Iblog sb = new ServiceBlog();
    Iutilisateur su = new ServiceUtilisateur();
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Commentaire c;
    private Blog b;
    Utilisateur u;
    @FXML
    private Label ContenuBlog;
    @FXML
    private TextField CommentContenuTF;
    @FXML
    private Label idLBL;
    @FXML
    private Button finishAjoutBTN;
    @FXML
    private Button SwitchToGestionCommentBTN;
    @FXML
    private Label idBlog;
    @FXML
    private Button RetourBlogBTN;
    @FXML
    private Label idBlog1;
    @FXML
    private Button switchToAddComment;
    @FXML
    private GridPane ptGP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUser(Utilisateur u){
    this.u = u;
        System.out.println(u);
        //this.idUser.setText(String.valueOf(u.getId()));
}
    
    public void idBlog(String idBlog){
        System.out.println(idBlog);
        this.idBlog.setText(idBlog);
        
        
    }

    @FXML
    private void ajoutComment(ActionEvent event) throws IOException {
        //System.out.println(u.getId());
        Commentaire c = new Commentaire(CommentContenuTF.getText(),java.sql.Date.valueOf(LocalDate.now()), sb.RetrieveBlog(Integer.parseInt(this.idBlog.getText())),this.u);
        System.out.println(c);
        sc.ajouterCommentaire(c);
        
        root = FXMLLoader.load(getClass().getResource("mainInterfaceFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void SwitchToGestionComment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainInterfaceFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void SwitchToGestionBlog(ActionEvent event) {
    }

    @FXML
    private void switchToAddCommentBTN(ActionEvent event) {
    }
    
}
