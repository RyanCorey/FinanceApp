package Communication;

import People.Account;
import People.Name;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Represents a list of support requests.
 *
 * @author group 2
 */
public class SupportRequestList {

    private ArrayList<SupportRequest> supportRequestList;
    private final String listOfSupportRequests = "supportRequestList.ser";

    /**
     * Constructor for SupportRequestList.
     */
    public SupportRequestList() {
        supportRequestList = new ArrayList<>();
        this.readSupportRequestListFile();
        if (supportRequestList.isEmpty()) {
            initializeList();
        }
    }

    /**
     * Initializes a support request list if there is no existing list.
     */
    public void initializeList() {
        SupportRequest sr1 = new SupportRequest("John Doe", "johndoe@example.com", "I'm having trouble logging in with my account.");
        supportRequestList.add(sr1);

        Account account = new Account(50, "janedoe1990", "password10");
        account.setName(new Name("Jane", "Doe"));
        account.setEmail("janedoe1990@example.com");
        SupportRequest sr2 = new SupportRequest(account, "I'm logged in but I have questions about applying for a loan.");
        supportRequestList.add(sr2);
    }

    /**
     * Reads the support request list file into the supportRequestList array.
     */
    private void readSupportRequestListFile() {

        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfSupportRequests);
            in = new ObjectInputStream(fis);
            supportRequestList = (ArrayList<SupportRequest>) in.readObject();
            in.close();
            if (!supportRequestList.isEmpty()) {

            }
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    /**
     * @return the supportRequestList
     */
    public ArrayList<SupportRequest> getSupportRequestList() {
        return supportRequestList;
    }

    /**
     * @param supportRequestList
     */
    public void setSupportRequestList(ArrayList<SupportRequest> supportRequestList) {

        this.supportRequestList = supportRequestList;
    }

    /**
     * Adds a support request.
     *
     * @param supportRequest
     */
    public void addSupportRequest(SupportRequest supportRequest) {
        supportRequestList.add(supportRequest);
    }

    /**
     * Writes the supportRequestList array to the support request list file.
     */
    public void writeSupportRequestListFile() {
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(listOfSupportRequests);
            out = new ObjectOutputStream(fos);
            out.writeObject(supportRequestList);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
