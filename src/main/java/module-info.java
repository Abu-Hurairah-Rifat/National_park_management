module oop.section6.national_park_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    // Export at least the root package (optional: also export sub-packages)
    exports oop.section6.national_park_management;

    // OPTIONAL exports if you want to use classes elsewhere
    exports oop.section6.national_park_management.Park_Manager;
    exports oop.section6.national_park_management.Park_Ranger;

    // These opens are CRITICAL so FXML can create controller classes using reflection
    opens oop.section6.national_park_management to javafx.fxml;
    opens oop.section6.national_park_management.Park_Manager to javafx.fxml;
    opens oop.section6.national_park_management.Park_Ranger to javafx.fxml;
    opens oop.section6.national_park_management.Permit_Officer to javafx.fxml;
    opens oop.section6.national_park_management.Maintenance_Staff to javafx.fxml;
    opens oop.section6.national_park_management.Tourist to javafx.fxml;
    opens oop.section6.national_park_management.EcoTourGuide to javafx.fxml;
    exports oop.section6.national_park_management.Permit_Officer;
    exports oop.section6.national_park_management.Maintenance_Staff;

    //opens oop.section6.national_park_management to javafx.fxml;
    //exports oop.section6.national_park_management;
    //exports oop.section6.national_park_management.Permit_Officer;
    //opens oop.section6.national_park_management.Permit_Officer to javafx.fxml;
    //exports oop.section6.national_park_management.Maintenance_Staff;
    //opens oop.section6.national_park_management.Maintenance_Staff to javafx.fxml;
    //opens oop.section6.national_park_management.Tourist to javafx.fxml;
    //opens oop.section6.national_park_management.EcoTourGuide to javafx.fxml;
}