public class CountdownMain {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(countdown);
        t1.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
