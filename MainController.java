package Register;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
	Parent parent;
	RegisterJDBC registerJDBC = new RegisterJDBC();

	@FXML
	private Button studentButton;

	@FXML
	private Button admisniterButton;

	public void studentButtonListener() throws IOException {
		Stage stage = (Stage)studentButton.getScene().getWindow();
		parent = FXMLLoader.load(getClass().getResource("StudentLoginFX.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
	}

	public void administerButtonListener() throws IOException {
		Stage stage = (Stage)studentButton.getScene().getWindow();
		parent = FXMLLoader.load(getClass().getResource("AdministerLoginFX.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
	}

}