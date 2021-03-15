package model;

/**
 * Class Type product.
 */
public class TypeProduct {
    //Attributes.
    private String name;
    private boolean avalibleT;

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
}
