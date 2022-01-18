public class ConcurrencyMain {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Main thread");

        Thread anotherThread =  new AnotherThread();
        anotherThread.start();

        new Thread(() -> System.out.println(ThreadColor.ANSI_GREEN + "From anonymous thread")).start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                try{
                    anotherThread.join();
                    System.out.println("AnotherThread terminated so I'm running it again");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_CYAN + "I couldnt wait");
                }
                System.out.println(ThreadColor.ANSI_RED + "Hello from anonymous class's implementation myRunnable");
            }
        });
        myRunnableThread.start();
        //anotherThread.interrupt();

        System.out.println(ThreadColor.ANSI_PURPLE + "Main thread again");

    }
}
