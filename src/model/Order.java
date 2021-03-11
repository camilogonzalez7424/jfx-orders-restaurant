package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private  String code;//hacerlo autogenerado
    private  String feedback;
    private Date hour;//mirar si sirve
    private  Date date;

    private  Client clientRequest;
    private ArrayList<Product> productsList;
    private  Employee employee;

    public Order(String code, String feedback, Date hour, Date date) {
        this.code = code;
        this.feedback = feedback;
        this.hour = hour;
        this.date = date;
        productsList = new ArrayList<>();

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
}