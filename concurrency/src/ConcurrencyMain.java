public class ConcurrencyMain {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Main thread");

        Thread anotherThread =  new AnotherThread();
        anotherThread.start();

        new Thread(() -> System.out.println(ThreadColor.ANSI_GREEN + "From anonymous thread")).start();

        System.out.println(ThreadColor.ANSI_PURPLE + "Main thread again");

    }
}
