package model;

/**
 * Class Client
 */
public class Client extends Person{
    //Attributes
    private  String address;
    private boolean work;


    /**
     * Instantiates a new Client.
     *
     * @param name           the name is type String and it extends from Person.
     * @param lastName       the last name is type String and it extends from Person.
     * @param identification the identification is type String and it extends from Person.
     * @param address         the address is type String
     */
    public Client(String name, String lastName, String identification, String address) {
        super(name, lastName, identification);
        this.address = address;
    }

    //Getters and Setters.

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
