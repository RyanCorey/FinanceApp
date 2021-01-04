package TestHarness;

import People.*;

/**
 * Tests creating an account.
 *
 * @author Group 2
 */
public class CreateAccount {

    public Name name;
    public Address address;
    public Account account;

    public CreateAccount() {

        name = new Name("", "", "");
        address = new Address("", "", "", "", "");
        account = new Account(0, "", "");

        name.setFirstName("John");
        name.setLastName("Smith");
        name.setMiddleInitial("C");

        String fn = name.getFirstName();
        String ln = name.getLastName();
        String mi = name.getMiddleInitial();

        address.setLine1("555 Cool Lane");
        address.setCity("Erie");
        address.setLine2("");
        address.setState("Pennsylvania");
        address.setZip("55555");

        String l1 = address.getLine1();
        String l2 = address.getLine2();
        String c = address.getCity();
        String s = address.getState();
        String z = address.getZip();

        account.setAccountType("Borrower");
        //account.setBirthdate(Calendar.getInstance().getTime());
        account.setEmail("John.Smith@test.com");
        account.setSSN("555-55-555");
        account.setUsername("John555");
        account.setPhone("555-555-5555");
        account.setPassword("Ham");
        account.setAccountNumber(1);

        System.out.println();
        System.out.println("Create Account");
        System.out.println("----------------");
        System.out.println("Name: " + name.getFullName());
        System.out.println("Address: " + address.getFullAddress());
        System.out.println("Birthdate: " + account.getBirthdate());
        System.out.println("Email: " + account.getEmail());
        System.out.println("SSN: " + account.getSSN());
        System.out.println("Username: " + account.getUsername());
        System.out.println("Phone: " + account.getPhone());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Password: " + account.getPassword());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println();

    }
}
