package threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new CDLTask(latch, "A"));
        service.execute(new CDLTask(latch, "B"));
        service.execute(new CDLTask(latch, "C"));

        latch.await();

        System.out.println("Main thread:  --> Finished!!");
//        service.shutdown();

    }
}

class CDLTask implements Runnable {

    private CountDownLatch latch;
    private String taskName;
    CDLTask(CountDownLatch latch, String taskName) {
        this.latch = latch;
        this.taskName = taskName;
    }
    @Override
    public void run() {
        latch.countDown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execute task: "+taskName);
    }
}
