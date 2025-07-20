package org.arya.advance.printAlphaNumeric;

class AlphabetPrinter implements Runnable {
    private final SharedPrinter printer;

    public AlphabetPrinter(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 65; i <= 90; i++) {
            printer.printAlphabet(i);
        }
    }
}