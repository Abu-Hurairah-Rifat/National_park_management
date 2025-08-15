package oop.section6.national_park_management.Park_Ranger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class UpdateProfileController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField contactField;

    @FXML
    private DatePicker availabilityDatePicker;

    @FXML
    private TableView<ProfileData> profileTable;

    @FXML
    private TableColumn<ProfileData, String> colField;

    @FXML
    private TableColumn<ProfileData, String> colValue;

    @FXML
    private Button backButton;

    @FXML
    private Button updateProfileButton;

    private final ObservableList<ProfileData> profileData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns
        colField.setCellValueFactory(data -> data.getValue().fieldProperty());
        colValue.setCellValueFactory(data -> data.getValue().valueProperty());

        // Load mock profile data
        profileData.setAll(
                new ProfileData("Full Name", "John Doe"),
                new ProfileData("Contact", "123-456-7890"),
                new ProfileData("Available From", LocalDate.now().toString())
        );
        profileTable.setItems(profileData);

        // Set default form values
        nameField.setText("John Doe");
        contactField.setText("123-456-7890");
        availabilityDatePicker.setValue(LocalDate.now());

        // Save changes button action
        updateProfileButton.setOnAction(e -> saveProfileChanges());
    }

    private void saveProfileChanges() {
        String name = nameField.getText();
        String contact = contactField.getText();
        LocalDate availableFrom = availabilityDatePicker.getValue();

        if (name.isEmpty() || contact.isEmpty() || availableFrom == null) {
            showAlert("Please fill in all fields before saving.");
            return;
        }

        profileData.setAll(
                new ProfileData("Full Name", name),
                new ProfileData("Contact", contact),
                new ProfileData("Available From", availableFrom.toString())
        );

        showAlert("Profile updated successfully!");
    }


    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/oop/section6/national_park_management/Park Ranger/ParkRangerDashboard.fxml"
            ));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Park Ranger Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Inner model class for profile table rows
     */
    public static class ProfileData {
        private final javafx.beans.property.SimpleStringProperty field;
        private final javafx.beans.property.SimpleStringProperty value;

        public ProfileData(String field, String value) {
            this.field = new javafx.beans.property.SimpleStringProperty(field);
            this.value = new javafx.beans.property.SimpleStringProperty(value);
        }

        public javafx.beans.property.StringProperty fieldProperty() { return field; }
        public javafx.beans.property.StringProperty valueProperty() { return value; }
    }
}
