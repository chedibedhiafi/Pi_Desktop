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
import javafx.util.Duration;
import models.Event;
import models.Reservation;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class ModifierReservationController implements Initializable {

    @FXML
    private TextField total;
    @FXML
    private TextField nbplaces;
    @FXML
    private Button retour;
    @FXML
    private DatePicker dateachat;
    @FXML
    private Button btn;
    @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<Reservation, String> nb;
    @FXML
    private TableColumn<Reservation, Date> date;
    
    @FXML
    private TableColumn<Reservation, String> totall;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceReservation sp = new ServiceReservation();

        List Reservations = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Reservations);
        

        table.setItems(list);
        ;
         nb.setCellValueFactory(new PropertyValueFactory<>("Nb_Places"));
         date.setCellValueFactory(new PropertyValueFactory<>("Date_Achat"));
        totall.setCellValueFactory(new PropertyValueFactory<>("Total"));
         
    }


    
public void initdata (Reservation u){
        total.setText(u.getTotal());
        nbplaces.setText(u.getNb_Places());
        dateachat.setValue(u.getDate_Achat().toLocalDate());       
        
    }
  ObservableList<Reservation> Events = FXCollections.observableArrayList();
   ObservableList<Reservation> allEvents;
   ObservableList<Reservation> selectedevents;
    @FXML
    private void modifier (ActionEvent event) {
            
           ServiceReservation sp = new ServiceReservation();
    
        String nbp = nbplaces.getText().toString().toLowerCase();
        String t = total.getText().toString().toLowerCase();
      
   
        Date datef = null;
        
        if (dateachat.getValue() != null) {
           datef = Date.valueOf(dateachat.getValue());
          
        selectedevents = table.getSelectionModel().getSelectedItems();
        if (selectedevents.size() > 0) {
        for (Reservation u : selectedevents){
                Reservation E= new Reservation (u.getReserv_Id(), nbp  , datef , t );
                          
                sp.modifier(E);
    }
                          }
          List<Reservation> listemps = sp.afficher();
	   for (int i = 0; i < listemps.size(); i++) {
		Events.add(listemps.get(i));
            }
           table.refresh(); 
        
        }

        }

    @FXML
    private void retour(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("evenements.fxml"));
            Parent root = loader.load();
           
          retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}

