package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        System.out.println("ExecutorService demo!!");

        ExecutorService service = Executors.newFixedThreadPool(5);

        for(int i=0; i<15; i++) {
            service.execute(new Task(i));
        }

        System.out.println("Closing ExecutorService!!");
        service.shutdown();
    }
}

class Task implements Runnable {

    int taskNumber;

    Task(int i) {
        taskNumber = i;
    }
    @Override
    public void run() {
        System.out.println("Task#: "+ taskNumber+" and Thread name: "+Thread.currentThread().getName());
    }
}