import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MessageMain {
    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();


        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, ThreadColors.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColors.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColors.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}
