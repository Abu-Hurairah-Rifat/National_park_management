package oop.section6.national_park_management.Maintenance_Staff;

import java.io.Serializable;

public class MaintenanceIssue implements Serializable {
    private int issueID;
    private String issueType, location, details, priorityLevel;


    public MaintenanceIssue(int issueID, String issueType, String location, String details, String priorityLevel) {
        this.issueID = issueID;
        this.issueType = issueType;
        this.location = location;
        this.details = details;
        this.priorityLevel = priorityLevel;
    }

    public MaintenanceIssue() {

    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        return "MaintenanceIssue{" +
                "issueID=" + issueID +
                ", issueType='" + issueType + '\'' +
                ", location='" + location + '\'' +
                ", details='" + details + '\'' +
                ", priorityLevel='" + priorityLevel + '\'' +
                '}';
    }
}
