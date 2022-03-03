/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Event;
import services.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class testmodifierController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField prix;
    @FXML
    private TextField descri;
    @FXML
    private DatePicker date;
    @FXML
    private Button retour;
    @FXML
    private Button modifier;
    @FXML
     private TableView<Event> tableevents;
    @FXML
    private TableColumn<Event , String> titreevent;
    @FXML
    private TableColumn<Event , String> prixevent;
    @FXML
    private TableColumn<Event , String> descrievent;
    @FXML
    private TableColumn<Event , Date> datevent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceEvent sp = new ServiceEvent();
              System.out.println("err 0" );      
        List Eventss = sp.afficher();
        System.out.println("err 1" );
        ObservableList list = FXCollections.observableArrayList(Eventss) ;
          System.out.println("err 2" );
        tableevents.setItems(list);
          System.out.println("err 3" );
           //*nafs l id" *// 
         titreevent.setCellValueFactory(new PropertyValueFactory<>("Titre")); //nafs les attributs kifma msamyethom fel base"
         descrievent.setCellValueFactory(new PropertyValueFactory<>("Description"));
         prixevent.setCellValueFactory(new PropertyValueFactory<>("Prix"));
         datevent.setCellValueFactory(new PropertyValueFactory<>("Date_Event"));

         
        // TODO
    }   
       
    public void initdata (Event u){
        titre.setText(u.getTitre());
        descri.setText(u.getDescription());
        prix.setText(u.getPrix());
      date.setValue(u.getDate_Event().toLocalDate());       
        
    }

    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
