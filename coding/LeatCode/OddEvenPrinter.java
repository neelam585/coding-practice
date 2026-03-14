package LeatCode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenPrinter {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Print even numbers
        executor.submit(() -> {
            for (int i = 2; i <= 20; i += 2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(100); // just to slow down output
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); //// preserve interrupt status
                }
            }
        });

        // Print odd numbers
        executor.submit(() -> {
            for (int i = 1; i <= 19; i += 2) {
                System.out.println("Odd: " + i);
                try {
                    Thread.sleep(100); // just to slow down output
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.shutdown();
    }
}
