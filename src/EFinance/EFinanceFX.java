package EFinance;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application entry point.
 *
 * @author Group 2
 */
public class EFinanceFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/LoginUI.fxml"));
        primaryStage.setTitle("Login | eFinance");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Loads a new JavaFX scene.
     *
     * @param c the calling class
     * @param fxmlFile the path of the FXML file to load
     * @param title the desired title of the window
     *
     * @usage EFinance.EFinanceFX.newScene(getClass(), "/View/myFXMLFile.fxml",
     * "My Window Title");
     */
    public static void newScene(Class c, String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(c.getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EFinanceFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Switches to a new JavaFX scene, closing the existing scene.
     *
     * @param c the calling class
     * @param fxmlFile the path of the FXML file to load
     * @param title the desired title of the window
     * @param event the initiating event
     *
     * @usage EFinance.EFinanceFX.newScene(getClass(), "/View/myFXMLFile.fxml",
     * "My Window Title", event);
     */
    public static void switchScene(Class c, String fxmlFile, String title, ActionEvent event) {
        EFinanceFX.newScene(c, fxmlFile, title);
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
