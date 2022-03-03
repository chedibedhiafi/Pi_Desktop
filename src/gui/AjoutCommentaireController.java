/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iblog;
import interfaces.Icommentaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Blog;
import models.Commentaire;
import services.ServiceBlog;
import services.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class AjoutCommentaireController implements Initializable {

    Icommentaire sc = new ServiceCommentaire();
    Iblog sb = new ServiceBlog();
    
    @FXML
    private Label titreBlog;
    @FXML
    private TextField BlogCommentTF;
    @FXML
    private Label dateBlog;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label ContenuBlog;
    @FXML
    private TextField CommentContenuTF;
    @FXML
    private Label idLBL;
    @FXML
    private Button finishAjout;
    @FXML
    private Button SwitchToGestionCommentBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutComment(ActionEvent event) {
        sc.ajouterCommentaire(new Commentaire(CommentContenuTF.getText(), java.sql.Date.valueOf(datePicker.getValue()), sb.RetrieveBlog(Integer.parseInt(BlogCommentTF.getText()))));
    }

    @FXML
    private void SwitchToGestionComment(ActionEvent event) {
    }
    
}
