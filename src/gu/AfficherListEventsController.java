/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Event;
import services.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class AfficherListEventsController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button btnadd;

    @FXML
    private TableView<Event> tableevent;
    @FXML
    private TableColumn<Event, String> titre;
    @FXML
    private TableColumn<Event, Double> prix;
    @FXML
    private TableColumn<Event , String> descri;
      @FXML
    private TableColumn<Event , Date> date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceEvent sb = new ServiceEvent();
        System.out.println("err");
        List Event = sb.afficherListView();
         System.out.println("err");
        ObservableList list = FXCollections.observableArrayList(Event);
         System.out.println("err");
        tableevent.setItems(list);
        titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        date.setCellValueFactory(new PropertyValueFactory<>("Date_Event"));
        descri.setCellValueFactory(new PropertyValueFactory<>("Description"));
        prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
    

    }    

    @FXML
    private void retour(ActionEvent event) {
        
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilAdmin.fxml"));
            Parent root = loader.load();
           
          retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }} 
    
    @FXML
    private void AjouterEvent(ActionEvent event) {
        
     try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gu/AjouterEvent.fxml"));
            Parent root = loader.load();
       AjouterEventController controller = loader.getController();
           retour.getScene().setRoot(root);
        } catch (IOException ex) { 
            Logger.getLogger(AfficherListEventsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
}
