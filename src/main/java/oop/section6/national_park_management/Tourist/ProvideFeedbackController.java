package oop.section6.national_park_management.Tourist;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ProvideFeedbackController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button attachPhotoButton;

    @FXML
    private TextArea commentsArea;

    @FXML
    private ComboBox<String> facilityComboBox;

    @FXML
    private ComboBox<String> issueCategoryComboBox;

    @FXML
    private Label photoNameLabel;

    @FXML
    private ComboBox<String> ratingComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    private Button submitButton;

    @FXML
    void initialize() {
        populateComboBoxes();

        submitButton.setOnAction(event -> handleSubmit());
        attachPhotoButton.setOnAction(event -> handleAttachPhoto());
    }

    private void populateComboBoxes() {
        facilityComboBox.setItems(FXCollections.observableArrayList(
                "Visitor Center", "Restrooms", "Canopy Walkway", "Trails", "Cafe"
        ));

        issueCategoryComboBox.setItems(FXCollections.observableArrayList(
                "Cleanliness", "Maintenance/Repair", "Staff Friendliness", "Signage Clarity", "Other"
        ));

        ratingComboBox.setItems(FXCollections.observableArrayList(
                "5 - Excellent", "4 - Good", "3 - Average", "2 - Poor", "1 - Terrible"
        ));
    }

    private void handleSubmit() {
        String facility = facilityComboBox.getSelectionModel().getSelectedItem();
        String category = issueCategoryComboBox.getSelectionModel().getSelectedItem();
        String rating = ratingComboBox.getSelectionModel().getSelectedItem();
        String comments = commentsArea.getText();

        if (facility == null || category == null || rating == null) {
            statusLabel.setText("Please fill in all required fields.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        System.out.println("Feedback Submitted:");
        System.out.println("Facility: " + facility);
        System.out.println("Category: " + category);
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);
        System.out.println("Attached Photo: " + photoNameLabel.getText());

        statusLabel.setText("Thank you! Your feedback has been submitted.");
        statusLabel.setStyle("-fx-text-fill: green;");

        clearForm();
    }

    private void handleAttachPhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) attachPhotoButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            photoNameLabel.setText(selectedFile.getName());
        }
    }

    private void clearForm() {
        facilityComboBox.getSelectionModel().clearSelection();
        issueCategoryComboBox.getSelectionModel().clearSelection();
        ratingComboBox.getSelectionModel().clearSelection();
        commentsArea.clear();
        photoNameLabel.setText("(Optional)");
    }
}