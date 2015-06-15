package com.twu.salestax;

public class Item {

    private String description;
    private double originalCost;
    private int quantity;
    private TaxComputer taxComputer;

    public Item(String description, double originalCost, int quantity, TaxComputer taxComputer) {
        this.description = description;
        this.originalCost = originalCost;
        this.quantity = quantity;
        this.taxComputer = taxComputer;
    }

    @Override
    public String toString() {
        return quantity + " " + description + ": " + originalCost;
    }

    public double totalCostAfterTaxes() {
        double totalCostWithoutTaxes = originalCost * quantity;
        double applicableTaxFraction = taxComputer.compute(description);
        double totalCost = totalCostWithoutTaxes * (1 + applicableTaxFraction);
        return round(totalCost);
    }

    private double round(double totalCost) {
        int temp = ((int) (totalCost * 1000)) % 10;
        totalCost = ((int) (totalCost * 100)) / 100.0;
        if (temp > 5)
            totalCost += 0.01;
        return totalCost;
    }

    public double salesTaxApplicable() {
        double totalCostWithoutTaxes = originalCost * quantity;
        double applicableTaxFraction = taxComputer.compute(description);
        double totalSalesTaxApplicable = totalCostWithoutTaxes * (applicableTaxFraction);
        return round(totalSalesTaxApplicable);
    }
}
