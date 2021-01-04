package Loans;

import People.Account;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Represents an auto loan application.
 *
 * @author Group 2
 */
public class AutoLoanApplication extends Application implements Serializable {

    private String autoDescription;

    private BigDecimal downPayment;

    private BigDecimal autoValue;

    private int creditRating;

    /**
     * Constructor for an auto loan application.
     *
     * @param loanNumber The loan number
     * @param applicant The applicant
     */
    public AutoLoanApplication(int loanNumber, Account applicant) {
        super("Auto", loanNumber, applicant);
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean isPreapproved() {
        return false;
    }

    /**
     * @return the autoDescription
     */
    public String getAutoDescription() {
        return autoDescription;
    }

    /**
     * @param autoDescription the autoDescription to set
     */
    public void setAutoDescription(String autoDescription) {
        this.autoDescription = autoDescription;
    }

    /**
     * @return the downPayment
     */
    public BigDecimal getDownPayment() {
        return downPayment;
    }

    /**
     * @param downPayment the downPayment to set
     */
    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    /**
     * @return the autoValue
     */
    public BigDecimal getAutoValue() {
        return autoValue;
    }

    /**
     * @param autoValue the autoValue to set
     */
    public void setAutoValue(BigDecimal autoValue) {
        this.autoValue = autoValue;
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

}
