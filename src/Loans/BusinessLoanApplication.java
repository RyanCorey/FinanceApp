package Loans;

import People.Account;
import java.io.Serializable;

/**
 * Represents a business loan application.
 *
 * @author Group 2
 */
public class BusinessLoanApplication extends Application implements Serializable {

    private String businessName;

    private People.Address businessAddress;

    private String businessDescription;

    private String loanPurpose;

    /**
     * Constructor for a business loan application.
     *
     * @param loanNumber The loan number
     * @param applicant The applicant
     */
    public BusinessLoanApplication(int loanNumber, Account applicant) {
        super("Business", loanNumber, applicant);
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean isPreapproved() {
        return false;
    }

    /**
     * @return the businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * @return the businessAddress
     */
    public People.Address getBusinessAddress() {
        return businessAddress;
    }

    /**
     * @param businessAddress the businessAddress to set
     */
    public void setBusinessAddress(People.Address businessAddress) {
        this.businessAddress = businessAddress;
    }

    /**
     * @return the businessDescription
     */
    public String getBusinessDescription() {
        return businessDescription;
    }

    /**
     * @param businessDescription the businessDescription to set
     */
    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    /**
     * @return the loanPurpose
     */
    public String getLoanPurpose() {
        return loanPurpose;
    }

    /**
     * @param loanPurpose the loanPurpose to set
     */
    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

}
