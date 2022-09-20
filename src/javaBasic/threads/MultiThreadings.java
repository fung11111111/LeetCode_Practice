package javaBasic.threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadings {

    class MultiThreadingThing extends Thread {

        private int thredNum;

        public MultiThreadingThing(int thredNum) {
            this.thredNum = thredNum;
        }

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                System.out.println(i + " from thread: " + thredNum);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MultiThreadingThing2 implements Runnable {
        private int thredNum;


        public MultiThreadingThing2(int thredNum) {
            this.thredNum = thredNum;
        }

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                System.out.println(i + " from thread: " + thredNum);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void client() throws InterruptedException {
        // start -> for multithreading
        // run -> single thread

//        for(int i =0;i<=3;i++){
//            MultiThreadingThing2 m = new MultiThreadingThing2(i);
//           Thread thread = new Thread(m);
//           thread.start();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<String> callable = () -> {
            System.out.println("Thread - " + Thread.currentThread().getName());
            Thread.sleep(1000);
            return "Thread is running";
        };

        System.out.println("Running main");
        List<Callable<String>> tasks = List.of(callable, callable, callable);
        executorService.invokeAll(tasks);


        executorService.shutdown();

        System.out.println("Back to main");

    }
}
