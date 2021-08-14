package banking;

public class CustomerBuilder {
    private String name;
    private double transaction = 0.0;

    public CustomerBuilder(){}

    public Customer buildCustomer() {
        return new Customer(name,transaction);
    }

    public CustomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder transaction(double transaction) {
        this.transaction = transaction;
        return this;
    }
}
