/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Icommentaire;
import interfaces.Iutilisateur;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Blog;
import models.Commentaire;
import models.Utilisateur;
import services.ServiceCommentaire;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class GestionCommentaireController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Utilisateur u;
    Icommentaire sc = new ServiceCommentaire();
    Iutilisateur su = new ServiceUtilisateur();
    @FXML
    private Button RetourBlogBTN;
    @FXML
    private GridPane ptGP;
    private Label idLBL;
    @FXML
    private Label idBlog;
    @FXML
    private Button switchToAddComment;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
     
    
        public void loadComments(){
             this.u = su.retrieveUtilisateur(5);
        int column = 0;
        int row = 0;
        
    
        for (Commentaire c : sc.SearchComment(Integer.parseInt(this.idBlog.getText()))){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("commentaire.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
            
            CommentaireController CommentaireController = fxmlLoader.getController();
            CommentaireController.setData(c, u);
            
            ptGP.add(anchorPane,column,row++);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }    
    public void idBlog(String idBlog){
        
        this.idBlog.setText(idBlog);
        System.out.println(idBlog);
    }
    
    @FXML
    private void SwitchToGestionBlog(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gestionBlogFrontFXML.fxml"));
        ((BorderPane)ptGP.getParent().getParent().getParent().getParent()).setCenter(root);
    }

    @FXML
    private void switchToAddCommentBTN(ActionEvent event) throws IOException {
        System.out.println(idBlog);
        String idLB = idBlog.getText();
        System.out.println(idBlog.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutCommentaire.fxml"));
        root = loader.load();
        AjoutCommentaireController modifierblogcontroller = loader.getController();
        modifierblogcontroller.idBlog(idLB);
        ((BorderPane)ptGP.getParent().getParent().getParent().getParent()).setCenter(root);
        
    }
    
}
