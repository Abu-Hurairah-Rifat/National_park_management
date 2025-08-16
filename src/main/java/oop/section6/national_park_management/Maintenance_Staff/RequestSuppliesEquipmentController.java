package oop.section6.national_park_management.Maintenance_Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.section6.national_park_management.AppendableObjectOutputStream;
import oop.section6.national_park_management.HelloApplication;
import oop.section6.national_park_management.Permit_Officer.IssuePermit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class RequestSuppliesEquipmentController {

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

    @FXML
    private TextField quantityTextField;

    @FXML
    private ComboBox<String> urgencyLevelComboBox;

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
    void submitRequestButton(ActionEvent event) {
        if (itemNameTextField.getText().isEmpty() ||
                quantityTextField.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Fill up the form properly.");
            errorAlert.show();
        }

        else{
            Alert processCompleteAlert = new Alert(Alert.AlertType.INFORMATION);
            processCompleteAlert.setContentText("Permit information submitted properly");
            processCompleteAlert.show();

            Equipment equipmentToBeAdded = getEquipmentList();

            itemDataTableView.getItems().add(equipmentToBeAdded);
            EquipmentList.add(equipmentToBeAdded);

            try{
                File b = new File("EquipmentInfo.bin");
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;

                if (b.exists()){
                    fos = new FileOutputStream(b, true);
                    oos = new AppendableObjectOutputStream(fos);
                }
                else{
                    fos = new FileOutputStream(b);
                    oos = new ObjectOutputStream(fos);
                }



                for (Equipment e : EquipmentList){
                    oos.writeObject(e);
                }
                oos.close();

            }
            catch (Exception e) {
                //
            }


        }

    }

    private Equipment getEquipmentList() {
        int initialId = 0;


        Equipment equipmentToBeAdded = new Equipment(
                initialId,
                Integer.parseInt(quantityTextField.getText()),
                itemNameTextField.getText(),
                urgencyLevelComboBox.getValue()
        );
        return equipmentToBeAdded;
    }

    public void initialize(){
        EquipmentList = new ArrayList<>();
        urgencyLevelComboBox.getItems().addAll("Normal", "Urgent");

        itemIdTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("id"));
        itemQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("quantity"));
        itemNameTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("itemName"));
        itemUrgencyLevelTableColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("urgencyLevel"));

    }

}
