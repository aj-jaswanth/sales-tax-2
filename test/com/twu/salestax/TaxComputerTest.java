package com.twu.salestax;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TaxComputerTest {

    private TaxComputer taxComputer;

    @Before
    public void setUp() {
        Set<String> itemsExcludedFromBasicTax = new LinkedHashSet<>();
        itemsExcludedFromBasicTax.add("chocolates");
        taxComputer = new TaxComputer(itemsExcludedFromBasicTax);
    }

    @Test
    public void shouldAddOnlyBasicSalesTaxForNonImportedAndNonTaxExcludedItems() {
        double actualTaxFraction = taxComputer.compute("bottle of perfume");

        assertThat(actualTaxFraction, is(equalTo(0.1)));
    }

    @Test
    public void shouldAddBothBasicSalesTaxAndImportedTaxForImportedAndNonTaxExcludedItems() {
        double actualTaxFraction = taxComputer.compute("imported bottle of perfume");

        assertEquals(0.15, actualTaxFraction, 0.001);
    }

    @Test
    public void shouldAddOnlyImportedTaxOnImportedAndTaxExcludedItems() {
        double actualTaxFraction = taxComputer.compute("imported box of chocolates");

        assertEquals(0.05, actualTaxFraction, 0.001);
    }

    @Test
    public void shouldAddNoTaxOnNonImportedAndTaxExcludedItems() {
        double actualTaxFraction = taxComputer.compute("box of chocolates");

        assertEquals(0.0, actualTaxFraction, 0.001);
    }
}
