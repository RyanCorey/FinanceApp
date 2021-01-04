/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHarness;

import Loans.*;

/**
 *
 * @author Group 2
 */
public class ApproveDenyLoan {

    protected NewApplication newApplication;

    public ApproveDenyLoan() {
        this.newApplication = new NewApplication();
        AutoLoanApplication loan = this.newApplication.autoLoanApplication;

        System.out.println();
        System.out.println("Checking Loan Status");
        System.out.println("-----------------------------");
        System.out.println("Status: " + loan.getStatus());
        System.out.println();

        System.out.println("Approving Loan");
        loan.approveLoan();
        System.out.println("-----------------------------");
        System.out.println("Status: " + loan.getStatus());
        System.out.println("Determination Date: " + loan.getDeterminationDate().toString());
        System.out.println();

        System.out.println("Resetting Loan Status");
        System.out.println("-----------------------------");
        loan.setStatus("Pending");
        System.out.println("Status: " + loan.getStatus());
        System.out.println();

        System.out.println("Denying Loan");
        loan.denyLoan();
        System.out.println("-----------------------------");
        System.out.println("Status: " + loan.getStatus());
        System.out.println("Determination Date: " + loan.getDeterminationDate().toString());
        System.out.println();

    }

}
