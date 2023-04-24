/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entite.Event;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.EventCRUD;



/**
 * FXML Controller class
 *
 * @author tasnim
 */
public class AfficherEventsController implements Initializable {
    

    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event, String> colId;
    @FXML
    private TableColumn<Event, String> colClient;
    @FXML
    private TableColumn<Event, String> colNumCmd;
    @FXML
    private TableColumn<Event, String> colMntCmd;
    
 private ObservableList<Event> observableList;
    


     ObservableList<Event> obl = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Event, Button> colButton;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        getListCmd();
    
        
               table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                // Get selected item
                Event selectedEvent = table.getSelectionModel().getSelectedItem();
                if (selectedEvent != null) {
                    // Open new window for editing the selected row
                    openEditWindow(selectedEvent);
                }
            }
        });


    }
    
    
private void openEditWindow(Event selectedEvent) {
    try {
        // Load the FXML file for the edit window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateDeleteEvent.fxml"));
        Parent root = loader.load();

        // Get the controller instance
        UpdateDeleteEventController controller = loader.getController();

        // Call a method on the controller to pass the selected Event
        controller.setSelectedEvent(selectedEvent);

        // Create a new scene and stage for the edit window
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Edit Event");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}





    
public void getListCmd() {
    EventCRUD cmd = new EventCRUD();
    colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colClient.setCellValueFactory(new PropertyValueFactory<>("nom"));
    colNumCmd.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
    colMntCmd.setCellValueFactory(new PropertyValueFactory<>("date_fin"));

   


    // Display row data
    List<Event> listEvents = cmd.consulterEvents();
    observableList = FXCollections.observableList(listEvents);
    table.setItems(observableList);
}


        
        
           @FXML
    private void getDetailCmd(MouseEvent event) {
   
     
        
  

    }

  public void updateDeleteEvent () throws IOException {
   Stage stage = new Stage ();
Parent root  = FXMLLoader.load (getClass().getResource("/UpdateDeleteEvent"));
Scene scene = new Scene (root);
stage.setScene(scene);
stage.setTitle("updated");
stage.show();

  }

@FXML
private void ajouterEvent(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEvent.fxml"));
       Parent root = loader.load();
       Scene scene = new Scene(root);
       Stage popupStage = new Stage();
       popupStage.initModality(Modality.WINDOW_MODAL);
       popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());
       popupStage.setScene(scene);
       popupStage.show();
}

   @FXML
private void refrech(ActionEvent event) {
    EventCRUD cmd = new EventCRUD();
    List<Event> listEvents = cmd.consulterEvents();

    // Update the table view with the new data
    table.getItems().clear();
    table.getItems().addAll(listEvents);
}


  

    @FXML
    private void DonTable(ActionEvent event)throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherDon.fxml"));
       Parent root = loader.load();
       Scene scene = new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }

    @FXML
    private void stat(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Stat.fxml"));
       Parent root = loader.load();
       Scene scene = new Scene(root);
       Stage popupStage = new Stage();
       popupStage.initModality(Modality.WINDOW_MODAL);
       popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());
       popupStage.setScene(scene);
       popupStage.show();
    }

        
   
                  }



