package oop.section6.national_park_management.conservation;

import java.time.LocalDate;

public class Trends{
    private String species1;
    private String species2;
    private int startYear;
    private int endYear;
    private String comparisonResults;
    private LocalDate comparisonDate;
    private int comparisonId;
    private String analystName;

    public Trends() {
        this.comparisonDate = LocalDate.now();
    }

    public Trends(String species1, String species2, int startYear, int endYear, String analystName) {
        this.species1 = species1;
        this.species2 = species2;
        this.startYear = startYear;
        this.endYear = endYear;
        this.analystName = analystName;
        this.comparisonDate = LocalDate.now();
    }

    public String getSpecies1() {
        return species1;
    }

    public void setSpecies1(String species1) {
        this.species1 = species1;
    }

    public String getSpecies2() {
        return species2;
    }

    public void setSpecies2(String species2) {
        this.species2 = species2;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getComparisonResults() {
        return comparisonResults;
    }

    public void setComparisonResults(String comparisonResults) {
        this.comparisonResults = comparisonResults;
    }

    public LocalDate getComparisonDate() {
        return comparisonDate;
    }

    public void setComparisonDate(LocalDate comparisonDate) {
        this.comparisonDate = comparisonDate;
    }

    public int getComparisonId() {
        return comparisonId;
    }

    public void setComparisonId(int comparisonId) {
        this.comparisonId = comparisonId;
    }

    public String getAnalystName() {
        return analystName;
    }

    public void setAnalystName(String analystName) {
        this.analystName = analystName;
    }

    public void generateComparisonId() {
        this.comparisonId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Comparison ID: " + comparisonId + "\n" +
                "Species 1: " + species1 + "\n" +
                "Species 2: " + species2 + "\n" +
                "Year Range: " + startYear + " - " + endYear + "\n" +
                "Analyst: " + analystName + "\n" +
                "Comparison Date: " + comparisonDate + "\n" +
                "Results:\n" + comparisonResults;
    }

    // Method to validate year range
    public boolean validateYearRange() {
        return startYear <= endYear && startYear > 0;
    }
}
