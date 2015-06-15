package com.twu.salestax;

public class Item {

    private String description;
    private double originalCost;
    private int quantity;

    public Item(String description, double originalCost, int quantity) {
        this.description = description;
        this.originalCost = originalCost;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + description + ": " + originalCost;
    }
}
