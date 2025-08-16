package oop.section6.national_park_management.Maintenance_Staff;

import java.io.Serializable;

public class Equipment implements Serializable {
    private int id, quantity;
    private String itemName, urgencyLevel;

    public Equipment(int id, int quantity, String itemName, String urgencyLevel) {
        this.id = id;
        this.quantity = quantity;
        this.itemName = itemName;
        this.urgencyLevel = urgencyLevel;
    }

    public Equipment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", itemName='" + itemName + '\'' +
                ", urgencyLevel='" + urgencyLevel + '\'' +
                '}';
    }
}
