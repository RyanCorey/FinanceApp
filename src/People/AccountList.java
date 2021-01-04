package People;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Represents a list of accounts.
 *
 * @author Group 2
 */
public class AccountList {

    private ArrayList<Account> accountList;
    private final String listOfUsers = "accountList.ser";

    /**
     * Constructor for account list.
     */
    public AccountList() {
        accountList = new ArrayList<>();
        this.readUserListFile();
        if (accountList.isEmpty()) {
            initializeList();
        }
    }

    /**
     * Initializes an account list if there is no existing list.
     */
    public void initializeList() {
        Account account = new Account(1, "shandelong", "password1");
        account.setName(new Name("Stephen", "Handelong"));
        accountList.add(account);

        account = new Account(2, "ckomlenic", "password2");
        account.setName(new Name("Christopher", "Komlenic"));
        accountList.add(account);

        account = new Account(3, "adargenzio", "password3");
        account.setName(new Name("Ashton", "Dargenzio"));
        accountList.add(account);

        account = new Account(4, "rcorey", "password4");
        account.setName(new Name("Ryan", "Corey"));
        accountList.add(account);
    }

    /**
     * Reads the user list file into the accountList array.
     */
    private void readUserListFile() {

        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfUsers);
            in = new ObjectInputStream(fis);
            accountList = (ArrayList<Account>) in.readObject();
            in.close();
            if (!accountList.isEmpty()) {

            }
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    /**
     * @return the accountList
     */
    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    /**
     * @param accountList
     */
    public void setAccountList(ArrayList<Account> accountList) {

        this.accountList = accountList;
    }

    /**
     * Adds a user.
     *
     * @param account
     */
    public void addUser(Account account) {

        accountList.add(account);
    }

    /**
     * Writes the accountList array to the user list file.
     */
    public void writeAccountListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfUsers);
            out = new ObjectOutputStream(fos);
            out.writeObject(accountList);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
