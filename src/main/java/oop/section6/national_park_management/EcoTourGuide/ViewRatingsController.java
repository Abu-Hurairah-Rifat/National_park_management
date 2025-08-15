package oop.section6.national_park_management.EcoTourGuide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ViewRatingsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label averageRatingLabel;
    @FXML
    private ComboBox<String> filterRatingComboBox;
    @FXML
    private ListView<Review> reviewsListView;

    private ObservableList<Review> allReviews;

    private record Review(int stars, String comment) {}

    @FXML
    void initialize() {
        loadSampleData();
        setupListView();
        setupFilterComboBox();
        calculateAverageRating();
    }

    private void loadSampleData() {
        allReviews = FXCollections.observableArrayList(
                new Review(5, "An absolutely fantastic and knowledgeable guide! Highly recommend."),
                new Review(5, "Made the trip unforgettable. Showed us so many hidden gems."),
                new Review(4, "Very good tour, professional and friendly."),
                new Review(5, "Perfect experience, 10/10."),
                new Review(3, "The tour was okay, but a bit rushed."),
                new Review(4, "Knowledgeable guide, we saw a lot of wildlife.")
        );
    }

    private void setupListView() {
        FilteredList<Review> filteredData = new FilteredList<>(allReviews, p -> true);
        reviewsListView.setItems(filteredData);

        reviewsListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Review item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText("Rating: " + item.stars() + "/5\n\"" + item.comment() + "\"");
                    setStyle("-fx-padding: 10px;");
                }
            }
        });

        filterRatingComboBox.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    filteredData.setPredicate(review -> {
                        if (newVal == null || "All Ratings".equals(newVal)) {
                            return true;
                        }
                        return newVal.startsWith(String.valueOf(review.stars()));
                    });
                }
        );
    }

    private void setupFilterComboBox() {
        filterRatingComboBox.setItems(FXCollections.observableArrayList(
                "All Ratings", "5 Stars", "4 Stars", "3 Stars", "2 Stars", "1 Star"
        ));
    }

    private void calculateAverageRating() {
        if (allReviews.isEmpty()) {
            averageRatingLabel.setText("N/A");
            return;
        }

        double average = allReviews.stream()
                .mapToInt(Review::stars)
                .average()
                .orElse(0.0);

        averageRatingLabel.setText(String.format("%.2f / 5.00", average));
    }
}