package Communication;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a request for support or feedback.
 *
 * @author Group 2
 */
public class SupportRequest implements Serializable{

    private int ID;

    private People.Account contactAccount;

    private String contactName;

    private String contactEmail;

    private Date requestDate;

    private String request;

    private String status;

    private People.Account customerServiceRep;

    /**
     * Constructor used for contacts who have an account and are logged in.
     *
     * @param contactAccount
     * @param request
     */
    public SupportRequest(People.Account contactAccount, String request) {
        this.contactAccount = contactAccount;
        this.contactName = this.contactAccount.getName().getFullName();
        this.contactEmail = this.contactAccount.getEmail();
        this.request = request;
        this.requestDate = new Date();
    }

    /**
     * Constructor used for contacts without accounts or who cannot login.
     *
     * @param contactName
     * @param contactEmail
     * @param request
     */
    public SupportRequest(String contactName, String contactEmail, String request) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.request = request;
        this.requestDate = new Date();
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * set the ID
     */
    public void setID(int ID) {

        this.ID = ID;
    }

    /**
     * @return the contactAccount
     */
    public People.Account getContactAccount() {
        return contactAccount;
    }

    /**
     * @param contactAccount the contactAccount to set
     */
    public void setContactAccount(People.Account contactAccount) {
        this.contactAccount = contactAccount;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return this.contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the contactEmail
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * @param contactEmail the contactEmail to set
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * @return the request
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the customerServiceRep
     */
    public People.Account getCustomerServiceRep() {
        return customerServiceRep;
    }

    /**
     * @param customerServiceRep the customerServiceRep to set
     */
    public void setCustomerServiceRep(People.Account customerServiceRep) {
        this.customerServiceRep = customerServiceRep;
    }

}
