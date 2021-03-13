package model;

/**
 * Class Client
 */
public class Client extends Person{

    private  String addres;

    public Client(String name, String lastName, String identification, String addres) {
        super(name, lastName, identification);
        this.addres = addres;
    }
}
