package oop.section6.national_park_management.Permit_Officer;

import java.time.LocalDate;

public class IssuePermit  {
    private String name, email, permitType;
    private int phone,noOfVisitor;
    private LocalDate visitDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public int getNoOfVisitor() {
        return noOfVisitor;
    }

    public void setNoOfVisitor(int noOfVisitor) {
        this.noOfVisitor = noOfVisitor;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public IssuePermit(String name, String email, int phone, String permitType, int noOfVisitor, LocalDate visitDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.permitType = permitType;
        this.noOfVisitor = noOfVisitor;
        this.visitDate = visitDate;
    }

    public IssuePermit() {

    }

    @Override
    public String toString() {
        return "IssuePermit{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", paymentType='" + permitType + '\'' +
                ", noOfVisitor=" + noOfVisitor +
                ", visitDate=" + visitDate +
                '}';
    }

    public void CalculateTotal(){

    }
}
