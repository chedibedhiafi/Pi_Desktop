/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Event;
import services.ServiceEvent;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class ModifierEventController implements Initializable {

    @FXML
    private TextField titre;
  
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
    @FXML
    private TextField prix;
    
    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
		
		
        
      ServiceEvent sp = new ServiceEvent();

        List Reservations = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Reservations);
        

        tableevents.setItems(list);
        
         titreevent.setCellValueFactory(new PropertyValueFactory<>("Titre"));
         prixevent.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        descrievent.setCellValueFactory(new PropertyValueFactory<>("Description"));
                datevent.setCellValueFactory(new PropertyValueFactory<>("Date_Event"));

         
        
        
        }
   
    public void initdata (Event u){
        titre.setText(u.getTitre());
        descri.setText(u.getDescription());
        prix.setText(u.getPrix());
      date.setValue(u.getDate_Event().toLocalDate());       
        
    }
      

  ObservableList<Event> Events = FXCollections.observableArrayList();
   ObservableList<Event> allEvents;
   ObservableList<Event> selectedEvents;


    @FXML
    private void modifier (ActionEvent event) {
        
         ServiceEvent sp = new ServiceEvent();
                              //kima fel champs taa l form"//
       String Titre =       titre.getText().toString().toLowerCase();
        String Description = descri.getText().toString().toLowerCase();
                 String Prix =    prix.getText().toString().toLowerCase();
                                   String Image =    null;


           Date date2 = null;
          if (date.getValue() != null) {
           date2 = Date.valueOf(date.getValue());  


          
        selectedEvents = tableevents.getSelectionModel().getSelectedItems();
        
        if (selectedEvents.size() > 0) {
			for (Event u : selectedEvents){
                            
            Event E=
             new Event(u.getEvent_Id() , date2 , Titre  , Description , Prix, Image );
                     
                              sp.modifier(E);
                        
                        }
          List<Event> listemps = sp.afficher();
	   for (int i = 0; i < listemps.size(); i++) {
		listemps.add(listemps.get(i));
            }
           tableevents.refresh(); 
        
        }
      
    } }

    @FXML
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilAdmin.fxml"));
            Parent root = loader.load();
           
           retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    }

    

