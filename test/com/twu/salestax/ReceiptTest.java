package com.twu.salestax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    @Test
    public void shouldPrintCorrectRepresentationOfItems() {
        Set<String> itemsExcludedFromBasicTax = new LinkedHashSet<>();
        itemsExcludedFromBasicTax.add("chocolates");
        TaxComputer taxComputer = new TaxComputer(itemsExcludedFromBasicTax);
        Receipt receipt = new Receipt(new ArrayList<Item>());
        Item item = new Item("imported bottle of perfume", 47.50, 1, taxComputer);
        Item secondItem = new Item("imported box of chocolates", 10.0, 1, taxComputer);
        receipt.add(item);
        receipt.add(secondItem);

        String actualOutput = receipt.toString();

        assertEquals("imported bottle of perfume: 54.62\n" +
                "imported box of chocolates: 10.5\n" +
                "Sales Tax: 7.62\n" +
                "Total: 65.12", actualOutput);
    }
}
