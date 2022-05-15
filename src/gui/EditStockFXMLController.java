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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.HistoriqueStock;
import models.PointDeVente;
import models.Stock;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.ServiceHistoriqueStock;
import services.ServicePointDeVente;
import services.ServiceProduit;
import services.ServiceStock;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class EditStockFXMLController implements Initializable {
    Iproduits interfaceProduits = new ServiceProduit();
    Istock interfaceStock = new ServiceStock();
    IpointDeVente interfaceDeVente = new ServicePointDeVente();
    IhistoriqueStock interIhistoriqueStock = new ServiceHistoriqueStock();
    PointDeVente point = null;
    Stock stock = null;
    
    @FXML
    private GridPane stockGP;
    @FXML
    private Label nameLBL;
    @FXML
    private Label adresseLBL;
    @FXML
    private Label proprioLBL;
    @FXML
    private Label dateOuvLBL;
    @FXML
    private Label idLBL;
    @FXML
    private ComboBox<String> monthCB;
    @FXML
    private ComboBox<String> yearCB;
    @FXML
    private ListView<String> histStockLV;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fillComboBox();
    }    
    
    //LOAD DATA IN GRIDPANE
    public void loadGP(){
        
        int maxColumns = 2;
        
        
        int column = 0;
        int row = 0;
        
        stockGP.getChildren().clear();
        List<Stock> list = null;
        
        if(this.point == null)
            list = interfaceStock.afficherStocks();
        else
            list = interfaceStock.findStockPointDeVente(this.point);
        
        
        for (Stock stck : list){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("produitStock.fxml"));
            
            AnchorPane anchorPane = fxmlLoader.load();
                
            
            ProduitStockController produitStockController = fxmlLoader.getController();
            produitStockController.setData(stck);
            
            
            if(column == maxColumns){
                column = 0;
                row++;
            }
            
            stockGP.add(anchorPane,column++,row);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
            
        }

    }
    
    public void setData(PointDeVente pt){
        this.point = interfaceDeVente.retrievePointDeVente(pt.getReference());
        loadLabels();
        loadGP();
    }
    
    private void loadLabels(){
        idLBL.setText(String.valueOf(this.point.getReference()));
        nameLBL.setText(this.point.getName());
        proprioLBL.setText(this.point.getProprietaire());
        dateOuvLBL.setText(String.valueOf(this.point.getDate_ouverture()));
        adresseLBL.setText(this.point.getAdresse());
    }
    
    private void fillComboBox(){
        for(int i=122;i>80;i--)
            yearCB.getItems().add(String.valueOf(1900+i));
        for(int i=1;i<10;i++)
            monthCB.getItems().add("0"+String.valueOf(i));
        for(int i=10;i<13;i++)
            monthCB.getItems().add(String.valueOf(i));
    }
    
    
    private void loadListView(Stock s){
        List<String> list = new ArrayList<>();
        for (HistoriqueStock hs : interIhistoriqueStock.getFromStock(s)){
            list.add(hs.getQuantite() + " , " + hs.getReason() + " , "+hs.getDate());
        }
        ObservableList<String> items =FXCollections.observableArrayList (list);
        histStockLV.setItems(items);
        
    }

    @FXML
    private void onGP_Clicked(MouseEvent event) {
        
    }

    @FXML
    private void returnBTN(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editPointDeVente.fxml"));
        Parent root = loader.load();
        //The following both lines are the only addition we need to pass the arguments
        EditPointDeVenteFXMLController editController = loader.getController();
        editController.setData(this.point);
        ((BorderPane)stockGP.getParent().getParent().getParent().getParent().getParent()).setCenter(root);
    }

    @FXML
    private void generateClicked(ActionEvent event) {
        if(checkCB(yearCB) && checkCB(monthCB)){
        Date d = Date.valueOf(yearCB.getValue()+"-"+monthCB.getValue()+"-"+"01");
        
        
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("EXCEL documents path");
        File defaultDirectory = new File(System.getProperty("user.home")+ "/Desktop");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(new Stage());

        
        
        try {
            generateExcel(selectedDirectory.toString(),this.point,d);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        showAlert(Alert.AlertType.INFORMATION,null,"Creation Du Fichier Excel", "Fichier crée");
        }

    }
    
    private void generateExcel(String directory, PointDeVente pt, Date date) throws FileNotFoundException, IOException{
            
            
            XSSFWorkbook wb = new  XSSFWorkbook(new FileInputStream("src/gui/elements/templates/template.xlsx"));
            XSSFSheet sheet = wb.getSheet("Feuil1");
            
            //INSERTING DATE
            XSSFCell resultCell=(XSSFCell) sheet.getRow(4).getCell(2);
            resultCell.setCellValue(monthCB.getValue()+"/"+yearCB.getValue());
            
            //INSERTING PointDeVente
            resultCell=(XSSFCell) sheet.getRow(7).getCell(2);
            resultCell.setCellValue(this.point.getName());
            
            //INSERTING TodayDate
            resultCell=(XSSFCell) sheet.getRow(36).getCell(1);
            resultCell.setCellValue(String.valueOf(LocalDate.now()));
            
            int row = 12;
            int column = 0;
            for(HistoriqueStock hs : interIhistoriqueStock.getHistoriquePt(pt, date)){
                if(column == 4){
                    column =0;
                    row++;
                }
                //Insert Nom Produit
                resultCell=(XSSFCell) sheet.getRow(row).getCell(column);
                resultCell.setCellValue(hs.getStock().getProduit().getNom());
                column++;
                //Insert date
                resultCell=(XSSFCell) sheet.getRow(row).getCell(column);
                resultCell.setCellValue(String.valueOf(hs.getDate()));
                column++;
                //Insert motif
                resultCell=(XSSFCell) sheet.getRow(row).getCell(column);
                resultCell.setCellValue(hs.getReason());
                column++;
                //Insert quantite
                resultCell=(XSSFCell) sheet.getRow(row).getCell(column);
                resultCell.setCellValue(hs.getQuantite());
                column++;
            }

            FileOutputStream fileOut = new FileOutputStream(directory+"/"+pt.getName()+" in "+monthCB.getValue()+"-"+yearCB.getValue()+".xlsx"); 
            wb.write(fileOut);
            fileOut.close();
            
            
            
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
    
    private boolean checkCB(ComboBox cb){
        if(cb.getValue() == null){
            showAlert(Alert.AlertType.ERROR,null,"ComboBox", "ComboBox est vide");
            return false;
        }
        else
            return true;
    }

    @FXML
    private void onPlusClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("insertInStock.fxml"));
        Parent root = loader.load();
        //The following both lines are the only addition we need to pass the arguments
        InsertInStockController insertController = loader.getController();
        insertController.setData(this.point);
        ((BorderPane)stockGP.getParent().getParent().getParent().getParent().getParent()).setCenter(root);
    }
}

    

