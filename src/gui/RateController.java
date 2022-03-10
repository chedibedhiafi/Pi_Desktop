/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.EventsUtilisateursController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import utils.AlertBox;


/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class RateController implements Initializable {

    @FXML
    private RadioButton s3;
    @FXML
    private RadioButton l3;
    @FXML
    private RadioButton s2;
    @FXML
    private RadioButton l2;
    @FXML
    private RadioButton s1;
    @FXML
    private RadioButton l1;
    @FXML
    private RadioButton q2;
    @FXML
    private RadioButton q1;
    @FXML
    private RadioButton q3;
    @FXML
    private Button submitnote;
    @FXML
    private TextField noteutilisateur;
    @FXML
    private Button retour;
    @FXML
    private ToggleGroup prix;
    @FXML
    private ToggleGroup qualite;
    @FXML
    private ToggleGroup organisation;
    @FXML
    private RadioButton q4;
    @FXML
    private RadioButton q5;
    @FXML
    private RadioButton l4;
    @FXML
    private RadioButton l5;
    @FXML
    private RadioButton s4;
    @FXML
    private RadioButton s5;
    
        int note1;
        int note2;
        int note3;
        int rate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void submit (ActionEvent event) {
        try{
       ////Group 1 ///// 
       
   if ((organisation.getSelectedToggle() != null)){  
      if ( (organisation.getSelectedToggle() == q1)) 
      { note1 = 1;
                System.out.println( note1);

      } 
      else if ( (organisation.getSelectedToggle() == q2)){
     note1 = 2;
   
 System.out.println( note1);
      }
      
      else if ( (organisation.getSelectedToggle() == q3)){
          note1 = 3;
      System.out.println( note1);
      }
      
      else if( (organisation.getSelectedToggle() == q4)){
          note1 = 4;
          System.out.println(note1);
      }
      
      else  {  note1=5; 
      System.out.println( note1);
            }       
   }        
  
    
     
     if ((qualite.getSelectedToggle() != null)){  
      if ( (qualite.getSelectedToggle() == l1)) 
      { note2 = 1;
                System.out.println( note2);

      } else if ( (qualite.getSelectedToggle() == l2)){
          note2 = 2;
                   System.out.println( note2);

      }
      else if ( (qualite.getSelectedToggle() == l3)){
          note2 =3;
         System.out.println(note2);
      }
      else if ((qualite.getSelectedToggle() == l4)){
          note2 =4;
          System.out.println(note2);
      }
      else  { 
                 note2=5;
            System.out.println( note2);}   
           
         
     
    }

     
     /////////////////// groupe 3 //////////
    
      if ((prix.getSelectedToggle() != null)){  
      if ( (prix.getSelectedToggle() == s1)) 
      { note3 = 1;
                System.out.println( note3);

      } else if ( (prix.getSelectedToggle() == s2)){
          note3 = 2;
                   System.out.println( note3);

      }
      else if ( (prix.getSelectedToggle() == s3)){
          note3 = 3;
          System.out.println(note3);
      }
      else if( (prix.getSelectedToggle() ==s4)){
          note3 =4;
          System.out.println(note3);
      }
      else  { 
                   note3= 5;
          System.out.println( note3); }
     
    }
    
      
      rate = (note1  + note2 + note3) / 3;
 
      
      noteutilisateur.setText(String.valueOf(rate));
      
          AlertBox.display("Success", "vous avez noté cet evenement");
    System.out.println("added");
  
      } catch(Exception Ex ){
            AlertBox.display("error", "veuillez donner une note!");


      }
        
    }
 @FXML
    private void retour(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EventsUtilisateurs.fxml"));
            Parent root = loader.load();
          ((BorderPane)submitnote.getParent().getParent()).setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(EventsUtilisateursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    }
    
    

  
