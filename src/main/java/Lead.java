import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by u2346 on 11/17/15.
 */
public class Lead {
    @JsonProperty("_id")
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Date entryDate;

    /*
     *  Construct
     */
    public Lead () {}

    /*
     *  Construct
     *  id
     *  @param firstName
     *  @param lastName
     *  @param email
     *  @param address
     *  @param entryDate
     */
    public Lead (String id, String firstName, String lastName, String email, String address, Date entryDate) {
        this._id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.entryDate = entryDate;

    }

    public String getId () {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String toString() {
        return firstName + " " + lastName + " with address: " + address + " and email: " + email + " and entryDate is :" + entryDate;
    }

    public int compare (Lead lead) {
        if (this.getId().equalsIgnoreCase(lead.getId()) && this.getEmail().equalsIgnoreCase(lead.getEmail()) && this.getFirstName().equalsIgnoreCase(lead.getFirstName())
                && this.getLastName().equalsIgnoreCase(lead.getLastName()) && this.getAddress().equalsIgnoreCase(lead.getAddress()) && this.getEntryDate().equals(lead.getEntryDate())) {
            return 0;

        }
        return 1;

    }
}
