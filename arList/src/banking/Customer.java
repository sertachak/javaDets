package banking;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    public Customer(String name, double transaction) {
        this.name = name;
        transactions = new ArrayList<Double>();
        addTransaction(transaction);
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
