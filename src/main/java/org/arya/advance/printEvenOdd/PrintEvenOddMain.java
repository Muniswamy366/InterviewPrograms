package org.arya.advance.printEvenOdd;

public class PrintEvenOddMain {
    public static void main(String[] args) {
        PrintNumber printer = new PrintNumber();
        int maxValue = 20;

        Thread oddThread = new Thread(new OddPrinter(printer, maxValue), "OddThread");
        Thread evenThread = new Thread(new EvenPrinter(printer, maxValue), "EvenThread");

        oddThread.start();
        evenThread.start();
    }
}