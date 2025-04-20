import java.util.ArrayList;

public class PhoneBookApp {
    private final ArrayList<String[]> contacts = new ArrayList<>();
    private int count;

    public boolean testThatContactListIsEmpty() {
        return contacts.isEmpty();
    }

    public String addContacts(String firstName, String lastName, String phoneNumber, String email) {
        String[] contact = new String[4];
        contact[0] = firstName;
        contact[1] = lastName;
        contact[2] = phoneNumber;
        contact[3] = email;
        contacts.add(contact);
        count++;
        return firstName + " " + lastName + " " + phoneNumber + " " + email;
    }

    public String removeContact(String firstName, String lastName) {
        for (int index = 0; index < contacts.size(); index++) {
            String[] contact = contacts.get(index);
            if (contact[0].equals(firstName) && contact[1].equals(lastName)) {
                contacts.remove(index);
                count--;
                return "Contact removed: " + firstName + " " + lastName;
            }
        }
        return "Contact not found";
    }

    public String findNumberWithNumber(String phoneNumber) {
        for (String[] contact : contacts) {
            if (contact[2].equals(phoneNumber)) {
                return contact[0] + " " + contact[1] + " " + contact[2] + " " + contact[3];
            }
        }
        return "Contact not found";
    }

    public String findContactByFirstName(String firstName) {
        for (String[] contact : contacts) {
            if (contact[0].equals(firstName)) {
                return contact[0] + " " + contact[1] + " " + contact[2] + " " + contact[3];
            }
        }
        return "Contact not found";
    }

    public String findContactByLastName(String lastName) {
        for (String[] contact : contacts) {
            if (contact[1].equals(lastName)) {
                return contact[0] + " " + contact[1] + " " + contact[2] + " " + contact[3];
            }
        }
        return "Contact not found";
    }

    public String editContact(String firstName, String lastName, String newPhoneNumber, String newEmail) {
        for (String[] contact : contacts) {
            if (contact[0].equals(firstName) && contact[1].equals(lastName)) {
                contact[2] = newPhoneNumber;
                contact[3] = newEmail;
                return "Contact updated: " + firstName + " " + lastName + " " + newPhoneNumber + " " + newEmail;
            }
        }
        return "Contact not found";
    }

    public int getCount() {
        return count;
    }

    public String phoneNumberIsValid(String number) {
        if(number.charAt(0) == '0'){
            return "This is a valid Nigerian number";
        }
        return "Invalid Nigerian number";
        }

    public String phoneNumberLength(String number) {
        if(number.length() > 0 && number.length() <= 11){
           return "This is a valid Nigerian number length";
        }else if(number.length() > 11 && number.length() <= 17){}
        return number;
    }
}