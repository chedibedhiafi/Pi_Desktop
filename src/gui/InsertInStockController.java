/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import interfaces.IhistoriqueStock;
import interfaces.IpointDeVente;
import interfaces.Iproduits;
import interfaces.Istock;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;
import services.ServiceHistoriqueStock;
import services.ServicePointDeVente;
import services.ServiceProduit;
import services.ServiceStock;


/**
 * FXML Controller class
 *
 * @author 21624
 */
public class InsertInStockController implements Initializable {
    
    PointDeVente point;
    Produit produit;
    Stock stock;
    IpointDeVente interfaceDeVente = new ServicePointDeVente();
    Iproduits interfaceProduits = new ServiceProduit();
    Istock interfaceStock = new ServiceStock();
    IhistoriqueStock interfaceHistoriqueStock = new ServiceHistoriqueStock();
    
    @FXML
    private ComboBox<String> produitCB;
    @FXML
    private TextField quantiteTF;
    @FXML
    private ComboBox<String> reasonCB;
    @FXML
    private BorderPane productBP;
    @FXML
    private Label dateLBL;
    @FXML
    private ListView<String> historiqueLV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fillComboBox();
        fillDate();
    }  
    
    public void setData(PointDeVente pt){
        this.point = pt;
    }
    
    public void fillComboBox(){
        reasonCB.getItems().add("Restock");
        reasonCB.getItems().add("Sale");
        
        for(Produit p : interfaceProduits.afficherProduit()){
            produitCB.getItems().add(p.getNom());
        }
    }
    
    public void fillDate(){
        dateLBL.setText(String.valueOf(LocalDate.now()));
    }

    @FXML
    private void comboBoxItemPicked(ActionEvent event) throws IOException {
        loadBP();
        loadListView();
    }
    
    private void loadBP() throws IOException{
        this.produit = interfaceProduits.rechercherProduit(produitCB.getValue()).get(0);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("produitStock.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        ProduitStockController produitStockController = fxmlLoader.getController();
        this.stock = interfaceStock.retrieveStock(this.produit.getId(), this.point.getReference());
        if(this.stock == null)
            produitStockController.setData(this.produit);
        else
            produitStockController.setData(this.stock);

        productBP.setCenter(anchorPane);
    }
    
    private void loadListView(){
        if(this.stock == null)
            return;
        List<String> list = new ArrayList<>();
        for (HistoriqueStock hs : interfaceHistoriqueStock.getFromStock(this.stock)){
            list.add(hs.getQuantite() + " , " + hs.getReason() + " , "+hs.getDate());
        }
        ObservableList<String> items =FXCollections.observableArrayList (list);
        historiqueLV.setItems(items);
    }

    @FXML
    private void onInsertClicked(ActionEvent event) throws IOException {
        if(checkCB(reasonCB) & checkCB(produitCB) & checkTF(quantiteTF)){
        if(reasonCB.getValue() == "Restock"){
            this.stock = new Stock(this.produit, this.point);
            interfaceHistoriqueStock.insertInHistoriqueStock(new HistoriqueStock(this.stock, Date.valueOf(dateLBL.getText()), Math.abs(Integer.valueOf(quantiteTF.getText())), reasonCB.getValue()));
        }
        else{
            this.stock = new Stock(this.produit, this.point);
            interfaceHistoriqueStock.insertInHistoriqueStock(new HistoriqueStock(this.stock, Date.valueOf(dateLBL.getText()), -Math.abs(Integer.valueOf(quantiteTF.getText())), reasonCB.getValue()));
        }
            
        loadListView();
        loadBP();
            }
    }

    @FXML
    private void returnBTN(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editStock.fxml"));
        Parent root = loader.load();
        //The following both lines are the only addition we need to pass the arguments
        EditStockFXMLController editStockFXMLController = loader.getController();
        editStockFXMLController.setData(this.point);
        ((BorderPane)historiqueLV.getParent().getParent().getParent().getParent()).setCenter(root);
    }
    
    private boolean showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        }
        return false;
        }
    
    private boolean checkLBL(Label lbl){
        if(lbl.getText()== null || lbl.getText().equals("0") ){
            showAlert(Alert.AlertType.ERROR,null,"Parametres insuffisants", "Veuillez inserez les parametres manquants");
            return false;
        }
        else
            return true;
    }
    
     private boolean checkTF(TextField tf){
        if(tf.getText()== null || tf.getText().equals("")){
                   showAlert(Alert.AlertType.ERROR,null,"Parametres insuffisants", "Veuillez inserez les parametres manquants");
            return false;
        }
        else
            return true;
    }
     
     private boolean checkCB(ComboBox cb){
        if(cb.getValue() == null){
            showAlert(Alert.AlertType.ERROR,null,"ComboBox", "ComboBox est vide");
            return false;
        }
        else
            return true;
    }

    
}
