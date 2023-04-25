/*
*/
package tn.esprit.gui;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.entities.Services;
import tn.esprit.services.GestionService;
import tn.esprit.tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author hamdi
 */
public class Interface_afficher_serviceController implements Initializable {

 
    @FXML
    private TableColumn<Services, String>  description;
    @FXML
    private TableColumn<Services, String>  type;
    @FXML
  private TableColumn<Services, Double>  prix;
    @FXML
  private TableColumn<Services, String> chef_service;

    /**
     * Initializes the controller class.
     */   Services s1 = new Services();
         GestionService gs = new GestionService();
private Connection conn =MaConnexion.getInstance().getCnx();
    @FXML
    private TableView<Services> Tservice;
    @FXML
    private Button refreshButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        chef_service.setCellValueFactory(new PropertyValueFactory<>("chef_service"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
   
        Tservice.setItems(afficherListeServices());
         refreshButton.setOnAction(e -> {
        ObservableList<Services> servicesList = afficherListeServices();
        Tservice.setItems(servicesList);
    });
    }    
 public ObservableList<Services> afficherListeServices() {

    List<Services> lservices = gs.afficher();
    ObservableList<Services> ServicesList = FXCollections.observableArrayList(lservices);
   
    return ServicesList;
    
}
}
