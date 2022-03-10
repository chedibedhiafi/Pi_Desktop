/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevcrud3a4;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import models.Commande;
import services.ServiceCommande;
import utils.AlertBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLHistoriqueCommandeController implements Initializable {

    @FXML
    private Button annul;
    
    @FXML
    private ListView<String> tvcomm;
    @FXML
    private TextField rech;
    @FXML
    private Label lbid;
    ServiceCommande sv= new ServiceCommande();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        loadListView();
    }    

    @FXML
    private void annulercommande(ActionEvent event) {
        try{
                    Commande comm=new Commande();
        comm.setId(Integer.parseInt(tvcomm.getSelectionModel().getSelectedItem().split("#")[1]));
        sv.supprimerCommande(comm);

        AlertBox.display("Success", "la commande a etait supprimé avec succee");

        
        }catch(java.lang.NumberFormatException Ex){
            AlertBox.display("error", "choisissez une commande a supprimer!!!");
            
        }
        loadListView();

        
    }


    private void loadListView(){
        
        List<String> list = new ArrayList<>();
        for (Commande c : sv.afficherCommandes()){
            list.add("Reference: #"+c.getId() + "#: Date Création :" + c.getDate_creation() + " Date Envoi :"+c.getDate_envoie());
        }
        ObservableList<String> items =FXCollections.observableArrayList (list);
        
        tvcomm.setItems(items);
    }

    @FXML
    private void onRechTyped(KeyEvent event) {
        loadListView();
        for(String e : tvcomm.getItems()){
            if(!e.split("#")[1].toLowerCase().contains(rech.getText().toLowerCase()))
                tvcomm.getItems().remove(e);
        }
    }
}
