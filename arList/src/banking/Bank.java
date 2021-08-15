package banking;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public void addBranch(String branchName) {
        for(int i = 0; i<branches.size(); i++) {
            if(branches.get(i).getName().equals(branchName)) {
                System.out.println("Branch is already created");
                return;
            }
        }
        Branch branch = new Branch(branchName);
        branches.add(branch);
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }

    public void addCustomer(String branchName, String customerName, double transaction) {
        Branch operationBranch = null;
        try {
            operationBranch = branches.stream().filter(branch -> branch.getName().equals(branchName)).findAny().get();
        } catch (NoSuchElementException e ){
            System.out.println("NO such branch in current banking system");
        }
        if( operationBranch != null ){
            operationBranch.addCustomer(new Customer(customerName, transaction));
        }
    }
}
