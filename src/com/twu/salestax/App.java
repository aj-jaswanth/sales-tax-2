package com.twu.salestax;

import java.util.Scanner;

public class App {
    private Parser parser;
    private Scanner input;
    private Receipt receipt;

    public App(Parser parser, Scanner input, Receipt receipt) {
        this.parser = parser;
        this.input = input;
        this.receipt = receipt;
    }

    public void start() {
        String str;
        while (true) {
            str = input.nextLine();
            if (str.equals("exit"))
                break;
            receipt.add(parser.parse(str));
        }
        System.out.println(receipt);
    }
}
