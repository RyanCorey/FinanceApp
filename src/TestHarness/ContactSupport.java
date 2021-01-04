/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHarness;

import Communication.SupportRequest;
import People.Account;
import People.Name;
import java.util.Calendar;

/**
 *
 * @author Group 2
 */
public class ContactSupport {

    public ContactSupport() {

        SupportRequest request = new SupportRequest("", "", "");

        Account serviceRep = new Account(1, "rep", "password");
        Account user = new Account(2, "user", "password");
        Name userName = new Name("John", "Doe");

        user.setName(userName);
        user.setEmail("John.Doe@test.com");

        request.setID(1);
        request.setContactName("John Smith");
        request.setContactEmail("John.Smith@test.com");
        request.setRequestDate(Calendar.getInstance().getTime());
        request.setRequest("I need help creating an account!");
        request.setStatus("Pending");
        request.setCustomerServiceRep(serviceRep);

        System.out.println();
        System.out.println("Support Request (No User Account)");
        System.out.println("----------------");
        System.out.println("Request ID: " + request.getID());
        System.out.println("Request Date: " + request.getRequestDate());
        System.out.println("Name: " + request.getContactName());
        System.out.println("Email: " + request.getContactEmail());
        System.out.println("Inquiry: " + request.getRequest());
        System.out.println("Status: " + request.getStatus());

        request = new SupportRequest(user, "");

        request.setID(2);
        request.setContactAccount(user);
        request.setContactName(user.getName().getFirstName() + " " + user.getName().getLastName());
        request.setContactEmail(user.getEmail());
        request.setRequestDate(Calendar.getInstance().getTime());
        request.setRequest("I need help applying for a loan, please.");
        request.setStatus("Pending");
        request.setCustomerServiceRep(serviceRep);

        System.out.println();
        System.out.println("Support Request (Existing User Account)");
        System.out.println("----------------");
        System.out.println("Request ID: " + request.getID());
        System.out.println("Request Date: " + request.getRequestDate());
        System.out.println("Name: " + request.getContactName());
        System.out.println("Email: " + request.getContactEmail());
        System.out.println("Inquiry: " + request.getRequest());
        System.out.println("Status: " + request.getStatus());

    }
}
