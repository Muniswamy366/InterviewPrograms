package org.arya.advance.printEvenOdd;

class OddPrinter implements Runnable {
    private final PrintNumber printer;
    private final int maxValue;

    public OddPrinter(PrintNumber printer, int maxValue) {
        this.printer = printer;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxValue; i += 2) {
            printer.printOdd(i);
        }
    }
}