package model;

/**
 * The type Product.
 */
public class Product {
    //Attributes.

    private String nameP;
    private String size;
    private int price;

    /**
     * Instantiates a new Product.
     *
     * @param nameP the namep is of type String.
     */
    public Product(String nameP){
        this.nameP = nameP;
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
