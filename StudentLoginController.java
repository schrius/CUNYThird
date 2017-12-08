package Register;

/*
 * Student login controller handle for login.
 */
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentLoginController {
	Parent parent;
	
	@FXML
	private Button loginButton;
	
	@FXML
	private Button signUpButton;
	
	@FXML
	private Label wrongPassword;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField username;
	
	public void loginListener() throws IOException {
		Stage stage = (Stage)loginButton.getScene().getWindow();
		parent = FXMLLoader.load(getClass().getResource("StudentCenterFX.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
	}
	public void signUpListener() throws IOException{
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		parent = FXMLLoader.load(getClass().getResource("SignUpFX.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
