package Controller;

import EFinance.Logger;
import EFinance.User;
import Loans.*;
import People.Account;
import People.Address;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Group 2
 */
public class NewApplicationControl implements Initializable {

    private String loanType;

    private ApplicationList applicationList;

    float interestRate;

    @FXML
    private RadioButton autoRadio;

    @FXML
    private RadioButton businessRadio;

    @FXML
    private RadioButton personalRadio;

    @FXML
    private Label nameLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private TextField loanAmountText;

    @FXML
    private TextArea loanDescriptionText;

    @FXML
    private ComboBox creditRatingText;

    @FXML
    private Label rateLabel;

    @FXML
    private ComboBox loanTermText;

    @FXML
    private Label paymentLabel;

    @FXML
    private Label businessNameLabel;

    @FXML
    private TextField businessNameText;

    @FXML
    private Label businessAddressLabel;

    @FXML
    private TextField addressLine1Text;

    @FXML
    private TextField addressLine2Text;

    @FXML
    private TextField cityText;

    @FXML
    private ComboBox stateText;

    @FXML
    private TextField zipText;

    @FXML
    private Label annualIncomeLabel;

    @FXML
    private Label existingDebtLabel;

    @FXML
    private TextField annualIncomeText;

    @FXML
    private TextField existingDebtText;

    @FXML
    private Label dollar1Label;

    @FXML
    private Label dollar2Label;

    @FXML
    private ToggleGroup Group;

    @FXML
    private Label nameText;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Button cancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Add state abbreviations to state list.
        for (String s : Address.STATE_LIST) {
            stateText.getItems().add(s);
        }

        // Get the logged in user
        Account account = User.getInstance().getAccount();

        // Set user's name.
        nameText.setText(account.getName().getFullName());

        // Set the application date.
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
        String formattedDate = df.format(new Date());
        dateLabel.setText(formattedDate);

        // Fill in the credit rating and loan term drop downs
        creditRatingText.getItems().addAll("300-599", "600-649", "650-699", "700-749", "750-799", "800-850");
        loanTermText.getItems().addAll("12", "24", "36", "48", "60", "72");

        // Default loan type to Auto
        loanType = "Auto";

        //
        applicationList = new ApplicationList();
    }

    /*
    * This method sets relevant fields visible for auto loan type
     */
    @FXML
    public void selectAutoLoan() {

        hideAll();
        loanTermText.getItems().clear();
        loanTermText.getItems().addAll("12", "24", "36", "48", "60", "72");
        loanType = "Auto";
    }

    /*
    * This method sets relevant fields visible for business loan type
     */
    @FXML
    public void selectBusinessLoan() {

        hideAll();
        businessNameLabel.setVisible(true);
        businessNameText.setVisible(true);
        businessAddressLabel.setVisible(true);
        addressLine1Text.setVisible(true);
        addressLine2Text.setVisible(true);
        cityText.setVisible(true);
        stateText.setVisible(true);
        zipText.setVisible(true);

        loanTermText.getItems().clear();
        loanTermText.getItems().addAll("12", "24", "36", "48", "60", "72", "84", "96", "108", "120");
        loanType = "Business";
    }

    /*
    * This method sets relevant fields visible for personal loan type
     */
    @FXML
    public void selectPersonalLoan() {

        hideAll();
        annualIncomeLabel.setVisible(true);
        existingDebtLabel.setVisible(true);
        annualIncomeText.setVisible(true);
        existingDebtText.setVisible(true);
        dollar1Label.setVisible(true);
        dollar2Label.setVisible(true);

        loanTermText.getItems().clear();
        loanTermText.getItems().addAll("12", "24", "36", "48", "60", "72", "84", "96", "108", "120");
        loanType = "Personal";
    }

    /*
    * This method hides all of the fields not shared by different loan types
     */
    public void hideAll() {

        businessNameLabel.setVisible(false);
        businessNameText.setVisible(false);
        businessAddressLabel.setVisible(false);
        addressLine1Text.setVisible(false);
        addressLine2Text.setVisible(false);
        cityText.setVisible(false);
        stateText.setVisible(false);
        zipText.setVisible(false);
        annualIncomeLabel.setVisible(false);
        existingDebtLabel.setVisible(false);
        annualIncomeText.setVisible(false);
        existingDebtText.setVisible(false);
        dollar1Label.setVisible(false);
        dollar2Label.setVisible(false);

    }

    @FXML
    private void createApplication(ActionEvent event) throws IOException {

        Application newApplication = null;
        Account account = User.getInstance().getAccount();
        int loanNumber = getNextAvailableApplication();

        System.out.println(loanType);

        if (loanType.equals("Auto")) {
            newApplication = new AutoLoanApplication(loanNumber, account);
            ((AutoLoanApplication) newApplication).setAutoDescription(loanDescriptionText.getText());

        } else if (loanType.equals("Business")) {
            newApplication = new BusinessLoanApplication(loanNumber, account);
            ((BusinessLoanApplication) newApplication).setBusinessName(businessNameText.getText());
            ((BusinessLoanApplication) newApplication).setBusinessAddress(new Address(addressLine1Text.getText(), addressLine2Text.getText(), cityText.getText(), (String) stateText.getValue(), zipText.getText()));
            ((BusinessLoanApplication) newApplication).setBusinessDescription(loanDescriptionText.getText());
        } else if (loanType.equals("Personal")) {
            newApplication = new PersonalLoanApplication(loanNumber, account);
            if (annualIncomeText.getText().equals("")) {
                annualIncomeText.setText("0");
            }
            if (existingDebtText.getText().equals("")) {
                existingDebtText.setText("0");
            }
            ((PersonalLoanApplication) newApplication).setAnnualHouseholdIncome(new BigDecimal(annualIncomeText.getText()));
            ((PersonalLoanApplication) newApplication).setTotalExistingDebt(new BigDecimal(existingDebtText.getText()));
        }

        if (loanAmountText.getText().equals("")) {
            loanAmountText.setText("0");
        }
        newApplication.setLoanAmount(new BigDecimal(loanAmountText.getText()));
        newApplication.setApplicationDate(new Date());
        newApplication.setStatus("Pending");
        newApplication.setComments("");
        newApplication.setInterestRate(getRate());
        if (loanTermText.getSelectionModel().isEmpty()) {
            newApplication.setLoanTerm(0);
        } else {
            newApplication.setLoanTerm(Integer.valueOf((String) loanTermText.getValue()));
        }

        String validation = validate(newApplication);

        //If the entered information is valid, create the application
        if (validation.equals("valid")) {

            applicationList.addApplication(newApplication);
            applicationList.writeApplicationListFile();

            Logger logger = Logger.getInstance();
            logger.log("New application was created for username '" + newApplication.getApplicant().getUsername() + "'.");

            // Show success message.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Application created! Please wait 3-5 days for application review.");
            alert.showAndWait();

            // Return user to menu.
            EFinance.EFinanceFX.newScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance");
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } else {
            // Show validation error(s).
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Failed");
            alert.setHeaderText(null);
            alert.setContentText(validation);
            alert.showAndWait();
        }
    }

    public String validate(Application application) {

        /*
        * These statements validate to make sure all shared fields are populated
         */
        if (application.getLoanAmount().compareTo(new BigDecimal("0")) == 0) {
            return "Loan amount cannot be 0!";
        }
        if (loanDescriptionText.getText().equals("")) {
            return "Loan purpose cannot be blank!";
        }
        if (application.getLoanAmount().compareTo(new BigDecimal("0")) < 0) {
            return "Loan amount cannot be negative!";
        }
        if (creditRatingText.getSelectionModel().isEmpty()) {
            return "Credit rating cannot be blank!";
        }
        if (loanTermText.getSelectionModel().isEmpty()) {
            return "Loan Term cannot be blank!";
        }

        /*
        * These statements validate fields for business loans
         */
        if (application.getLoanType().equals("Business")) {
            if (businessNameText.getText().equals("")) {
                return "Business Name cannot be blank!";
            }
            if (addressLine1Text.getText().equals("")) {
                return "Address Line 1 cannot be blank!";
            }
            if (cityText.getText().equals("")) {
                return "City cannot be blank!";
            }
            if (stateText.getSelectionModel().isEmpty()) {
                return "State cannot be blank!";
            }
            if (zipText.getText().equals("")) {
                return "Zip cannot be blank!";
            }
        }

        /*
        * These statements validate fields for personal loans
         */
        if (application.getLoanType().equals("Personal")) {
            if (annualIncomeText.getText().equals("")) {
                return "Annual Income cannot be blank!";
            }
            if (existingDebtText.getText().equals("")) {
                return "Existing Debt cannot be blank!";
            }
        }
        return "valid";
    }

    @FXML
    private void cancelButtonClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelling Loan Application");
        alert.setHeaderText("Your loan application will not be created and all information entered on this form will be lost.");
        alert.setContentText("Click OK to cancel this loan application.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            EFinance.EFinanceFX.switchScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance", event);
        }

    }

    private int getNextAvailableApplication() {

        int applicationNumber = 0;

        int x; //counter for finding next available application number
        int y; //counter for finding next available application number

        boolean available = false;
        for (x = 1; x < applicationList.getApplicationList().size(); x++) {
            available = true;
            for (y = 0; y < applicationList.getApplicationList().size(); y++) {
                if (applicationList.getApplicationList().get(y).getLoanNumber() == x) {
                    available = false;
                }
            }
            if (available) {
                applicationNumber = x;
                break;
            }
        }
        if (!available) {
            applicationNumber = x + 1;
        }
        //End of account number loop

        return applicationNumber;
    }

    private float getRate() {

        if (creditRatingText.getSelectionModel().isEmpty()) {
            return 0;
        }
        String creditRating = (String) creditRatingText.getValue();

        if (creditRating.equals("300-599")) {
            return 6;
        } else if (creditRating.equals("600-649")) {
            return 5;
        } else if (creditRating.equals("650-699")) {
            return 4;
        } else if (creditRating.equals("700-749")) {
            return 3;
        } else if (creditRating.equals("750-799")) {
            return 2;
        } else if (creditRating.equals("800-850")) {
            return 1;
        }

        return 0;
    }

    /*
    * This method sets the interest rate to the interest rate label when credit rating is selected
     */
    @FXML
    private void setRate() {

        rateLabel.setText(Float.toString(getRate()) + "%");
        setPayment();
    }

    @FXML
    private void setPayment() {

        if (creditRatingText.getSelectionModel().isEmpty() || loanTermText.getSelectionModel().isEmpty()
                || loanAmountText.getText().equalsIgnoreCase("")) {
            paymentLabel.setText("$0");
        } else {
            int amount = Integer.parseInt(loanAmountText.getText());
            int months = Integer.parseInt((String) loanTermText.getSelectionModel().getSelectedItem());
            double rate = getRate() / 1200;
            double factor = (Math.pow(1 + rate, months) - 1) / (rate * Math.pow(1 + rate, months));
            double payment = amount / factor;

            paymentLabel.setText("$" + String.format("%.02f", payment));
        }

    }

}
