package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public final static String SAVE_PATH_FILE_USERS = "data/users.txt";
    public final static String SAVE_PATH_FILE_CLIENTS = "data/clients.txt";

    //Relationship.
    private ArrayList<Client> clientList;
    private ArrayList<Product> products;
    private ArrayList<Order> orderList;
    private List<User> users;
    private ArrayList<Employee> employees;

    private User currentUser;
    private  User lastUser;

    /**
     * Instantiates a new Restaurant.
     */
    public Restaurant(){
        clientList = new ArrayList<>();
        products = new ArrayList<>();
        orderList = new ArrayList<>();
        users = new ArrayList<>();
        employees = new ArrayList<>();
    }

    //Getters and Setters.

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public List<User> getUsers() {
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


    /**
     * Can login boolean.
     * This method checks that the user's data is correct for enter the main menu.
     * <b> pre: </b> previous has to exist a user created.
     * <b> pos: </b> if the data is correct the user can enter the main menu.
     * @param userName the userName is type String.
     * @param passWord the passWord is type String.
     * @return the can is type boolean.
     */
    public Boolean canLogin(String userName , String passWord){
        boolean can = false;
        for (int i = 0; i <users.size() && !can ; i++) {
            if (userName.equals(users.get(i).getUserName()) && passWord.equals(users.get(i).getPassword())) {
                can = true;

            }
        }

        return  can;
    }

    //--------------------------------------USERS REQUIREMENTS--------------------------------------------
    /**
     * Create user.
     * This method create and add a new user in a arraylist <br>
     * @param nameE           the nameE is type String.
     * @param lastnameE       the lastnameR is type String.
     * @param identificationE the identificationE is type String.
     * @param userName        the userName is type String.
     * @param password        the password is type String.
     */
    public void createUser(String nameE, String lastnameE, String identificationE, String userName , String password){
        users.add(new User(nameE,lastnameE,identificationE,userName,password));
    }

    /**
    * UpdateInfo
    * it updates the info of an object (user) <br>
    * <b> pre: the list users must have at least an user <br>
    * @param username,  the username of the user
    * @param password , the password of the user
    * @param update , the new information
    * @param type , for indicating the type of field that will be updated
    * */

    public void updateInfo(String username, String password, String update , int type){
        boolean found=false;
        for (int i = 0; i <users.size() && !found; i++) {
            if (username.equals(users.get(i).getUserName())&& password.equals(users.get(i).getPassword())){
                switch (type){
                    case 0: (users.get(i)).setUserName(update);
                             break;
                    case 1: (users.get(i)).setPassword(update);
                             break;
                }
                found = true;

            }

        }

    }

    /**
     * Delete <br>
     * it deletes the an object from the list (User)
     * <b> pre: the list users must have at least an user <br>
     * @param userName , the username of the user
     * @return  boolean , true if it was found false if it was not found
     */


    public boolean delete(String userName){
        boolean deleted = false;
        for (int i = 0; i <users.size() && !deleted; i++) {
            if(userName.equals(users.get(i).getUserName())){
                users.remove(i);
                deleted=true;
            }
        }

        return deleted;
    }
    /**
     * ToDisable <br>
     * it deletes the an object from the list (User) <br>
     * @param  username , the user name of the user
     * @return  boolean , true if it was found false if it was not found
     */


    public boolean toDisable(String username){
        boolean disable = false;
        for (int i = 0; i <users.size() && !disable ; i++) {
            if(username.equals(users.get(i).getUserName())){
                users.get(i).setWorks(false);
                disable = true;
            }
        }
        return disable;
    }


    /**
     * Save data users.
     * This method save the data of the users in the system (file.txt)
     * @throws IOException the io exception
     */
    public void saveDataUsers() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_USERS));
         oos.writeObject(users);
         oos.close();
    }


    /**
     * Load data user.
     * This method load the data of the users.
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void loadDataUser() throws IOException, ClassNotFoundException {
        File f = new File(SAVE_PATH_FILE_USERS);
        boolean loaded = false;
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            users = (ArrayList<User>) ois.readObject();
            ois.close();
            loaded = true;
        }

    }
  //--------------------------------------------------------------------------------------------------------

  //-----------------------REQUIREMENTS INGREDIENTS----------------------------------------------------------

   public void  createIngredient() {
   }

    //__________________________ CLIENTES LOGICA ____________________________________-

    public void createClient(String name, String lastName, String identification, String address){
        clientList.add(new Client(name, lastName, identification, address));
       }

    public void saveDataClients() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CLIENTS));
        oos.writeObject(clientList);
        oos.close();
    }

    public void loadDataClients() throws IOException, ClassNotFoundException {
        File f = new File(SAVE_PATH_FILE_CLIENTS);
        boolean loaded = false;
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            clientList = (ArrayList<Client>) ois.readObject();
            ois.close();
            loaded = true;
        }
    }
}
