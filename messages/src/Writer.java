import java.util.Random;

public class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        String[] messages = {
                "Coko treat",
                "Efo treat",
                "The cat gang",
                "Cannot be passed without any shred"
        };

        Random random = new Random();

        for (String s : messages) {
            message.write(s);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }

        message.write("Finished");
    }
}
