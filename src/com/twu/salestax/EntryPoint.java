package com.twu.salestax;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EntryPoint {
    public static void main(String[] args) {
        Set<String> itemsExcludedFromBasicTax = new LinkedHashSet<>();
        populateExcludedItemsList(itemsExcludedFromBasicTax);
        TaxComputer taxComputer = new TaxComputer(itemsExcludedFromBasicTax);
        Parser parser = new Parser(taxComputer);
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt(new ArrayList<Item>());
        App app = new App(parser, scanner, receipt);
        app.start();
    }

    private static void populateExcludedItemsList(Set<String> itemsExcludedFromBasicTax) {
        itemsExcludedFromBasicTax.add("chocolates");
        itemsExcludedFromBasicTax.add("chocolate");
        itemsExcludedFromBasicTax.add("book");
        itemsExcludedFromBasicTax.add("books");
        itemsExcludedFromBasicTax.add("pill");
        itemsExcludedFromBasicTax.add("pills");
    }
}
