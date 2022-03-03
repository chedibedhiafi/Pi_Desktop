/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IhistoriqueStock;
import interfaces.Iproduits;
import interfaces.Istock;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Event;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Produit;
import models.Stock;
import services.ServiceHistoriqueStock;
import services.ServiceProduit;
import services.ServiceStock;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class GestionDuStockController implements Initializable{

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Pane paneId;
    @FXML
    private ScrollPane scrollPaneID;
    @FXML
    private GridPane ptGP;
    @FXML
    private VBox ajoutModifPanel;
    @FXML
    private Label pointdeventeLBL;
    @FXML
    private Label hiddenIdLBL;
    
    @FXML
    private Button ajouterModifierBTN;
    
    Istock interfaceStock = new ServiceStock();
    Iproduits interfaceProduits = new ServiceProduit();
    private PointDeVente point = null;
    private Stock stock = null;
    IhistoriqueStock interfaceHisStock = new ServiceHistoriqueStock();
    
    @FXML
    private Label nameLBL;
    @FXML
    private ComboBox<String> produitDropBox;
    @FXML
    private Label dataLBL;
    @FXML
    private ListView<String> listViewHistorique;
    @FXML
    private TextField quantiteTF;
    @FXML
    private TextField reasonTF;
  

    /**
     * Initializes the controller class.
     */

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajoutModifPanel.setVisible(false);
    }    
   
    public void setPt(PointDeVente pt){
        this.point = pt;
    }
    
    public void LoadData(){
        loadGP();
        nameLBL.setText(point.getName());
        loadComboBox();
        dataLBL.setText(String.valueOf(LocalDate.now()));
    }
    
    private void loadListView(Stock s){
        List<String> list = new ArrayList<>();
        for (HistoriqueStock hs : interfaceHisStock.getFromStock(this.stock)){
            list.add(hs.getQuantite() + " , " + hs.getReason() + " , "+hs.getDate());
        }
        ObservableList<String> items =FXCollections.observableArrayList (list);
        listViewHistorique.setItems(items);
        
    }
    
    private void loadComboBox(){
        List<Produit> list = interfaceProduits.afficherProduit();
        List<String> listString = new ArrayList<String>();
        for(Produit pd : list){
            listString.add(String.valueOf(pd.getId()) + "," + pd.getNom());
        }
        produitDropBox.getItems().addAll(listString);
        
    }
    
    //LOAD DATA IN GRIDPANE
    public void loadGP(){
        
        int maxColumns = 2;
        
        
        int column = 0;
        int row = 0;
        
        ptGP.getChildren().clear();
        List<Stock> list = null;
        
        if(this.point == null)
            list = interfaceStock.afficherStocks();
        else
            list = interfaceStock.findStockPointDeVente(this.point);
        
        
        for (Stock stck : list){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("stockProduit.fxml"));
            
            AnchorPane anchorPane = fxmlLoader.load();
                
            
            StockProduitController stockProduitController = fxmlLoader.getController();
            stockProduitController.setData(stck);
            
            
            if(column == maxColumns){
                column = 0;
                row++;
            }
            
            ptGP.add(anchorPane,column++,row);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }

    }
    private void refreshData(){
        if(this.stock != null){
            loadListView(this.stock);
        }
            
        loadGP();
    }

    @FXML
    private void plusButtonClicked(ActionEvent event) {
        
        ajoutModifPanel.setVisible(true);
        refreshData();
    }

    
    @FXML
    private void onGP_clicked(MouseEvent event) {
        Node source = (Node)event.getTarget() ;
        Stock targetPoint = getDataFromScene(source.getParent().getParent());
        this.stock = interfaceStock.retrieveStock(targetPoint);
        ajoutModifPanel.setVisible(true);
        refreshData();
        
  
    }
    private Stock getDataFromScene(Parent scene){
        Label refLBL = (Label) scene.lookup("#referenceLBL");
        return new Stock(interfaceProduits.retriveproduit(Integer.parseInt(refLBL.getText())), point);
    }
    
    

    @FXML
    private void xAjouterModifierClicked(ActionEvent event) {
        ajoutModifPanel.setVisible(false);
        loadGP();
    }

    @FXML
    private void ajouterModifierBTN_clicked(ActionEvent event) {
        if(controledesaisie()){
           
        Produit prod = new Produit();
        prod.setId(Integer.parseInt(produitDropBox.getValue().split(",")[0]));
        System.out.println(prod);
        this.stock = new Stock(prod, point);
        interfaceHisStock.insertInHistoriqueStock(new HistoriqueStock(this.stock, Date.valueOf(dataLBL.getText()), Integer.parseInt(quantiteTF.getText()), reasonTF.getText()));
        refreshData();
        }
        else
            showAlert("Check the parameters entered");
    }
    
    private boolean controledesaisie(){
        if( produitDropBox.getValue() == null || quantiteTF.equals("") || reasonTF.getText().equals("") || dataLBL.getText().equals("date"))
            return false;
        return true;
    }
    
    private void showAlert(String s){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(s);
        alert.setContentText(null);

        alert.showAndWait();

    }
    
 

}
