package oop.section6.national_park_management.Maintenance_Staff;

import java.time.LocalDate;

public class WorkLog {
    private int issueId;
    private LocalDate startDate, endDate;
    private String details;

    public WorkLog(int issueId, LocalDate startDate, LocalDate endDate, String details) {
        this.issueId = issueId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.details = details;
    }

    public WorkLog() {
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "WorkLog{" +
                "issueId=" + issueId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", details='" + details + '\'' +
                '}';
    }
}
