package Controller;

import EFinance.Logger;
import People.Account;
import People.AccountList;
import People.Address;
import People.Name;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Group 2
 */
public class CreateAccountControl implements Initializable {

    private AccountList accountList;

    private int passwordStrength;

    @FXML
    private ImageView weakImage;

    @FXML
    private ImageView mediumImage;

    @FXML
    private ImageView strongImage;

    @FXML
    private Label passwordStrengthLabel;

    @FXML
    private Label strengthLabel;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField middleInitialText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField address1Text;

    @FXML
    private TextField address2Text;

    @FXML
    private TextField cityText;

    @FXML
    private ComboBox<String> stateText;

    @FXML
    private TextField zipText;

    @FXML
    private DatePicker dobText;

    @FXML
    private TextField ssnText;

    @FXML
    private TextField phoneText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField captcha;

    @FXML
    private Label captchaOK;

    @FXML
    private Label captchaFail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Add state abbreviations to state list.
        for (String s : Address.STATE_LIST) {
            stateText.getItems().add(s);
        }

    }

    //Method to check the strength of the password
    public void checkPasswordStrength() {

        int length = 0; //length of the password
        int letter = 0; //checks if there is a letter in the password
        int number = 0; //checks if there is a number in the password
        int special = 0; //checks if there is a special character in the password
        int complexity = 0; //calculates complexity

        length = passwordText.getLength();

        if (passwordText.getText().matches("(?=.*[0-9]).*")) {
            number = 1;
        }
        if (passwordText.getText().matches("(?=.*[A-Z]).*")) {
            letter = 1;
        }
        if (passwordText.getText().matches("(?=.*[a-z]).*")) {
            letter = 1;
        }
        if (passwordText.getText().matches("(?=.*[~!@#$%^&*()_-]).*")) {
            special = 1;
        }

        complexity = number + letter + special;

        if (length == 0) {

            weakImage.setVisible(false);
            mediumImage.setVisible(false);
            strongImage.setVisible(false);
            passwordStrengthLabel.setVisible(false);
            strengthLabel.setVisible(false);
        } else {
            passwordStrengthLabel.setVisible(true);
            strengthLabel.setVisible(true);

            //Check For Weak Password
            if (length < 8 || complexity < 2) {
                strengthLabel.setText("Weak");
                strengthLabel.setTextFill(Color.RED);
                weakImage.setVisible(true);
                mediumImage.setVisible(false);
                strongImage.setVisible(false);
                this.passwordStrength = 1;
            }

            //2 Checks For Medium Password
            if (length >= 8 && length <= 12 && complexity >= 2) {
                strengthLabel.setText("Medium");
                strengthLabel.setTextFill(Color.YELLOW);
                weakImage.setVisible(true);
                mediumImage.setVisible(true);
                strongImage.setVisible(false);
                this.passwordStrength = 2;
            }
            if (length >= 8 && complexity == 2) {
                strengthLabel.setText("Medium");
                strengthLabel.setTextFill(Color.YELLOW);
                weakImage.setVisible(true);
                mediumImage.setVisible(true);
                strongImage.setVisible(false);
                this.passwordStrength = 2;
            }

            //Check For Strong Password
            if (length >= 12 && complexity == 3) {
                strengthLabel.setText("Strong");
                strengthLabel.setTextFill(Color.GREEN);
                weakImage.setVisible(true);
                mediumImage.setVisible(true);
                strongImage.setVisible(true);
                this.passwordStrength = 3;
            }

        }

    }

    //Method to create a new account
    public void createAccount(ActionEvent event) throws IOException {

        Account newAccount;
        int accountNumber = getNextAvailableAccount();

        newAccount = new Account(accountNumber, usernameText.getText(), passwordText.getText());
        Name newName = new Name(firstNameText.getText(), lastNameText.getText(), middleInitialText.getText());
        newAccount.setName(newName);
        Address newAddress = new Address(address1Text.getText(), address2Text.getText(), cityText.getText(), stateText.getValue(), zipText.getText());
        newAccount.setAddress(newAddress);
        newAccount.setBirthdate(dobText.getValue());
        newAccount.setSSN(ssnText.getText());
        newAccount.setPhone(phoneText.getText());
        newAccount.setEmail(emailText.getText());

        String validation = validate(newAccount);

        //If the entered information is valid, add the new user
        if (validation.equals("valid")) {

            accountList.addUser(newAccount);
            accountList.writeAccountListFile();

            Logger logger = Logger.getInstance();
            logger.log("User account created for username '" + newAccount.getUsername() + "'.");

            // Show success message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Account created! Please log in.");
            alert.showAndWait();

            // Return user to login.
            EFinance.EFinanceFX.newScene(getClass(), "/View/LoginUI.fxml", "eFinance");
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } else {
            // Show validation error(s).
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validation Failed");
            alert.setHeaderText(null);
            alert.setContentText(validation);
            alert.showAndWait();
        }

    }

    // This method is used by the login controller to set the account list for the create account controller
    public void setAccountList(AccountList accountList) {
        this.accountList = accountList;
    }

    /*
     * This method checks to see if the information entered is valid. If it is invalid a string with the
     * invalid information will be returned.
     */
    public String validate(Account newAccount) {

        // This loop checks if the username is valid.
        int i;
        for (i = 0; i < accountList.getAccountList().size(); i++) {

            if (newAccount.getUsername().equalsIgnoreCase(accountList.getAccountList().get(i).getUsername())) {
                return "Username is already taken";

            }
        }
        if (newAccount.getUsername().length() < 1) {
            return "Username cannot be blank";
        }

        if (this.passwordStrength < 2) {
            return "Password is not strong enough";
        }

        if (newAccount.getName().getFirstName().length() < 1) {
            return "First name cannot be blank";
        }

        if (newAccount.getName().getLastName().length() < 1) {
            return "Last name cannot be blank";
        }

        if (newAccount.getAddress().getLine1().length() < 1) {
            return "Address Line 1 cannot be blank";
        }

        if (newAccount.getAddress().getCity().length() < 1) {
            return "City cannot be blank";
        }

        if (newAccount.getAddress().getState().length() < 1) {
            return "State cannot be blank";
        }

        if (newAccount.getAddress().getZip().length() < 1) {
            return "Zip Code cannot be blank";
        }

        if (newAccount.getBirthdate() == null) {
            return "Date of birth cannot be blank";
        }

        if (newAccount.getSSN().length() < 1) {
            return "SSN cannot be blank";
        }

        if (newAccount.getPhone().length() < 1) {
            return "Phone cannot be blank";
        }

        if (newAccount.getEmail().length() < 1) {
            return "Email cannot be blank";
        }

        if (!"4".equals(captcha.getText())) {
            return "Try CAPTCHA again";
        }

        return "valid";
    }

    public void checkCaptcha() {
        if (captcha.getText().matches("4")) {
            captchaOK.setVisible(true);
            captchaFail.setVisible(false);
        } else {
            captchaOK.setVisible(false);
            captchaFail.setVisible(true);
        }
    }

    @FXML
    private void cancelButtonClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancelling Account Creation");
        alert.setHeaderText("Your account will not be created and all information entered on this form will be lost.");
        alert.setContentText("Click OK to cancel creating an account.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            EFinance.EFinanceFX.newScene(getClass(), "/View/LoginUI.fxml", "eFinance");
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    /**
     * Finds the next available account number.
     *
     * @return the next available account number.
     */
    private int getNextAvailableAccount() {

        int accountNumber = 0;

        int x; //counter for finding next available account number
        int y; //counter for finding next available account number

        boolean available = false;
        for (x = 1; x < accountList.getAccountList().size(); x++) {
            available = true;
            for (y = 0; y < accountList.getAccountList().size(); y++) {
                if (accountList.getAccountList().get(y).getAccountNumber() == x) {
                    available = false;
                }
            }
            if (available) {
                accountNumber = x;
                break;
            }
        }
        if (!available) {
            accountNumber = x + 1;
        }
        //End of account number loop

        return accountNumber;
    }

}
