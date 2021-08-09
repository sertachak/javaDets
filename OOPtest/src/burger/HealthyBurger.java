package burger;

public class HealthyBurger extends Burger{

    private int healthyLimit = 0;

    public HealthyBurger(String meat) {
        super("HealthyBurger", meat, 11.34, "Brown rye");
    }

    public int getHealthyLimit() {
        return healthyLimit;
    }

    public void setHealthyLimit(int healthyLimit) {
        this.healthyLimit = healthyLimit;
    }

    @Override
    public void addAdditions(String addition, double additionPrice) {
        if( getHealthyLimit() < 2 )
            super.addAdditions(addition, additionPrice);
            setHealthyLimit(getHealthyLimit() + 1 );
    }
}
