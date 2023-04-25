/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.teknikindustries.bulksms.SMS;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hamdi
 */
public class SmsController implements Initializable {

    @FXML
    private TextField receiver;
    @FXML
    private TextArea message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void send(ActionEvent event) {
        SMS sm=new SMS();
        sm.SendSMS("tasnimmmmmm", "Vd@SD@@Pr@Ee6BZ", "216","hello","https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
          JOptionPane.showMessageDialog(null, "sms sent");
         
                  
            
    }
    
}
