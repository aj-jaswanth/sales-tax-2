package com.twu.salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void shouldParseTheItemDescriptionCorrectly() {
        Parser parser = new Parser(null);

        Item actualItem = parser.parse("1 imported bottle of perfume at 27.99");
        Item expectedItem = new Item("imported bottle of perfume", 27.99, 1, null);

        assertEquals(expectedItem, actualItem);
    }

    @Test
    public void shouldParseTheNonImportedItemDescriptionCorrectly() {
        Parser parser = new Parser(null);

        Item actualItem = parser.parse("1 chocolate bar at 0.85");
        Item expectedItem = new Item("chocolate bar", 0.85, 1, null);

        assertEquals(expectedItem, actualItem);
    }
}
