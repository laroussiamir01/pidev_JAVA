/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import Entities.Materiel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.image.Image;
import utils.MyDB;
/**
 * FXML Controller class
 *
 * @author fadi1
 */
public class CardViewController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Label EventName;
    @FXML
    private Label Adresse;
   
  @FXML
    private Label  
ShowCategory;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void setData(Materiel event) throws SQLException{
     EventName.setText(event.getLibelle());
        Adresse.setText(event.getType());
       
   if (event.getFournisseur_id() == 0) {
    ShowCategory.setText("fournisseur non définie");
    System.out.println("err");
    return;
}

// Exécution de la requête SQL pour récupérer le nom de catégorie
Connection cnx = MyDB.getInstance().getCnx();
PreparedStatement ps = cnx.prepareStatement("SELECT nom FROM fournisseur WHERE id = ?");
ps.setInt(1, event.getFournisseur_id());
ResultSet rs = ps.executeQuery();
if (rs.next()) {
    String nomCategorie = rs.getString(1);
    ShowCategory.setText(nomCategorie);
} else {
    ShowCategory.setText("Fournisseur introuvable");
}
   
   
    }
    
}
