public class Main {

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
    }
}
