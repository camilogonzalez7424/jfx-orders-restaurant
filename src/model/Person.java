package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private  static final long serialVersionUID = 1;
    //Attributes.
    private String name;
    private String lastName;
    private String identification;

    /**
     * Instantiates a new Person.
     *
     * @param name           the name is type String.
     * @param lastName       the last name is type String.
     * @param identification the identification is type String.
     */
    public Person(String name, String lastName, String identification) {
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
    }

    //Getters and Setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }


}
