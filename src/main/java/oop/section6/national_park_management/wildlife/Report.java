package oop.section6.national_park_management.wildlife;

import java.io.Serializable;
import java.time.LocalDate;

public class Report {
    private String title;
    private String content;
    private LocalDate submissionDate;
    private String researcherName;
    private int reportId;


    public Report() {
        this.submissionDate = LocalDate.now();
    }

    public Report(String title, String content, String researcherName) {
        this.title = title;
        this.content = content;
        this.researcherName = researcherName;
        this.submissionDate = LocalDate.now();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getResearcherName() {
        return researcherName;
    }

    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public void generateReportId() {
        this.reportId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Report ID: " + reportId + "\n" +
                "Title: " + title + "\n" +
                "Researcher: " + researcherName + "\n" +
                "Submission Date: " + submissionDate + "\n" +
                "Content: " + content;
    }
}
