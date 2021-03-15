package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private  static final long serialVersionUID = 2;
    //Attributes.
    private String name;
    private String lastName;
    private String identification;
    private boolean habilitate;

    private User creatorUser;
    private  User lastUser;

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
        habilitate = true;
    }

    //Getters and Setters.


    public User getCurrentUser() {
        return creatorUser;
    }

    public void setCurrentUser(User currentUser) {
        this.creatorUser = currentUser;
    }

    public User getLastUser() {
        return lastUser;
    }

    public void setLastUser(User lastUser) {
        this.lastUser = lastUser;
    }

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

    public boolean isHabilitate() {
        return habilitate;
    }

    public void setHabilitate(boolean habilitate) {
        this.habilitate = habilitate;
    }
}
