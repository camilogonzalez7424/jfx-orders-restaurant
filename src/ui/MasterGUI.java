package ui;

import com.jfoenix.controls.*;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;


public class MasterGUI {

    //Relationship.
    private Restaurant mainRestaurant;

    /* NOTES:
       Attributes = A.
       Methods = M.     */

    //____________________ A. MENU PANEL _______________

    @FXML
    private Label MenuClose;

    @FXML
    private JFXTabPane managementTabs;

    @FXML
    private JFXTextField txtNameM;

    @FXML
    private JFXTextField txtLastNameM;

    @FXML
    private JFXTextField txtIdM;

    @FXML
    private JFXTextField txtAdreesM;

    @FXML
    private JFXSlider Ssize;

    @FXML
    private JFXTextField txtPriceM;

    @FXML
    private JFXTabPane management;

    @FXML
    private Tab TabUser;

    @FXML
    private TableView<User> TUsers;

    @FXML
    private TableColumn< User,String> CnameU;

    @FXML
    private TableColumn< User, String> ClastNameU;

    @FXML
    private TableColumn<User,String> CIdU;

    @FXML
    private TableColumn<User,String> CuserName;

    @FXML
    private Tab TabEmployee;

    @FXML
    private TableView<Employee> TEmployee;

    @FXML
    private TableColumn<Employee,String> CnameE;

    @FXML
    private TableColumn<Employee,String> CLastnameE;

    @FXML
    private TableColumn<Employee,String> CIdE;

    @FXML
    private Tab TabClients;

    @FXML
    private TableView<Client> TClients;

    @FXML
    private TableColumn<Client,String> CnameC;

    @FXML
    private TableColumn<Client,String> ClastNameC;

    @FXML
    private TableColumn<Client,String> CidC;

    @FXML
    private TableColumn<Client,String> Caddress;

    @FXML
    private Tab TabOrders;

    @FXML
    private TableView<Order> Torders;

    @FXML
    private TableColumn<Order,String> Ccode;

    @FXML
    private TableColumn<Order, String> Cdate;

    @FXML
    private TableColumn<Order, String> Cclient;

    @FXML
    private TableColumn<Order, String> Cemployee;

    @FXML
    private TableColumn<Order, String> Cstatus;

    @FXML
    private Tab TabProduct;

    @FXML
    private TableView<Product> Tproducts;

    @FXML
    private TableColumn<Product, String> CnameP;

    @FXML
    private TableColumn<Product, String> CsizeP;

    @FXML
    private TableColumn<Product, String> CpriceP;

    @FXML
    private TableColumn<Product, String> CavalibeP;

    @FXML
    private TableColumn<Product, String> CtypeP;

    @FXML
    private Tab TabIngredients;

    @FXML
    private TableView<Ingredient> TIngredients;

    @FXML
    private TableColumn<Ingredient, String> CnameI;

    @FXML
    private TableColumn<Ingredient, String> CavalibleI;

    @FXML
    private Tab TabType;

    @FXML
    private TableView<TypeProduct> Ttype;

    @FXML
    private TableColumn<TypeProduct, String> CnameType;

    @FXML
    private TableColumn<TypeProduct, String> CnameAvalibleT;

    @FXML
    private Label currentManage;

    @FXML
    private JFXTextField txtIngredient;

    @FXML
    private JFXTextField txtType;

    @FXML
    private JFXComboBox<TypeProduct> comboType;

    @FXML
    private JFXTextField txtProduct;



    //------------------------------------------

    //________________A.ORDERS PANE_____________
    @FXML
    private JFXComboBox<Product> comboProducts;

    @FXML
    private TableView<Product> TorderProduct;

    @FXML
    private TableColumn<Product, String> CproductsOrder;

    @FXML
    private JFXTextField txtClientName;

    @FXML
    private JFXComboBox<Employee> comboEmployee;


    //_____________ A. MAIN PANEL ____________
    @FXML
    private BorderPane borderPane;

    //____________________________________

    //_____________ A. LOGIN PANEL ___________
    @FXML
    private JFXTextField txtLoginUser;

    @FXML
    private JFXPasswordField txtLoginPass;

    //---------------------------------

    //________________ A. REGISTER PANEL _________________
     @FXML
     private JFXTextField txtPassword;

     @FXML
     private JFXTextField txtName;

     @FXML
     private JFXTextField txtUserName;

     @FXML
     private JFXTextField txtLastName;

     @FXML
     private JFXTextField txtId;

     //------------------------------------------------------------

    //_________________ MASTERGUI _______________________

    /**
     * Constructor method.
     */
    public MasterGUI(){
        mainRestaurant = new Restaurant();
    }


    public BorderPane getBorderPane() {
        try {
            mainRestaurant.loadDataUser();
        }catch (Exception e){
            System.out.println("Nothing yet");
        }

        return borderPane;
    }
    //_________________________________________________


//________________ M. LOGIN PANEL __________________
    /**
     * Log in.
     * This method performs an action. This method performs an action.
     * Open the menu panel if the user exists and enter their data correctly.
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void logIn(ActionEvent event) throws IOException {

        if (mainRestaurant.canLogin(txtLoginUser.getText(),txtLoginPass.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
            fxmlLoader.setController(this);
            Parent menuPane = fxmlLoader.load();
            borderPane.setCenter(menuPane);

        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("We can not find you :(");
            alert.setHeaderText("Look the problem");
            alert.setContentText("Check your data if have account"+"\n"+"or please create an account :)");
            alert.showAndWait();

        }


    }

    /**
     * Sign up.
     * This method performs an action. Open the panel to register.
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader.setController(this);
        Parent signUpPane = fxmlLoader.load();

        borderPane.setCenter(signUpPane);

    }
    //_____________________________________________


    //________________ M. REGISTER PANEL _________________

    /**
     * Create user.
     * This method performs an action. Create an user and open menu panel.
     * @param event the event
     * @throws IOException the io exception
     */
    public void createUser(ActionEvent event) throws IOException {
        String name , lastName, userName, password, id;
        name = txtName.getText();
        lastName = txtLastName.getText();
        userName = txtUserName.getText();
        password = txtPassword.getText();
        id = txtId.getText();

        if (name.equals("")|| lastName.equals("")|| id.equals("")||userName.equals("") || password.equals("") ){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("¡Incomplete data!");
            alert.setHeaderText("Look the problem");
            alert.setContentText("Please fill all the blanks :)");
            alert.showAndWait();
            txtName.setText("");
            txtLastName.setText("");
            txtUserName.setText("");
            txtPassword.setText("");
            txtId.setText("");

        }else {
            mainRestaurant.createUser(name,lastName,id,userName,password);
            mainRestaurant.saveDataUsers();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
            fxmlLoader.setController(this);
            Parent menuPane = fxmlLoader.load();
            borderPane.setCenter(menuPane);

        }
    }

    /**
     * To back.
     * This method performs an action. Return to the login panel from the register panel.
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void toBack(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent loginBack = fxmlLoader.load();

        borderPane.setCenter(loginBack);
    }


    //____________________ M. MENU PANEL _______________

    /**
     * Exit button.
     * This method performs an action. Return to the login panel from the menu panel.
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void exitButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent loginBack = fxmlLoader.load();

        borderPane.setCenter(loginBack);
    }

    @FXML
    public void setTabUsers(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        management = fxmlLoader.load();
        TabUser = management.getTabs().get(0);
        managementTabs.getTabs().addAll(TabUser);


    }

    @FXML
    public void setTabEmployee(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        management = fxmlLoader.load();
        TabEmployee = management.getTabs().get(1);
        managementTabs.getTabs().addAll(TabEmployee);


    }

    @FXML
    public void setTabClients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        management = fxmlLoader.load();
        TabClients = management.getTabs().get(2);
        managementTabs.getTabs().addAll(TabClients);


    }
    @FXML
    public void setTabOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        management = fxmlLoader.load();
        TabOrders = management.getTabs().get(3);
        managementTabs.getTabs().addAll(TabOrders);


    }
    @FXML
    public void setTabProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        management = fxmlLoader.load();
        TabProduct = management.getTabs().get(4);
        managementTabs.getTabs().addAll(TabProduct);


    }
    @FXML
    public void setTabIngredients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        management = fxmlLoader.load();
        TabIngredients = management.getTabs().get(5);
        managementTabs.getTabs().addAll(TabIngredients);


    }
    @FXML
    public void setTabType(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        management = fxmlLoader.load();
        TabType = management.getTabs().get(6);
        managementTabs.getTabs().addAll(TabType);



    }

    @FXML
    public void newEmployee(ActionEvent event){
        if (txtNameM.isVisible() && txtLastNameM.isVisible() && txtIdM.isVisible()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("A new Employee has been created");
            alert.showAndWait();
        }else{
            currentManage.setText("Employee");
            txtNameM.setVisible(true);
            txtLastNameM.setVisible(true);
            txtIdM.setVisible(true);
            txtAdreesM.setVisible(false);
            Ssize.setVisible(false);
            txtPriceM.setVisible(false);
            txtIngredient.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(false);
            comboType.setVisible(false);

        }

    }

    @FXML
    public void newClient(ActionEvent event){
        if (txtNameM.isVisible() && txtLastNameM.isVisible() && txtIdM.isVisible() && txtAdreesM.isVisible()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("A new Client has been registered");
            alert.showAndWait();
        }else{
            currentManage.setText("Client");
            txtNameM.setVisible(true);
            txtLastNameM.setVisible(true);
            txtIdM.setVisible(true);
            txtAdreesM.setVisible(true);
            Ssize.setVisible(false);
            txtPriceM.setVisible(false);
            txtIngredient.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(false);
            comboType.setVisible(false);

        }

    }
    @FXML
    public void newIngredient(ActionEvent event){
        if (txtIngredient.isVisible()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("A new Ingredient has been created");
            alert.showAndWait();
        }else{
            currentManage.setText("Ingredient");
            txtIngredient.setVisible(true);
            txtNameM.setVisible(false);
            txtLastNameM.setVisible(false);
            txtIdM.setVisible(false);
            txtAdreesM.setVisible(false);
            Ssize.setVisible(false);
            txtPriceM.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(false);
            comboType.setVisible(false);

        }

    }
    @FXML
    public void newType(ActionEvent event){
        if (txtType.isVisible()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("A new Type of product has been created");
            alert.showAndWait();
        }else{
            currentManage.setText("Type of product");
            txtIngredient.setVisible(false);
            txtNameM.setVisible(false);
            txtLastNameM.setVisible(false);
            txtIdM.setVisible(false);
            txtAdreesM.setVisible(false);
            Ssize.setVisible(false);
            txtPriceM.setVisible(false);
            txtType.setVisible(true);
            txtProduct.setVisible(false);
            comboType.setVisible(false);

        }

    }
    @FXML
    public void newProduct(ActionEvent event){
        if (Ssize.isVisible() && txtProduct.isVisible() && comboType.isVisible() ){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("A new product has been created");
            alert.showAndWait();
        }else{
            currentManage.setText("Product");
            txtNameM.setVisible(false);
            txtLastNameM.setVisible(false);
            txtIdM.setVisible(false);
            txtAdreesM.setVisible(false);
            Ssize.setVisible(true);
            txtPriceM.setVisible(false);
            txtIngredient.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(true);
            comboType.setVisible(true);


        }

    }

    @FXML
    public  void  create(ActionEvent event){
        switch (currentManage.getText()){
            case "Employee": newEmployee(event);
                            break;
            case "Client" : newClient(event);
                             break;
            case "Product": newProduct(event);
                             break;
            case "Type of product": newType(event);
                                    break;
            case "Ingredients": newIngredient(event);
                                 break;
            default:  Alert alert = new Alert(AlertType.INFORMATION);
                     alert.setContentText("Select something to manage");
                     alert.showAndWait();

        }

    }

    @FXML
    public void orderPane(ActionEvent event) throws IOException {
        FXMLLoader open= new FXMLLoader(getClass().getResource("ordersPane.fxml"));
        Parent root =open.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("New Order");
        stage.showAndWait();

    }

    
}
