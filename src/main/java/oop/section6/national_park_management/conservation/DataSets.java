package oop.section6.national_park_management.conservation;

import java.time.LocalDate;

public class DataSets{
    private String datasetName;
    private String exportFormat;
    private String parameters;
    private LocalDate exportDate;
    private int exportId;
    private String analystName;

    public DataSets() {
        this.exportDate = LocalDate.now();
    }

    public DataSets(String datasetName, String exportFormat, String parameters, String analystName) {
        this.datasetName = datasetName;
        this.exportFormat = exportFormat;
        this.parameters = parameters;
        this.analystName = analystName;
        this.exportDate = LocalDate.now();
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getExportFormat() {
        return exportFormat;
    }

    public void setExportFormat(String exportFormat) {
        this.exportFormat = exportFormat;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public LocalDate getExportDate() {
        return exportDate;
    }

    public void setExportDate(LocalDate exportDate) {
        this.exportDate = exportDate;
    }

    public int getExportId() {
        return exportId;
    }

    public void setExportId(int exportId) {
        this.exportId = exportId;
    }

    public String getAnalystName() {
        return analystName;
    }

    public void setAnalystName(String analystName) {
        this.analystName = analystName;
    }

    public void generateExportId() {
        this.exportId = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Export ID: " + exportId + "\n" +
                "Dataset: " + datasetName + "\n" +
                "Format: " + exportFormat + "\n" +
                "Analyst: " + analystName + "\n" +
                "Export Date: " + exportDate + "\n" +
                "Parameters: " + parameters;
    }

    public void prepareExport() {
    }
}