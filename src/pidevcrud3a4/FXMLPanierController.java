/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevcrud3a4;

import interfaces.Iproduitcommande;
import interfaces.Iproduits;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Commande;
import models.Produit;
import models.ProduitCommande;
import services.ServiceProduit;
import services.ServiceProduitCommande;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLPanierController implements Initializable {

    @FXML
    private Button mod;
    @FXML
    private Button supp;
    @FXML
    private Button cont;
    @FXML
    private Button pass;
    @FXML
    private TextField quantiteTF;
    @FXML
    private Label LBnom;
    @FXML
    private Label LBprix;
    @FXML
    private Label LBtotal;
    @FXML
    private Label LBdescription;
    @FXML
    private Label lbid;
    @FXML
    private ImageView ImageTF;
    private ImageView quanTF;
    private ImageView barTF;
    public static float Total;
    Iproduits interfaceProduits = new ServiceProduit();
    @FXML
    private TreeView<String> TreeProduit;
    public static int id_user=14;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        fnShowTree();
        try {
           
            // TODO
            Image img= new Image(new FileInputStream("C:\\Users\\ASUS\\Downloads\\GestionMagasin\\PidevCrud3a4\\téléchargement.jpg"));
            ImageTF.setImage(img);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLPanierController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
     
       
               
    }    

    @FXML
    private void modifierpanier(ActionEvent event) {
      ServiceProduitCommande sr = new ServiceProduitCommande() {};  
      ProduitCommande pc = new ProduitCommande();
        Commande c=new Commande();
       
         c.setId (13);
      pc.setC(c);
      pc.setQuantite(Integer.parseInt(quantiteTF.getText()));
       Produit p=new Produit();
        p.setId(Integer.parseInt(lbid.getText()));
        
      pc.setP(p);
      sr.modifierquantite(pc);
      fnShowTree();
      
    }
    

    @FXML
    private void supprimerpanier(ActionEvent event) {
        
         ServiceProduitCommande sr = new ServiceProduitCommande() {};  
      ProduitCommande pc = new ProduitCommande();
        Commande c=new Commande();
        c.setId(13);
      pc.setC(c);
        Produit p=new Produit();
        p.setId(Integer.parseInt(lbid.getText()));
      pc.setP(p);
      sr.removeproduit(pc);
      fnShowTree();
    }

    @FXML
    private void continuerachat(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("FXMLListeProduit.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    @FXML
    private void passercaisse(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("FXMLLivraison.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        ServiceProduitCommande sr= new ServiceProduitCommande();
        List<Produit> espaceList = sr.afficPrCommande(3);
        int totata=0;
        for(int i=0; i<espaceList.size();i++){
            totata+=espaceList.get(i).getTotal();
        }
        Total=totata;
        
    }

    
    
    
    public void fnShowTree(){
                ServiceProduitCommande sr= new ServiceProduitCommande();
        List<Produit> espaceList = sr.afficPrCommande(13);
        for(Produit pr :espaceList){
            
        }
        ObservableList list =FXCollections.observableArrayList(espaceList);
        TreeItem<String> rootNode = new TreeItem<String>("Produits");
        TreeProduit.setRoot(rootNode);
        
        for (Produit produit : espaceList) {
            
            TreeItem<String> empLeaf = new TreeItem<String>(produit.getNom());
           
            rootNode.getChildren().addAll(empLeaf);
            
            
        }
         
    }

    @FXML
    private void fnTreeSelected(ContextMenuEvent event) {
//        TreeItem<String> item= TreeProduit.getSelectionModel().getSelectedItem();
//        if(item != null){
//            System.out.println(item.getValue());
//            ServiceProduit serP=new ServiceProduit();
//            Produit esp=serP.getProduitByNom(item.getValue());
//            LBnom.setText(String.valueOf(esp.getNom()));
//         LBprix.setText(String.valueOf(esp.getPrix()));
//          LBtotal.setText(String.valueOf(esp.getTotal()));
//           LBdescription.setText(String.valueOf(esp.getDescription()));
//        quantiteTF.setText(""+esp.getQuantite());
//        lbid.setText(""+esp.getId());
//        }
    }

    @FXML
    private void fnTreeSelected(MouseEvent event) {
        
        TreeItem<String> item= TreeProduit.getSelectionModel().getSelectedItem();
        if(item != null){
            System.out.println(item.getValue());
            ServiceProduit serP=new ServiceProduit();
            Produit esp=serP.getProduitByNom(item.getValue());
            
            
            LBnom.setText(String.valueOf(esp.getNom()));
         LBprix.setText(String.valueOf(esp.getPrix()));
          LBtotal.setText(String.valueOf(esp.getTotal()));
           LBdescription.setText(String.valueOf(esp.getDescription()));
        quantiteTF.setText(String.valueOf(esp.getQuantite()));
        lbid.setText(String.valueOf(esp.getId()));
        //System.out.println(lbid.getText());
        }
        
    }
}
