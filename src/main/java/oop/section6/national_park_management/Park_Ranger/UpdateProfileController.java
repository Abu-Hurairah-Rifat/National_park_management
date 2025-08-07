package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class UpdateProfileController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextArea availabilityArea;
    @FXML private Button updateProfileBtn;

    @FXML
    private void handleUpdate(ActionEvent event) {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String availability = availabilityArea.getText();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || availability.isEmpty()) {
            System.out.println("Please fill in all profile fields.");
        } else {
            System.out.println("Profile Updated:\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nAvailability: " + availability);
        }
    }
}
