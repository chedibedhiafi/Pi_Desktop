/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iblog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.Blog;
import services.ServiceBlog;
import gui.PtdeventeController;


/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class UpdateBlogController implements Initializable {

    @FXML
    private ImageView imgIV;
    @FXML
    private Label titreBlog;
    @FXML
    private TextField newBlogTitreTF;
    @FXML
    private Label sujetBlog;
    @FXML
    private TextField newBlogSujetTF;
    @FXML
    private Label ContenuBlog;
    @FXML
    private TextField newBlogContenuTF;
    @FXML
    private Label idLBL;
    @FXML
    private Button finishUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    Iblog sb = new ServiceBlog();
            //Blog b69= new Blog();

    @FXML
    private void updateBlog(ActionEvent event) {
//        java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(datePicker.getValue());
      /*  Blog b1 = tv.getSelectionModel().getSelectedItem();
        DepartmentService ds = new DepartmentService();
        
        b.setId(sb.getIdTeacher(t));
        t.setName(tfname.getText());
        t.setLastname(tflastname.getText());
        t.setCin(Integer.parseInt(tfcin.getText()));
        LocalDate date = tfdate.getValue(); 
        //java.sql.Date dd = java.sql.Date.valueOf(date);
        //t.setBirth_date(dd);
        t.setEmail(tfemail.getText());
        t.setPhone_number(Integer.parseInt(tfnumber.getText()));
        String sss = ccbdep.getValue();
        t.setDeps(sss);
        ObservableList<String> ol2 = ccbsubject.getCheckModel().getCheckedItems();
        t.setSubject(ol2.toString());
        //t.setLast_updated_by("hamza");
        //t.setLast_update_date(java.sql.Date.valueOf(java.time.LocalDate.now()));
        //System.out.println(t.toString());
        ts.update(t);*/
            sb.modifierBlog(new Blog(Integer.parseInt(idLBL.getText()) ,newBlogTitreTF.getText(),newBlogSujetTF.getText(),newBlogContenuTF.getText()));
    }
    
}
