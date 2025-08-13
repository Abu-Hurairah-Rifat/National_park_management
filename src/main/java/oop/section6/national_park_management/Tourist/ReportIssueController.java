package oop.section6.national_park_management.Tourist;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReportIssueController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label confirmationLabel;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Label evidenceFileLabel;

    @FXML
    private ComboBox<String> issueCategoryComboBox;

    @FXML
    private ImageView mapImageView;

    @FXML
    private Button submitReportButton;

    @FXML
    private Button uploadEvidenceButton;

    @FXML
    void initialize() {
        populateComboBox();
        loadPlaceholderMap();

        submitReportButton.setOnAction(this::handleSubmitReport);
        uploadEvidenceButton.setOnAction(this::handleUploadEvidence);
    }

    private void populateComboBox() {
        issueCategoryComboBox.setItems(FXCollections.observableArrayList(
                "Safety Hazard (e.g., broken trail)",
                "Injured or Distressed Animal",
                "Fire Hazard",
                "Illegal Activity (e.g., poaching)",
                "Environmental Damage"
        ));
    }

    private void loadPlaceholderMap() {
        try {
            Image mapImage = new Image(getClass().getResourceAsStream("/oop/section6/national_park_management/Tourist/placeholder_map.png"));
            mapImageView.setImage(mapImage);
        } catch (Exception e) {
            System.err.println("Could not load placeholder map image.");
        }
    }

    private void handleSubmitReport(ActionEvent event) {
        String category = issueCategoryComboBox.getSelectionModel().getSelectedItem();
        String description = descriptionArea.getText();

        if (category == null || category.isEmpty()) {
            showAlert("Validation Error", "Please select an issue category.");
            return;
        }
        if (description == null || description.trim().isEmpty()) {
            showAlert("Validation Error", "Please provide a description of the issue.");
            return;
        }

        System.out.println("--- URGENT REPORT SUBMITTED ---");
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Evidence File: " + evidenceFileLabel.getText());

        confirmationLabel.setText("Report sent successfully! Park staff have been alerted.");

        submitReportButton.setDisable(true);
        uploadEvidenceButton.setDisable(true);
        issueCategoryComboBox.setDisable(true);
        descriptionArea.setDisable(true);
    }

    private void handleUploadEvidence(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Evidence");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Media Files", "*.png", "*.jpg", "*.jpeg", "*.mp4", "*.mov"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"),
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.mov")
        );

        Stage stage = (Stage) uploadEvidenceButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            evidenceFileLabel.setText(selectedFile.getName());
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