/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Loans.Application;
import Loans.ApplicationList;
import Loans.AutoLoanApplication;
import Loans.BusinessLoanApplication;
import Loans.PersonalLoanApplication;
import java.net.URL;
import java.text.DateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Group 2
 */
public class ApproveDenyControl implements Initializable {

    private Application selectedApplication;
    private ApplicationList applicationList;

    @FXML
    private Label loanTypeLabel;

    @FXML
    private Label applicantNameLabel;

    @FXML
    private Label applicationDateLabel;

    @FXML
    private Label loanAmountLabel;

    @FXML
    private Label loanPurposeLabel;

    @FXML
    private Label creditRatingLabel;

    @FXML
    private Label interestRateLabel;

    @FXML
    private Label loanTermLabel;

    @FXML
    private Label monthlyPaymentLabel;

    @FXML
    private Label extraLabel1;

    @FXML
    private Label extraLabel2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void populate(Application selectedApplication, ApplicationList applicationList) {

        this.selectedApplication = selectedApplication;
        this.applicationList = applicationList;

        extraLabel1.setVisible(false);
        extraLabel2.setVisible(false);

        loanTypeLabel.setText("Loan Type: " + selectedApplication.getLoanType());
        applicantNameLabel.setText("Applicant Name: " + selectedApplication.getApplicant().getName().getFullName());

        DateFormat date = DateFormat.getDateInstance();
        applicationDateLabel.setText("Application Date: " + date.format(selectedApplication.getApplicationDate().getTime()));
        loanAmountLabel.setText("Loan Amount: $" + selectedApplication.getLoanAmount() + ".00");

        String creditRating = "";

        if (selectedApplication.getInterestRate() == 6) {
            creditRating = "300-599";
        } else if (selectedApplication.getInterestRate() == 5) {
            creditRating = "600-649";
        } else if (selectedApplication.getInterestRate() == 4) {
            creditRating = "650-699";
        } else if (selectedApplication.getInterestRate() == 3) {
            creditRating = "700-749";
        } else if (selectedApplication.getInterestRate() == 2) {
            creditRating = "750-799";
        } else if (selectedApplication.getInterestRate() == 1) {
            creditRating = "800-850";
        }

        creditRatingLabel.setText("Credit Rating: " + creditRating);
        interestRateLabel.setText("Interest Rate: " + selectedApplication.getInterestRate() + "%");
        loanTermLabel.setText("Loan Term: " + selectedApplication.getLoanTerm() + " months");

        double amount = selectedApplication.getLoanAmount().doubleValue();
        int months = selectedApplication.getLoanTerm();
        double rate = selectedApplication.getInterestRate() / 1200;
        double factor = (Math.pow(1 + rate, months) - 1) / (rate * Math.pow(1 + rate, months));
        double payment = amount / factor;

        monthlyPaymentLabel.setText("Monthly Payment: $" + String.format("%.02f", payment));

        if (selectedApplication.getLoanType().equalsIgnoreCase("Business")) {

            loanPurposeLabel.setText("Business Description: " + ((BusinessLoanApplication) selectedApplication).getBusinessDescription());
            extraLabel1.setVisible(true);
            extraLabel1.setText("Business Name: " + ((BusinessLoanApplication) selectedApplication).getBusinessName());

            extraLabel2.setVisible(true);
            extraLabel2.setText("Business Address: " + ((BusinessLoanApplication) selectedApplication).getBusinessAddress()
                    .getFullAddress());
        } else if (selectedApplication.getLoanType().equalsIgnoreCase("Personal")) {

            loanPurposeLabel.setText("Loan Purpose: " + ((PersonalLoanApplication) selectedApplication).getLoanPurpose());
            extraLabel1.setVisible(true);
            extraLabel1.setText("Annual Income: " + ((PersonalLoanApplication) selectedApplication).getAnnualHouseholdIncome());

            extraLabel2.setVisible(true);
            extraLabel2.setText("Existing Debt: " + ((PersonalLoanApplication) selectedApplication).getTotalExistingDebt());
        } else {

            loanPurposeLabel.setText("Auto Description: " + ((AutoLoanApplication) selectedApplication).getAutoDescription());
        }

    }

    @FXML
    private void returnToListButtonClicked(ActionEvent event) {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/LoanListUI.fxml", "eFinance", event);
    }

    @FXML
    private void approveLoanClicked(ActionEvent event) {
        //Approve Loan
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Approve Loan");

        if (selectedApplication.getStatus().equalsIgnoreCase("Pending")) {

            alert.setHeaderText("Do you wish to approve this loan?");
            alert.setContentText("Click OK to approve the loan.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                selectedApplication.approveLoan();
                applicationList.writeApplicationListFile();
                EFinance.EFinanceFX.switchScene(getClass(), "/View/LoanListUI.fxml", "eFinance", event);
            }
        } else {

            alert.setHeaderText("This loan is currently in " + selectedApplication.getStatus() + " status.");
            alert.setContentText("Click OK to change status to Approved.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                selectedApplication.approveLoan();
                applicationList.writeApplicationListFile();
                EFinance.EFinanceFX.switchScene(getClass(), "/View/LoanListUI.fxml", "eFinance", event);
            }
        }

    }

    @FXML
    private void denyLoanClicked(ActionEvent event) {
        //Deny Loan
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Approve Loan");

        if (selectedApplication.getStatus().equalsIgnoreCase("Pending")) {

            alert.setHeaderText("Do you wish to approve this loan?");
            alert.setContentText("Click OK to approve the loan.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                selectedApplication.denyLoan();
                applicationList.writeApplicationListFile();
                EFinance.EFinanceFX.switchScene(getClass(), "/View/LoanListUI.fxml", "eFinance", event);

            }
        } else {

            alert.setHeaderText("This loan is currently in " + selectedApplication.getStatus() + " status.");
            alert.setContentText("Click OK to change status to Denied.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                selectedApplication.denyLoan();
                applicationList.writeApplicationListFile();
                EFinance.EFinanceFX.switchScene(getClass(), "/View/LoanListUI.fxml", "eFinance", event);

            }
        }

    }
}
