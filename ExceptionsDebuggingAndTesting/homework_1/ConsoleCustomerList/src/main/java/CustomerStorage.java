import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        String regexPhoneNumber = "\\+[7][0-9]{10}";
        String regexMail = "^[a-z]*@[a-z]*\\.[a-z]{2,3}$";

        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format for ADD");
        }
        else if (!components[INDEX_EMAIL].matches(regexMail)) {
            throw new IllegalArgumentException("Wrong format e-mail");
        } else if (!components[INDEX_PHONE].matches(regexPhoneNumber)) {
            throw new IllegalArgumentException("Wrong format phone number");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}