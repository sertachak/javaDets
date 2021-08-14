import java.util.ArrayList;

public class Contact {
    private String name;
    private String phoneNumber;
    private ArrayList<Integer> passwords;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        passwords = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name,phoneNumber);
    }

    public void addToPasswords(int pass) {
        if( (int)Math.floor(Math.log10(pass) + 1 ) > 5 ){
            passwords.add(Integer.valueOf(pass));//Autoboxing behind the scenes
        }
    }

    public int getContactPassword(int place) {
        return passwords.get(place).intValue();//Unboxing behind the scenes
    }
}
