import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookAppTest {
    PhoneBookApp phone = new PhoneBookApp();

    @Test
    public void testThatPhoneBookIsEmpty() {
        assertTrue(phone.testThatContactListIsEmpty());
    }

    @Test
    public void testThatPhoneBookIsNotEmpty() {
        phone.addContacts("Dupe", "Olaitan", "08128255657", "dupe@gmail.com");
        assertFalse(phone.testThatContactListIsEmpty());
    }

    @Test
    public void testThatAddsContact() {
        String result = phone.addContacts("Kemi", "Adeyemi", "09088881817", "kemi@gmail.com");
        assertEquals("Kemi Adeyemi 09088881817 kemi@gmail.com", result);
        assertEquals(1, phone.getCount());
    }

    @Test
    public void testThatRemovesContact() {
        phone.addContacts("Peejay", "Smith", "07034343567", "peejay1122@gmail.com");
        String result = phone.removeContact("Peejay", "Smith");
        assertEquals("Contact removed: Peejay Smith", result);
        assertEquals(0, phone.getCount());
    }

    @Test
    public void testThatRemovesContactNotFound() {
        String result = phone.removeContact("Ayo", "Ade");
        assertEquals("Contact not found", result);
    }

    @Test
    public void testThatFindsByPhoneNumber() {
        phone.addContacts("Dupe", "Ade", "07071213141", "dupe@gmail.com");
        String result = phone.findNumberWithNumber("07071213141");
        assertEquals("Dupe Ade 07071213141 dupe@gmail.com", result);
    }

    @Test
    public void testThatFindsByPhoneNumberNotFound() {
        phone.addContacts("Dupe", "Ade", "07071213141", "dupe@gmail.com");
        String result = phone.findNumberWithNumber("07000000000");
        assertEquals("Contact not found", result);
    }

    @Test
    public void testThatFindsByFirstName() {
        phone.addContacts("Kemi", "Ola", "08123456789", "kemi@gmail.com");
        String result = phone.findContactByFirstName("Kemi");
        assertEquals("Kemi Ola 08123456789 kemi@gmail.com", result);
    }

    @Test
    public void testThatFindsByFirstNameNotFound() {
        phone.addContacts("Kemi", "Ola", "08123456789", "kemi@gmail.com");
        String result = phone.findContactByFirstName("Unknown");
        assertEquals("Contact not found", result);
    }

    @Test
    public void testThatFindsByLastName() {
        phone.addContacts("Peejay", "Smith", "07034343567", "peejay1122@gmail.com");
        String result = phone.findContactByLastName("Smith");
        assertEquals("Peejay Smith 07034343567 peejay1122@gmail.com", result);
    }

    @Test
    public void testThatFindsByLastNameNotFound() {
        phone.addContacts("Peejay", "Smith", "07034343567", "peejay1122@gmail.com");
        String result = phone.findContactByLastName("Unknown");
        assertEquals("Contact not found", result);
    }

    @Test
    public void testThatEditsContact() {
        phone.addContacts("Dupe", "Adeola", "07071213141", "dupe@gmail.com");
        String result = phone.editContact("Dupe", "Adeola", "09099829999", "dupe.new@gmail.com");
        assertEquals("Contact updated: Dupe Adeola 09099829999 dupe.new@gmail.com", result);
    }

}