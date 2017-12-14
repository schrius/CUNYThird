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

public class AddCourseController implements Initializable {

	// Course pane
	@FXML
	private TextField courseCode;
	@FXML
	private TextField courseName;
	@FXML
	private TextField courseDescription;
	@FXML
	private TextField courseSemester;
	@FXML
	private TextField courseRoom;
	@FXML
	private DatePicker courseStartDate;
	@FXML
	private DatePicker courseEndDate;
	@FXML
	private TextField courseDays;
	@FXML
	private TextField courseTime;
	@FXML
	private TextField courseRequirement;
	@FXML
	private TextField courseUnit;
	@FXML
	private TextField instructorID;
	@FXML
	private ComboBox<String> department;
	@FXML
	private TextField capacity;
	@FXML
	private TextField currentCapacity;
	@FXML
	private Button confirm;
	public void confirmButtonListener() throws SQLException {
		String sql = "INSERT INTO Course VALUES("
				+ "'" + courseCode.getText() + "'," +
				"'" + courseName.getText() + "'," +
				"'" + courseDescription.getText() + "'," +
				"'" + courseSemester.getText() + "'," +
				"'" + courseRoom.getText() + "'," +
				"TO_DATE('" + courseStartDate.getValue() + "', 'YYYY-MM-DD'),"+
				"TO_DATE('" + courseEndDate.getValue() + "', 'YYYY-MM-DD'),"+
				"'" + courseTime.getText() + "'," +
				"'" + courseRequirement.getText() + "'," +
				 courseUnit.getText() + "," +
				"'" + instructorID.getText() + "'," +
				"'" + department.getValue() + "'," +
				"'" + courseDays.getText() + "'," +
				 capacity.getText() + "," +
				 currentCapacity.getText() + ")";
		RegisterJDBC.excuteSQL(sql);
		((Stage)confirm.getScene().getWindow()).close();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		department.getItems().addAll((new Department().getDepartment()));
	}
}
