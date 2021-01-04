package People;

import java.io.Serializable;

/**
 * Represents the name of a person.
 *
 * @author Group 2
 */
public class Name implements Serializable {

    private String firstName;

    private String middleInitial;

    private String lastName;

    /**
     * Constructor for a name without a middle initial.
     *
     * @param firstName the first name
     * @param lastName the last name
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor for a name with a middle initial.
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param middleInitial the middle initial
     */
    public Name(String firstName, String lastName, String middleInitial) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
    }

    /**
     * Gets the full name of a person.
     *
     * @return The full name (first, middle initial, last) of a person.
     */
    public String getFullName() {
        String name = "";
        if (this.firstName != null && !this.firstName.trim().isEmpty()) {
            name += this.firstName + " ";
        }
        if (this.middleInitial != null && !this.middleInitial.trim().isEmpty()) {
            name += this.middleInitial + " ";
        }
        if (this.lastName != null && !this.lastName.trim().isEmpty()) {
            name += this.lastName;
        }
        return name;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleInitial
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * @param middleInitial the middleInitial to set
     */
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
