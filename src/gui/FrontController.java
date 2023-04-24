/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Don;
import java.io.IOException;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.DonCRUD;

/**
 * FXML Controller class
 *
 * @author tasnim
 */
public class FrontController implements Initializable {

    @FXML
    private TableView<Don> table;
    @FXML
    private TableColumn<Don, String> colId;
    @FXML
    private TableColumn<Don, String> colClient;
    @FXML
    private TableColumn<Don, String> colNumCmd;
    @FXML
    private TableColumn<Don, String> colMntCmd;
    // 
        ObservableList<Don> obl = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getListDon();
        // TODO
        
                      table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                // Get selected item
                Don selectedEvent = table.getSelectionModel().getSelectedItem();
                if (selectedEvent != null) {
                    // Open new window for editing the selected row
                    openEditWindows(selectedEvent);
                }
            }
        });
    }




    
private void openEditWindows(Don selectedDon) {
    try {
        // Load the FXML file for the edit window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GererDon.fxml"));
        Parent root = loader.load();

        // Get the controller instance
        GerersDonController controller = loader.getController();

        // Call a method on the controller to pass the selected Event
        controller.setSelectedDon(selectedDon);

        // Create a new scene and stage for the edit window
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Edit Don");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}













    
    
            public void getListDon() {
        DonCRUD cmd = new DonCRUD();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colNumCmd.setCellValueFactory(new PropertyValueFactory<>("nom"));
                  colMntCmd.setCellValueFactory(new PropertyValueFactory<>("montant"));
        colClient.setCellValueFactory(new PropertyValueFactory<>("events"));
    
  
    
        
        // Display row data
        List<Don> listDon = cmd.consulterDon();
        ObservableList<Don> observableList = FXCollections.observableList(listDon);
         table.setItems(observableList);
    }
    
    

    @FXML
    private void getDetailCmd(MouseEvent event) {
    }

    private void refrechdon(ActionEvent event) {
           DonCRUD cmd = new DonCRUD();
    List<Don> listDon = cmd.consulterDon();

    // Update the table view with the new data
    table.getItems().clear();
    table.getItems().addAll(listDon);
    }

    /*@FXML
    private void ajouterdon(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterDon.fxml"));
       Parent root = loader.load();
       Scene scene = new Scene(root);
       Stage popupStage = new Stage();
       popupStage.initModality(Modality.WINDOW_MODAL);
       popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());
       popupStage.setScene(scene);
       popupStage.show();
    }*/

 

    private void eventtable(ActionEvent event) throws IOException {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEvent.fxml"));
       Parent root = loader.load();
       Scene scene = new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
    }
   
}
