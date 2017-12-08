package Register;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
 * Main screen
 * Connect sql and setup the entity.
 * Ideally, this should not be included. Student and administer never use the same platform.
 * And sql connection should be generating when login or sign up is requested.
 */
public class RegisterSystem extends Application{
	Stage window;
	@Override
	public void start(Stage stage){
		window = stage;
		Parent parent;
		try {
		//	RegisterJDBC.connect();
			parent = FXMLLoader.load(getClass().getResource("MainFX.fxml"));
			Scene scene = new Scene(parent);

			window.setTitle("Register Sytem");
			window.setScene(scene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	/*	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
	}
	public static void main(String[] args) {
		launch(args);

	}

}

