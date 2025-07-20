package org.arya.advance.printAlphaNumeric;

class SharedPrinter {

    private boolean isNumber = true;
    private final Object lock = new Object();

    public void printAlphabet(int alphabet) {
        synchronized (lock) {
            while (isNumber) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Alphabet : " + (char)alphabet);
            isNumber = true;
            lock.notifyAll();
        }
    }

    public void printNumber(int number) {
        synchronized (lock) {
            while (!isNumber) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Number   : " + number);
            isNumber = false;
            lock.notifyAll();
        }
    }
}