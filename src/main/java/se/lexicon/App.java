package se.lexicon;


public class App 
{
    public static void main( String[] args ) {

        System.out.println(ContactsList.size()); // 0
        boolean isAddedContact1 =ContactsList.add("Test,1234567890,test@test.se");
        System.out.println(isAddedContact1); // -> true
        System.out.println(ContactsList.size()); // 1
        System.out.println(ContactsList.add("Test2,1234567890,test2@test2.se")); // ? false
        System.out.println(ContactsList.size()); // 1

    }
}
