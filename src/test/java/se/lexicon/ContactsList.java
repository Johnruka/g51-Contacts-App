package se.lexicon;

import jdk.internal.icu.text.UnicodeSet;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.Assert.*;

public class ContactsList {

    @BeforeEach
    public void setup(){
        ContactsList.clear();
    }

    private static void clear() {
    }

    @Test
    public void testAdd() {
        String contactData = "Mehrdad Javan,1234567890,mehrdad.javan@lexicon.se";
        UnicodeSet ContactsList = null;
        assertTrue(ContactsList.add(contactData).isFrozen());
    }


    @Test
    public void testAdd_DuplicateMobileNumber() {
        String contactData = "Mehrdad Javan,1234567890,mehrdad.javan@lexicon.se";
        assertTrue(ContactsList.add(contactData));
        assertFalse(ContactsList.add(contactData));
    }

    private static boolean add(String contactData) {
        return false;
    }

    @Test
    public void testAdd_EmptyContact() {
        String contactData = "";
        assertFalse(ContactsList.add(contactData));
    }
    @Test
    public void testAdd_NullContact() {
        String contactData = null;
        assertFalse(ContactsList.add(contactData));
    }

    @Test
    public void testSize() {
        String contactData = "Mehrdad Javan,1234567890,mehrdad.javan@lexicon.se";
        assertTrue(ContactsList.add(contactData));

        int expectedSize = 1;
        int actualSize = ContactsList.size();

        assertEquals(expectedSize, actualSize);
    }

    private static int size() {
        return 0;
    }


    @Test
    public void testGetAll() {
        String contact2 = "Jane Smith,0987654321,jane.smith@example.com";
        ContactsList.add(contact2);
        String[] contacts = ContactsList.getAll();
        assertEquals(1, contacts.length);
    }

    private static String[] getAll() {
        return new String[0];
    }

    @Test
    public void testFindByName() {
        String contactData = "Mehrdad Javan,1234567890,mehrdad.javan@lexicon.se";
        assertTrue(ContactsList.add(contactData));

        String[] result = ContactsList.findByName("Mehrdad Javan");
        assertEquals(1, result.length);
        assertTrue(result[0].contains("1234567890"));
    }

    private static String[] findByName(String mehrdadJavan) {
        return new String[0];
    }

    @Test
    public void testRemoveByMobileNumber() {
        String contactData = "Mehrdad Javan,1234567890,mehrdad.javan@lexicon.se";
        assertTrue(ContactsList.add(contactData));

        assertTrue(ContactsList.removeByMobileNumber("1234567890"));
        assertEquals(0, ContactsList.getAll().length);
    }

    private static boolean removeByMobileNumber(String number) {
        return false;
    }

    @Test
    public void testRemoveByMobileNumber_NotFound() {
        String contactData = "Mehrdad Javan,1234567890,mehrdad.javan@lexicon.se";
        assertTrue(ContactsList.add(contactData));

        assertFalse(ContactsList.removeByMobileNumber("0987654321"));
        assertEquals(1, ContactsList.getAll().length);
    }

    @Test
    public void testUpdateByMobileNumber() {
        String contactData = "Mehrdad Javan,1234567890,mehrdad.javan@lexicon.se";
        assertTrue(ContactsList.add(contactData));


        String updatedContact = "Nickan Javan,2222222222,nickan@test.se";
        assertTrue(ContactsList.updateByMobileNumber("1234567890", updatedContact));
        assertEquals(updatedContact, ContactsList.getAll()[0]);
    }

    private static boolean updateByMobileNumber(String number, String updatedContact) {
        return false;
    }
}
