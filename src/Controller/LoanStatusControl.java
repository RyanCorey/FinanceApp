package Controller;

import EFinance.User;
import Loans.ApplicationList;
import Loans.AutoLoanApplication;
import Loans.BusinessLoanApplication;
import Loans.PersonalLoanApplication;
import People.Account;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cxk292
 */
public class LoanStatusControl implements Initializable {

    @FXML
    private Label loanLabel;

    @FXML
    private TableView<PersonalLoanApplication> loanTable;

    @FXML
    private Button returnToMenuButton;

    @FXML
    private TableColumn<PersonalLoanApplication, String> loanType;

    @FXML
    private TableColumn<PersonalLoanApplication, BigDecimal> loanAmount;

    @FXML
    private TableColumn<PersonalLoanApplication, String> loanStatus;

    private ApplicationList applicationList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Get the logged in user.
        Account account = User.getInstance().getAccount();

        // Personalize window.
        loanLabel.setText("Loans for " + account.getName().getFullName());

        loanTable.setPlaceholder(new Label("User has no loans on file"));

        // Associate table columns with Application fields.
        loanType.setMinWidth(100);
        loanType.setCellValueFactory(new PropertyValueFactory<>("loanType"));

        loanAmount.setMinWidth(100);
        loanAmount.setCellValueFactory(new PropertyValueFactory<>("loanAmount"));

        loanStatus.setMinWidth(100);
        loanStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        this.applicationList = new ApplicationList();

        /**
         * Add loans associated with the logged in user.
         *
         * This code needs some work, but is working. The main problem is that
         * it treats all loans as personal loans for the purposes of adding them
         * to the tableview. If the main Loans.Application class wasn't
         * abstract, this would be greatly simplified.
         */
        for (Object o : applicationList.getApplicationList()) {

            switch (o.getClass().getSimpleName()) {

                case "AutoLoanApplication":
                    if (((AutoLoanApplication) o).getApplicant().getUsername().equals(account.getUsername())) {
                        PersonalLoanApplication temp = new PersonalLoanApplication(0, account);
                        temp.setLoanType("Auto");
                        temp.setLoanAmount(((AutoLoanApplication) o).getLoanAmount());
                        temp.setStatus(((AutoLoanApplication) o).getStatus());
                        loanTable.getItems().add(temp);
                    }
                    break;

                case "BusinessLoanApplication":
                    if (((BusinessLoanApplication) o).getApplicant().getUsername().equals(account.getUsername())) {
                        PersonalLoanApplication temp = new PersonalLoanApplication(0, account);
                        temp.setLoanType("Business");
                        temp.setLoanAmount(((BusinessLoanApplication) o).getLoanAmount());
                        temp.setStatus(((BusinessLoanApplication) o).getStatus());
                        loanTable.getItems().add(temp);
                    }
                    break;

                case "PersonalLoanApplication":
                    if (((PersonalLoanApplication) o).getApplicant().getUsername().equals(account.getUsername())) {
                        PersonalLoanApplication temp = new PersonalLoanApplication(0, account);
                        temp.setLoanType("Personal");
                        temp.setLoanAmount(((PersonalLoanApplication) o).getLoanAmount());
                        temp.setStatus(((PersonalLoanApplication) o).getStatus());
                        loanTable.getItems().add(temp);
                    }
                    break;
            }
        }

    }

    @FXML
    private void returnToMenuButtonClicked(ActionEvent event) {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance", event);
    }

}
