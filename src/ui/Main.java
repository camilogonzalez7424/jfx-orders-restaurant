package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Software to manage a restaurant.
 * @author Camilo González.
 * @author Johan Ricardo.
 * @since March 2021
 * @version 1.0
 */
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));

        //Colocar controladora

        //fxmlLoader.setController(contactManagerGUI);

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LA CASA DORADA");
        primaryStage.show();
    }
}
