package Controller;

import Communication.SupportRequest;
import Communication.SupportRequestList;
import EFinance.User;
import People.Account;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author cxk292
 */
public class SupportRequestControl implements Initializable {

    @FXML
    private TextField nameText;
    @FXML
    private TextField emailText;
    @FXML
    private TextArea requestText;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    private Account account;
    private SupportRequestList supportRequestList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Get the logged in user
        account = User.getInstance().getAccount();

        // If the user is logged in, prefill the name and email fields.
        if (account != null) {
            this.nameText.setText(account.getName().getFullName());
            this.emailText.setText(account.getEmail());
        }

        this.supportRequestList = new SupportRequestList();
        System.out.println(supportRequestList);
    }

    @FXML
    private void submitButtonClicked(ActionEvent event) {
        String validation = validate();

        if (validation.equals("valid")) {

            // Save the support request.            
            if (account == null) {
                SupportRequest sr = new SupportRequest(nameText.getText(), emailText.getText(), requestText.getText());
                supportRequestList.addSupportRequest(sr);
                System.out.println(supportRequestList);
                supportRequestList.writeSupportRequestListFile();
                
            } else {
                SupportRequest sr = new SupportRequest(account, requestText.getText());
                supportRequestList.addSupportRequest(sr);
                supportRequestList.writeSupportRequestListFile();
            }

            // Show success message.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Your support request has been submitted. You will receive confirmation via email and a response  within 24 hours. Thank you.");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();

            // Redirect the user to the correct location based on if they are
            // logged in or not.
            if (account == null) {
                EFinance.EFinanceFX.switchScene(getClass(), "/View/LoginUI.fxml", "Login | eFinance", event);
            } else {
                EFinance.EFinanceFX.switchScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance", event);
            }

        } else {
            // Show validation error(s).
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Failed");
            alert.setHeaderText(null);
            alert.setContentText(validation);
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelling Support Request");
        alert.setHeaderText("Your support request will not be created and all information entered on this form will be lost.");
        alert.setContentText("Click OK to cancel creating this support request.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            // Redirect the user to the correct location based on if they are
            // logged in or not.
            if (account == null) {
                EFinance.EFinanceFX.switchScene(getClass(), "/View/LoginUI.fxml", "Login | eFinance", event);
            } else {
                EFinance.EFinanceFX.switchScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance", event);
            }

        }
    }

    /**
     * Validates inputs.
     */
    public String validate() {
        if (nameText.getText().isEmpty()) {
            return "Name cannot be empty.";
        } else if (emailText.getText().isEmpty()) {
            return "Email cannot be empty.";
        } else if (requestText.getText().isEmpty()) {
            return "Support Request cannot be empty.";
        } else {
            return "valid";
        }
    }
}
