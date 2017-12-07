<<<<<<< HEAD:Register/RegisterSystem.java
package Register;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterSystem extends Application{
	Stage window;
	@Override
	public void start(Stage stage){
		window = stage;
		Parent parent;
		try {
			RegisterJDBC.connect();
			parent = FXMLLoader.load(getClass().getResource("MainFX.fxml"));
			Scene scene = new Scene(parent);

			window.setTitle("Register Sytem");
			window.setScene(scene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);

	}

}
=======
package Register;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterSystem extends Application{
	Stage window;
	@Override
	public void start(Stage stage){
		window = stage;
		Parent parent;
		try {
			RegisterJDBC.connect();
			parent = FXMLLoader.load(getClass().getResource("MainFX.fxml"));
			Scene scene = new Scene(parent);

			window.setTitle("Register Sytem");
			window.setScene(scene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);

	}

}
>>>>>>> dedcd6673d66286166f976818e9c0cab3f527c91:RegisterSystem.java
