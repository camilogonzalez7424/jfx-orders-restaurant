package model;

public class Employee {
    private  String nameE;
    private  String lastnameE;
    private  String identificationE;

    public Employee(String nameE, String lastnameE, String identificationE) {
        this.nameE = nameE;
        this.lastnameE = lastnameE;
        this.identificationE = identificationE;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getLastnameE() {
        return lastnameE;
    }

    public void setLastnameE(String lastnameE) {
        this.lastnameE = lastnameE;
    }

    public String getIdentificationE() {
        return identificationE;
    }

    public void setIdentificationE(String identificationE) {
        this.identificationE = identificationE;
    }
}
