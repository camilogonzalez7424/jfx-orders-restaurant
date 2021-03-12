package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MasterGUI {
    //Attributes
    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXTextField txtLoginUser;

    @FXML
    private JFXPasswordField txtLoginPass;


    @FXML
    public void logIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("menu.fxml"));
        fxmlLoader1.setController(this);
        Parent logInPane = fxmlLoader1.load();

        borderPane.setCenter(logInPane);
    }

    @FXML
    public void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader1.setController(this);
        Parent signUpPane = fxmlLoader1.load();

        borderPane.setCenter(signUpPane);

    }

    /**
     * Constructor method.
     */
    public MasterGUI(){

    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    //___________________________________
    //Corregir

    @FXML
    private DatePicker date;

    @FXML
    private RadioButton female;

    @FXML
    private ToggleGroup genderGrup;

    @FXML
    private RadioButton other;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton sis;

    @FXML
    private ToggleGroup careerGrup;

    @FXML
    private RadioButton tel;

    @FXML
    private RadioButton ind;

    @FXML
    private TextField txtUserN;

    @FXML
    private TextField txtImageURL;

    @FXML
    private ChoiceBox<?> browser;

    @FXML
    private TextField txtPass;

    @FXML
    void SignIn(ActionEvent event) {

    }

    @FXML
    void createAccount(ActionEvent event) {

    }

    @FXML
    void fileBrowser(ActionEvent event) {

    }

    //____________________
    @FXML
    private JFXButton Button;


}
