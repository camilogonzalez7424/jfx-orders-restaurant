package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    private  static final long serialVersionUID = 1;

    //Attributes.
    private  String code;//hacerlo autogenerado
    private  String feedback;
    private Date hour;//mirar si sirve
    private  Date date;
    private boolean available;

    //Relationship.
    private  Client clientRequest;
    private ArrayList<Product> productsList;
    private  Employee employee;
    private  User creatorU;
    private  User lastU;
    private Status status;

    /**
     * Instantiates a new Order.
     *
     * @param code     the code is type String.
     * @param feedback the feedback is type String.
     */
    public Order(String code, String feedback) {
        this.code = code;
        this.feedback = feedback;
        status = Status.REQUESTED;
        productsList = new ArrayList<>();
        available = true;

    }

    //Getters and Setters.

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(Client clientRequest) {
        this.clientRequest = clientRequest;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
