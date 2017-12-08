package Register;
/*
 * Sign up window controller
 * getting all data from textfield and try to sign up
 * It should check the database for duplicate first.
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController implements Initializable {
	@FXML
	private TextField firstNameField;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField retypeField;
	
	@FXML
	private RadioButton maleRadioButton;
	
	@FXML
	private RadioButton femaleRadioButton;
	@FXML
	private TextField emailField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField stateField;
	@FXML
	private TextField SSNField;
	
	@FXML
	private ComboBox<String> majorBox;
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private Button cancelButton;
	@FXML
	private Button submitButton;
	
	public void cancelButtonListener(){
		((Stage)cancelButton.getScene().getWindow()).close();
	}
	
	public void submiteButtonListener(){
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		majorBox.getItems().addAll("Business", "Accouting", "Finance");
	}
}
