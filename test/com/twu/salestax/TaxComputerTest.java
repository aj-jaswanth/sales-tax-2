package com.twu.salestax;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
    public void shouldAddOnlyBasicSalesTaxForNonImportedItems() {
        double actualTaxFraction = taxComputer.compute("bottle of perfume");

        assertThat(actualTaxFraction, is(equalTo(0.1)));
    }
}
