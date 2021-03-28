package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Restaurant {
    public final static String SAVE_PATH_FILE_USERS = "data/users.txt";
    public final static String SAVE_PATH_FILE_CLIENTS = "data/clients.txt";
    public final static String SAVE_PATH_FILE_INGREDIENTS = "data/ingredients.txt";
    public final static String SAVE_PATH_FILE_EMPLOYEES = "data/employees.txt";
    public final static String SAVE_PATH_FILE_PRODUCTS = "data/products.txt";
    public final static String SAVE_PATH_FILE_ORDERS = "data/orders.txt";
    public final static String SAVE_PATH_FILE_TYPES = "data/types.txt";

    //Atributes
    private  int clientSearchedIndex; // es el indice del cliente que se busca a la hora de hacer una orden

    //Relationship.
    private ArrayList<Client> clientList;
    private ArrayList<Product> products;
    private ArrayList<Order> orderList;
    private List<User> users;
    private ArrayList<Employee> employees;
    private ArrayList<Ingredient> ingredientsList;
    private ArrayList<TypeProduct> typeProducts;

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
        ingredientsList = new ArrayList<>();
        typeProducts = new ArrayList<>();
        clientSearchedIndex=0;

    }

    //Getters and Setters.



    public int getClientSearched() {
        return clientSearchedIndex;
    }

    public void setClientSearchedIndex(int clientSearched) {
        clientSearchedIndex = clientSearched;
    }

    public ArrayList<TypeProduct> getTypeProducts() {
        return typeProducts;
    }

    public ArrayList<Ingredient> getIngredientsList() {
        return ingredientsList;
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
                setCurrentUser(users.get(i));
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
        User newUser =new User(nameE,lastnameE,identificationE,userName,password);
        users.add(newUser);
        employees.add(newUser);
        setCurrentUser(newUser);
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
                users.get(i).setHabilitate(false);
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
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            users = (ArrayList<User>) ois.readObject();
            ois.close();
        }

    }
  //--------------------------------------------------------------------------------------------------------

  //-----------------------REQUIREMENTS INGREDIENTS----------------------------------------------------------

    /**/
   public void  createIngredient(String name) {
       Ingredient newIngredient = new Ingredient(name);
       newIngredient.setCreatorU(getCurrentUser());
       ingredientsList.add(newIngredient);
   }
    public boolean deleteIngredient(String name){
        boolean deletedIngredient = false;
        for (int i = 0; i <ingredientsList.size() && !deletedIngredient; i++) {
            if(name.equals(ingredientsList.get(i).getNameI())){
                ingredientsList.remove(i);
                deletedIngredient=true;
            }
        }
        return deletedIngredient;
    }

    public boolean disableIngredients(String name){
        boolean disable = false;
        for (int i = 0; i <ingredientsList.size() && !disable ; i++) {
            if(name.equals(ingredientsList.get(i).getNameI())){
                ingredientsList.get(i).setAvailable(false);
                disable = true;
            }
        }
        return disable;
    }

    public void saveIngredients() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_INGREDIENTS));
        oos.writeObject(ingredientsList);
        oos.close();
    }

    public void loadDataIngredients() throws IOException, ClassNotFoundException {
        File f1 = new File(SAVE_PATH_FILE_INGREDIENTS);
        if(f1.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
            ingredientsList = (ArrayList<Ingredient>) ois.readObject();
            ois.close();
        }

    }
//-------------------------------------------------------------------------------------------------------------

// ------------------------------------- EMPLOYEES REQUIREMENTS-------------------------------------------------

    public void createEmployee(String name, String lastname, String identification){
       Employee newEmployee = new Employee(name,lastname,identification);
       newEmployee.setCurrentUser(getCurrentUser());
       employees.add(newEmployee);

    }


    public boolean deleteEmployee(String name){
        boolean deleEmployee = false;
        for (int i = 0; i <employees.size() && !deleEmployee; i++) {
            if(name.equals(employees.get(i).getName())){
                users.remove(employees.get(i));
                employees.remove(i);
                deleEmployee=true;
            }
        }
        return deleEmployee;

    }

    public boolean disableEmployee(String name){
        boolean disable = false;
        int index;
        for (int i = 0; i <employees.size() && !disable ; i++) {
            if(name.equals(employees.get(i).getName())){
                employees.get(i).setHabilitate(false);
                index = users.indexOf(employees.get(i));
                users.get(index).setHabilitate(false);
                disable = true;
            }
        }
        return disable;
    }

    public void saveDataEmployees() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_EMPLOYEES));
        oos.writeObject(employees);
        oos.close();
    }

    public void loadDataEmployees() throws IOException, ClassNotFoundException {
        File f1 = new File(SAVE_PATH_FILE_EMPLOYEES);
        if(f1.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
            employees = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }

    }

//------------------------------------------------------------------------------------------------------------------------

// __________________________ CLIENTS REQUIREMENTS ____________________________________-

    /**
     * Create client.
     * @param name           the name
     * @param lastName       the last name
     * @param identification the identification
     * @param address        the address
     */
    public void createClient(String name, String lastName, String identification, String address,String telephone){
        Client newClient = new Client(name, lastName, identification, address,telephone);
        newClient.setCurrentUser(getCurrentUser());
        Collections.sort(clientList);
        addSorted(newClient);
    }

    /**
     * <b> Pre: the list musts be sorted</b>
     */

    public void addSorted(Client newClient){
          if(clientList.isEmpty()){
              clientList.add(newClient);
          }else{
             int i=0;
             while (i<clientList.size() && newClient.compareTo(clientList.get(i))>0){
                 i++;
             }
             clientList.add(i,newClient);
          }
    }

    /*public void insertionSort(){
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < p.size(); i++) {
            a.add(products.get(i).getPrice());
        }
        System.out.println(a);
        Integer[] array = new Integer[a.size()];
        for(int i = 0; i < array.length; i++){
            array = a.toArray(new Integer [0]);
        }
        //insertionSort
        System.out.println(Arrays.toString(array));

        for(int i =1; i < array.length; i++) {
            for(int j = i; j>0 && array[j-1]>array[j];j--) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
        for(int i = 1; i < products.size(); i++){
            for(int j = i; j>0 && products.get(j-1).getPrice()>products.get(j).getPrice();j--){
                int temp = products.get(j).getPrice();
                products.get(j).getPrice() = products.get(j).getPrice();
                products.get(j-1).getPrice() = temp;
            }
        }

    }*/

    public void insertionSortArrayList(List<Product> list) {
        for (int j = 1; j < list.size(); j++) {
            Product current = list.get(j);
            int i = j-1;
            while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
                list.set(i+1, list.get(i));
                i--;
            }
            list.set(i+1, current);
        }
    }

    /**
     * Save data clients.
     *
     * @throws IOException the io exception
     */
    public void saveDataClients() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CLIENTS));
        oos.writeObject(clientList);
        oos.close();
    }

    /**
     * Load data clients.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
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



    /**
     * Delete client boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean deleteClient(String name){
        boolean deleClient = false;
        for (int i = 0; i <clientList.size() && !deleClient; i++) {
            if(name.equals(clientList.get(i).getName())){
                clientList.remove(i);
                deleClient=true;
            }
        }
        return deleClient;

    }

    /**
     * Disable client boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean disableClient(String name){
        boolean disable = false;
        for (int i = 0; i <clientList.size() && !disable ; i++) {
            if(name.equals(clientList.get(i).getName())){
                clientList.get(i).setHabilitate(false);
                disable = true;
            }
        }
        return disable;
    }

//------------------------------------------------------------------------------------------------------------------------

//__________________________ PRODUCTS REQUIREMENTS _______________________________________________________________________

    /**
     * Create product.
     *
     * @param nameP the nameP is type String
     * @param size  the size
     * @param price the price
     * @param name the nameT
     */
    public void createProduct(String nameP, String size, int price, String name, ArrayList<Ingredient> ichoosen){
        TypeProduct nameT;
        boolean found=false;
        for (int i = 0; i <typeProducts.size() && !found; i++) {
            if (typeProducts.get(i).getName().equals(name)){
                nameT = typeProducts.get(i);
                Product newProduct =new Product(nameP,size,price,nameT);
                newProduct.setIngredients(ichoosen);
                newProduct.setCreatorU(getCurrentUser());
                products.add(newProduct);
                found = true;
            }
        }

    }

    /**
     * Save data product.
     *
     * @throws IOException the io exception
     */
    public void saveDataProduct() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCTS));
        oos.writeObject(products);
        oos.close();
    }

    /**
     * Load data product.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void loadDataProduct() throws IOException, ClassNotFoundException {
        File f = new File(SAVE_PATH_FILE_PRODUCTS);
        boolean loaded = false;
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            products = (ArrayList<Product>) ois.readObject();
            ois.close();
            loaded = true;
        }
    }



    /**
     * Delete product boolean.
     *
     * @param nameP the nameP
     * @return the boolean
     */
    public boolean deleteProduct(String nameP){
        boolean deleProduct = false;
        for (int i = 0; i <products.size() && !deleProduct; i++) {
            if(nameP.equals(products.get(i).getNameP())){
                products.remove(i);
                deleProduct=true;
            }
        }
        return deleProduct;

    }

    /**
     * Disable product boolean.
     *
     * @param nameP the name p
     * @return the boolean
     */
    public boolean disableProduct(String nameP){
        boolean disable = false;
        for (int i = 0; i <products.size() && !disable ; i++) {
            if(nameP.equals(products.get(i).getNameP())){
                products.get(i).setAvailable(false);
                disable = true;
            }
        }
        return disable;
    }

//------------------------------------------------------------------------------------------------------------------------

//__________________________ ORDERS REQUIREMENTS _______________________________________________________________________


    public void createOrder(String employee, int client, String address, ArrayList<Product> productsIn, String name, Date date){
        boolean out=false;
        Client newClient=null;
        int amount =0;
        Employee employeeAttending=null;
        if (client>=0){
            newClient = clientList.get(client);
        }else{
            for (int i = 0; i <clientList.size() && !out ; i++) {
                 if(name.equals(clientList.get(i).getName())){
                     newClient = clientList.get(i);
                     out = true;
                 }

            }
        }

        for (int i = 0; i <employees.size() && !out ; i++) {
            if (employee.equals(employees.get(i).getName())){
                employeeAttending = employees.get(i);
                out= true;
            }
        }

        if (employeeAttending!=null && newClient!=null){
            Order newOrder = new Order(newClient,employeeAttending,address);
            newOrder.setDate(date);
            newOrder.setProductsList(productsIn);
            newOrder.setCreatorU(getCurrentUser());
            orderList.add(newOrder);
            employeeAttending.getAmountOfOrders().add(newOrder);

        }else{
            System.out.println("hay algo null");
        }


    }

    /**
     * Create order.
     *
     * @param feedback the feedback
     */
    public void createOrder(String employee, int client, String address,String feedback, ArrayList<Product> productsIn, String name, Date date){
        Client newClient1 = null;
        Employee employeeAttending=null;
        boolean out=false;
        if (client>=0){
            newClient1 = clientList.get(client);
        }else{
            for (int i = 0; i <clientList.size() && !out ; i++) {
                if(name.equals(clientList.get(i).getName())){
                    newClient1 = clientList.get(i);
                    out = true;
                }

            }
        }

        for (int i = 0; i <employees.size() && !out ; i++) {
            if (employee.equals(employees.get(i).getName())){
                employeeAttending = employees.get(i);
                out= true;
            }
        }

        if (employeeAttending!=null && newClient1!=null){
            Order newOrder = new Order(newClient1,employeeAttending,address);
            newOrder.setDate(date);
            newOrder.setProductsList(productsIn);
            newOrder.setCreatorU(getCurrentUser());
            employeeAttending.getAmountOfOrders().add(newOrder);

            orderList.add(newOrder);

        }else{
            System.out.println("hay algo null");
        }







    }



    /**
     * Save data order.
     *
     * @throws IOException the io exception
     */
    public void saveDataOrder() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_ORDERS));
        oos.writeObject(orderList);
        oos.close();
    }

    /**
     * Load data order.
     *
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void loadDataOrder() throws IOException, ClassNotFoundException {
        File f = new File(SAVE_PATH_FILE_ORDERS);
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            orderList = (ArrayList<Order>) ois.readObject();
            ois.close();
        }
    }

    /**
     * Delete order boolean.
     *
     * @param code the code
     * @return the boolean
     */
    public boolean deleteOrder(String code){
        boolean deleOrder = false;
        for (int i = 0; i <orderList.size() && !deleOrder; i++) {
            if(code.equals(orderList.get(i).getCode())){
                orderList.remove(i);
                deleOrder=true;
            }
        }
        return deleOrder;

    }

    /**
     * Disable order boolean.
     *
     * @param code the code
     * @return the boolean
     */
    public boolean disableOrder(String code){
        boolean disable = false;
        for (int i = 0; i <orderList.size() && !disable ; i++) {
            if(code.equals(orderList.get(i).getCode())){
                orderList.get(i).setAvailable(false);
                disable = true;
            }
        }
        return disable;
    }

//_________________________ EXPORT DATA _________________________________________

    /**
     * Export data user.
     *
     * @param fileName  the file name
     * @param separator the separator
     * @throws FileNotFoundException the file not found exception
     */
    public void exportDataUser(String fileName,String separator) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(fileName);

        for(int i=0;i<users.size();i++){
            User myUser = users.get(i);
            pw.println(myUser.getName()+separator+myUser.getLastName()
                +separator+myUser.getIdentification()
                +separator+myUser.getUserName()+separator+myUser.getPassword());
        }

        pw.close();
    }

    /**
     * Export data employee.
     *
     * @param fileName  the file name
     * @param separator the separator
     * @throws FileNotFoundException the file not found exception
     */
    public void exportDataEmployee(String fileName,String separator) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(fileName);

        for(int i=0;i<employees.size();i++){
            Employee myEmployee = employees.get(i);
            pw.println(myEmployee.getName()+separator+myEmployee.getLastName()+separator+myEmployee.getIdentification());
        }

        pw.close();
    }

    /**
     * Export data client.
     *
     * @param fileName  the file name
     * @param separator the separator
     * @throws FileNotFoundException the file not found exception
     */
    public void exportDataClient(String fileName,String separator) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(fileName);

        for(int i=0;i<clientList.size();i++){
            Client myClient = clientList.get(i);
            pw.println(myClient.getName()+separator+myClient.getLastName()
                    +separator+myClient.getIdentification()+separator+myClient.getAddress());
        }

        pw.close();
    }

    /**
     * Export data ingredient.
     *
     * @param fileName  the file name
     * @param separator the separator
     * @throws FileNotFoundException the file not found exception
     */
    public void exportDataIngredient(String fileName,String separator) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(fileName);

        for(int i=0;i<ingredientsList.size();i++){
            Ingredient myIngredient = ingredientsList.get(i);
            pw.println(myIngredient.getNameI());
        }

        pw.close();
    }

    /**
     * Export data product.
     *
     * @param fileName  the file name
     * @param separator the separator
     * @throws FileNotFoundException the file not found exception
     */
    public void exportDataProduct(String fileName,String separator) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(fileName);

        for(int i=0;i< products.size();i++){
            Product myProduct = products.get(i);
            pw.println(myProduct.getNameP()+separator+myProduct.getSize()+separator+
                    myProduct.getPrice()+separator+myProduct.getType());
        }

        pw.close();
    }

    /**
     * Export data order.
     *
     * @param fileName  the file name
     * @param separator the separator
     * @throws FileNotFoundException the file not found exception
     */
    public void exportDataOrder(String fileName,String separator) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(fileName);

        for(int i=0;i<orderList.size();i++){
            Order myOrder = orderList.get(i);
            pw.println(myOrder.getCode()+separator+myOrder.getFeedback());
        }

        pw.close();
    }


//_______________________________________________________________________________

//______________________TYPE REQUIREMNTS__________________________________________

   public void createType(String name){
        TypeProduct newType = new TypeProduct(name);
        typeProducts.add(newType);
   }



    public boolean deleteType(String name){
        boolean deletedType = false;
        for (int i = 0; i <typeProducts.size() && !deletedType; i++) {
            if(name.equals(typeProducts.get(i).getName())){
                typeProducts.remove(i);
                deletedType=true;
            }
        }
        return deletedType;

    }

    public boolean disableType(String name){
        boolean disable = false;
        for (int i = 0; i <typeProducts.size() && !disable ; i++) {
            if(name.equals(typeProducts.get(i).getName())){
                typeProducts.get(i).setAvailableT(false);
                disable = true;
            }
        }
        return disable;
    }

    public void saveTypes() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_TYPES));
        oos.writeObject(typeProducts);
        oos.close();
    }

    public void loadDataType() throws IOException, ClassNotFoundException {
        File f1 = new File(SAVE_PATH_FILE_TYPES);
        if(f1.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
            typeProducts = (ArrayList<TypeProduct>) ois.readObject();
            ois.close();
        }

    }



























}
