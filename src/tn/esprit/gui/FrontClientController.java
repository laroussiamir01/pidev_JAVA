/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamdi
 */
public class FrontClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clic_ajout_hosp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Interface_ajout_hosp.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Votre Profil");
                stage.show();

    }

    @FXML
    private void clic_mod_hosp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Interface_ajout_hosp.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Votre Profil");
                stage.show();

    }

    @FXML
    private void clic_aff_hosp(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Interface_ajout_hosp.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Votre Profil");
                stage.show();

    }

    @FXML
    private void clic_aff_serv(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Interface_afficher_service.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Votre Profil");
                stage.show();

    }
    
}
