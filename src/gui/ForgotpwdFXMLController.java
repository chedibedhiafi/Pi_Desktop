/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class ForgotpwdFXMLController implements Initializable {

    int randomcode;
    private String email;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private MediaPlayer mediaPlayer;
    private Media media;
    
    @FXML
    private MediaView mediaView;
    @FXML
    private TextField emailTF;
    @FXML
    private PasswordField codeTF;
    @FXML
    private Label erreurauthdisplay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String path = new File("src\\gui\\elements\\video\\final2.mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(15));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
    }    



    @FXML
    private void confirmcode(ActionEvent event) throws IOException {

        if (Integer.valueOf(codeTF.getText()) == randomcode) {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResetpwdFXML.fxml"));
            root = loader.load();
           //The following both lines are the only addition we need to pass the arguments
           ResetpwdFXMLController rc = loader.getController();
           rc.setEmail(email);

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

    @FXML
    private void sendcode(ActionEvent event) throws AddressException, MessagingException, IOException {
      
       File htmlTemplateFile = new File("src/gui/elements/template.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);

        Random rand = new Random();
        randomcode = rand.nextInt(999999-111111)+111111;
        htmlString = htmlString.replace("$verificationCode", String.valueOf(randomcode));

        String password = "quantech123";
        String toAddress = emailTF.getText();
        String userName = "quantechp@gmail.com";
        String subject = "Code de vérification";
        String message = htmlString;
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
       //MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        // set plain text message
        Multipart multipart = new MimeMultipart("related");
        MimeBodyPart htmlPart = new MimeBodyPart();
        //add reference to your image to the HTML body <img src="cid:some-image-cid" alt="img" />
        htmlPart.setText(message, "utf-8", "html");
        multipart.addBodyPart(htmlPart);
        msg.setContent(multipart);

        Transport t = session.getTransport("smtp");
        t.connect("smtp.gmail.com", userName, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
        
        email =  emailTF.getText();
        System.out.println(email);
    }
    
}
