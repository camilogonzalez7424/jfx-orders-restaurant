package model;

/**
 * The type Employee.
 */
public class Employee extends  Person {
    private boolean works;
    /**
     * Instantiates a new Employee.
     *
     * @param name           the name is type String and it extends from Person.
     * @param lastname       the lastname is type String and it extends from Person.
     * @param identification the identification is type and it extends from Person.
     */
    public Employee(String name, String lastname, String identification) {
        super(name,lastname,identification);
        works = true;

    }

    public boolean isWorks() {
        return works;
    }

    public void setWorks(boolean works) {
        this.works = works;
    }
}
