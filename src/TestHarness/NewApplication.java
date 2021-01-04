package TestHarness;

import Loans.*;
import People.Account;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Tests the creation of new loan applications.
 *
 * @author Group 2
 */
public class NewApplication {

    private Account account;
    private Account loanOfficer;
    DecimalFormat df = new DecimalFormat("#,###0.00");

    protected AutoLoanApplication autoLoanApplication;
    protected BusinessLoanApplication businessLoanApplication;
    protected PersonalLoanApplication personalLoanApplication;

    public NewApplication() {
        this.account = new Account(1, "John.Smith@test.com", "abc123");
        this.loanOfficer = new Account(2, "brianbaker@example.com", "qxp987");

        this.autoLoanApplication = new AutoLoanApplication(1, this.account);
        this.autoLoanApplication.setLoanAmount(new BigDecimal(22150.25));
        this.autoLoanApplication.setStatus("Pending");
        this.autoLoanApplication.setAutoDescription("2019 White Toyota Prius LE");
        this.autoLoanApplication.setDownPayment(new BigDecimal(2200.00));
        this.autoLoanApplication.setAutoValue(new BigDecimal(24980.00));
        this.autoLoanApplication.setLoanTerm(60);
        this.autoLoanApplication.setCreditRating(710);
        this.autoLoanApplication.setInterestRate((float) 5.675);

        this.businessLoanApplication = new BusinessLoanApplication(3, this.account);
        this.businessLoanApplication.setLoanAmount(new BigDecimal(85000.00));
        this.businessLoanApplication.setStatus("Pending");
        this.businessLoanApplication.setBusinessName("John Smith's Widgets");
        this.businessLoanApplication.setBusinessDescription("Retail seller of quality widgets.");
        this.businessLoanApplication.setLoanPurpose("Expansion of business to a second location.");
        this.businessLoanApplication.setLoanTerm(36);
        this.businessLoanApplication.setInterestRate((float) 12.25);

        this.personalLoanApplication = new PersonalLoanApplication(4, this.account);
        this.personalLoanApplication.setLoanAmount(new BigDecimal(12956.58));
        this.personalLoanApplication.setStatus("Pending");
        this.personalLoanApplication.setAnnualHouseholdIncome(new BigDecimal(67500));
        this.personalLoanApplication.setTotalExistingDebt(new BigDecimal(32120.45));
        this.personalLoanApplication.setLoanPurpose("Debt Consolidation.");
        this.personalLoanApplication.setLoanTerm(24);
        this.personalLoanApplication.setInterestRate((float) 9.75);
        this.personalLoanApplication.setCreditRating(710);

    }

    public void testAutoLoanApplication() {

        System.out.println();
        System.out.println("Initial Auto Loan Application");
        System.out.println("-----------------------------");

        System.out.println("Loan number: " + this.autoLoanApplication.getLoanNumber());
        System.out.println("Applicant: " + this.autoLoanApplication.getApplicant().getUsername());
        System.out.println("Loan Amount: $" + df.format(this.autoLoanApplication.getLoanAmount()));
        System.out.println("Application Date: " + this.autoLoanApplication.getApplicationDate().toString());
        System.out.println("Status: " + this.autoLoanApplication.getStatus());
        System.out.println("Comments: " + this.autoLoanApplication.getComments());
        System.out.println("Auto Description: " + this.autoLoanApplication.getAutoDescription());
        System.out.println("Down Payment: $" + df.format(this.autoLoanApplication.getDownPayment()));
        System.out.println("Auto Value: $" + df.format(this.autoLoanApplication.getAutoValue()));
        System.out.println("Loan Term: " + this.autoLoanApplication.getLoanTerm() + "");
        System.out.println("Credit Rating: " + this.autoLoanApplication.getCreditRating() + "");
        System.out.println("Interest Rate: " + this.autoLoanApplication.getInterestRate() + "%");
        System.out.println();

        System.out.println("Assigning and Preapproving Auto Loan");
        System.out.println("------------------------------------");
        this.autoLoanApplication.setLoanOfficer(this.loanOfficer);
        this.autoLoanApplication.setComments("Loan assigned to Loan Officer. Not preapproved.");
        System.out.println("Loan Officer: " + this.autoLoanApplication.getLoanOfficer().getUsername());
        System.out.println("Preapproval: " + this.autoLoanApplication.isPreapproved());
        System.out.println("Comments: " + this.autoLoanApplication.getComments());
        System.out.println();

    }

    public void testBusinessLoanApplication() {

        System.out.println("Initial Business Loan Application");
        System.out.println("---------------------------------");
        System.out.println("Loan number: " + this.businessLoanApplication.getLoanNumber());
        System.out.println("Applicant: " + this.businessLoanApplication.getApplicant().getUsername());
        System.out.println("Loan Amount: $" + df.format(this.businessLoanApplication.getLoanAmount()));
        System.out.println("Application Date: " + this.businessLoanApplication.getApplicationDate().toString());
        System.out.println("Status: " + this.businessLoanApplication.getStatus());
        System.out.println("Comments: " + this.businessLoanApplication.getComments());
        System.out.println("Business Name: " + this.businessLoanApplication.getBusinessName());
        System.out.println("Business Description: " + this.businessLoanApplication.getBusinessDescription());
        System.out.println("Loan Purpose: " + this.businessLoanApplication.getLoanPurpose());
        System.out.println("Loan Term: " + this.businessLoanApplication.getLoanTerm() + "");
        System.out.println("Interest Rate: " + this.businessLoanApplication.getInterestRate() + "%");
        System.out.println();

        System.out.println("Assigning and Preapproving Business Loan");
        System.out.println("----------------------------------------");
        this.businessLoanApplication.setLoanOfficer(this.loanOfficer);
        this.businessLoanApplication.setComments("Loan assigned to Loan Officer. Not preapproved.");
        System.out.println("Loan Officer: " + this.businessLoanApplication.getLoanOfficer().getUsername());
        System.out.println("Preapproval: " + this.businessLoanApplication.isPreapproved());
        System.out.println("Comments: " + this.businessLoanApplication.getComments());
        System.out.println();

    }

    public void testPersonalLoanApplication() {

        System.out.println("Initial Personal Loan Application");
        System.out.println("---------------------------------");
        System.out.println("Loan number: " + this.personalLoanApplication.getLoanNumber());
        System.out.println("Applicant: " + this.personalLoanApplication.getApplicant().getUsername());
        System.out.println("Loan Amount: $" + df.format(this.personalLoanApplication.getLoanAmount()));
        System.out.println("Application Date: " + this.personalLoanApplication.getApplicationDate().toString());
        System.out.println("Status: " + this.personalLoanApplication.getStatus());
        System.out.println("Comments: " + this.personalLoanApplication.getComments());
        System.out.println("Annual Household Income: $" + df.format(this.personalLoanApplication.getAnnualHouseholdIncome()));
        System.out.println("Total Existing Debt: $" + df.format(this.personalLoanApplication.getTotalExistingDebt()));
        System.out.println("Loan Purpose: " + this.personalLoanApplication.getLoanPurpose());
        System.out.println("Loan Term: " + this.personalLoanApplication.getLoanTerm() + "");
        System.out.println("Interest Rate: " + this.personalLoanApplication.getInterestRate() + "%");
        System.out.println("Credit Rating: " + this.personalLoanApplication.getCreditRating() + "");
        System.out.println();

        System.out.println("Assigning and Preapproving Personal Loan");
        System.out.println("----------------------------------------");
        this.personalLoanApplication.setLoanOfficer(this.loanOfficer);
        this.personalLoanApplication.setComments("Loan assigned to Loan Officer. Not preapproved.");
        System.out.println("Loan Officer: " + this.personalLoanApplication.getLoanOfficer().getUsername());
        System.out.println("Preapproval: " + this.personalLoanApplication.isPreapproved());
        System.out.println("Comments: " + this.personalLoanApplication.getComments());
        System.out.println();

    }

}
