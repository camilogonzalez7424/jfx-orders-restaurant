package model;

/**
 * Class Client
 */
public class Client extends Person{
    //Attributes
    private  String address;


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
}
