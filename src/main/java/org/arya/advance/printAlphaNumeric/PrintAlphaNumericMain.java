package org.arya.advance.printAlphaNumeric;

public class PrintAlphaNumericMain {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        Thread alphabetThread = new Thread(new AlphabetPrinter(printer), "AlphabetThread");
        Thread numberThread = new Thread(new NumberPrinter(printer), "NumberThread");

        numberThread.start();
        alphabetThread.start();
    }
}