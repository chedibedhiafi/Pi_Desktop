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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.Blog;
import models.Commentaire;
import services.ServiceCommentaire;
import interfaces.Icommentaire;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class CommentaireController implements Initializable {
    private Commentaire c;

    @FXML
    private ImageView imgIV;
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
    private Label blogId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     public void setData(Commentaire c){
        this.c = c;
        this.idLBL.setText(String.valueOf(c.getId()));
        //this.user_name.setInt(c.get);
        //this.blogId.setText(Integer.parseInt(c.getId_blog()));
        this.blogId.setText(String.valueOf(c.getId_blog().getTitre()));
        this.dateComment.setText(c.getDate().toString());
        this.contenuComment.setText(c.getContenu());
        
    }

    @FXML
    private void upvote_onClick(ActionEvent event) {
    }

    @FXML
    private void downvote_onClick(ActionEvent event) {
    }

    @FXML
    private void updateVote_onClick(ActionEvent event) {
    }

    @FXML
    private void updateComment_onClick(ActionEvent event) {
    }

    @FXML
    private void deleteComment_onClick(ActionEvent event) {
                Commentaire c = new Commentaire();
          c.setId(Integer.parseInt(this.idLBL.getText()));
          Icommentaire sc = new ServiceCommentaire();
          sc.supprimerCommentaire(c);
    }
    
}
