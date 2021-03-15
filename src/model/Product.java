package model;

/**
 * The type Product.
 */
public class Product {
    //Attributes.
    private String nameP;
    private String size;
    private int price;

    //Relationship.
    private TypeProduct type;
    private User CreatorU;
    private  User lastUser;

    /**
     * Instantiates a new Product.
     *
     * @param nameP the nameP is of type String.
     */

    public Product(String nameP, String size, int price, TypeProduct type) {
        this.nameP = nameP;
        this.size = size;
        this.price = price;
        this.type = type;
    }



    //Getters and Setters.


    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public User getCreatorU() {
        return CreatorU;
    }

    public void setCreatorU(User creatorU) {
        CreatorU = creatorU;
    }

    public User getLastUser() {
        return lastUser;
    }

    public void setLastUser(User lastUser) {
        this.lastUser = lastUser;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}