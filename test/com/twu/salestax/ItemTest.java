package com.twu.salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void shouldReturnAMeaningfulRepresentationOfItself() {
        Item item = new Item("imported bottle of perfume", 18.99, 1);

        String actualOutput = item.toString();

        assertEquals("1 imported bottle of perfume: 18.99", actualOutput);
    }
}
