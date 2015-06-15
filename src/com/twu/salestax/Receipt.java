package com.twu.salestax;

import java.util.ArrayList;

public class Receipt {

    private ArrayList<Item> items;

    public Receipt(ArrayList<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        double totalCost = 0;
        double salesTax = 0;
        String receiptPrintOut = "";
        for (Item item : items) {
            receiptPrintOut += item.toString() + "\n";
            salesTax += item.salesTaxApplicable();
            totalCost += item.totalCostAfterTaxes();
        }
        receiptPrintOut += "Sales Tax: " + round(salesTax) + "\n";
        receiptPrintOut += "Total: " + round(totalCost);
        return receiptPrintOut;
    }

    private double round(double totalCost) {
        int temp = ((int) (totalCost * 1000)) % 10;
        totalCost = ((int) (totalCost * 100)) / 100.0;
        if (temp > 5)
            totalCost += 0.01d;
        return totalCost;
    }
}
