package model;

public class SystemUser extends  Employee{
    private  String userName;
    private String password;

    public SystemUser(String nameE, String lastnameE, String identificationE, String userName , String password) {
        super(nameE, lastnameE, identificationE);
        this.userName = userName;
        this.password = password;
    }

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
