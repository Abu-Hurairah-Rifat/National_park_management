package oop.section6.national_park_management.EcoTourGuide;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MaintainProfileController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextArea bioArea;
    @FXML
    private Button changePictureButton;
    @FXML
    private TextField nameField;
    @FXML
    private ImageView profileImageView;
    @FXML
    private Button saveProfileButton;
    @FXML
    private TextField specialtiesField;
    @FXML
    private Label statusLabel;

    @FXML
    void initialize() {
        loadCurrentProfile();
        saveProfileButton.setOnAction(this::handleSaveProfile);
        changePictureButton.setOnAction(this::handleChangePicture);
    }

    private void loadCurrentProfile() {
        nameField.setText("Your Name");
        specialtiesField.setText("Bird Watching, Botany, Wildlife Tracking");
        bioArea.setText("An experienced and certified eco-tour guide with a passion for the unique biodiversity of Lawachara National Park. Specializing in guided treks and educational tours for all ages.");
        try {
            Image avatar = new Image(getClass().getResourceAsStream("/oop/section6/national_park_management/EcoTourGuide/tour_guide_avatar.jpg"));
            profileImageView.setImage(avatar);
        } catch (Exception e) {
            System.err.println("Could not load placeholder avatar image.");
        }
    }

    private void handleSaveProfile(ActionEvent event) {
        if (nameField.getText().trim().isEmpty() || specialtiesField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Name and Specialties fields cannot be empty.");
            return;
        }

        System.out.println("--- Saving Profile ---");
        System.out.println("Name: " + nameField.getText());
        System.out.println("Specialties: " + specialtiesField.getText());
        System.out.println("Bio: " + bioArea.getText());

        statusLabel.setText("Profile saved successfully!");
        statusLabel.setStyle("-fx-text-fill: green;");
    }

    private void handleChangePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select New Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) changePictureButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                Image newImage = new Image(selectedFile.toURI().toString());
                profileImageView.setImage(newImage);
                statusLabel.setText("New profile picture selected.");
                statusLabel.setStyle("-fx-text-fill: black;");
            } catch (Exception e) {
                showAlert("Image Load Error", "Could not load the selected image.");
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}