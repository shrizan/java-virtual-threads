import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        // creating a thread using lambda function
        Runnable blockingTask = () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        List<Thread> threads = new ArrayList<>();

        // creating 100_000 threads and saving it to list
        for (int i = 0; i < 100_000; i++) {
            threads.add(new Thread(blockingTask));
        }

        // starting each thread
        for (Thread thread : threads) {
            thread.start();
        }

        System.out.println("Main thread completed");

    }
}