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

    //Relationship.
    private Restaurant mainRestaurant;

    /* NOTES:
       Attributes = A.
       Methods = M.     */

    //____________________ A. MENU PANEL _______________



    //------------------------------------------

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




    /*@FXML
    public void exportContact(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Export File");
        File file =fileChooser.showSaveDialog(mainPanel.getScene().getWindow());
        try {
            contactManager.exportData(file.getAbsolutePath());
        } catch (FileNotFoundException e) {

        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Export Contacts");
        alert.setContentText("Contacts were export");
        alert.showAndWait();
    }*/
}
