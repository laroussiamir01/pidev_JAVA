/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author damak
 */
public class MainClient extends Application {

    
    @Override
  
     
    public void start(Stage primaryStage) {
     Parent root;   
     try{
         root = FXMLLoader.load(getClass().getResource("FrontClient.fxml"));
         Scene scene = new Scene(root);
     //    primaryStage.getIcons().add(new Image("/Assets/logo.png"));
        primaryStage.setTitle("SAUVEVIES Desktop Application");
        primaryStage.setScene(scene);
        primaryStage.show();
       
     }
     catch(IOException ex)
     {
           System.out.println(ex.getMessage());
     }
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
