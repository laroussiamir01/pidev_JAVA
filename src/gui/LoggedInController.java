/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.ServiceUser;
import entites.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import pidevuser.PidevUser;
import util.dbconnection;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoggedInController implements Initializable {

    
    
    @FXML
    private Button exit;
    @FXML
    private TextField Recherche_User;
    @FXML
    private TableView<User> tvUsers;
    
    @FXML
    private Button button_logout;
   @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> roles;
    @FXML
    private TableColumn<User, String> username;

    @FXML
    private TextField emails;
    @FXML
    private TextField ids;
    @FXML
    private TextField usernames;
     @FXML
    private TextField roless;

    
    
    @FXML
    private Button refresh;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    
    private Connection cnx;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    int index = -1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //showRec();
        addButtonToTable();
         addButtonToTable2();
        ObservableList<User> listm = getUserList();
             
       email.setCellValueFactory(new PropertyValueFactory<>("email"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        roles.setCellValueFactory(new PropertyValueFactory<>("roles"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
   
        tvUsers.setItems(listm);
        search_user();

    }
    
       @FXML
    private void logout() throws IOException {  
        PidevUser m = new PidevUser() ;
       
        m.changeScene("/gui/login.fxml");
        
    }
    
     @FXML
    private void tobot()throws IOException {
        PidevUser m = new PidevUser() ;
         m.changeScene("/gui/ChatBot.fxml");
        
    }
    
  private void addButtonToTable() {
        TableColumn<User, Void> BlockBtn = new TableColumn("Block");

        Callback<TableColumn<User, Void>, TableCell<User, Void>> cellFactory = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(final TableColumn<User, Void> param) {
                final TableCell<User, Void> cell = new TableCell<User, Void>() {

                    private final Button btn = new Button("Block");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            TableColumn<User, String> firstColumn = (TableColumn<User, String>) getTableView().getColumns().get(0);
                            String email = firstColumn.getCellData(getIndex());
                            System.out.println("selectedData: " + email);
                           try {
                                ServiceUser.getInstance().BlockUser(email);
                            } catch (SQLException ex) {
                                Logger.getLogger(LoggedInController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        BlockBtn.setCellFactory(cellFactory);

        tvUsers.getColumns().add(BlockBtn);

    }
  
   private void addButtonToTable2() {
        TableColumn<User, Void> Block1Btn = new TableColumn("Déblock");

        Callback<TableColumn<User, Void>, TableCell<User, Void>> cellFactory = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(final TableColumn<User, Void> param) {
                final TableCell<User, Void> cell = new TableCell<User, Void>() {

                    private final Button btn = new Button("Déblock");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            TableColumn<User, String> firstColumn = (TableColumn<User, String>) getTableView().getColumns().get(0);
                            String email = firstColumn.getCellData(getIndex());
                            System.out.println("selectedData: " + email);
                           try {
                                ServiceUser.getInstance().DeblockUser(email);
                            } catch (SQLException ex) {
                                Logger.getLogger(LoggedInController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
            
             
        };

        Block1Btn.setCellFactory(cellFactory);

        tvUsers.getColumns().add(Block1Btn);
       

    }
  
  
    @FXML
    public void getSelected(MouseEvent event) throws SQLException {
        index = tvUsers.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        ids.setText(id.getCellData(index).toString());
        emails.setText(email.getCellData(index).toString());
        usernames.setText(username.getCellData(index).toString());    
        roless.setText(roles.getCellData(index).toString());
       


    }

    @FXML
    private void showSelectedUser(MouseEvent event) {
    }

    @FXML
    public ObservableList<User> getUserList() {
        cnx = dbconnection.getInstance().getConnection();

        ObservableList<User> UserList = FXCollections.observableArrayList();
        try {
            String query2 = "SELECT  * from user ";
            PreparedStatement smt = cnx.prepareStatement(query2);
            User user;
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("email"),rs.getString("roles"),rs.getString("username"));
                UserList.add(user);
            }
            System.out.println(UserList);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return UserList;

    }

    @FXML
    public void showRec() {

        ObservableList<User> list = getUserList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        roles.setCellValueFactory(new PropertyValueFactory<>("roles"));


        tvUsers.setItems(list);

    }

    @FXML
    private void refresh() {
        ObservableList<User> list = getUserList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        roles.setCellValueFactory(new PropertyValueFactory<>("roles"));
        
        tvUsers.setItems(list);

    }


    public void Edit() {

        try {
            cnx = dbconnection.getInstance().getConnection();
            String value1 = ids.getText();
            String value2 = emails.getText();
            String value3 = usernames.getText();
            String value8 = roless.getText();

            String query3 = "update user set email='" + value2 + "'  ,username='" + value3 + "'  ,roles='" + value8 + "' WHERE id = '" + value1 + "' ";
            PreparedStatement smt = cnx.prepareStatement(query3);
            smt.execute();
            showRec();
            search_user();
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Success");
             alert.setHeaderText(null);
             alert.setContentText("Votre a été modifier avec sucess");
             alert.showAndWait();


        } catch (Exception e) {
        }
    }

    public void Delete() {
        cnx = dbconnection.getInstance().getConnection();
        String sql = "delete from user where id = ?";
        try {

            PreparedStatement smt = cnx.prepareStatement(sql);
            smt.setString(1, ids.getText());
            smt.execute();
            showRec();
            search_user();
            
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Success");
             alert.setHeaderText(null);
             alert.setContentText("Votre a été supprimer avec sucess");
             alert.showAndWait();
             
        } catch (Exception e) {

        }

    }

    @FXML
    void search_user() {
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        roles.setCellValueFactory(new PropertyValueFactory<>("roles"));
     
        
        cnx = dbconnection.getInstance().getConnection();

        ObservableList<User> dataList = getUserList();

        tvUsers.setItems(dataList);

        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);
        Recherche_User.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                } else if (person.getRoles().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password*/
                } else if (String.valueOf(person.getEmail()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches email
                } else {
                    return false; // Does not match.
                }
            });
        });

        SortedList<User> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvUsers.comparatorProperty());
        tvUsers.setItems(sortedData);

    }

    

}
