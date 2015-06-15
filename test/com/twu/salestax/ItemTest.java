package com.twu.salestax;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {
    @Test
    public void shouldReturnAMeaningfulRepresentationOfItself() {
        Item item = new Item("imported bottle of perfume", 27.99, 1, null);

        String actualOutput = item.toString();

        assertEquals("1 imported bottle of perfume: 27.99", actualOutput);
    }

    @Test
    public void shouldReturnCostAfterApplyingTaxes() {
        TaxComputer taxComputer = mock(TaxComputer.class);
        Item item = new Item("imported bottle of perfume", 27.99, 1, taxComputer);
        when(taxComputer.compute("imported bottle of perfume")).thenReturn(0.15);

        double actualCost = item.totalCostAfterTaxes();

        assertThat(actualCost, is(equalTo(32.19)));
    }
}
