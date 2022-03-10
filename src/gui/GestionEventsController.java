/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
import models.Event;
import services.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class GestionEventsController implements Initializable {
IService<Event> interfaceEvent = new ServiceEvent();
    UnEventController gstC = new UnEventController();
    
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
        int column = 0;
        int row = 0;
        
        ptGP.getChildren().clear();
    
        for (Event pt : interfaceEvent.afficher()){
            try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UnEvent.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
                
            
            UnEventController ptdeventeController = fxmlLoader.getController();
            ptdeventeController.setData(pt);
            anchorPane.setId(String.valueOf(pt.getEvent_Id()));
            
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
        Event targetPoint = getDataFromScene(source.getParent().getParent());
       
        if(source.getParent() instanceof Label){
        if(((Label)source.getParent()).getText().equals("MODIFIER")){
            
            LoadInTF(targetPoint);
            ajoutModifPanel.setVisible(true);
            loadGP();
            
        }else{
            getPage(targetPoint,"Evenements.fxml");
        }
        }else{
            getPage(targetPoint,"Evenements.fxml");
        }
        
       
    }
    
    private void getPage(Event pt ,String path) throws IOException{
        
        
        
        
        
    }

    
    private Event getDataFromScene(Parent scene){
        
        Label nameLBL = (Label) scene.lookup("#nameLBL");
                Label date_ouvLBL = (Label) scene.lookup("#date_ouvLBL");

        Label proprietaireLBL = (Label) scene.lookup("#proprietaireLBL");
        Label adressLBL = (Label) scene.lookup("#adressLBL");
        Label idLBL = (Label) scene.lookup("#idLBL");
        
        
        return new Event(
                Integer.parseInt(idLBL.getText()),
                Date.valueOf(date_ouvLBL.getText()),
                nameLBL.getText(), 
                proprietaireLBL.getText(),
                adressLBL.getText())
                ;
    }
    

    @FXML
    private void ajouterModifierBTN_clicked(ActionEvent event) {
        if(controledesaisie()){
         
        if(ajouterModifierBTN.getText().equals("Ajouter")){
            Event point = new Event(
                    Integer.parseInt(hiddenIdLBL.getText()),
                     Date.valueOf(dateouvTF.getValue()),
                    nameTF.getText(),
                    proprioTF.getText(), 
                    adresseTF.getText()
                   );
       
            interfaceEvent.ajout(point);
            ajoutModifPanel.setVisible(false);
            loadGP();
        }
        else{
            Event point = new Event(Integer.parseInt(hiddenIdLBL.getText())
                    , Date.valueOf(dateouvTF.getValue()),
                    nameTF.getText(), 
                    proprioTF.getText(), 
                    adresseTF.getText());
            interfaceEvent.modifier(point);
            
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
        pointdeventeLBL.setText("Ajouter Un Evénement");
        hiddenIdLBL.setText("0");
        dateouvTF.setValue(LocalDate.now());

        nameTF.setText("");
        proprioTF.setText("");
        adresseTF.setText("");
        ajouterModifierBTN.setText("Ajouter");
    }
    
    private void LoadInTF(Event pt){
        pointdeventeLBL.setText("Modifier L'évenement selectionné");
        hiddenIdLBL.setText(String.valueOf(pt.getEvent_Id()));
                dateouvTF.setValue(pt.getDate_Event().toLocalDate());

        nameTF.setText(pt.getTitre());
        proprioTF.setText(pt.getPrix());
        adresseTF.setText(pt.getDescription());
        ajouterModifierBTN.setText("Modifier");
    }
    
    private boolean controledesaisie(){
        if(hiddenIdLBL.getText().equals("") || nameTF.getText().equals("") || proprioTF.getText().equals("") || adresseTF.getText().equals("") || dateouvTF.getValue() == null)
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
