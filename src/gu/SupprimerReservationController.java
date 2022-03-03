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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Reservation;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class SupprimerReservationController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<Reservation, String> nb;
    @FXML
    private TableColumn<Reservation, String> totall;
    @FXML
    private TableColumn<Reservation, Date> date;
    @FXML
    private Button ouh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     ServiceReservation sp = new ServiceReservation();

        List Reservations = sp.afficher();
        ObservableList list = FXCollections.observableArrayList(Reservations);
        

        table.setItems(list);
        ;
         nb.setCellValueFactory(new PropertyValueFactory<>("Nb_Places"));
         date.setCellValueFactory(new PropertyValueFactory<>("Date_Achat"));
        totall.setCellValueFactory(new PropertyValueFactory<>("Total"));
         
                TableColumn<Reservation, Void> actTitre1 = new TableColumn("Action");
          
   Callback<TableColumn<Reservation, Void>, TableCell<Reservation, Void>> cellFactory
           = new Callback<TableColumn<Reservation, Void>, TableCell<Reservation, Void>>() {
          
            @Override
            public TableCell<Reservation, Void> call(final TableColumn<Reservation, Void> param) {
                final TableCell<Reservation, Void> cell = new TableCell<Reservation, Void>() {

                    private final Button btn = new Button("Supprimer");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Reservation data = getTableView().getItems().get(getIndex());
                            
                            sp.supprimer(data. getReserv_Id());
                            System.out.println("selectedData: " + data);
                        });
                       
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        actTitre1.setCellFactory(cellFactory);

        table.getColumns().add(actTitre1);
    }


    


    @FXML
    private void retour(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilAdmin.fxml"));
            Parent root = loader.load();
           
          retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
