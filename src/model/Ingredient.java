package model;

public class Ingredient {
    //Attributes
    private String nameI;
    private boolean avalible;

    /**
     * Instantiates a new Ingredient.
     *
     * @param nameI the nameI is type String.
     */
    public Ingredient(String nameI){
       this.nameI = nameI;
       avalible = true;
    }

    //Getters and Setters.

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
