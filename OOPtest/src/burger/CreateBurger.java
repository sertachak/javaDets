package burger;

public class CreateBurger {

    public static void main(String[] args) {
        Burger burger = new Burger("BigMac", "120gr", 34.65, "White");
        burger.addAdditions("Salad", 22.11);
        System.out.println(burger.buildSelectedBurger());

        DeluxeBurger db = new DeluxeBurger();

    }
}
