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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import models.Livraison;
import services.ServiceLivraison;
import utils.AlertBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLHistoriqueLivraisonController implements Initializable {

    @FXML
    private ListView<String> tvliv;
    @FXML
    private TextField rechliv;
    ServiceLivraison sl= new ServiceLivraison();
    @FXML
    private Button envoyerlivraison;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           loadListView();
    }    
    private void loadListView(){
        
        List<String> list = new ArrayList<>();
        for (Livraison l : sl.afficherLivraison()){
            list.add("Referance: #"+l.getId() + "#: frais de livraison :" + l.getFrais_livraison()+ " Etat de livraison :"+l.getEtat_livraison()+" :numero de livreur:" + l.getNum_livreur());
        }
        ObservableList<String> items =FXCollections.observableArrayList (list);
        
         tvliv.setItems(items);
    }

   
      
    private void onrech(KeyEvent event) {
        loadListView();
        for(String e : tvliv.getItems()){
            if(!e.split("#")[1].toLowerCase().contains(rechliv.getText().toLowerCase()))
                tvliv.getItems().remove(e);
        }
    }

    @FXML
    private void envoyerliv(ActionEvent event) {
           try{
                    Livraison liv=new Livraison();
        liv.setId(Integer.parseInt(tvliv.getSelectionModel().getSelectedItem().split("#")[1]));
        sl.supprimerLivraison(liv);

        AlertBox.display("Success", "la commande a ete envoyer a la livraison");

        
        }catch(java.lang.NumberFormatException Ex){
            AlertBox.display("error", "choissiser une commande a livrer!!!");
            
        }
        loadListView();
    }

    @FXML
    private void Onrech(KeyEvent event) {
    }

    }

   

