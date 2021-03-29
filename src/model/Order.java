package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    private  static final long serialVersionUID = 3;

    //Attributes.
    private  String code;//hacerlo autogenerado
    private  String feedback;
    private  Date date;
    private boolean available;
    private String orderAddress;
    private int amountProducts;
    private int price;



    //Relationship.
    private  Client clientRequest;
    private ArrayList<Product> productsList;
    private  Employee employee;
    private  User creatorU;
    private  User lastU;
    private Status status;



    public Order(Client clientRequest, Employee employee,String orderAddress) {
        feedback = "";
        code = "";
        status = Status.REQUESTED;
        productsList = new ArrayList<>();
        available = true;
        this.clientRequest =clientRequest;
        this.employee = employee;
        this.orderAddress = orderAddress;
        amountProducts =0;
        price = 0;

    }

    //Getters and Setters.

    public String getAmountProducts() {
        return String.valueOf(amountProducts);
    }

    public int getPrice() {
        if(productsList.size() != 0){
            for(int i = 0; i < productsList.size(); i++){
            price += productsList.get(i).getPrice();
             }
        }
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
        amountProducts=productsList.size();
    }

    public Client getClient(){ return  clientRequest;}


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
        generateCode();
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

    public String getDate() {
        return date.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientRequest() {
        return clientRequest.getName();
    }

    public void setClientRequest(Client clientRequest) {
        this.clientRequest = clientRequest;
    }


    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void generateCode() {
        char o;
        if(code.equals("")) {
            o = (char)(Math.random()*26+'a');
            code+=o;
            for (int i = 0; i <3 ; i++) {
                code+= (int)((Math.random())*(i+9)+2+i+1);

            }
        }

    }

    public String getEmployee() {
        return employee.getName();
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
