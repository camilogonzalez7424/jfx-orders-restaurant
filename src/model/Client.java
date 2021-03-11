package model;

/**
 * Class Client
 */
public class Client {
    private  String nameC;
    private String lastnameC;
    private  String identificationC;
    private  String addres;

    public Client(String nameC, String lastnameC, String identificationC, String addres) {
        this.nameC = nameC;
        this.lastnameC = lastnameC;
        this.identificationC = identificationC;
        this.addres = addres;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getLastnameC() {
        return lastnameC;
    }

    public void setLastnameC(String lastnameC) {
        this.lastnameC = lastnameC;
    }

    public String getIdentificationC() {
        return identificationC;
    }

    public void setIdentificationC(String identificationC) {
        this.identificationC = identificationC;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
