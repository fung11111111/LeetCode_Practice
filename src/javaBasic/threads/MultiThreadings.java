package javaBasic.threads;

public class MultiThreadings{

    class MultiThreadingThing extends  Thread{

        private int thredNum;

        public MultiThreadingThing(int thredNum) {
            this.thredNum = thredNum;
        }

        @Override
        public void run(){
            for(int i =1; i < 5; i++){
                System.out.println(i + " from thread: " + thredNum);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MultiThreadingThing2 implements Runnable{
        private int thredNum;

        public MultiThreadingThing2(int thredNum) {
            this.thredNum = thredNum;
        }

        @Override
        public void run() {
            for(int i =1; i < 5; i++){
                System.out.println(i + " from thread: " + thredNum);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void client(){
        // start -> for multithreading
        // run -> single thread

        for(int i =0;i<=3;i++){
            MultiThreadingThing2 m = new MultiThreadingThing2(i);
           Thread thread = new Thread(m);
           thread.start();
        }
    }
}
