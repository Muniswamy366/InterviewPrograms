package org.arya.advance.printEvenOdd;

class EvenPrinter implements Runnable {
    private final PrintNumber printer;
    private final int maxValue;

    public EvenPrinter(PrintNumber printer, int maxValue) {
        this.printer = printer;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for (int i = 2; i <= maxValue; i += 2) {
            printer.printEven(i);
        }
    }
}