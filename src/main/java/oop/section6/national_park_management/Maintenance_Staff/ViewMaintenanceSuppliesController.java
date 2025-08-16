package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.HelloApplication;
import oop.section6.national_park_management.Permit_Officer.IssuePermit;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ViewMaintenanceSuppliesController {

    @FXML
    private TableView<Equipment> itemDataTableView;

    @FXML
    private TableColumn<Equipment, String> itemIdTableColumn;

    @FXML
    private TableColumn<Equipment, String> itemNameTableColumn;

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TableColumn<Equipment, String> itemQuantityTableColumn;

    @FXML
    private TableColumn<Equipment, String> itemUrgencyLevelTableColumn;

    ArrayList<Equipment> EquipmentList;

    @FXML
    void backToDashboardButton(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Maintenance_Staff/Maintenance_Staff_Main_Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage nextStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            nextStage.setTitle("Lawachara National Park");
            nextStage.setScene(scene);
            nextStage.show();
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
        }

    }

    @FXML
    void searchButton(ActionEvent event) {

    }

    public void initialize(){
        EquipmentList = new ArrayList<>();

        itemIdTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("id"));
        itemQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("quantity"));
        itemNameTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("itemName"));
        itemUrgencyLevelTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("urgencyLevel"));
    }

    @FXML
    public void viewAllButton(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File b = new File("EquipmentInfo.bin");
            if (b.exists()){
                fis = new FileInputStream(b);
            }
            else{
                //Alert: File does not exist
            }
            if (fis!= null){
                ois = new ObjectInputStream(fis);
            }
            while (true){
                itemDataTableView.getItems().add((Equipment) ois.readObject());

            }

        }

        catch (Exception e) {
            try{
                ois.close();
            }
            catch (Exception ex) {
                //
            }
        }
    }
}
