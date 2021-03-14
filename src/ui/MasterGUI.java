package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Restaurant;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;


public class MasterGUI {
    //Attributess

    private Restaurant mainRestaurant;

    //____________________ MENU _______________
    @FXML
    private Label Menu;

    @FXML
    private Label menuBack;

    @FXML
    private AnchorPane slider;

    @FXML
    private JFXButton buttonExit;

    //------------------------------------------

    //_____________ MAIN PANE ____________
    @FXML
    private BorderPane borderPane;


    //____________________________________

    //_____________ LOGIN PANE ___________
    @FXML
    private JFXTextField txtLoginUser;

    @FXML
    private JFXPasswordField txtLoginPass;

    //---------------------------------

    //________________Register_________________
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

    //________________________________________

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
            System.out.println("nada aun");
        }

        return borderPane;
    }

    @FXML
    public void logIn(ActionEvent event) throws IOException {

        if (mainRestaurant.canLogin(txtLoginUser.getText())){
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("menu.fxml"));
            fxmlLoader1.setController(this);
            Parent logInPane = fxmlLoader1.load();
            borderPane.setCenter(logInPane);

        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("We can not find you :(");
            alert.setHeaderText(null);
            alert.setContentText("Please create an account :)");
            alert.showAndWait();

        }


    }

    @FXML
    public void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader.setController(this);
        Parent signUpPane = fxmlLoader.load();

        borderPane.setCenter(signUpPane);

    }


    //________________ REGISTER _________________

    public void createUser(ActionEvent event) throws IOException {
        String name , lastName, userName, password, id;
        name = txtName.getText();
        lastName = txtLastName.getText();
        userName = txtUserName.getText();
        password = txtPassword.getText();
        id = txtId.getText();

        if (name.equals("")|| lastName.equals("")|| id.equals("")||userName.equals("") || password.equals("") ){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Please fill all the blanks");
            alert.setHeaderText(null);
            alert.showAndWait();
            txtName.setText("");
            txtLastName.setText("");
            txtUserName.setText("");
            txtPassword.setText("");

        }else {
            mainRestaurant.createUser(name,lastName,id,userName,password);
            mainRestaurant.saveDataUsers();

        }

    }

    //____________________ MENU _______________

    @FXML
    public void exitButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent loginBack = fxmlLoader.load();

        borderPane.setCenter(loginBack);
    }
    //__________________



}
