import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Already on file");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        AtomicInteger index = new AtomicInteger();
        contacts.parallelStream().forEach( contact -> { // can be used anyMatch
            if(contact.getName().equals(contactName)) {
                index.set(contacts.indexOf(contact));
            }
        });
        if(index.get()>=0){
            return index.get();
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if( foundPosition < 0 ) {
            System.out.println("Old Contact not found");
            return false;
        }
        this.contacts.set(foundPosition, newContact);
        System.out.println("Contact replaced");
        return true;
    }

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("5554442211");
        Contact cont1 = new Contact("Halil", "5556667788");
        phone.addContact(cont1);
        System.out.println(phone.findContact(cont1.getName()));
    }
}
