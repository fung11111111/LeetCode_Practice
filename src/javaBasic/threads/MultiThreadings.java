package javaBasic.threads;

public class MultiThreadings extends Thread{

    @Override
    public void run(){
        for(int i =1; i < 5; i++){
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void testFunc(){
        // start -> for multithreading
        // run -> single thread
    }
}
