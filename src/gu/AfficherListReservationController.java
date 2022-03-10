/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gu;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Reservation;
import services.ServiceEvent;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class AfficherListReservationController implements Initializable {

    private Button retour;
    @FXML
    private TableView <Reservation> table;
    @FXML
    private TableColumn<Reservation , Date> dateachat;
    @FXML
    private TableColumn<Reservation , Integer> total;
    @FXML
    private TableColumn<Reservation , Integer> nb;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                // TODO
        ServiceReservation sb = new ServiceReservation();
        System.out.println("err");
        List Reservation = sb.afficher();
        ObservableList list = FXCollections.observableArrayList(Reservation);
        
        table.setItems(list);
        nb.setCellValueFactory(new PropertyValueFactory<>("Nb_Places"));
        dateachat.setCellValueFactory(new PropertyValueFactory<>("Date_Achat"));
        total.setCellValueFactory(new PropertyValueFactory<>("Total"));
           TableColumn<Reservation, Void> gotobtn = new TableColumn("Action");
 Callback<TableColumn<Reservation, Void>, TableCell<Reservation, Void>> cellFactory;
        cellFactory = new Callback<TableColumn<Reservation, Void>, TableCell<Reservation, Void>>() {
            
            @Override
            public TableCell<Reservation, Void> call(final TableColumn<Reservation, Void> param) {
                final TableCell<Reservation, Void> cell;
                cell = new TableCell<Reservation, Void>() {
                    
                    
                    private final Button btn = new Button("Pdf");
                    
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Reservation data = getTableView().getItems().get(getIndex());
                            int a=data.getReserv_Id();
                            System.out.println(a);
                            Reservation u=new Reservation();
                            
                            
                            
                            String Total=data.getTotal();
                            String Nb_Places=data.getNb_Places();
                            
                            
                            String id=String.valueOf(a);
                            String dated=String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", data.getDate_Achat());
                            
                            
                            
                            Document doc =new Document();
                             
                            try {
                                String file_name="C:\\Users\\SOULAYMA\\Documents\\NetBeansProjects\\events\\generatepdf\\dynamiclistreserv.pdf";
                                PdfWriter.getInstance(doc, new FileOutputStream(file_name));
                                doc.open();
                                
                                doc.addTitle("Code de la reservation: "+id);
                                doc.add(new Paragraph("Votre Total: '"+Total+"'"));
                                
                                
                                doc.add(new Paragraph("Le nombre places '"+Nb_Places+"'"));
                                doc.add(new Paragraph("Vous avez fait la reservztion: '"+dated+"'"));

                                doc.close();
                                Desktop.getDesktop().open(new File(file_name));
                            } catch (FileNotFoundException ex) {
                                System.out.println("3");
                                Logger.getLogger(AfficherListReservationController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (DocumentException ex) {
                                System.out.println("4");
                                Logger.getLogger(AfficherListReservationController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {System.out.println("5");
                            Logger.getLogger(AfficherListReservationController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
                            
                        });
                       
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

       gotobtn.setCellFactory(cellFactory);
System.out.println("6");
       table.getColumns().add(gotobtn);
      
      
  }
        // TODO
        

    private void retour(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(".fxml"));
            Parent root = loader.load();
           
          retour.getScene().setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

 
    
}
