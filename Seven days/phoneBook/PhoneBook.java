import java.util.Scanner;

public static String menu() {
    return """
            1. Add contact
            2. Remove contact
            3. Find contact by phone number
            4. Find contact by first name
            5. Find contact by last name
            6. Edit contact
            7. Exit
            """;
}

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PhoneBookApp contactApp = new PhoneBookApp();

    while (true) {
        System.out.println(menu());
        System.out.println("Enter your choice (1 - 7): ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter first name: ");
                String firstName = input.nextLine();
                System.out.println("Enter last name: ");
                String lastName = input.nextLine();
                System.out.println("Enter phone number: ");
                String phoneNumber = input.nextLine();
                System.out.println("Enter email: ");
                String email = input.nextLine();
                String addedContact = contactApp.addContacts(firstName, lastName, phoneNumber, email);
                System.out.println("Contact added: " + addedContact);
                break;

            case 2:
                System.out.println("Enter first name: ");
                firstName = input.nextLine();
                System.out.println("Enter last name: ");
                lastName = input.nextLine();
                String removedContact = contactApp.removeContact(firstName, lastName);
                System.out.println(removedContact);
                break;

            case 3:
                System.out.println("Enter phone number: ");
                phoneNumber = input.nextLine();
                String foundNumber = contactApp.findNumberWithNumber(phoneNumber);
                System.out.println(foundNumber);
                break;

            case 4:
                System.out.println("Enter first name: ");
                firstName = input.nextLine();
                String foundByFirstName = contactApp.findContactByFirstName(firstName);
                System.out.println(foundByFirstName);
                break;

            case 5:
                System.out.println("Enter last name: ");
                lastName = input.nextLine();
                String foundByLastName = contactApp.findContactByLastName(lastName);
                System.out.println(foundByLastName);
                break;

            case 6:
                System.out.println("Enter first name: ");
                firstName = input.nextLine();
                System.out.println("Enter last name: ");
                lastName = input.nextLine();
                System.out.println("Enter new phone number: ");
                phoneNumber = input.nextLine();
                System.out.println("Enter new email: ");
                String newEmail = input.nextLine();
                String editedContact = contactApp.editContact(firstName, lastName, phoneNumber, newEmail);
                System.out.println(editedContact);
                break;

            case 7:
                System.out.println("Exiting the app. Goodbye!");
                return;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
