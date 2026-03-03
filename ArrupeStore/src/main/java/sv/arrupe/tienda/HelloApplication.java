package sv.arrupe.tienda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/sv/arrupe/tienda/view/tienda.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("logoarrupe.png")));
        stage.setTitle("Tienda con JavaFX + JDBC");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
