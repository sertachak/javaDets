public class Main {

    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
        GearBox.Gear first = mcLaren.new Gear(1, 12.3); // without outer class object cannot create a inner class object error= is not an enclosing class
        System.out.println(first.drivateSpeed(1000));
    }
}
