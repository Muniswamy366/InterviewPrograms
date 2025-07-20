package org.arya.advance.printEvenOdd;

class PrintNumber {
    private boolean isEven = false;
    private final Object lock = new Object();

    public void printOdd(int number) {
        synchronized (lock) {
            while (isEven) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Odd  : " + number);
            isEven = true;
            lock.notifyAll();
        }
    }

    public void printEven(int number) {
        synchronized (lock) {
            while (!isEven) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Even : " + number);
            isEven = false;
            lock.notifyAll();
        }
    }
}