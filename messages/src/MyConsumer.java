import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock){
        this.bufferLock = bufferLock;
        this.color = color;
        this.buffer = buffer;
    }

    @Override
    public void run(){
            while(true){
                bufferLock.lock();
                if(buffer.isEmpty()){
                    bufferLock.unlock();
                    continue;
                }
                if(buffer.get(0).equals("EOF")){
                    System.out.println(color + "Exiting");
                    bufferLock.unlock();
                    break;
                } else {
                    System.out.println(color + "Removed" + buffer.remove(0));
                }
                bufferLock.unlock();
            }
    }
}
