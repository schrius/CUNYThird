package Register;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TextField gender;
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

	@FXML
	private TableView<Object> table;

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

	//search Field for generate Database.
	@SuppressWarnings("unchecked")
	public void searchButtonListerner() throws ClassNotFoundException, SQLException{
		String search = searchField.getText();
		String sql;

		if(courseRadio.isSelected()){
			sql = "SELECT * FROM Course WHERE CourseName = '" + search + "' OR " + "CourseCode = '" + search + "'";
			RegisterJDBC.excuteSQL(sql);
			TableView<Student> studentTable = new TableView<Student>();

			TableColumn<Student, String> idColumn = new TableColumn<>("Student ID");
			idColumn.setMinWidth(100);
			idColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));

			TableColumn<Student, String> firstNameColumn = new TableColumn<>("FirstName");
			firstNameColumn.setMinWidth(100);
			firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

			TableColumn<Student, String> lastNameColumn = new TableColumn<>("LastName");
			lastNameColumn.setMinWidth(100);
			lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

			TableColumn<Student, String> addressColumn = new TableColumn<>("Address");
			addressColumn.setMinWidth(100);
			addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

			TableColumn<Student, String> cityColumn = new TableColumn<>("City");
			cityColumn.setMinWidth(100);
			cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

			TableColumn<Student, String> stateColumn = new TableColumn<>("State");
			stateColumn.setMinWidth(100);
			stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

			TableColumn<Student, String> zipCodeColumn = new TableColumn<>("ZipCode");
			zipCodeColumn.setMinWidth(100);
			zipCodeColumn.setCellValueFactory(new PropertyValueFactory<>("zipcode"));

			TableColumn<Student, String> SSNColumn = new TableColumn<>("SSN");
			SSNColumn.setMinWidth(100);
			SSNColumn.setCellValueFactory(new PropertyValueFactory<>("SSN"));

			TableColumn<Student, String> DOBColumn = new TableColumn<>("DOB");
			DOBColumn.setMinWidth(100);
			DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));

			TableColumn<Student, String> majorColumn = new TableColumn<>("Major");
			majorColumn.setMinWidth(100);
			majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

			TableColumn<Student, String> genderColumn = new TableColumn<>("Gender");
			genderColumn.setMinWidth(100);
			genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

			TableColumn<Student, Double> GPAColumn = new TableColumn<>("GPA");
			GPAColumn.setMinWidth(100);
			GPAColumn.setCellValueFactory(new PropertyValueFactory<>("GPA"));

			TableColumn<Student, Double> totalUnitsColumn = new TableColumn<>("TotalUnits");
			totalUnitsColumn.setMinWidth(100);
			totalUnitsColumn.setCellValueFactory(new PropertyValueFactory<>("totalUnits"));

			TableColumn<Student, Double> dueTuitionColumn = new TableColumn<>("DueTuition");
			dueTuitionColumn.setMinWidth(100);
			dueTuitionColumn.setCellValueFactory(new PropertyValueFactory<>("dueTuition"));

			RegisterJDBC.excuteSQL(sql);

			studentTable.setItems(getStudent());
			studentTable.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, addressColumn,
					stateColumn, zipCodeColumn, SSNColumn, DOBColumn, majorColumn, genderColumn,
					GPAColumn, totalUnitsColumn, dueTuitionColumn);
		}
		else if(instructorRadio.isSelected()){
			sql = "SELECT * FROM Instructor WHERE FirstName = '" + search + "' OR " + "LastName = '" + search
					+ "' OR instructorID = '" + search + "'";
			RegisterJDBC.excuteSQL(sql);
			while(RegisterJDBC.result.next()){

			}
		}
		else {
			sql = "SELECT * FROM Student WHERE FirstName = '" + search + "' OR " + "LastName = '" + search
					+ "' OR studentID = '" + search + "'";
			RegisterJDBC.excuteSQL(sql);
			while(RegisterJDBC.result.next()){

			}
		}
	}

	// Button listener for adding new student into database with information from Textfield
	public void addStudentButtonListener() throws SQLException {
		String sql = "INSERT INTO Student(StudentID, FirstName, LastName, Address, City, State,"
				+ "ZipCode, SSN, DOB, Major, Gender, GPA, TotalUnits, DueTuition) VALUES"
				+ "('" + studentID.getText() + "'," + "'" + firstName.getText() + "'," + "'" + lastName.getText() + "',"
				+ "'" + address.getText() + "'," + "'" + city.getText() + "'," + "'" + state.getText() + "',"
				+ "'" + zipCode.getText() + "'," + "'" + SSN.getText() + "'," + "'" + DOB.getText() + "',"
				+ "'" + major.getText() + "'," + "'" + gender.getText() + "'," + "'" + Double.parseDouble(GPA.getText()) + "',"
				+ "'" + Double.parseDouble(totalUnits.getText()) + "',"+ "'" + Double.parseDouble(dueTuition.getText()) + "')";
		RegisterJDBC.excuteSQL(sql);
	}

	// Button listener for deleting a student from the database.
	public void deleteStudentButtonListener() throws SQLException {
		String sql = "DELETE FROM Student WHERE StudentID =" + "'" + studentID.getText() + "'";
		RegisterJDBC.excuteSQL(sql);
	}

	// Button listener for adding new course into database with information from Textfield
	public void addCourseButtonListener() {

	}

	// Button listener for deleting a student from the database.
	public void deleteCourseButtonListener() throws SQLException {
		String sql = "DELETE FROM Course WHERE CourseCode =" + "'" + courseCode.getText() + "'";
		RegisterJDBC.excuteSQL(sql);
	}

	// Button listener for executing a SQL statement.
	public void excuteSQLButtonListener() throws SQLException {
		System.out.println(SQLArea.getText());
		RegisterJDBC.excuteSQL(SQLArea.getText());
	}

	ObservableList<Student> getStudent() throws SQLException{
		ObservableList<Student> students = FXCollections.observableArrayList();
		while(RegisterJDBC.result.next()){
		students.add(new Student(RegisterJDBC.result.getString("StudentID"), RegisterJDBC.result.getString("FirstName"),
				RegisterJDBC.result.getString("LastNAME"), RegisterJDBC.result.getString("Address"),
				RegisterJDBC.result.getString("City"), RegisterJDBC.result.getString("State"),
				RegisterJDBC.result.getString("ZipCode"), RegisterJDBC.result.getString("SSN"),
				RegisterJDBC.result.getString("DOB"), RegisterJDBC.result.getString("Major"),
				RegisterJDBC.result.getString("Gender"),
				Double.parseDouble(RegisterJDBC.result.getString("GPA")),
				Double.parseDouble(RegisterJDBC.result.getString("FurtureTuition")),
				Double.parseDouble(RegisterJDBC.result.getString("DueTuition")),
				Double.parseDouble(RegisterJDBC.result.getString("TotalUnits")),
				Double.parseDouble(RegisterJDBC.result.getString("CurrentUnits")),
				RegisterJDBC.result.getString("Password")));
		}
		return students;
	}

	ObservableList<Instructor> getInstructor(){
		ObservableList<Instructor> instructors = FXCollections.observableArrayList();
		instructors.add(new Instructor());
		return instructors;
	}

	ObservableList<Course> getCourse(){
		ObservableList<Course> courses = FXCollections.observableArrayList();
		courses.add(new Course());
		return courses;
	}
}
