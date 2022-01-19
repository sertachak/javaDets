public class Message {
    private String message;
    private volatile boolean empty;

    public synchronized String read(){
        while (empty) {
            Thread.onSpinWait();

        }
        empty = true;
        return message;
    }

    public synchronized void write(String message){
        while (!empty) {
            Thread.onSpinWait();

        }
        empty = false;
        this.message = message;
    }
}
