import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockMain {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Thread1());
        executorService.execute(new Thread2());

    }
    public static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread1: lock1 is obtained");
                try{
                  Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread1: is waiting for lock2");
                synchronized(lock2){
                    System.out.println("Thread1: lock2 is obtained");
                }
                System.out.println("Thread1: lock2 is released");
            }
            System.out.println("Thread1: lock1 is released");
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread2: lock1 is obtained");
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread2: is waiting for lock2");
                synchronized(lock2){
                    System.out.println("Thread2: lock2 is obtained");
                }
                System.out.println("Thread2: lock2 is released");
            }
            System.out.println("Thread2: lock1 is released");
        }
    }
}

