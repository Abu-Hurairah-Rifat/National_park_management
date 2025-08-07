module oop.section6.national_park_management {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.section6.national_park_management to javafx.fxml;
    exports oop.section6.national_park_management;
    exports oop.section6.national_park_management.Permit_Officer;
    opens oop.section6.national_park_management.Permit_Officer to javafx.fxml;
    exports oop.section6.national_park_management.Maintenance_Staff;
    opens oop.section6.national_park_management.Maintenance_Staff to javafx.fxml;
}