package model;

import java.io.Serializable;

public class Ingredient  implements Serializable {
    private  static final long serialVersionUID = 1;

    //Attributes
    private String nameI;
    private boolean available;

    private User creatorU;
    private User lastU;

    /**
     * Instantiates a new Ingredient.
     *
     * @param nameI the nameI is type String.
     */
    public Ingredient(String nameI){
       this.nameI = nameI;
       available = true;
    }

    //Getters and Setters.


    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getCreatorU() {
        return creatorU;
    }

    public void setCreatorU(User creatorU) {
        this.creatorU = creatorU;
    }

    public User getLastU() {
        return lastU;
    }

    public void setLastU(User lastU) {
        this.lastU = lastU;
    }

    public String getNameI() {
        return nameI;
    }

    public void setNameI(String nameI) {
        this.nameI = nameI;
    }

    public boolean isAvailable() {
        return available;
    }
}
