package Register;

/*
 * Student login controller handle for login.
 */
import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
	private PasswordField password;
	
	@FXML
	private TextField username;
	
	public void loginListener() throws IOException, SQLException {
		if(username.getText()!=null && password.getText()!=null) {
		String sql = "SELECT StudentID, Password FROM Student WHERE StudentID ='"
				+ username.getText() + "'";
		RegisterJDBC.excuteSQL(sql);
		
		if(RegisterJDBC.result.next()) {
		if((RegisterJDBC.result.getString("StudentID")).equals(username.getText())&&
				(RegisterJDBC.result.getString("Password")).equals(password.getText())) {
		//load student information after login
			sql = "SELECT * FROM Student WHERE StudentID ='" + username.getText() + "'";
			RegisterJDBC.excuteSQL(sql);
			RegisterJDBC.result.next();
			
		Stage stage = (Stage)loginButton.getScene().getWindow();
		parent = FXMLLoader.load(getClass().getResource("StudentCenterFX.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		}else
		wrongPassword.setText("User or Password is not match!");
		}
		else {
			wrongPassword.setText("User does not exist.");
		}
		}
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
