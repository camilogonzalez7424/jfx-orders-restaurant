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
    private String isAvalibleT;

    private User creatorUser;
    private User lastUser;

    /**
     * Instantiates a new Type product.
     *
     * @param name the name is type String.
     */
    public TypeProduct(String name) {
        this.name = name;
        isAvalibleT = "yes";
    }

    //Getters and Setters.

    public String getIsAvalibleT() {
        return isAvalibleT;
    }

    public void setIsAvalibleT(String isAvalibleT) {
        this.isAvalibleT = isAvalibleT;
    }

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
