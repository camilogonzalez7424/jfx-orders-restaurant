package ui;

import com.jfoenix.controls.*;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;
import model.Client;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.Product;
import model.Restaurant;
import model.TypeProduct;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.text.SimpleDateFormat;



public class MasterGUI {

    //Relationship.
    private Restaurant mainRestaurant;

    /* NOTES:
       Attributes = A.
       Methods = M.     */

    //____________________ A. MENU PANEL _______________

    @FXML
    private AnchorPane slider;

    @FXML
    private Label MenuClose;

    @FXML
    private Label Menu;

    @FXML
    private JFXTabPane managementTabs;

    @FXML
    private JFXTextField txtNameM;

    @FXML
    private JFXTextField txtTelephoneU;

    @FXML
    private JFXTextField txtLastNameM;

    @FXML
    private JFXTextField txtIdM;

    @FXML
    private JFXTextField txtAdreesM;

    @FXML
    private JFXComboBox<String> comboSize;

    @FXML
    private JFXTextField txtPriceM;

    @FXML
    private JFXTabPane management;

    @FXML
    private Tab TabUser;

    @FXML
    private TableView<User> TUsers;

    @FXML
    private TableColumn<User, String> CnameU;

    @FXML
    private TableColumn<User, String> ClastNameU;

    @FXML
    private TableColumn<User, String> CIdU;

    @FXML
    private TableColumn<User, String> CuserName;

    @FXML
    private Tab TabEmployee;

    @FXML
    private TableView<Employee> TEmployee;

    @FXML
    private TableColumn<Employee, String> CnameE;

    @FXML
    private TableColumn<Employee, String> CLastnameE;

    @FXML
    private TableColumn<Employee, String> CIdE;

    @FXML
    private Tab TabClients;

    @FXML
    private TableView<Client> TClients;

    @FXML
    private TableColumn<Client, String> CnameC;

    @FXML
    private TableColumn<Client, String> ClastNameC;

    @FXML
    private TableColumn<Client, String> CidC;

    @FXML
    private TableColumn<Client, String> Caddress;

    @FXML
    private TableColumn<Client, String> Ctelefono;

    @FXML
    private Tab TabOrders;

    @FXML
    private TableView<Order> Torders;

    @FXML
    private TableColumn<Order, String> Ccode;

    @FXML
    private TableColumn<Order, String> Cdate;

    @FXML
    private TableColumn<Order, String> Cclient;

    @FXML
    private TableColumn<Order, String> Cemployee;

    @FXML
    private TableColumn<Order, String> Cstatus;

    @FXML
    private TableColumn<Order, String> CamountP;

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
    private JFXComboBox<String> comboType;

    @FXML
    private JFXTextField txtProduct;


    //------------------------------------------

    //________________A.ORDERS PANE_____________
    @FXML
    private JFXComboBox<String> comboProducts;

    @FXML
    private TableView<Product> TorderProduct;

    @FXML
    private TableColumn<Product, String> CproductsOrder;

    @FXML
    private JFXTextField txtClientName;

    @FXML
    private JFXComboBox<String> comboEmployee;

    @FXML
    private JFXTextField txtAddressOrder;

    @FXML
    private JFXTextArea txtFeedBack;

    @FXML
    private JFXToggleButton orderFeedback;

    @FXML
    private Label labelDate;

    @FXML
    private Label labelPrice;



    //_____________ A. MAIN PANEL ____________
    @FXML
    private BorderPane borderPane;

    //____________________________________

    //_____________ A. LOGIN PANEL ___________
    @FXML
    private JFXTextField txtLoginUser;

    @FXML
    private JFXPasswordField txtLoginPass;

    @FXML
    private Tooltip toolTipPass;






    //____________________________________________________________________

    //_____________________ A. REGISTER PANEL ____________________________
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
    public MasterGUI() {
        mainRestaurant = new Restaurant();
    }


    public BorderPane getBorderPane() {
        try {
            mainRestaurant.loadDataUser();
            mainRestaurant.loadDataClients();
            mainRestaurant.loadDataEmployees();
            mainRestaurant.loadDataIngredients();
            mainRestaurant.loadDataType();
            mainRestaurant.loadDataProduct();
            mainRestaurant.loadDataOrder();
        } catch (Exception e) {
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
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void logIn(ActionEvent event) throws IOException {

        if (mainRestaurant.canLogin(txtLoginUser.getText(), txtLoginPass.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
            fxmlLoader.setController(this);
            Parent menuPane = fxmlLoader.load();
            borderPane.setCenter(menuPane);



        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("No podemos encontrarte :(");
            alert.setHeaderText("Mira el problema");
            alert.setContentText("Revisa tus datos" + "\n" + "o crea una cuenta por favor :)");
            alert.showAndWait();



        }


    }

    /**
     * Sign up.
     * This method performs an action. Open the panel to register.
     *
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


    @FXML
    void showPass(MouseEvent event) {

        toolTipPass.setText("");
        txtLoginPass.textProperty().bindBidirectional(toolTipPass.textProperty());
        toolTipPass.setAutoHide(false);
    }



    //_____________________________________________


    //________________ M. REGISTER PANEL _________________

    /**
     * Create user.
     * This method performs an action. Create an user and open menu panel.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void createUser(ActionEvent event) throws IOException {
        String name, lastName, userName, password, id;
        name = txtName.getText();
        lastName = txtLastName.getText();
        userName = txtUserName.getText();
        password = txtPassword.getText();
        id = txtId.getText();

        if (name.equals("") || lastName.equals("") || id.equals("") || userName.equals("") || password.equals("")) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("¡Datos Incompletos!");
            alert.setHeaderText("Mira el problema");
            alert.setContentText("Por favor llena los espacios en blanco :)");
            alert.showAndWait();
            txtName.setText("");
            txtLastName.setText("");
            txtUserName.setText("");
            txtPassword.setText("");
            txtId.setText("");

        } else {
            mainRestaurant.createUser(name, lastName, id, userName, password);
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
     *
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
     *
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


    public void exportOrder(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Export File");
        File file = fileChooser.showSaveDialog(borderPane.getScene().getWindow());
        try {
            mainRestaurant.exportDataOrder(file.getAbsolutePath());
        } catch (FileNotFoundException e) {

        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Pedidos Exportadas");
        alert.setContentText("Los pedidos fueron exportados");
        alert.showAndWait();
    }

    @FXML
    public void setTabUsers(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        fxmlLoader.setController(this);
        management = fxmlLoader.load();
        TabUser = management.getTabs().get(0);
        managementTabs.getTabs().addAll(TabUser);
        initializeTables();




    }

    @FXML
    public void setTabEmployee(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        fxmlLoader.setController(this);
        management = fxmlLoader.load();
        TabEmployee = management.getTabs().get(1);
        managementTabs.getTabs().addAll(TabEmployee);
        initializeTables();

    }

    @FXML
    public void setTabClients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        fxmlLoader.setController(this);
        management = fxmlLoader.load();
        TabClients = management.getTabs().get(2);
        managementTabs.getTabs().addAll(TabClients);
        initializeTables();

    }

    @FXML
    public void setTabOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        fxmlLoader.setController(this);
        management = fxmlLoader.load();
        TabOrders = management.getTabs().get(3);
        managementTabs.getTabs().addAll(TabOrders);
        initializeTables();

    }

    @FXML
    public void setTabProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        fxmlLoader.setController(this);
        management = fxmlLoader.load();
        TabProduct = management.getTabs().get(4);
        managementTabs.getTabs().addAll(TabProduct);
        initializeTables();

    }

    @FXML
    public void setTabIngredients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        fxmlLoader.setController(this);
        management = fxmlLoader.load();
        TabIngredients = management.getTabs().get(5);
        managementTabs.getTabs().addAll(TabIngredients);
        initializeTables();

    }

    @FXML
    public void setTabType(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("management.fxml"));
        fxmlLoader.setController(this);
        management = fxmlLoader.load();
        TabType = management.getTabs().get(6);
        managementTabs.getTabs().addAll(TabType);
        initializeTables();

    }

    @FXML
    public void newEmployee(ActionEvent event) throws IOException {
        if (txtNameM.isVisible() && txtLastNameM.isVisible() && txtIdM.isVisible()) {
            String nameE, lastNameE, idE;

            nameE = txtNameM.getText();
            lastNameE = txtLastNameM.getText();
            idE = txtIdM.getText();

            if(txtNameM.getText().equals("") || txtLastNameM.getText().equals("") || txtIdM.getText().equals("")){

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("¡Datos Incompletos!");
                alert.setHeaderText("Mira el problema");
                alert.setContentText("Por favor llena los espacios en blanco :)");
                alert.showAndWait();

                txtNameM.setText("");
                txtLastNameM.setText("");
                txtIdM.setText("");

            } else if(!nameE.equals("") && !lastNameE.equals("") && !idE.equals("")){
                mainRestaurant.createEmployee(nameE,lastNameE,idE);
                mainRestaurant.saveDataEmployees();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("¡Un nuevo Empleado fue creado!");
                alert.showAndWait();

                txtNameM.setText("");
                txtLastNameM.setText("");
                txtIdM.setText("");
                txtAdreesM.setText("");
            }
        } else {
            currentManage.setText("Empleado");
            txtNameM.setVisible(true);
            txtLastNameM.setVisible(true);
            txtIdM.setVisible(true);
            txtAdreesM.setVisible(false);
            comboSize.setVisible(false);
            txtPriceM.setVisible(false);
            txtIngredient.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(false);
            comboType.setVisible(false);
            txtTelephoneU.setVisible(false);

        }

    }

    @FXML
    public void newClient(ActionEvent event) throws IOException {
        if (txtNameM.isVisible() && txtLastNameM.isVisible() && txtIdM.isVisible() && txtAdreesM.isVisible() && txtTelephoneU.isVisible()) {
            String nameC, lastNameC, idC, addressC, telephoneC;

            nameC = txtNameM.getText();
            lastNameC = txtLastNameM.getText();
            idC = txtIdM.getText();
            addressC = txtAdreesM.getText();
            telephoneC = txtTelephoneU.getText();

            if(txtNameM.getText().equals("") || txtLastNameM.getText().equals("") || txtIdM.getText().equals("") || txtAdreesM.getText().equals("") || txtTelephoneU.getText().equals("")){

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("¡Datos Incompletos!");
                alert.setHeaderText("Mira el problema");
                alert.setContentText("Por favor llena los datos en blanco :)");
                alert.showAndWait();

                txtNameM.setText("");
                txtLastNameM.setText("");
                txtIdM.setText("");
                txtAdreesM.setText("");
                txtTelephoneU.setText("");


            } else if(!nameC.equals("") && !lastNameC.equals("") && !idC.equals("") && !addressC.equals("") && !telephoneC.equals("")){
                mainRestaurant.createClient(nameC,lastNameC,idC,addressC,telephoneC);
                mainRestaurant.saveDataClients();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("¡Un nuevo Cliente fue creado!");
                alert.showAndWait();

                txtNameM.setText("");
                txtLastNameM.setText("");
                txtIdM.setText("");
                txtAdreesM.setText("");
                txtTelephoneU.setText("");
            }
        } else {
            currentManage.setText("Cliente");
            txtNameM.setVisible(true);
            txtLastNameM.setVisible(true);
            txtIdM.setVisible(true);
            txtAdreesM.setVisible(true);
            comboSize.setVisible(false);
            txtPriceM.setVisible(false);
            txtIngredient.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(false);
            comboType.setVisible(false);
            txtTelephoneU.setVisible(true);

        }

    }

    @FXML
    public void newIngredient(ActionEvent event) throws IOException {
        if (txtIngredient.isVisible()) {
            String nameI;

            nameI = txtIngredient.getText();

            if(txtIngredient.getText().equals("")){

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("¡Datos Incompletos!");
                alert.setHeaderText("Mira el problema");
                alert.setContentText("Por favor llena los datos en blanco :)");
                alert.showAndWait();

                txtIngredient.setText("");


            } else if(!nameI.equals("")){
                mainRestaurant.createIngredient(nameI);
                mainRestaurant.saveIngredients();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("¡Un nuevo ingrediente fue creado!");
                alert.showAndWait();

                txtIngredient.setText("");

            }
        } else {
            currentManage.setText("Ingrediente");
            txtIngredient.setVisible(true);
            txtNameM.setVisible(false);
            txtLastNameM.setVisible(false);
            txtIdM.setVisible(false);
            txtAdreesM.setVisible(false);
            comboSize.setVisible(false);
            txtPriceM.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(false);
            comboType.setVisible(false);
            txtTelephoneU.setVisible(false);

        }

    }

    @FXML
    public void newType(ActionEvent event) throws IOException {
        if (txtType.isVisible()) {
            String nameT;
            nameT = txtType.getText();

            if(txtType.getText().equals("")){

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("¡Datos Incompletos!");
                alert.setHeaderText("Mira el problema");
                alert.setContentText("Por favor llena los datos en blanco :)");
                alert.showAndWait();

                txtIngredient.setText("");


            } else if(!nameT.equals("")){
                mainRestaurant.createType(nameT);
                mainRestaurant.saveTypes();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("¡Un nuevo Tipo de Producto fue creado!");
                alert.showAndWait();

                txtType.setText("");

            }
        } else {
            currentManage.setText("Tipo de Producto");
            txtIngredient.setVisible(false);
            txtNameM.setVisible(false);
            txtLastNameM.setVisible(false);
            txtIdM.setVisible(false);
            txtAdreesM.setVisible(false);
            comboSize.setVisible(false);
            txtPriceM.setVisible(false);
            txtType.setVisible(true);
            txtProduct.setVisible(false);
            comboType.setVisible(false);
            txtTelephoneU.setVisible(false);

        }

    }

    @FXML
    public void newProduct(ActionEvent event) {
        if (comboSize.isVisible() && txtProduct.isVisible() && comboType.isVisible()&& txtPriceM.isVisible()) {
            if(txtProduct.getText().isEmpty() && comboSize.isPressed() && comboType.isPressed()){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("¡Datos Incompletos!");
                alert.setHeaderText("Mira el problema");
                alert.setContentText("Por favor llena los datos en blanco :)");
                alert.showAndWait();

                txtPriceM.setText("");
                txtProduct.setText("");
            }else{
                try {
                    String name,size;
                    String type;
                    int price;
                    name = txtProduct.getText();
                    size = comboSize.getValue();
                    type = comboType.getValue();
                    price = Integer.parseInt(txtPriceM.getText());
                    mainRestaurant.createProduct(name,size,price,type);
                    mainRestaurant.saveDataProduct();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setContentText("¡Un nuevo Producto fue creado!");
                    alert.showAndWait();

                    txtProduct.setText("");
                    txtPriceM.setText("");

                }catch (Exception e){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setContentText("Selecciona algo y llena los campos.");
                    alert.showAndWait();

                    txtProduct.setText("");
                    txtPriceM.setText("");
                }

            }

        } else {
            currentManage.setText("Producto");
            txtNameM.setVisible(false);
            txtLastNameM.setVisible(false);
            txtIdM.setVisible(false);
            txtAdreesM.setVisible(false);
            comboSize.setVisible(true);
            txtPriceM.setVisible(true);
            txtIngredient.setVisible(false);
            txtType.setVisible(false);
            txtProduct.setVisible(true);
            comboType.setVisible(true);
            txtTelephoneU.setVisible(false);


           /* for (int i = 0; i <mainRestaurant.getTypeProducts().size(); i++) {
                comboType.getItems().addAll(mainRestaurant.getTypeProducts().get(i).getName());

            }*/

            for(int i = 0; i < mainRestaurant.getTypeProducts().size(); i++) {
                if(!comboType.getItems().isEmpty()) {
                    comboType.getItems().removeAll(mainRestaurant.getTypeProducts().get(i).getName());
                }
                comboType.getItems().add(mainRestaurant.getTypeProducts().get(i).getName());

            }



            if (comboSize.getItems().isEmpty()){
                comboSize.setItems(FXCollections.observableArrayList("Familiar", "Mediano","Personal"));
            } else if (!comboSize.getItems().isEmpty()) {
                comboSize.getItems().clear();
                comboSize.setItems(FXCollections.observableArrayList("Familiar", "Mediano","Personal"));

            }

        }

    }

    @FXML
    public void create(ActionEvent event) throws IOException {
        switch (currentManage.getText()) {
            case "Empleado":
                newEmployee(event);
                initializeTables();
                break;
            case "Cliente":
                newClient(event);
                initializeTables();
                break;
            case "Producto":
                newProduct(event);
                initializeTables();
                Tproducts.refresh();
                break;
            case "Tipo de Producto":
                newType(event);
                initializeTables();
                break;
            case "Ingrediente":
                newIngredient(event);
                initializeTables();
                break;
            default:
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Seleccione algo para administrar.");
                alert.showAndWait();

        }

    }

    @FXML
    public void orderPane(ActionEvent event) throws IOException {
        if (mainRestaurant.getClientList().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Lo sentimos");
            alert.setContentText("No hay clientes para hacer pedidos, " + "\npor favor registra uno.");
            alert.showAndWait();
        }else{
            FXMLLoader open = new FXMLLoader(getClass().getResource("ordersPane.fxml"));
            open.setController(this);
            Parent root = open.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Nueva orden");
            if(comboEmployee.getItems().isEmpty()){
                for (int i = 0; i <mainRestaurant.getEmployees().size() ; i++) {
                    comboEmployee.getItems().addAll(mainRestaurant.getEmployees().get(i).getName());
                }
            }

            if (comboProducts.getItems().isEmpty()){
                for (int i = 0; i <mainRestaurant.getProducts().size() ; i++) {
                    comboProducts.getItems().addAll(mainRestaurant.getProducts().get(i).getNameP());

                }

            }

            stage.showAndWait();

        }
            }



    @FXML
    public void searchClient(ActionEvent event){
        int found=-1;
        int i =0;
        int j=mainRestaurant.getClientList().size()-1;
        String name="";
        name = txtClientName.getText();
            long star = System.nanoTime();
            if (!name.equals("")){
                while (i<=j && found<0){
                    int m =(i+j)/2;
                    if(mainRestaurant.getClientList().get(m).getName().equals(name)){
                        found = m;
                    }else if(name.compareTo(mainRestaurant.getClientList().get(m).getName())>0){
                        i=m+1;
                    }else{
                         j = m-1;
                    }

                }
            long end = System.nanoTime();
                if (found>=0){
                    mainRestaurant.setClientSearchedIndex(found);
                    txtAddressOrder.setText(mainRestaurant.getClientList().get(found).getAddress());

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("La busqueda tardó: "+TimeUnit.SECONDS.convert((end-star),TimeUnit.NANOSECONDS)+" Segundos");
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Informacion");
                    alert.setHeaderText(null);
                    alert.setContentText("No se encontró el cliente,asegurese de haberlo escrito correctamente");
                    alert.showAndWait();
                }

            }else{
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Informacion");
                 alert.setContentText("Por favor escriba un nombre para buscar");
                 alert.showAndWait();
            }


    }

    @FXML
    public void addProductToOrder(ActionEvent event){
        int totalPrice=0;
        String product= comboProducts.getValue();
        ArrayList<Product> choosen = new ArrayList<>();
        boolean out = false;
        int amount=0;//para las veces que se pide un producto
        for (int i = 0; i <mainRestaurant.getProducts().size() && !out ; i++) {
            if (product.equals(mainRestaurant.getProducts().get(i).getNameP())){
                choosen.add(mainRestaurant.getProducts().get(i));
                totalPrice+= mainRestaurant.getProducts().get(i).getPrice();
                amount = mainRestaurant.getProducts().get(i).getAmountOfRequest();//obtiene las veces que se pidio
                amount+=1;//le suma 1
                mainRestaurant.getProducts().get(i).setAmountOfRequest(amount);//las vuelve a agregar
                out = true;
            }
        }

        if(TorderProduct.getItems().isEmpty()){
            ObservableList<Product> productObservableList = FXCollections.observableArrayList(choosen);
            TorderProduct.setItems(productObservableList);
            CproductsOrder.setCellValueFactory(new PropertyValueFactory<Product,String>("nameP"));
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmacion");
            alert.setHeaderText(null);
            alert.setContentText("El producto se agrego con exito");
            alert.showAndWait();
            labelPrice.setText(String.valueOf(totalPrice));
        }else{
               initializersSecondment(product);
        }


    }
    //Para visualizar los cambios en la tabla de productos
    private void initializersSecondment(String product){
        boolean out = false;
        int totalPrice=Integer.parseInt(labelPrice.getText());
        for (int i = 0; i <mainRestaurant.getProducts().size() && !out ; i++) {
            if (product.equals(mainRestaurant.getProducts().get(i).getNameP())){
                ObservableList<Product> productObservableList = TorderProduct.getItems();
                productObservableList.add(mainRestaurant.getProducts().get(i));
                totalPrice+= mainRestaurant.getProducts().get(i).getPrice();
                CproductsOrder.setCellValueFactory(new PropertyValueFactory<Product,String>("nameP"));
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Confirmacion");
                alert.setHeaderText(null);
                alert.setContentText("El producto se agrego con exito");
                alert.showAndWait();
                labelPrice.setText(String.valueOf(totalPrice));
                out = true;
            }
        }




    }


    @FXML
    public void createOrder(ActionEvent event){
        //para dar formato de la fecha
        Date dateOfOrder = new Date();
        String dateFormat = "dd/MM/yy - hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        ArrayList<Product>pChoosen;
        String  adrress, employee,feedback;
        int nameC = mainRestaurant.getClientSearched();
        adrress = txtAddressOrder.getText();
        employee = comboEmployee.getValue();
        feedback = txtFeedBack.getText();
        String nameNosearched = txtClientName.getText();//para que no dependa de buscar el cliente para crear el pedido
        if(!feedback.equals("")){
            if (nameNosearched.equals("") || adrress.equals("") || employee.equals("") || TorderProduct.getItems().isEmpty()) {
                System.out.println("hay feedback");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Datos incompletos");
                alert.setHeaderText("Por favor llene todos los campos, no olvide elegir un producto");
                alert.setContentText("Si no busco al cliente por favor complete el campo de direccion\n"+
                                      "CONSEJO: si escribe el nombre del cliente y le da a buscar la direccion se completa sola"
                );
                alert.showAndWait();

            }else{
                pChoosen = new ArrayList<>(TorderProduct.getItems());
                mainRestaurant.createOrder(employee,nameC,feedback,adrress,pChoosen,nameNosearched,dateOfOrder);
                mainRestaurant.setClientSearchedIndex(-1);
                labelDate.setText(sdf.format(dateOfOrder));
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Exito!");
                alert.setContentText("Se ha creado una nueva orden");
                alert.showAndWait();
                //solucionar como resetear los textField
                txtClientName.setText("");
                txtAddressOrder.setText("");
                txtFeedBack.setText("");
                comboProducts.resetValidation();
                comboEmployee.resetValidation();
                TorderProduct.setItems(null);
                TorderProduct.refresh();
                //para mañana solucionar lo de las tablas en la interfaz y la clase date en los pedidos

            }
        }else{
            if (nameNosearched.equals("") || adrress.equals("") || employee.equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Datos incompletos");
                alert.setHeaderText("Por favor llene todos los campos, no olvide elegir un producto");
                alert.setContentText("CONSEJO: si escribe el nombre del cliente y le da a buscar \n"+"la direccion se completa sola");
                alert.showAndWait();
            }else{
                //System.out.println("No hay feedback y se creo la orden ");
                pChoosen = new ArrayList<>(TorderProduct.getItems());
                mainRestaurant.createOrder(employee,nameC,adrress,pChoosen,nameNosearched,dateOfOrder);
                mainRestaurant.setClientSearchedIndex(-1);
                labelDate.setText(sdf.format(dateOfOrder));
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Exito!");
                alert.setContentText("Se ha creado una nueva orden");
                alert.showAndWait();
            }

        }

    }




    @FXML
    public void mainActions(ActionEvent event) {

        String election = "";
        String slelectedOne;

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de acciones principales");
        alert.setHeaderText("Confirma lo que quieres hacer");
        alert.setContentText("Elige tu opción.");

        ButtonType buttonTypeOne = new ButtonType("Borrar");
        ButtonType buttonTypeTwo = new ButtonType("Deshabilitar");
        ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();

        List<String> choices1 = new ArrayList<>();
        choices1.add("Usuario");
        choices1.add("Empleado");
        choices1.add("Cliente");
        choices1.add("Pedido");
        choices1.add("Ingrediente");
        choices1.add("Producto");
        choices1.add("Tipo de Producto");
        ChoiceDialog<String> dialog1 = new ChoiceDialog<>(null, choices1);


        if (result.get() == buttonTypeOne) {
            dialog1.setTitle("Opción Eliminar");
            dialog1.setHeaderText("¿Qué quieres eliminar? (Los pedidos serán administrados por su código)");
            dialog1.setContentText("Escoge una opción:");
            Optional<String> result1 = dialog1.showAndWait();
            List<String> choices2 = new ArrayList<>();
            if (result1.isPresent()) {
                election = result1.get();
                switch (election) {
                    case "Usuario":
                        for (int i = 0; i < mainRestaurant.getUsers().size(); i++) {
                            choices2.add(mainRestaurant.getUsers().get(i).getUserName());
                        }
                        break;
                    case "Empleado":
                        for (int i = 0; i < mainRestaurant.getEmployees().size(); i++) {
                            choices2.add(mainRestaurant.getEmployees().get(i).getName());
                        }
                        break;
                    case "Cliente":
                        for (int i = 0; i < mainRestaurant.getClientList().size(); i++) {
                            choices2.add(mainRestaurant.getClientList().get(i).getName());
                        }
                        break;

                    case "Pedido":
                        for (int i = 0; i < mainRestaurant.getOrderList().size(); i++) {
                            choices2.add(mainRestaurant.getOrderList().get(i).getCode());
                        }
                        break;
                    case "Ingrediente":
                        for (int i = 0; i < mainRestaurant.getIngredientsList().size(); i++) {
                            choices2.add(mainRestaurant.getIngredientsList().get(i).getNameI());
                        }
                        break;
                    case "Producto":
                        for (int i = 0; i < mainRestaurant.getProducts().size(); i++) {
                            choices2.add(mainRestaurant.getProducts().get(i).getNameP());
                        }
                        break;
                    case "Tipo de Producto":
                        for (int i = 0; i < mainRestaurant.getTypeProducts().size(); i++) {
                            choices2.add(mainRestaurant.getTypeProducts().get(i).getName());
                        }
                        break;
                }

            }

            ChoiceDialog<String> dialog2 = new ChoiceDialog<>(null, choices2);
            dialog2.setTitle("Eliminar");
            dialog2.setHeaderText("¿Cuál será eliminado?");
            dialog2.setContentText("Elija un " + election + ":");
            Optional<String> result2 = dialog2.showAndWait();
            if (result2.isPresent()) {
                slelectedOne = result2.get();
                switch (election) {
                    case "Usuario":
                        if (mainRestaurant.delete(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                            initializeTables();
                        } else {
                            Alert alert2 = new Alert(AlertType.WARNING);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("Something went wrong");
                            alert2.showAndWait();
                        }
                        break;
                    case "Empleado":
                        if (mainRestaurant.deleteEmployee(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("La acción se realizó con éxito");
                            alert2.showAndWait();
                            initializeTables();
                        }
                        break;
                    case "Cliente":
                        if (mainRestaurant.deleteClient(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Result");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                            initializeTables();
                        }
                        break;
                    case "Pedido":
                        if (mainRestaurant.deleteOrder(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                            initializeTables();
                        }
                        break;
                    case "Ingrediente":
                        if (mainRestaurant.deleteIngredient(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                            initializeTables();
                        }
                        break;
                    case "Producto":
                        if (mainRestaurant.deleteProduct(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                            initializeTables();
                        }
                        break;

                    case "Tipo de Producto":
                        if (mainRestaurant.deleteType(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                            initializeTables();
                        }
                        break;

                }

            }

        } else if (result.get() == buttonTypeTwo) {
            dialog1.setTitle("Opción Deshabilitar");
            dialog1.setHeaderText("¿Qué quieres deshabilitar? (Los pedidos serán administrados por su código)");
            dialog1.setContentText("Elige uno:");
            Optional<String> result2 = dialog1.showAndWait();
            List<String> choices2 = new ArrayList<>();
            if (result2.isPresent()) {
                election = result2.get();
                switch (election) {
                    case "Usuario":
                        for (int i = 0; i < mainRestaurant.getUsers().size(); i++) {
                            choices2.add(mainRestaurant.getUsers().get(i).getUserName());
                        }
                        break;
                    case "Empleado":
                        for (int i = 0; i < mainRestaurant.getEmployees().size(); i++) {
                            choices2.add(mainRestaurant.getEmployees().get(i).getName());
                        }
                        break;
                    case "Cliente":
                        for (int i = 0; i < mainRestaurant.getClientList().size(); i++) {
                            choices2.add(mainRestaurant.getClientList().get(i).getName());
                        }
                        break;

                    case "Pedido":
                        for (int i = 0; i < mainRestaurant.getOrderList().size(); i++) {
                            choices2.add(mainRestaurant.getOrderList().get(i).getCode());
                        }
                        break;
                    case "Ingrediente":
                        for (int i = 0; i < mainRestaurant.getIngredientsList().size(); i++) {
                            choices2.add(mainRestaurant.getIngredientsList().get(i).getNameI());
                        }
                        break;
                    case "Producto":
                        for (int i = 0; i < mainRestaurant.getProducts().size(); i++) {
                            choices2.add(mainRestaurant.getProducts().get(i).getNameP());
                        }
                        break;
                    case "Tipo de Producto":
                        for (int i = 0; i < mainRestaurant.getTypeProducts().size(); i++) {
                            choices2.add(mainRestaurant.getOrderList().get(i).getCode());
                        }
                        break;
                }
            }

            ChoiceDialog<String> dialog2 = new ChoiceDialog<>(null, choices2);
            dialog2.setTitle("Deshabilitar");
            dialog2.setHeaderText("¿Cuál se deshabilitará?");
            dialog2.setContentText("Elija un" + election + ":");
            Optional<String> result3 = dialog2.showAndWait();
            if (result3.isPresent()) {
                slelectedOne = result3.get();
                switch (election) {
                    case "Usuario":
                        if (mainRestaurant.toDisable(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                            initializeTables();
                        }
                        break;
                    case "Empleado":
                        if (mainRestaurant.disableEmployee(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                        }
                        break;
                    case "Cliente":
                        if (mainRestaurant.disableClient(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                        }
                        break;
                    case "Pedido":
                        if (mainRestaurant.disableOrder(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Result");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                        }
                        break;
                    case "Ingrediente":
                        if (mainRestaurant.disableIngredients(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                        }
                        break;
                    case "Producto":
                        if (mainRestaurant.disableProduct(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                        }
                        break;

                    case "Tipo de Producto":
                        if (mainRestaurant.disableType(slelectedOne)) {
                            Alert alert2 = new Alert(AlertType.INFORMATION);
                            alert2.setHeaderText("Resultado");
                            alert2.setContentText("¡La acción se realizó con éxito!");
                            alert2.showAndWait();
                        }
                        break;

                }


            }

        }

    }


    public void initializeTables() {
        //___________________________ USER TABLE __________________________________________________________
        ObservableList<User> userObservableList;
        List<User> availableUsers = new ArrayList<>();
        for (int i = 0; i < mainRestaurant.getUsers().size(); i++) {
            if (mainRestaurant.getUsers().get(i).isHabilitate()) {
                availableUsers.add(mainRestaurant.getUsers().get(i));
            }
        }
        userObservableList = FXCollections.observableArrayList(availableUsers);
        TUsers.setItems(userObservableList);
        CnameU.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        ClastNameU.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        CIdU.setCellValueFactory(new PropertyValueFactory<User, String>("identification"));
        CuserName.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));

    //_______________________________ CLIENT TABLE ________________________________________________________

        ObservableList<Client> clientObservableList;
        ArrayList<Client> availableClients = new ArrayList<>();
        for (int i = 0; i < mainRestaurant.getClientList().size(); i++) {
            if (mainRestaurant.getClientList().get(i).isHabilitate()) {
                availableClients.add(mainRestaurant.getClientList().get(i));
            }
        }
        clientObservableList = FXCollections.observableList(availableClients);
        TClients.setItems(clientObservableList);
        CnameC.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        ClastNameC.setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
        CidC.setCellValueFactory(new PropertyValueFactory<Client, String>("identification"));
        Caddress.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
        Ctelefono.setCellValueFactory(new PropertyValueFactory<Client,String>("telephone"));

    //_____________________________ EMPLOYEE TABLE ________________________________________________________
        ObservableList<Employee> employeeObservableList;
        ArrayList<Employee> availableEmployees = new ArrayList<>();
        for (int i = 0; i < mainRestaurant.getEmployees().size() ; i++) {
            if(mainRestaurant.getEmployees().get(i).isHabilitate()){
                availableEmployees.add(mainRestaurant.getEmployees().get(i));
            }
        }
        employeeObservableList = FXCollections.observableArrayList(availableEmployees);
        TEmployee.setItems(employeeObservableList);
        CnameE.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        CLastnameE.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        CIdE.setCellValueFactory(new PropertyValueFactory<Employee, String>("identification"));

    //_____________________________ INGREDIENTS TABLE ______________________________________________________

        ObservableList<Ingredient> ingredientObservableList;
        ingredientObservableList = FXCollections.observableList(mainRestaurant.getIngredientsList());
        TIngredients.setItems(ingredientObservableList);
        CnameI.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("nameI"));
        CavalibleI.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("isAvailable"));

    //___________________________________ PRODUCTS TABLE___________________________________________________________
        ObservableList<Product> productsObservableList;
        productsObservableList = FXCollections.observableArrayList(mainRestaurant.getProducts());
        Tproducts.setItems(productsObservableList);
        CnameP.setCellValueFactory(new PropertyValueFactory<Product,String>("nameP"));
        CsizeP.setCellValueFactory(new PropertyValueFactory<Product,String>("size"));
        CpriceP.setCellValueFactory(new PropertyValueFactory<Product,String>("auxPrice"));
        CavalibeP.setCellValueFactory(new PropertyValueFactory<Product,String>("isAvailableP"));
        CtypeP.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));

    //____________________________ TYPE OF PRODUCTS TABLE______________________________________________________________
        ObservableList<TypeProduct>typeProductObservableList;
        typeProductObservableList = FXCollections.observableArrayList(mainRestaurant.getTypeProducts());
        Ttype.setItems(typeProductObservableList);
        CnameType.setCellValueFactory(new PropertyValueFactory<TypeProduct,String>("name") );
        CnameAvalibleT.setCellValueFactory(new PropertyValueFactory<TypeProduct,String>("isAvalibleT"));
    //___________________________________ORDERS TABLE_________________________________________________
        ObservableList<Order>orderObservableList;
        orderObservableList = FXCollections.observableArrayList(mainRestaurant.getOrderList());
        Torders.setItems(orderObservableList);
        Ccode.setCellValueFactory(new PropertyValueFactory<Order,String>("code"));
        Cdate.setCellValueFactory(new  PropertyValueFactory<Order,String>("date"));
        Cclient.setCellValueFactory(new PropertyValueFactory<Order,String>("clientRequest"));
        Cemployee.setCellValueFactory(new PropertyValueFactory<Order,String>("employee"));
        Cstatus.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
        CamountP.setCellValueFactory(new PropertyValueFactory<Order,String>("amountProducts"));


        updateInfoFromTableviewUsers();
        updateInfoFromTableviewClients();
        updateInfoFromtableviewEmployees();
        updateInfoFromTableviewIngredients();
        updateInfoFromTableviewOrders();
        updateInfoFromTableviewProducts();
        updateInfoFromTableviewTypeOfProducts();


    }



    //Llamar el metodo cuando cargen las pantallas Nota Borrar metodos update
    public void updateInfoFromTableviewUsers(){

        CnameU.setCellFactory(TextFieldTableCell.forTableColumn());
        CnameU.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue()));

        ClastNameU.setCellFactory(TextFieldTableCell.forTableColumn());
        ClastNameU.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setLastName(event.getNewValue()));

        CIdU.setCellFactory(TextFieldTableCell.forTableColumn());
        CIdU.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setIdentification(event.getNewValue()));

        CuserName.setCellFactory(TextFieldTableCell.forTableColumn());
        CuserName.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setUserName(event.getNewValue()));


        TUsers.setEditable(true);


    }


    public void updateInfoFromtableviewEmployees(){
        CnameE.setCellFactory(TextFieldTableCell.forTableColumn());
        CnameE.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue()));

        CLastnameE.setCellFactory(TextFieldTableCell.forTableColumn());
        CLastnameE.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setLastName(event.getNewValue()));

        CIdE.setCellFactory(TextFieldTableCell.forTableColumn());
        CIdE.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setIdentification(event.getNewValue()));

        TEmployee.setEditable(true);
    }
    public void updateInfoFromTableviewClients(){
        CnameC.setCellFactory(TextFieldTableCell.forTableColumn());
        CnameC.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue()));

        ClastNameC.setCellFactory(TextFieldTableCell.forTableColumn());
        ClastNameC.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setLastName(event.getNewValue()));

        CidC.setCellFactory(TextFieldTableCell.forTableColumn());
        CidC.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setIdentification(event.getNewValue()));

        Caddress.setCellFactory(TextFieldTableCell.forTableColumn());
        Caddress.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setIdentification(event.getNewValue()));

        Ctelefono.setCellFactory(TextFieldTableCell.forTableColumn());
        Ctelefono.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setTelephone(event.getNewValue()));
        TClients.setEditable(true);
    }

    //Dejar de ultimo
    public void updateInfoFromTableviewOrders(){

    }

    /**
     * <b> Pre: para cambiar el si esta disponible debe escribir 'true' o 'false'</b>
     *
     *
     */
    public void updateInfoFromTableviewProducts() {
        CnameP.setCellFactory(TextFieldTableCell.forTableColumn());
        CnameP.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setNameP(event.getNewValue()));

        CsizeP.setCellFactory(TextFieldTableCell.forTableColumn());
        CsizeP.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setSize(event.getNewValue()));

        CpriceP.setCellFactory(TextFieldTableCell.forTableColumn());
        CpriceP.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setPrice(event.getNewValue()));

        CavalibeP.setCellFactory(TextFieldTableCell.forTableColumn());
        CavalibeP.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setIsAvailableP(event.getNewValue()));

        CtypeP.setCellFactory(TextFieldTableCell.forTableColumn());
        CtypeP.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setType(event.getNewValue()));

        Tproducts.setEditable(true);
    }



    public void updateInfoFromTableviewIngredients(){
         CnameI.setCellFactory(TextFieldTableCell.forTableColumn());
         CnameI.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setNameI(event.getNewValue()));

         CavalibleI.setCellFactory(TextFieldTableCell.forTableColumn());
         CavalibleI.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setIsAvailable(event.getNewValue()));

         TIngredients.setEditable(true);
    }

    public void updateInfoFromTableviewTypeOfProducts(){
        CnameType.setCellFactory(TextFieldTableCell.forTableColumn());
        CnameType.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue()));

        CnameAvalibleT.setCellFactory(TextFieldTableCell.forTableColumn());
        CnameAvalibleT.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setIsAvalibleT(event.getNewValue()));

        Ttype.setEditable(true);

    }

   @FXML
    public void saveDataUpdated( MouseEvent event) throws IOException {
        mainRestaurant.saveDataUsers();
        mainRestaurant.saveDataEmployees();
        mainRestaurant.saveDataClients();
        mainRestaurant.saveDataProduct();
        mainRestaurant.saveIngredients();
        mainRestaurant.saveTypes();
        mainRestaurant.saveDataOrder();
       System.out.println("ete es el buenoo");
   }

    @FXML
    public void sortProduct(ActionEvent event) {

        mainRestaurant.insertionSortArrayList(mainRestaurant.getProducts());
        initializeTables();


    }

    @FXML
    public void menuAction(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);

        slide.setToX(0);
        slide.play();

        slider.setTranslateX(-330);

        slide.setOnFinished((ActionEvent e)-> {
            Menu.setVisible(false);
            MenuClose.setVisible(true);
        });
    }


    @FXML
    public void menuCloseAction(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);

        slide.setToX(-330);
        slide.play();

        slider.setTranslateX(0);

        slide.setOnFinished((ActionEvent e)-> {
            Menu.setVisible(true);
            MenuClose.setVisible(false);
    });

}

















}




