import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
        /*Inner classes generally defined as private
        GearBox.Gear first = mcLaren.new Gear(1, 12.3); // without outer class object cannot create a inner class object error= is not an enclosing class
        System.out.println(first.drivateSpeed(1000));
        */
        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.6);
        mcLaren.addGear(3, 15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(1000));

/*        class ClickListener implements Button.OnClickListener { // example of innerClass

            public ClickListener() {
                System.out.println("Listener has been attached");
            }

            @Override
            public void onClick(String title){
                System.out.println(title + " was clicked");
            }
        }*/

        btnPrint.setOnClickListener(new Button.OnClickListener() {  //example of anonymous class
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
    }


    public static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> {quit = true;
                            System.out.println("Quit is selected");}
                case 1 -> btnPrint.onClick();
            }
        }
    }
}
