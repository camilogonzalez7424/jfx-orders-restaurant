package model;

/**
 * Class Type product.
 */
public class TypeProduct {
    private String name;
    private boolean avalibleT;

    public TypeProduct(String name){
        this.name = name;
    }

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
