package model;

/**
 * Class Client
 */
public class Client extends Person implements Comparable<Client>{
    //Attributes
    private  String address;
    private  String telephone;


    /**
     * Instantiates a new Client.
     *
     * @param name           the name is type String and it extends from Person.
     * @param lastName       the last name is type String and it extends from Person.
     * @param identification the identification is type String and it extends from Person.
     * @param address         the address is type String
     */
    public Client(String name, String lastName, String identification, String address,String telephone) {
        super(name, lastName, identification);
        this.address = address;
        this.telephone = telephone;
    }

    //Getters and Setters.

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Client other) {
        return  getName().compareTo(other.getName());

    }
}
