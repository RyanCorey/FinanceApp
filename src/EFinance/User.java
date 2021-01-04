package EFinance;

import People.Account;

/**
 * Represents a logged in user.
 *
 * @author group 2
 *
 * This class maintains the logged in user throughout the application so that it
 * can be referenced where needed.
 *
 * @usage // Get the logged in user Account account =
 * User.getInstance().getAccount(); // Get some property of the logged in user
 * account.getName().
 *
 */
public class User {

    private People.Account account;

    private static final User INSTANCE = new User();

    /**
     * Constructor for user.
     */
    private User() {
    }

    /**
     * Gets the current instance.
     *
     * @return The logger instance
     */
    public static User getInstance() {
        return INSTANCE;
    }

    /**
     * Set the account
     *
     * @param account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return this.account;
    }

}
