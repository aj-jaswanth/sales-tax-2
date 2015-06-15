package com.twu.salestax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private ByteArrayInputStream inputContent;
    private ByteArrayOutputStream outputContent;

    @Before
    public void setUp() {
        inputContent = new ByteArrayInputStream(("1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85\nexit").getBytes());
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldReturnCorrectRepresentationForGivenItems() {
        Set<String> itemsExcludedFromBasicTax = new LinkedHashSet<>();
        itemsExcludedFromBasicTax.add("book");
        itemsExcludedFromBasicTax.add("chocolate");
        TaxComputer taxComputer = new TaxComputer(itemsExcludedFromBasicTax);
        Parser parser = new Parser(taxComputer);
        Scanner scanner = new Scanner(inputContent);
        Receipt receipt = new Receipt(new ArrayList<Item>());
        App app = new App(parser, scanner, receipt);

        app.start();
        String actualResult = outputContent.toString();

        assertEquals("book: 12.49\n" +
                "music CD: 16.49\n" +
                "chocolate bar: 0.85\n" +
                "Sales Tax: 1.5\n" +
                "Total: 29.83\n", actualResult);
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
