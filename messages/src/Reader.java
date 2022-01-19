import java.util.Random;

public class Reader implements Runnable{
    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        Random random = new Random();
        for(String lastMessage = message.read(); !lastMessage.equals("Finished");){
            lastMessage = message.read();
            System.out.println(lastMessage);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e ){

            }
        }
    }
}
