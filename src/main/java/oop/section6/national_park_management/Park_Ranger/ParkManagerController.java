package oop.section6.national_park_management.Park_Ranger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ParkManagerController {

    @FXML private Button logoutButton;
    @FXML private Button approveScheduleBtn;
    @FXML private Button monitorVisitorsBtn;
    @FXML private Button reviewIncidentsBtn;
    @FXML private Button assignPatrolZonesBtn;
    @FXML private Button manageCensusBtn;
    @FXML private Button scheduleMaintenanceBtn;
    @FXML private Button setFeeBtn;
    @FXML private Button exportFinanceBtn;
    @FXML
    private GridPane buttonGrid;

    @FXML
    public void initialize() {
        approveScheduleBtn.setOnAction(e -> System.out.println("Open Approve Schedules view"));
        monitorVisitorsBtn.setOnAction(e -> System.out.println("Open Monitor Visitors view"));
        reviewIncidentsBtn.setOnAction(e -> System.out.println("Open Review Incident Reports view"));
        assignPatrolZonesBtn.setOnAction(e -> System.out.println("Open Assign Patrol Zones view"));
        manageCensusBtn.setOnAction(e -> System.out.println("Open Manage Wildlife Census view"));
        scheduleMaintenanceBtn.setOnAction(e -> System.out.println("Open Schedule Maintenance view"));
        setFeeBtn.setOnAction(e -> System.out.println("Open Set Entry Fee Rates view"));
        exportFinanceBtn.setOnAction(e -> System.out.println("Open Export Financial Reports view"));
    }
}
