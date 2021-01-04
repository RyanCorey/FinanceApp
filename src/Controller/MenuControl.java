package Controller;

import EFinance.User;
import People.Account;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author cxk292
 */
public class MenuControl implements Initializable {
    
    @FXML
    private Button newLoanButton;
    
    @FXML
    private Button contactSupportButton;
    
    @FXML
    private Button logOutButton;
    
    @FXML
    private Button loanStatusButton;
    
    @FXML
    private Label welcomeLabel;
    
    private Account account;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Get the logged in user
        account = User.getInstance().getAccount();

        // Personalize window
        welcomeLabel.setText("Welcome to eFinance, " + account.getName().getFullName() + "!");

        // Modify interface if logged in user is a loan officer.
        if (account.getUsername().equalsIgnoreCase("LoanOfficer")) {
            loanStatusButton.setText("Approve/Deny Loans");
            contactSupportButton.setText("View Support Requests");
        }
        
    }
    
    @FXML
    private void logOut(ActionEvent event) throws IOException {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/LoginUI.fxml", "Login | eFinance", event);
    }
    
    @FXML
    private void newApplication(ActionEvent event) throws IOException {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/NewApplicationUI.fxml", "New Application | eFinance", event);
    }
    
    @FXML
    private void viewLoanStatus(ActionEvent event) {
        if (account.getUsername().equalsIgnoreCase("LoanOfficer")) {
            EFinance.EFinanceFX.switchScene(getClass(), "/View/LoanListUI.fxml", "Loan List | eFinance", event);
        } else {
            EFinance.EFinanceFX.switchScene(getClass(), "/View/LoanStatusUI.fxml", "Loan Status | eFinance", event);
        }        
    }
    
    @FXML
    private void contactSupport(ActionEvent event) {
        
        if (account.getUsername().equalsIgnoreCase("LoanOfficer")) {
            EFinance.EFinanceFX.switchScene(getClass(), "/View/SupportRequestListUI.fxml", "Support Request List | eFinance", event);
        } else {
            EFinance.EFinanceFX.switchScene(getClass(), "/View/SupportRequestUI.fxml", "Support Request | eFinance", event);
        }
        
    }
    
}
