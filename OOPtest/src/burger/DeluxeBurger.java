package burger;

public class DeluxeBurger extends Burger{

    public DeluxeBurger() {
        super("Deluxe", "Bacon & Sausage", 14.54, "White");
        super.addAdditions("Chips", 2.75);
        super.addAdditions("Drink", 1.81);
    }

    @Override
    public void addAdditions(String addition, double additionPrice) {
        System.out.println("Unable to add additional items to this menu");
    }
}
