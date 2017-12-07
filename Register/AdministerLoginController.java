package Register;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdministerLoginController {
	Parent parent;
	
	@FXML
	private Button loginButton;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField passwordField;
	
	public void loginButtonListener() throws IOException{
		Administer administer = new Administer();
		if(nameField.getText().equals(administer.getName()) && 
				passwordField.getText().equals(administer.getPassword())){
		Stage stage = (Stage) loginButton.getScene().getWindow();
		parent = FXMLLoader.load(getClass().getResource("AdministerCenterFX.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		}
		else {
			errorLabel.setText("Incorrect User or password!");
		}
	}
}
