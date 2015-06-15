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
        TaxComputer taxComputer = mock(TaxComputer.class);
        when(taxComputer.compute("imported bottle of perfume")).thenReturn(0.15);
        Item item = new Item("imported bottle of perfume", 27.99, 1, taxComputer);

        String actualOutput = item.toString();

        assertEquals("imported bottle of perfume: 32.199999999999996", actualOutput);
    }

    @Test
    public void shouldReturnCostAfterApplyingTaxes() {
        TaxComputer taxComputer = mock(TaxComputer.class);
        Item item = new Item("imported bottle of perfume", 27.99, 1, taxComputer);
        when(taxComputer.compute("imported bottle of perfume")).thenReturn(0.15);

        double actualCost = item.totalCostAfterTaxes();

        assertThat(actualCost, is(equalTo(32.19)));
    }

    @Test
    public void shouldReturnTotalTaxesApplied() {
        TaxComputer taxComputer = mock(TaxComputer.class);
        Item item = new Item("imported bottle of perfume", 27.99, 1, taxComputer);
        when(taxComputer.compute("imported bottle of perfume")).thenReturn(0.15);

        double actualCost = item.salesTaxApplicable();

        assertThat(actualCost, is(equalTo(4.2)));
    }

    @Test
    public void equalityOfItemAndNothing() {
        Item firstItem = new Item("description", 20, 2, null);

        boolean actual = firstItem.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfItemAndOtherObject() {
        Item firstItem = new Item("description", 20, 2, null);

        boolean actual = firstItem.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Item firstItem = new Item("description", 20, 2, null);

        boolean actual = firstItem.equals(firstItem);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Item firstItem = new Item("description", 20, 2, null);
        Item secondItem = new Item("description", 20, 2, null);

        boolean actual = firstItem.equals(secondItem) == secondItem.equals(firstItem);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Item firstItem = new Item("description", 20, 2, null);
        Item secondItem = new Item("description", 20, 2, null);
        Item thirdItem = new Item("description", 20, 2, null);

        boolean actual = firstItem.equals(secondItem) && secondItem.equals(thirdItem) && firstItem.equals(thirdItem);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoItemsAreEqualThenTheirHashCodesMustBeEqual() {
        Item firstItem = new Item("description", 20, 2, null);
        Item secondItem = new Item("description", 20, 2, null);

        boolean actual = firstItem.equals(secondItem) && firstItem.hashCode() == secondItem.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoItemsAreDifferentThenTheirHashCodesMustBeDifferent() {
        Item firstItem = new Item("description", 20, 2, null);
        Item secondItem = new Item("description two", 20, 2, null);

        boolean actual = firstItem.equals(secondItem) && firstItem.hashCode() == secondItem.hashCode();

        assertThat(actual, is(false));
    }
}
