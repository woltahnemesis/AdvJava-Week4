import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main (String[] args){
        launch(args);
    }

    // Scene changer
    @Override
    public void start(Stage stage) throws Exception {
        // Loads and store the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("newPatientInTakeView.fxml"));

        // Instantiates the root
        Scene scene = new Scene(root);

        // Adds the stylesheet file
        scene.getStylesheets().add("stylesheet.css");

        stage.setScene(scene);
        stage.setTitle("Doctor's Office");
        stage.show();
    }
}
