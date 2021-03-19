package model;

import java.io.Serializable;

/**
 * Class Type product.
 */
public class TypeProduct  implements Serializable {
    private  static final long serialVersionUID = 1;
    //Attributes.
    private String name;
    private boolean availableT;

    private User creatorUser;
    private User lastUser;

    /**
     * Instantiates a new Type product.
     *
     * @param name the name is type String.
     */
    public TypeProduct(String name) {
        this.name = name;
    }

    //Getters and Setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailableT() {
        return availableT;
    }

    public void setAvailableT(boolean availableT) {
        this.availableT = availableT;
    }

    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }

    public User getLastUser() {
        return lastUser;
    }

    public void setLastUser(User lastUser) {
        this.lastUser = lastUser;
    }
}
