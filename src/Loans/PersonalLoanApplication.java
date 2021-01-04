package Loans;

import People.Account;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Represents a personal loan application.
 *
 * @author Group 2
 */
public class PersonalLoanApplication extends Application implements Serializable {

    private String loanPurpose;

    private BigDecimal annualHouseholdIncome;

    private BigDecimal totalExistingDebt;

    private int creditRating;

    /**
     * Constructor for a personal loan application.
     *
     * @param loanNumber The loan number
     * @param applicant The applicant
     */
    public PersonalLoanApplication(int loanNumber, Account applicant) {
        super("Personal", loanNumber, applicant);
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean isPreapproved() {
        return false;
    }

    /**
     * @return the annualHouseholdIncome
     */
    public BigDecimal getAnnualHouseholdIncome() {
        return annualHouseholdIncome;
    }

    /**
     * @param annualHouseholdIncome the annualHouseholdIncome to set
     */
    public void setAnnualHouseholdIncome(BigDecimal annualHouseholdIncome) {
        this.annualHouseholdIncome = annualHouseholdIncome;
    }

    /**
     * @return the totalExistingDebt
     */
    public BigDecimal getTotalExistingDebt() {
        return totalExistingDebt;
    }

    /**
     * @param totalExistingDebt the totalExistingDebt to set
     */
    public void setTotalExistingDebt(BigDecimal totalExistingDebt) {
        this.totalExistingDebt = totalExistingDebt;
    }

    /**
     * @return the creditRating
     */
    public int getCreditRating() {
        return creditRating;
    }

    /**
     * @param creditRating the creditRating to set
     */
    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
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
