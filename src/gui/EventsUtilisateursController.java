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
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import models.Event;
import services.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class EventsUtilisateursController implements Initializable {
  private Stage stage;
    private Scene scene;
    private Parent root;
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
    private TextField nameTF;
  @FXML
    private TextField proprioTF;
  @FXML
    private TextField adresseTF;
  @FXML
    private DatePicker dateouvTF;
    @FXML
    private Button ajouterModifierBTN;

    /**
     * Initializes the controller class.
     */
        
    IService<Event> interfaceEvent = new ServiceEvent();
    UnEventUtilisateurController gstC = new UnEventUtilisateurController();
    
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
                System.out.println(pt);
                
                FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UnEventUtilisateur.fxml"));
            
                AnchorPane anchorPane = fxmlLoader.load();
                
            
            UnEventUtilisateurController ptdeventeController = fxmlLoader.getController();
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
        if(((Label)source.getParent()).getText().equals("Reserver")){
            
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
    private void ajouterModifierBTN_clicked(ActionEvent event)  throws IOException {
        int Event_Id = Integer.parseInt(hiddenIdLBL.getText());
                    String Titre = nameTF.getText();

          System.out.println(Event_Id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReservation.fxml")); 
       root = loader.load();
       
       AjouterReservationController  rateboutiquecontroller = loader.getController();
         rateboutiquecontroller.setEvent(interfaceEvent.retrieve(Event_Id));
       ((BorderPane)mainBorderPane.getParent().getParent().getParent().getParent().getParent()).setCenter(root);
    }

   

  @FXML
    private void xAjouterModifierClicked(ActionEvent event) {
        
        ajoutModifPanel.setVisible(false);
        loadGP();
    }
    
    
    
    private void LoadInTF(Event pt){
        pointdeventeLBL.setText("Consulter L'évenement selectionné");
        hiddenIdLBL.setText(String.valueOf(pt.getEvent_Id()));
    dateouvTF.setValue(pt.getDate_Event().toLocalDate());

        nameTF.setText(pt.getTitre());
        proprioTF.setText(pt.getPrix());
        adresseTF.setText(pt.getDescription());
        ajouterModifierBTN.setText("Reserver");
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
