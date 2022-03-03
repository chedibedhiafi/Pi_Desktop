/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.xml.bind.DatatypeConverter;
import models.PointDeVente;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class PtdeventeController implements Initializable {

    @FXML
    private Label nameLBL;
    @FXML
    private Label proprietaireLBL;
    @FXML
    private Label date_ouvLBL;
    
    private PointDeVente ptdevente;
    @FXML
    private ImageView imgIV;
    @FXML
    private Label idLBL;
    @FXML
    private Label adressLBL;
    @FXML
    private Label modifierBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                // TODO
    }    
    
    public void setData(PointDeVente pt){
        this.ptdevente = pt;
        this.idLBL.setText(String.valueOf(pt.getReference()));
        this.nameLBL.setText(pt.getName());
        this.proprietaireLBL.setText(pt.getProprietaire());
        this.date_ouvLBL.setText(pt.getDate_ouverture().toString());
        
    }
    
    public PointDeVente getData(){
        return ptdevente;
    }
    
}
