package People;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a US mailing address.
 *
 * @author Group 2
 */
public class Address implements Serializable {

    private String line1;

    private String line2;

    private String city;

    private String state;

    private String zip;

    /**
     * A list of US State abbreviations.
     */
    public static final ArrayList<String> STATE_LIST = new ArrayList<>(Arrays.asList(
            "AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
            "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME",
            "MI", "MN", "MO", "MP", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM",
            "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX",
            "UM", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY"));

    /**
     * Constructor for address.
     *
     * @param line1 the first street address line
     * @param line2 the second street address line
     * @param city the city
     * @param state the US state
     * @param zip the zip code
     */
    public Address(String line1, String line2, String city, String state, String zip) {

        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Returns a full address.
     *
     * @return a String representing an address
     */
    public String getFullAddress() {
        return this.line1 + " " + this.line2 + " " + this.city + ", " + this.state + " " + this.zip;
    }

    /**
     * @return the line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     * @param line1 the line1 to set
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * @return the line2
     */
    public String getLine2() {
        return line2;
    }

    /**
     * @param line2 the line2 to set
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

}
