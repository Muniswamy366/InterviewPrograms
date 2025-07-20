package org.arya.advance.printAlphaNumeric;

class NumberPrinter implements Runnable {
    private final SharedPrinter printer;

    public NumberPrinter(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 26; i++) {
            printer.printNumber(i);
        }
    }
}