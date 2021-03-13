package model;

public class Ingredient {
    //Attributes
    private String nameI;
    private boolean avalible;

    /**
     * Instantiates a new Ingredient.
     */
    public Ingredient(String nameI){
       this.nameI = nameI;
       avalible = true;
    }

    public String getNameI() {
        return nameI;
    }



    public void setNameI(String nameI) {
        this.nameI = nameI;
    }

    public boolean isAvalible() {
        return avalible;
    }
}
