package model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Restaurant {

    public final static String SAVE_PATH_FILE_USERS = "data/users.txt";
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

    public Boolean canLogin(String userName){
        boolean can = false;
        for (int i = 0; i <users.size() && !can ; i++) {
            if (userName.equals(users.get(i).getUserName())) {
                can = true;

            }
        }

        return  can;
    }

    public void createUser(String nameE, String lastnameE, String identificationE, String userName , String password){
        users.add(new User(nameE,lastnameE,identificationE,userName,password));
    }

    public void saveDataUsers() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_USERS));
         oos.writeObject(users);
         oos.close();
    }

    public boolean loadDataUser() throws IOException, ClassNotFoundException {
        File f = new File(SAVE_PATH_FILE_USERS);
        boolean loaded = false;
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            users = (ArrayList<User>) ois.readObject();
            ois.close();
            loaded = true;
        }
        return loaded;

    }


}
