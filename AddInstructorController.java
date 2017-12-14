package Register;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddInstructorController implements Initializable {
	@FXML
	private TextField instructorID;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private ComboBox<String> department;
	@FXML
	private TextField office;
	@FXML
	private TextField phone;
	@FXML
	private DatePicker hireDate;
	@FXML
	private TextField salary;
	@FXML
	private Button confirm;
	
	public void confirmButtonListner() throws SQLException {
		String sql = "INSERT INTO Instructor VALUES(" + 
				 "'" + instructorID.getText() +"', "+ 
				 "'" + firstName.getText() +"'," +
				 "'" + lastName.getText() + "'," + 
				 "'" + department.getValue() + "'," +
				 "'" + office.getText() + "'," +
				 "'" + phone.getText() + "'," +
				 "TO_DATE('" + hireDate.getValue() + "', 'YYYY-MM-DD'),"+
				 "'" + salary.getText() + ")";
		RegisterJDBC.excuteSQL(sql);
		((Stage)confirm.getScene().getWindow()).close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		department.getItems().addAll((new Department().getDepartment()));
	}
}
