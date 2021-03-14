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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MasterGUI {
    //Attributess

    //_____________ MAIN PANE ____________
    @FXML
    private BorderPane borderPane;

    public BorderPane getBorderPane() {
        return borderPane;
    }
    //____________________________________

    //_____________ LOGIN PANE ___________
    @FXML
    private JFXTextField txtLoginUser;

    @FXML
    private JFXPasswordField txtLoginPass;


    @FXML
    public void logIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        fxmlLoader.setController(this);
        Parent menuPane = fxmlLoader.load();

        borderPane.setCenter(menuPane);

    }

    @FXML
    public void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader.setController(this);
        Parent signUpPane = fxmlLoader.load();

        borderPane.setCenter(signUpPane);

    }
    //________________________________________

    /**
     * Constructor method.
     */
    public MasterGUI() {

    }


    //________________ REGISTER _________________


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
