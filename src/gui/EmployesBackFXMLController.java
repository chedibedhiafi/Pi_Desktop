/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iemploye;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;
import models.Employe;
import services.ServiceEmploye;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class EmployesBackFXMLController implements Initializable {
    
    Employe e;
    Iemploye se = new ServiceEmploye();
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private GridPane gridpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadGP();
    } 
    
    public void setEmploye(Employe e)
    {
        this.e=e;
    } 

    @FXML
    private void ajouterEmploye(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEmployeBackFXML.fxml"));
           Parent anchorPane = (AnchorPane) loader.load();
           //The following both lines are the only addition we need to pass the arguments
           AjouterEmployeBackFXMLController aecb = loader.getController();
           System.out.println(aecb);
           aecb.setEmploye(this.e);

        
           ((BorderPane)((Node)event.getSource()).getParent().getParent()).setCenter(anchorPane);
    
    }
    
    private void loadGP(){
        
        gridpane.getChildren().clear();
        int column = 0;
        int row = 0;
        int maxColumn = 3;
        for (Employe e : se.afficherEmployes()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UtilisateurFXML.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();               
            
            UtilisateurFXMLController uc = fxmlLoader.getController();
            uc.setData(e);
            if(column == maxColumn){
                column =0;
                row++;
            }
            
            gridpane.add(anchorPane,column++,row);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }
    }
    
}
