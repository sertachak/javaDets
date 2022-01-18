public class Countdown {
    public void doCountdown(){
        String color = switch (Thread.currentThread().getName()) {
            case "Thread 1" -> ThreadColor.ANSI_CYAN;
            case "Thread 2" -> ThreadColor.ANSI_PURPLE;
            default -> ThreadColor.ANSI_GREEN;
        };

        for(int i = 10; i > 0; i--){
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
        }
    }
}

class CountdownThread extends  Thread {
    private Countdown countdown;

    public CountdownThread(Countdown countdown){
        this.countdown = countdown;
    }

    @Override
    public void run(){
        countdown.doCountdown();
    }

}
