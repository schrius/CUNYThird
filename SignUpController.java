package Register;
/*
 * Sign up window controller
 * getting all data from textfield and try to sign up
 * It should check the database for duplicate first.
 */
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
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
	private TextField zipCodeField;
	@FXML
	private TextField SSNField;
	
	@FXML
	private ComboBox<String> majorBox;
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label genderLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label retypeLabel;
	@FXML
	private Label majorLabel;
	@FXML
	private Label SSNLabel;
	@FXML
	private Label DOBLabel;
	
	
	@FXML
	private Button cancelButton;
	@FXML
	private Button submitButton;
	
	public void cancelButtonListener(){
		((Stage)cancelButton.getScene().getWindow()).close();
	}
	
	public void submiteButtonListener() throws SQLException, InterruptedException{
		String gender = null;
		boolean complete = true;
		if(maleRadioButton.isSelected()){
			gender = maleRadioButton.getText();
		}
		else if (femaleRadioButton.isSelected()){
			gender = femaleRadioButton.getText();
		}
		else {
			genderLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(!emailField.getText().contains("@")){
			emailLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(firstNameField.getText().equals("") || firstNameField.getText() == null){
			firstNameLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(lastNameField.getText().equals("") || lastNameField.getText() == null){
			lastNameLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(passwordField.getText().equals("") || passwordField.getText() == null){
			passwordLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(!passwordField.getText().equals(retypeField.getText())){
			retypeLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(majorBox.getValue() == null){
			majorLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(SSNField.getText().equals("") || SSNField.getText() == null){
			SSNLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(datePicker.getValue() == null){
			DOBLabel.setTextFill(Paint.valueOf("#ff471a"));
			complete = false;
		}
		if(complete){
		submitButton.setText("Processing...");
		String sql = "INSERT INTO Student(StudentID, FirstName, LastName, Gender, Email, Password, Address, City"
				+ ", State, ZipCode, Major, SSN, DOB ) VALUES(seq_student," + 
				 "'" + firstNameField.getText() +"', "+ 
				 "'" + lastNameField.getText() +"'," +
				 "'" + gender + "'," + 
				 "'" + emailField.getText() + "'," +
				 "'" + passwordField.getText() + "'," +
				 "'" + addressField.getText() + "'," +
				 "'" + cityField.getText() + "'," +
				 "'" + stateField.getText() + "'," +
				 "'" + zipCodeField.getText() + "'," +
				 "'" + majorBox.getValue() + "'," +
				 "'" + SSNField.getText() + "'," +
				 "'" + datePicker.getValue() + "')";
		RegisterJDBC.excuteSQL(sql);
		wait(2000);
		((Stage)submitButton.getScene().getWindow()).close();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		majorBox.getItems().addAll("Business", "Accouting", "Finance");
	}
}
