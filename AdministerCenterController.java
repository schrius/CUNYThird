package Register;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AdministerCenterController {
	@FXML
	private TextField searchField;
	
	
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
	private TextField courseStartDate;
	@FXML
	private TextField courseEndDate;
	@FXML
	private TextField courseTime;
	@FXML
	private TextField courseRequirement;
	@FXML
	private TextField courseUnit;
	@FXML
	private TextField instructorID;
	@FXML
	private TextField courseDepartment;
	
	// Student pane
	@FXML
	private TextField studentID;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
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
	private TextField DOB;
	@FXML
	private TextField major;
	@FXML
	private TextField gener;
	@FXML
	private TextField GPA;
	@FXML
	private TextField totalUnits;
	@FXML
	private TextField dueTuition;
	
	// search radioButton
	@FXML
	private RadioButton courseRadio;
	@FXML
	private RadioButton instructorRadio;
	@FXML
	private RadioButton studentRadio;
	
	// SQL pane
	@FXML
	private TextArea SQLArea;
	@FXML
	private Button searchButton;
	@FXML
	private Button excuteSQLButton;
	
	// add and delete courses and student button
	@FXML
	private Button addCourseButton;
	@FXML
	private Button deleteCourseButton;
	@FXML
	private Button addStudentButton;
	@FXML
	private Button deleteStudentButton;
	
	public void searchButtonListerner() throws ClassNotFoundException, SQLException{
		RegisterJDBC registerJDBC = new RegisterJDBC();
		ResultSet resultSet;
		String search = searchField.getText();
		String sql;
		if(courseRadio.isSelected()){
			sql = "SELECT * FROM Course WHERE name = " + search + " OR " + "code = " + search;
			registerJDBC.excuteSQL(sql);
			resultSet = registerJDBC.getResult();
			while(resultSet.next()){
				
			}
		}
		else if(instructorRadio.isSelected()){
			sql = "SELECT * FROM Instructor WHERE firstName = " + search + " OR " + "lastName = " + search
					+ " OR instructorID = " + search;
			registerJDBC.excuteSQL(sql);
			resultSet = registerJDBC.getResult();
			while(resultSet.next()){
				
			}
		}
		else {
			sql = "SELECT * FROM Student WHERE firstName = " + search + " OR " + "lastName = " + search
					+ " OR studentID = " + search;
			registerJDBC.excuteSQL(sql);
			resultSet = registerJDBC.getResult();
			while(resultSet.next()){
				
			}
			
		}
	}
	
	public void addStudentButtonListener() {
		
	}
	
	public void deleteStudentButtonListener() {
		
	}
	public void addCourseButtonListener() {
		
	}
	
	public void deleteCourseButtonListener() {
		
	}
	public void excuteSQLButtonListener() {
		SQLArea.getText();
	}
	
}
