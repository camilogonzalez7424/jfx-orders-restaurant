package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Product.
 */
public class Product implements Serializable {
    private  static final long serialVersionUID = 1;

    //Attributes.
    private String nameP;
    private String size;
    private String isAvailableP;
    private int price;
    private boolean available;
    private  int amountOfRequest;

    private String auxPrice;

    //Relationship.
    private TypeProduct type;
    private ArrayList<Ingredient> ingredients;
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
        available = true;
        isAvailableP = "YES";
        auxPrice = String.valueOf(price);
        ingredients = new ArrayList<>();
        amountOfRequest =0;
    }



    //Getters and Setters.


    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountOfRequest() {
        return amountOfRequest;
    }

    public void setAmountOfRequest(int amountOfRequest) {
        this.amountOfRequest = amountOfRequest;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setAuxPrice(String auxPrice) {
        this.auxPrice = auxPrice;
    }

    public String getAuxPrice() {
        return auxPrice;
    }

    public String getIsAvailableP() {
        return isAvailableP;
    }

    public void setIsAvailableP(String isAvailableP) {
        this.isAvailableP = isAvailableP;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public String getType() {
        return type.getName();
    }

    public void setType(String ntype){
        type = new TypeProduct(ntype);
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

    public void setPrice(String price) {
        int newPrice = Integer.parseInt(price);
        this.price = newPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int compareTo(Product element) {
        int res = 0;
        if (this.price < element.getPrice()) {
            res = -1;
        }
        if (this.price > element.getPrice()) {
            res = 1;
        }
        return res;
    }
}