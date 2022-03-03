/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.SpringLayout;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ForgotpwdController implements Initializable {

    int randomcode;
    static String email;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField emailTF;
    @FXML
    private TextField codeTF;
    @FXML
    private Label erreurauthdisplay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendcode(ActionEvent event) throws AddressException, MessagingException, IOException {
        Random rand = new Random();
        randomcode = rand.nextInt(999999-111111)+111111;

        String password = "quantech123";
        String toAddress = emailTF.getText();
        String userName = "quantechp@gmail.com";
        String subject = "password reset";
        String message = "your reset code is : "+randomcode;
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
// * BEGIN CHANGE
        properties.put("mail.smtp.user", userName);

        // creates a new session, no Authenticator (will connect() later)
        Session session = Session.getDefaultInstance(properties);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        // set plain text message
        msg.setText(message);

        Transport t = session.getTransport("smtp");
        t.connect("smtp.gmail.com", userName, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
        
        email =  emailTF.getText();
            
    }

    @FXML
    private void confirmcode(ActionEvent event) throws IOException {
        ForgotpwdController fps = new ForgotpwdController();

        if (Integer.valueOf(codeTF.getText()) == randomcode) {

        Parent root = FXMLLoader.load(getClass().getResource("Resetpwd.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        }
        
        else {
            erreurauthdisplay.setText("Mauvais code");
            codeTF.setStyle("-fx-border-color: #d53235;");
        }
    }

}
