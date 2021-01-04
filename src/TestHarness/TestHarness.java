package TestHarness;

/**
 * Tests the API's in the eFinance application.
 *
 * @author Group 2
 */
public class TestHarness {

    public TestHarness() {

        printSection("Testing Account Creation:");
        CreateAccount createAccount = new CreateAccount();

        printSection("Testing Login:");
        Login login = new Login();

        printSection("Testing New Loan Application:");
        NewApplication newApplication = new NewApplication();
        newApplication.testAutoLoanApplication();
        newApplication.testBusinessLoanApplication();
        newApplication.testPersonalLoanApplication();

        printSection("Testing Checking Loan Status:");
        LoanStatus loanStatus = new LoanStatus();

        printSection("Testing Approve/Deny Loan:");
        ApproveDenyLoan approveDenyLoan = new ApproveDenyLoan();

        printSection("Testing Contact Support:");
        ContactSupport contactSupport = new ContactSupport();
    }

    private void printSection(String text) {
        System.out.println("=================================================");
        System.out.println(text);
        System.out.println("=================================================");
    }

}
