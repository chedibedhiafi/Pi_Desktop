/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.IpointDeVente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.PointDeVente;
import services.ServicePointDeVente;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class PtdeventeController implements Initializable {

    PointDeVente pointDeVente;
    IpointDeVente interfacePointDeVente = new ServicePointDeVente();
    
    @FXML
    private Label nameLBL;
    @FXML
    private Label idLBL;
    @FXML
    private Label adresseLBL;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void setData(PointDeVente pt){
        this.pointDeVente = interfacePointDeVente.retrievePointDeVente(pt.getReference());
        idLBL.setText(String.valueOf(this.pointDeVente.getReference()));
        nameLBL.setText(this.pointDeVente.getName());
        adresseLBL.setText(this.pointDeVente.getAdresse());
    }
    
}
