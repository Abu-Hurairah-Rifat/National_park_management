package oop.section6.national_park_management.Tourist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FindAndRateGuideController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> completedToursComboBox;

    @FXML
    private TextArea guideDetailsArea;

    @FXML
    private Label guideNameLabel;

    @FXML
    private ListView<Guide> guidesListView;

    @FXML
    private ComboBox<String> ratingComboBox;

    @FXML
    private TextArea reviewCommentsArea;

    @FXML
    private Label reviewStatusLabel;

    @FXML
    private TextField searchGuideField;

    @FXML
    private Button submitReviewButton;

    private ObservableList<Guide> allGuides;

    private record Guide(String name, String specialties, String bio) {}

    @FXML
    void initialize() {
        setupGuideFinder();
        setupGuideRater();

        submitReviewButton.setOnAction(event -> handleSubmitReview());
    }

    private void setupGuideFinder() {
        allGuides = FXCollections.observableArrayList(
                new Guide("John Doe", "Bird Watching, Trekking", "An expert in local avian species with over 10 years of experience."),
                new Guide("Jane Smith", "Botany, Photography", "Specializes in rare orchids and landscape photography."),
                new Guide("Ali Khan", "Wildlife Tracking, Survival", "A seasoned tracker skilled in identifying animal trails and habitats.")
        );

        FilteredList<Guide> filteredGuides = new FilteredList<>(allGuides, p -> true);
        guidesListView.setItems(filteredGuides);

        guidesListView.setCellFactory(param -> new ListCell<Guide>() {
            @Override
            protected void updateItem(Guide item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.name() == null) {
                    setText(null);
                } else {
                    setText(item.name());
                }
            }
        });

        guidesListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                updateGuideDetails(newVal);
            }
        });

        searchGuideField.textProperty().addListener((obs, oldVal, newVal) -> {
            filteredGuides.setPredicate(guide -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newVal.toLowerCase();
                return guide.name().toLowerCase().contains(lowerCaseFilter);
            });
        });
    }

    private void setupGuideRater() {
        completedToursComboBox.setItems(FXCollections.observableArrayList(
                "Tour with John Doe - 2025-08-05",
                "Tour with Jane Smith - 2025-07-21"
        ));

        ratingComboBox.setItems(FXCollections.observableArrayList(
                "5 Stars - Excellent",
                "4 Stars - Good",
                "3 Stars - Average",
                "2 Stars - Poor",
                "1 Star - Terrible"
        ));
    }

    private void updateGuideDetails(Guide guide) {
        guideNameLabel.setText(guide.name() + " (" + guide.specialties() + ")");
        guideDetailsArea.setText(guide.bio());
    }

    private void handleSubmitReview() {
        String tour = completedToursComboBox.getSelectionModel().getSelectedItem();
        String rating = ratingComboBox.getSelectionModel().getSelectedItem();
        String comment = reviewCommentsArea.getText();

        if (tour == null || rating == null) {
            reviewStatusLabel.setText("Please select a tour and a rating.");
            return;
        }

        System.out.println("Review Submitted:");
        System.out.println("Tour: " + tour);
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + comment);

        reviewStatusLabel.setText("Thank you for your review!");

        completedToursComboBox.getSelectionModel().clearSelection();
        ratingComboBox.getSelectionModel().clearSelection();
        reviewCommentsArea.clear();
    }
}