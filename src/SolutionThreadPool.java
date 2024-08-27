import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SolutionThreadPool {
    private static final int NUMBER_OF_TASKS = 10_000;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        startTasks();
        System.out.printf("Time to complete task:%dms \n", System.currentTimeMillis() - startTime);
    }

    private static void startTasks() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(1000)) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(()->{
                    for (int j = 0; j < 100; j++) {
                        slowIOOperation();
                    }
                });
            }
        }
    }

    private static void slowIOOperation() {
        System.out.println("Executing slow operation: " + Thread.currentThread());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
