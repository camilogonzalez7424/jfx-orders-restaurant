package model;

/**
 * Class Type product.
 */
public class TypeProduct {
    //Attributes.
    private String name;
    private boolean avalibleT;

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

    public boolean isAvalibleT() {
        return avalibleT;
    }

    public void setAvalibleT(boolean avalibleT) {
        this.avalibleT = avalibleT;
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
