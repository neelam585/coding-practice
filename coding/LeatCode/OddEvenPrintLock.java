package LeatCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrintLock {
    private final Object lock = new Object();
    private boolean oddTurn = true;

    public void printOdd() {
        for (int i = 1; i <= 19; i += 2) {
            synchronized (lock) {
                while (!oddTurn) {
                    try { lock.wait(); } catch (InterruptedException e) {}
                }
                System.out.println("Odd " + i);
                oddTurn = false;
                lock.notify();
            }
        }
    }

    public void printEven() {
        for (int i = 2; i <= 20; i += 2) {
            synchronized (lock) {

                while (oddTurn) {
                    try { lock.wait(); } catch (InterruptedException e) {}
                }
                System.out.println("Even " + i);
                oddTurn = true;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrintLock o = new OddEvenPrintLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(o::printOdd);
        executor.submit(o::printEven);

        executor.shutdown();
    }
}
