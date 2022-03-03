/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IpointDeVente;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.PointDeVente;
import models.Utilisateur;
import services.ServicePointDeVente;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class GestionPointDeVenteController implements Initializable {
    
    IpointDeVente interfacePointDeVente = new ServicePointDeVente();
    PtdeventeController gstC = new PtdeventeController();
    
    @FXML
    private GridPane ptGP;
    @FXML
    private VBox ajoutModifPanel;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField proprioTF;
    @FXML
    private TextField adresseTF;
    @FXML
    private DatePicker dateouvTF;
    @FXML
    private Button ajouterModifierBTN;

    @FXML
    private Label pointdeventeLBL;
    @FXML
    private Label hiddenIdLBL;
    @FXML
    private Pane paneId;
    @FXML
    private ScrollPane scrollPaneID;
    @FXML
    private BorderPane mainBorderPane;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ajoutModifPanel.setVisible(false);
        LoadData();                
    }    
    
    private void LoadData() {
        loadGP();
                
    }
    //LOAD DATA IN GRIDPANE
    private void loadGP(){
        int maxColumns = 2;
        /*if(ajoutModifPanel.isVisible()){
            maxColumns = 2;
            
        }else{
            maxColumns = 3;
            
        }*/
        
        int column = 0;
        int row = 0;
        
        ptGP.getChildren().clear();
    
        for (PointDeVente pt : interfacePointDeVente.afficherPointDeVentes()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ptdevente.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
                
            
            PtdeventeController ptdeventeController = fxmlLoader.getController();
            ptdeventeController.setData(pt);
            anchorPane.setId(String.valueOf(pt.getReference()));
            
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
    
    

    //CLICKING ON A GRIDPANE CELL
    @FXML
    private void onGP_clicked(MouseEvent event) throws IOException {
        
        Node source = (Node)event.getTarget() ;
        PointDeVente targetPoint = getDataFromScene(source.getParent().getParent());
       
        if(source.getParent() instanceof Label){
        if(((Label)source.getParent()).getText().equals("MODIFIER")){
            
            LoadInTF(targetPoint);
            ajoutModifPanel.setVisible(true);
            loadGP();
            
        }else{
            getPage(targetPoint,"gestionDuStock.fxml");
        }
        }else{
            getPage(targetPoint,"gestionDuStock.fxml");
        }
        
       
    }
    
    private void getPage(PointDeVente pt ,String path) throws IOException{
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gestionDuStock.fxml"));
           Parent root = loader.load();
           //The following both lines are the only addition we need to pass the arguments
           GestionDuStockController pc = loader.getController();
           pc.setPt(pt);
           pc.LoadData();

        
        mainBorderPane.setCenter(root);
        
        
    }

    
    private PointDeVente getDataFromScene(Parent scene){
        
        Label nameLBL = (Label) scene.lookup("#nameLBL");
        Label proprietaireLBL = (Label) scene.lookup("#proprietaireLBL");
        Label adressLBL = (Label) scene.lookup("#adressLBL");
        Label date_ouvLBL = (Label) scene.lookup("#date_ouvLBL");
        Label idLBL = (Label) scene.lookup("#idLBL");
        
        
        return new PointDeVente(Integer.parseInt(idLBL.getText()), nameLBL.getText(), proprietaireLBL.getText(), adressLBL.getText(), Date.valueOf(date_ouvLBL.getText()));
    }
    

    @FXML
    private void ajouterModifierBTN_clicked(ActionEvent event) {
        if(controledesaisie()){
         
        if(ajouterModifierBTN.getText().equals("Ajouter")){
            PointDeVente point = new PointDeVente(Integer.parseInt(hiddenIdLBL.getText()), nameTF.getText(), proprioTF.getText(), adresseTF.getText(), Date.valueOf(dateouvTF.getValue()));
       
            interfacePointDeVente.ajouterPointDeVente(point);
            ajoutModifPanel.setVisible(false);
            loadGP();
        }else{
            PointDeVente point = new PointDeVente(Integer.parseInt(hiddenIdLBL.getText()), nameTF.getText(), proprioTF.getText(), adresseTF.getText(), Date.valueOf(dateouvTF.getValue()));
            interfacePointDeVente.modifierPointDeVente(point);
            ajoutModifPanel.setVisible(false);
            loadGP();
        }
        }
        else
            showAlert("Please Recheck the data entered");
        
    }
    

    @FXML
    private void plusButtonClicked(ActionEvent event) {
        clearDataTF();
        ajoutModifPanel.setVisible(true);
        loadGP();
    }

    @FXML
    private void xAjouterModifierClicked(ActionEvent event) {
        clearDataTF();
        ajoutModifPanel.setVisible(false);
        loadGP();
    }
    
    private void clearDataTF(){
        pointdeventeLBL.setText("Ajouter Point De Vente");
        hiddenIdLBL.setText("0");
        nameTF.setText("");
        proprioTF.setText("");
        adresseTF.setText("");
        dateouvTF.setValue(LocalDate.now());
        ajouterModifierBTN.setText("Ajouter");
    }
    
    private void LoadInTF(PointDeVente pt){
        pointdeventeLBL.setText("Modifier Point De Vente");
        hiddenIdLBL.setText(String.valueOf(pt.getReference()));
        nameTF.setText(pt.getName());
        proprioTF.setText(pt.getProprietaire());
        adresseTF.setText(pt.getAdresse());
        dateouvTF.setValue(pt.getDate_ouverture().toLocalDate());
        ajouterModifierBTN.setText("Modifier");
    }
    
    private boolean controledesaisie(){
        if(hiddenIdLBL.getText().equals("") || nameTF.getText().equals("") || proprioTF.getText().equals("") || adresseTF.getText().equals("") || dateouvTF.getValue() == null)
            return false;
        return true;
    }
    
    private void showAlert(String s){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(s);
        alert.setContentText(null);

        alert.showAndWait();

    }
}
