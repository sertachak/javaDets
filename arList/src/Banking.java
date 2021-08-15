import banking.Bank;
import banking.Branch;

public class Banking {

    public static void main(String[] args) {
        Bank currentBank = new Bank("Coko");
        currentBank.addBranch("YasMama");
        currentBank.addCustomer("YasMama", "Efo", 1.4);
    }
}
