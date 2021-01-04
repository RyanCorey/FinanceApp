package Controller;

import EFinance.Logger;
import EFinance.User;
import People.AccountList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Group 2
 */
public class LoginControl implements Initializable {

    private AccountList accountList;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccountButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        accountList = new AccountList();

    }

    @FXML
    public void createAccount(ActionEvent event) throws IOException {

        //Loads the Create Account UI
        FXMLLoader createAccountLoader = new FXMLLoader(getClass().getResource("/View/CreateAccountUI.fxml"));
        Parent createAccountUI = (Parent) createAccountLoader.load();
        Stage createAccountStage = new Stage();
        createAccountStage.setTitle("Create Account");
        createAccountStage.setScene(new Scene(createAccountUI));
        createAccountStage.show();

        // Send account list to the create account controller
        CreateAccountControl createAccountController = createAccountLoader.getController();
        createAccountController.setAccountList(accountList);

        // Close Login UI
        Stage loginStage = (Stage) loginButton.getScene().getWindow();
        loginStage.close();
    }

    //This method handles authentication
    @FXML
    public void authenticate(ActionEvent event) throws IOException {

        String username = usernameText.getText();
        String password = passwordText.getText();

        int i;
        boolean authentication = false;

        for (i = 0; i < accountList.getAccountList().size(); i++) {

            if (username.equalsIgnoreCase(accountList.getAccountList().get(i).getUsername())) {

                if (password.equals(accountList.getAccountList().get(i).getPassword())) {

                    // Log this event.
                    Logger logger = Logger.getInstance();
                    logger.log("Login successful by user '" + username + "'.");

                    // Set the user object.
                    User user = User.getInstance();
                    user.setAccount(accountList.getAccountList().get(i));

                    //Replace this code with successful authentication code (load menu)
                    System.out.println("Authentication Successful!");
                    authentication = true;
                    EFinance.EFinanceFX.switchScene(getClass(), "/View/MenuUI.fxml", "Menu | eFinance", event);
                } else {
                    Logger logger = Logger.getInstance();
                    logger.log("Login failed (incorrect password) by user '" + username + "'.");
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Authentication Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect password. Please try again or click \"Help\" to contact support.");
                    alert.showAndWait();
                    return;
                }
            }
        }

        if (!authentication) {
            Logger logger = Logger.getInstance();
            logger.log("Login failed (unknown user) by user '" + username + "'.");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Authentication Failed");
            alert.setHeaderText(null);
            alert.setContentText("Unknown username. Please try again or click \"Help\" to contact support.");
            alert.showAndWait();
        }
    }

    @FXML
    private void exitButtonClicked() {
        System.exit(0);
    }

    @FXML
    private void help(ActionEvent event) {
        EFinance.EFinanceFX.switchScene(getClass(), "/View/SupportRequestUI.fxml", "Support Request | eFinance", event);
    }

}
