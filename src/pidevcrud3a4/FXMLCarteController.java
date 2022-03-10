/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevcrud3a4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.AlertBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLCarteController implements Initializable {

    
    
    @FXML
    private DatePicker dateLB;
    @FXML
    private TextField LBnom;
    @FXML
    private TextField LBprenom;
    @FXML
    private Button payTF;
    @FXML
    private Button retourTF;
    @FXML
    private TextField numcarte;
    @FXML
    private TextField cvvtf;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
       

        
    }

    @FXML
    private void validerpaiement(ActionEvent event) throws IOException {
        
        if(numcarte.getText().length()!=16 ){
            AlertBox.display("error", "numero de carte doit etre composé 16 chiffres");
            
        } else if (cvvtf.getText().length()!=3){
             AlertBox.display("error", "le CVV doit etre composé de 3 chiffres");
        }else{
            
            
            Parent etab = FXMLLoader.load(getClass().getResource("FXMLPaiement.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        window.setScene(scene);
        window.show();
        }
        }
          
         
        
       
    
   
    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
        if(LBnom.getText().equals("") || LBprenom.getText().equals("") || cvvtf.getText().equals("")|| numcarte.getText().equals("")||dateLB.getValue().equals(null))
        {
       AlertBox.display("error", "veuillez completer vos information");
         }else{
            Parent etab = FXMLLoader.load(getClass().getResource("FXMLPaiement.fxml"));
            Scene scene = new Scene(etab);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
             window.setScene(scene);
            window.show();
        }
    }


   
    
}
