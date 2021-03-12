package model;

import java.util.ArrayList;

public class Restaurant {

    private ArrayList<Client> clientList;
    private ArrayList<Product> products;
    private ArrayList<Order> orderList;
    private ArrayList<User> users;
    private ArrayList<Employee> employees;

    private User currentUser;
    private  User lastUser;

    public Restaurant(){
        clientList = new ArrayList<>();
        products = new ArrayList<>();
        orderList = new ArrayList<>();
        users = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getLastUser() {
        return lastUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setLastUser(User lastUser) {
        this.lastUser = lastUser;
    }
}
