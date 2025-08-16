package oop.section6.national_park_management.Permit_Officer;

import javafx.fxml.FXML;

import java.io.Serializable;
import java.time.LocalDate;

public class IssuePermit implements Serializable {
    private String name, email, permitType;
    private int id,phone,noOfVisitor,price;
    private LocalDate visitDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

    public IssuePermit(int id, int price) {
        this.id = id;
        this.price = price;
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
        return  "Name: " + name + '\n' +
                "Email: " + email + '\n' +
                "Permit Type: " + permitType + '\n' +
                "ID: " + id + '\n' +
                "Phone: " + phone + '\n' +
                "No Of Visitor: " + noOfVisitor + '\n' +
                "Price: " + price + '\n' +
                "Visit Date: " + visitDate;
    }

    public void CalculateTotal(){

    }

    public void generateId(){
        int i = 1;
        for (i=0; ; i++);


    }
}
