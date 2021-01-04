package Loans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents a loan application.
 *
 * @author Group 2
 */
public abstract class Application implements Serializable {

    private String loanType;

    private int loanNumber;

    private People.Account applicant;

    private People.Account loanOfficer;

    private BigDecimal loanAmount;

    private Date applicationDate;

    private Date determinationDate;

    private String status;

    private String comments;

    private float interestRate;

    private int loanTerm;

    /**
     * Constructor for Application
     *
     * @param loanNumber The loan number
     * @param applicant The applicant
     */
    public Application(String loanType, int loanNumber, People.Account applicant) {

        this.loanType = loanType;
        this.loanNumber = loanNumber;
        this.applicant = applicant;
        // Sets application date to the current date.
        this.applicationDate = new Date();
    }

    /**
     * Determines if a loan can be pre-approved.
     *
     * @return True if pre-approved, false otherwise.
     */
    public abstract boolean isPreapproved();

    /**
     * Approves a loan.
     */
    public void approveLoan() {
        this.setStatus("Approved");
        this.setDeterminationDate(new Date());
    }

    /**
     * Denies a loan.
     */
    public void denyLoan() {
        this.setStatus("Denied");
        this.setDeterminationDate(new Date());
    }

    /**
     * @return the loanType
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * @param loanType the loanType to set
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * @return the loanNumber
     */
    public int getLoanNumber() {
        return loanNumber;
    }

    /**
     * @return the applicant
     */
    public People.Account getApplicant() {
        return applicant;
    }

    /**
     * @param applicant the applicant to set
     */
    public void setApplicant(People.Account applicant) {
        this.applicant = applicant;
    }

    /**
     * @return the loanOfficer
     */
    public People.Account getLoanOfficer() {
        return loanOfficer;
    }

    /**
     * @param loanOfficer the loanOfficer to set
     */
    public void setLoanOfficer(People.Account loanOfficer) {
        this.loanOfficer = loanOfficer;
    }

    /**
     * @return the loanAmount
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param loanAmount the loanAmount to set
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * @return the applicationDate
     */
    public Date getApplicationDate() {
        return applicationDate;
    }

    /**
     * @param applicationDate the applicationDate to set
     */
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    /**
     * @return the determinationDate
     */
    public Date getDeterminationDate() {
        return determinationDate;
    }

    /**
     * @param determinationDate the determinationDate to set
     */
    public void setDeterminationDate(Date determinationDate) {
        this.determinationDate = determinationDate;
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
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the interestRate
     */
    public float getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the loanTerm
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * @param loanTerm the loanTerm to set
     */
    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

}
