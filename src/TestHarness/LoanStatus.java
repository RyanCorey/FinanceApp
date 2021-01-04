/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHarness;

/**
 *
 * @author Group 2
 */
public class LoanStatus {

    protected NewApplication newApplication;

    public LoanStatus() {

        this.newApplication = new NewApplication();

        System.out.println();
        System.out.println("Checking Loan Status");
        System.out.println("-----------------------------");
        System.out.println("Status: " + this.newApplication.autoLoanApplication.getStatus());
        System.out.println();
    }

}
