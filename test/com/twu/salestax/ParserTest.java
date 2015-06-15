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
}
