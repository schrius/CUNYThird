package Register;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AddStudentController implements Initializable{
	// Student pane
	@FXML
	private TextField studentID;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	private TextField address;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField zipCode;
	@FXML
	private TextField SSN;
	@FXML
	private DatePicker DOB;
	@FXML
	private ComboBox<String> major;
	@FXML
	private TextField GPA;
	@FXML
	private TextField totalUnits;
	@FXML
	private TextField dueTuition;
	@FXML
	private TextField currentUnits;
	@FXML
	private TextField furtureTuition;
	@FXML
	private RadioButton maleRadioButton;
	@FXML
	private RadioButton femaleRadioButton;
	@FXML
	private ToggleGroup genderToggle;
	@FXML
	private Button submit;

	public void addStudentButtonListener() throws SQLException {
		String gender = null;
		if(maleRadioButton.isSelected()){
			gender = maleRadioButton.getText();
		}
		else {
			gender = femaleRadioButton.getText();
			}
		String sql = "INSERT INTO Student(StudentID, FirstName, LastName, Address, City, State,"
				+ "ZipCode, SSN, DOB, Major, Gender, GPA, TotalUnits, DueTuition) VALUES"
				+ "(" + studentID.getText() + "," + "'" + firstName.getText() + "'," + "'" + lastName.getText() + "',"
				+ "'" + address.getText() + "'," + "'" + city.getText() + "'," + "'" + state.getText() + "',"
				+ "'" + zipCode.getText() + "'," + "'" + SSN.getText() + "'," + "TO_DATE('" + DOB.getValue() + "',"
						+ "'YYYY-MM-DD'),"
				+ "'" + major.getValue() + "'," + "'" + gender + "'," + GPA.getText() + ","
				 + totalUnits.getText() + ","+ dueTuition.getText() + ")";
		RegisterJDBC.excuteSQL(sql);
	}
	
	public void  initialize(URL arg0, ResourceBundle arg1) {
		major.getItems().addAll(new Major().getMajor());
	}
}
