package com.twu.salestax;

import java.util.Set;

public class TaxComputer {

    private Set<String> itemsExcludedFromBasicTax;

    public TaxComputer(Set<String> itemsExcludedFromBasicTax) {
        this.itemsExcludedFromBasicTax = itemsExcludedFromBasicTax;
    }

    public double compute(String itemDescription) {
        double taxFraction = 0.10;
        String[] array = itemDescription.split(" ");
        for (String word : array) {
            if (word.equals("imported"))
                taxFraction += 0.05;
            if (isExcludedFromBasicTax(word)) {
                taxFraction -= 0.10;
                break;
            }
        }
        return taxFraction;
    }

    private boolean isExcludedFromBasicTax(String word) {
        for (String wordInList : itemsExcludedFromBasicTax)
            if (wordInList.equals(word))
                return true;
        return false;
    }
}
