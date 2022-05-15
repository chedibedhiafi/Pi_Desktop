/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Icommentaire;
import interfaces.Iutilisateur;
import interfaces.Ivote;
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
import models.Vote;
import models.Commentaire;
import models.Utilisateur;
import services.ServiceCommentaire;
import services.ServiceUtilisateur;
import services.ServiceVote;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class CommentaireController implements Initializable {
    
    private Commentaire c;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Blog b;
    private Vote v;
    Utilisateur u;
    Ivote sv = new ServiceVote();
    Icommentaire sc = new ServiceCommentaire();
    Iutilisateur su = new ServiceUtilisateur();
    @FXML
    private Label titreBlog;
    @FXML
    private Label user_name;
    @FXML
    private Label dateComment;
    @FXML
    private Label contenuComment;
    @FXML
    private Label idLBL;
    @FXML
    private Button upvoteButton;
    @FXML
    private Button downvoteButton;
    @FXML
    private Button updateVoteButton;
    @FXML
    private Button updateCommentButton;
    @FXML
    private Button deleteCommentButton;
    @FXML
    private Label idBlog;
    @FXML
    private Label idComment;
    @FXML
    private Label idUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Commentaire c, Utilisateur u){
        this.c = c;
        this.idBlog.setText(String.valueOf(c.getId_blog().getId()));
       // this.titreBlog.setText(b.getTitre());
       // this.sujetBlog.setText(b.getSujet());
        this.dateComment.setText(c.getDate().toString());
        this.contenuComment.setText(c.getContenu());
        this.idComment.setText(String.valueOf(c.getId()));
        
        this.u = u;
        
        Utilisateur u1 = this.c.getId_user();
        this.user_name.setText(u1.getNom() + " " +u1.getPrenom());
        System.out.println(u);
        
        
    }
     public void idBlog(String idBlog){
        System.out.println(idBlog);
        this.idBlog.setText(idBlog);
        
    }
     public void idComment(String idComment){
        System.out.println(idComment);
        this.idComment.setText(idComment);
        
    }

    @FXML
    private void upvote_onClick(ActionEvent event) {
        sv.ajouterVote(new Vote (1, sc.RetrieveCommentaires(Integer.parseInt(idComment.getText())), this.u));
    }

    @FXML
    private void downvote_onClick(ActionEvent event) {
        sv.ajouterVote(new Vote (-1, sc.RetrieveCommentaires(Integer.parseInt(idComment.getText())), this.u));
        
    }

    @FXML
    private void updateVote_onClick(ActionEvent event) {
        Vote v = new Vote();
        //v.setId(Integer.parseInt(this.idLBL.getText()));
        
        
        
        
        sv.supprimerVote(sv.RetrieveVote(Integer.parseInt(idComment.getText()), u.getId()));
    }

    @FXML
    private void updateComment_onClick(ActionEvent event) throws IOException {
        String idCommentaire = idComment.getText();
        System.out.println(idComment.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierCommentaire.fxml"));
        root = loader.load();
        modifierCommentaireController modifierblogcontroller = loader.getController();
        modifierblogcontroller.idComment(idCommentaire, idBlog.getText(),this.u);
        
        ((BorderPane)updateCommentButton.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent()).setCenter(root);
    }

    @FXML
    private void deleteComment_onClick(ActionEvent event) {
    
        Commentaire c = new Commentaire();
        c.setId(Integer.parseInt(this.idComment.getText()));
        Icommentaire sc = new ServiceCommentaire();
        sc.supprimerCommentaire(c);
    }
    
}
