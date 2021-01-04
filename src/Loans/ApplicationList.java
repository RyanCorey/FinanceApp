package Loans;

import People.Account;
import People.Name;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Group 2
 */
public class ApplicationList {

    private ArrayList<Application> applicationList;

    private final String listOfApplications = "applicationList.ser";

    /**
     * Constructor for application list.
     */
    public ApplicationList() {
        applicationList = new ArrayList<>();
        this.readApplicationListFile();
        if (applicationList.isEmpty()) {
            initializeList();
        }
    }

    /**
     * Initializes an application list if there is no existing list.
     */
    public void initializeList() {

        Account account = new Account(1, "shandelong", "password1");
        account.setName(new Name("Stephen", "Handelong"));
        Application application = new PersonalLoanApplication(0, account);
        account.setName(new Name("Stephen", "Handelong"));
        applicationList.add(application);
    }

    /**
     * Reads the application list file into the applicationList array.
     */
    private void readApplicationListFile() {

        FileInputStream fis;
        ObjectInputStream in;
        try {
            fis = new FileInputStream(listOfApplications);
            in = new ObjectInputStream(fis);
            applicationList = (ArrayList<Application>) in.readObject();
            in.close();
            if (!applicationList.isEmpty()) {

            }
        } catch (IOException | ClassNotFoundException ex) {

        }
    }

    /**
     * @return the applicationList
     */
    public ArrayList<Application> getApplicationList() {
        return applicationList;
    }

    /**
     * @param applicationList
     */
    public void setApplicationList(ArrayList<Application> applicationList) {

        this.applicationList = applicationList;
    }

    /**
     * Adds an application.
     *
     * @param application
     */
    public void addApplication(Application application) {

        applicationList.add(application);
    }

    /**
     * Writes the applicationList array to the application list file.
     */
    public void writeApplicationListFile() {
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(listOfApplications);
            out = new ObjectOutputStream(fos);
            out.writeObject(applicationList);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
