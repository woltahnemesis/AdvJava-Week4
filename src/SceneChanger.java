import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void changeScene(ActionEvent event, String viewName, String title) throws IOException {
        FXMLLoader loader = FXMLLoader.load(new Object(){}.getClass()
                .getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Hand Sanitizer GUI cool thing");
        stage.show();
    }
}