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
        return totalCostWithoutTaxes + salesTaxApplicable();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.originalCost, originalCost) != 0) return false;
        if (quantity != item.quantity) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        return !(taxComputer != null ? !taxComputer.equals(item.taxComputer) : item.taxComputer != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = description != null ? description.hashCode() : 0;
        temp = Double.doubleToLongBits(originalCost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        result = 31 * result + (taxComputer != null ? taxComputer.hashCode() : 0);
        return result;
    }
}
