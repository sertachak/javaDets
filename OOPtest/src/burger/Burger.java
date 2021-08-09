package burger;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class Burger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;
    private final int MAX_ADDITION_SIZE = 3;

    private HashMap<String, Double> additions = new HashMap<String, Double>();

    public Burger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        System.out.println("Created " + this.name + " with " + this.meat + "on " + this.breadRollType + "price is " + this.price );
    }

    public void addAdditions(String addition, double additionPrice) {
        if(additions.size() < MAX_ADDITION_SIZE)
            additions.put(addition,additionPrice);
    }

    public double buildSelectedBurger(){
        double finalPrice = this.price;
        for(Map.Entry<String,Double> entry : additions.entrySet() ){
            double price = entry.getValue();
            finalPrice += price;
        }

        return finalPrice;
    }

}
