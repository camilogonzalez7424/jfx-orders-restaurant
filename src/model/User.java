package model;

/**
 * The type User.
 */
public class User extends  Employee {
    //Attributes.
    private  String userName;
    private String password;

    /**
     * Instantiates a new User.
     *
     * @param nameE           the nameE is type String and it extends from Employee.
     * @param lastnameE       the lastnameE is type String and it extends from Employee.
     * @param identificationE the identificationE is type String and it extends from Employee.
     * @param userName        the user name is type String.
     * @param password        the password is type String.
     */
    public User(String nameE, String lastnameE, String identificationE, String userName , String password) {
        super(nameE, lastnameE, identificationE);
        this.userName = userName;
        this.password = password;
    }

    //Getters and Setters.

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
