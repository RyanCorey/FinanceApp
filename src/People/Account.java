package People;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * A person, including login information.
 *
 * All users, including customer service representatives and loan officers will
 * have accounts.
 *
 * @author Group 2
 */
public class Account implements Serializable {

    private int accountNumber;

    private String username;

    private String accountType;

    private Name name;

    private Address address;

    private LocalDate birthdate;

    private String SSN;

    private String email;

    private String phone;

    private String password;

    @FXML
    private ComboBox<String> stateText;

    public Account(int accountNumber, String username, String password) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
    }

    /**
     * Authenticates a user by checking the supplied password.
     *
     * @param suppliedPassword The password to check.
     * @return True if the password is valid, false otherwise.
     */
    public boolean authenticate(String suppliedPassword) {
        return true;
    }

    /**
     * Resets an account password to a random temporary password.
     *
     * @return The new temporary password.
     */
    public String resetPassword(String password) {
        return password;
    }

    /**
     * Changes the password associated with an account.
     *
     * @param oldPassword The original old password.
     * @param newPassword The new password.
     */
    public void changePassword(String oldPassword, String newPassword) {

    }

    /**
     * Returns the user's age, in years.
     *
     * @return the user's age, in years.
     */
    public int getAge() {
        return 0;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the SSN
     */
    public String getSSN() {
        return SSN;
    }

    /**
     * @param SSN the SSN to set
     */
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @param accountNumber sets customer's account number
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @param username sets customer's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
