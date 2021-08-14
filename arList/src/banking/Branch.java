package banking;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public void addCustomerTransaction(String customerName, double transaction) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(transaction);
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean newCustomer(String customerName) {
       if( findCustomer(customerName) == null ) {
           Customer customer = new CustomerBuilder().name(customerName).buildCustomer();
           addCustomer(customer);
           return true;
       }
            return false;
    }

    private Customer findCustomer(String customerName) {
        return customers.parallelStream().filter( customer -> customer.getName() == customerName).findAny().get();
    }
}
