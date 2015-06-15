package com.twu.salestax;

public class Parser {

    private TaxComputer taxComputer;

    public Parser(TaxComputer taxComputer) {
        this.taxComputer = taxComputer;
    }

    public Item parse(String itemDescription) {
        String[] array = itemDescription.split(" ");
        int quantity = Integer.parseInt(array[0]);
        double cost = Double.parseDouble(array[array.length - 1]);
        StringBuffer description = new StringBuffer();
        for (int x = 1; x < array.length - 2; x++) {
            description.append(array[x]);
            description.append(" ");
        }
        return new Item(description.toString().trim(), cost, quantity, taxComputer);
    }
}
