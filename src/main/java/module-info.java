module oop.section6.national_park_management {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.section6.national_park_management to javafx.fxml;
    exports oop.section6.national_park_management;
}