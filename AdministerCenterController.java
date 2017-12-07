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
import javafx.scene.control.ToggleGroup;
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
	private TextField departmentNumber;

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
	private TableView<Student> table;

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
	@FXML
	private ToggleGroup toggleGroupSearch;

	//search Field for generate Database.
	@SuppressWarnings("unchecked")
	public void searchButtonListerner() throws ClassNotFoundException, SQLException{
		String search = searchField.getText();
		String sql;

		if(courseRadio.isSelected()){
			sql = "SELECT * FROM Course WHERE CourseName = '" + search + "' OR " + "CourseCode = '" + search + "'";
			RegisterJDBC.excuteSQL(sql);
			TableColumn<Course, String> courseCodeColumn = new TableColumn<>("CourseCode");
			courseCodeColumn.setMinWidth(100);
			courseCodeColumn.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
			
			TableColumn<Course, String> CourseNameColumn = new TableColumn<>("CourseName");
			CourseNameColumn.setMinWidth(100);
			CourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
			
			TableColumn<Course, String> semesterColumn = new TableColumn<>("Semester");
			semesterColumn.setMinWidth(100);
			semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
			
			TableColumn<Course, String> roomColumn = new TableColumn<>("Room");
			roomColumn.setMinWidth(100);
			roomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
			
			TableColumn<Course, String> departmentColumn = new TableColumn<>("Department");
			departmentColumn.setMinWidth(100);
			departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
			
			TableColumn<Course, String> startDateColumn = new TableColumn<>("StartDate");
			startDateColumn.setMinWidth(100);
			startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
			
			TableColumn<Course, String> endDateColumn = new TableColumn<>("EndDate");
			endDateColumn.setMinWidth(100);
			endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
			
			TableColumn<Course, String> daysColumn = new TableColumn<>("Days");
			daysColumn.setMinWidth(100);
			daysColumn.setCellValueFactory(new PropertyValueFactory<>("days"));
			
			TableColumn<Course, String> timeColumn = new TableColumn<>("Time");
			timeColumn.setMinWidth(100);
			timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
			
			TableColumn<Course, String> requiredCourseColumn = new TableColumn<>("RequiredCourse");
			requiredCourseColumn.setMinWidth(100);
			requiredCourseColumn.setCellValueFactory(new PropertyValueFactory<>("requiredCourse"));
			
			TableColumn<Course, String> InstructorFirstNameColumn = new TableColumn<>("Instructor FirstName");
			InstructorFirstNameColumn.setMinWidth(100);
			InstructorFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("instructorFirstName"));
			
			TableColumn<Course, String> instructorLastNameColumn = new TableColumn<>("Instructor LastName");
			instructorLastNameColumn.setMinWidth(100);
			instructorLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("instructorLastName"));
			
			TableColumn<Course, String> descriptionColumn = new TableColumn<>("Description");
			descriptionColumn.setMinWidth(100);
			descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
			
			TableColumn<Course, Double> courseUnitsColumn = new TableColumn<>("Units");
			courseUnitsColumn.setMinWidth(100);
			courseUnitsColumn.setCellValueFactory(new PropertyValueFactory<>("units"));
		}
		else if(instructorRadio.isSelected()){
			sql = "SELECT * FROM Instructor WHERE FirstName = '" + search + "' OR " + "LastName = '" + search
					+ "' OR instructorID = '" + search + "'";
			RegisterJDBC.excuteSQL(sql);
			TableColumn<Instructor, String> instructorIDColumn = new TableColumn<>("InstructorID");
			instructorIDColumn.setMinWidth(100);
			instructorIDColumn.setCellValueFactory(new PropertyValueFactory<>("InstructorID"));
			
			TableColumn<Instructor, String> instructorFirstNameColumn = new TableColumn<>("FirstName");
			instructorFirstNameColumn.setMinWidth(100);
			instructorFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));

			TableColumn<Instructor, String> instructorLastNameColumn = new TableColumn<>("LastName");
			instructorLastNameColumn.setMinWidth(100);
			instructorLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			
			TableColumn<Instructor, String> departmentLastNameColumn = new TableColumn<>("Department");
			departmentLastNameColumn.setMinWidth(100);
			departmentLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
			
			TableColumn<Instructor, String> officeColumn = new TableColumn<>("Office");
			officeColumn.setMinWidth(100);
			officeColumn.setCellValueFactory(new PropertyValueFactory<>("office"));

			TableColumn<Instructor, String> phoneColumn = new TableColumn<>("Phone");
			phoneColumn.setMinWidth(100);
			phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

			TableColumn<Instructor, String> hireDateColumn = new TableColumn<>("HireDate");
			hireDateColumn.setMinWidth(100);
			hireDateColumn.setCellValueFactory(new PropertyValueFactory<>("hireDate"));

			TableColumn<Instructor, Double> salaryColumn = new TableColumn<>("Salary");
			salaryColumn.setMinWidth(100);
			salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
			
		}
		else {
			sql = "SELECT * FROM Student WHERE FirstName = '" + search + "' OR " + "LastName = '" + search
					+ "' OR StudentID = '" + search + "'";
			RegisterJDBC.excuteSQL(sql);

			TableColumn<Student, String> idColumn = new TableColumn<>("StudentID");
			idColumn.setMinWidth(100);
			idColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));

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
			zipCodeColumn.setCellValueFactory(new PropertyValueFactory<>("zipCode"));

			TableColumn<Student, String> SSNColumn = new TableColumn<>("SSN");
			SSNColumn.setMinWidth(100);
			SSNColumn.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));

			TableColumn<Student, String> DOBColumn = new TableColumn<>("DOB");
			DOBColumn.setMinWidth(100);
			DOBColumn.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));

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

			table.setItems(getStudent());
			table.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, addressColumn,
					cityColumn, stateColumn, zipCodeColumn, SSNColumn, DOBColumn, majorColumn, genderColumn,
					GPAColumn, totalUnitsColumn, dueTuitionColumn);
			System.out.println("Search student..");
		}
	}

	// Button listener for adding new student into database with information from Textfield
	public void addStudentButtonListener() throws SQLException {
		String sql = "INSERT INTO Student(StudentID, FirstName, LastName, Address, City, State,"
				+ "ZipCode, SSN, DOB, Major, Gender, GPA, TotalUnits, DueTuition) VALUES"
				+ "(" + studentID.getText() + "," + "'" + firstName.getText() + "'," + "'" + lastName.getText() + "',"
				+ "'" + address.getText() + "'," + "'" + city.getText() + "'," + "'" + state.getText() + "',"
				+ "'" + zipCode.getText() + "'," + "'" + SSN.getText() + "'," + "'" + DOB.getText() + "',"
				+ "'" + major.getText() + "'," + "'" + gender.getText() + "'," + GPA.getText() + ","
				 + totalUnits.getText() + ","+ dueTuition.getText() + ")";
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
				Double.parseDouble(RegisterJDBC.result.getString("CurrentUnit")),
				RegisterJDBC.result.getString("Password")));
		}
		System.out.println(students.size() + " Rows has been found");
		return students;
	}

	ObservableList<Instructor> getInstructor() throws SQLException{
		ObservableList<Instructor> instructors = FXCollections.observableArrayList();
		while(RegisterJDBC.result.next()){
			instructors.add(new Instructor(RegisterJDBC.result.getString("InstructorID"), 
					RegisterJDBC.result.getString("FirstName"), 
					RegisterJDBC.result.getString("LastName"), 
					RegisterJDBC.result.getString("Department"),
					RegisterJDBC.result.getString("Office"),
					RegisterJDBC.result.getString("Phone"),
					RegisterJDBC.result.getString("HireDate"),
					Double.parseDouble(RegisterJDBC.result.getString("Salary"))
					));
		}
		System.out.println(instructors.size() + " Rows has been found");
		return instructors;
	}

	ObservableList<Course> getCourse() throws NumberFormatException, SQLException{
		ObservableList<Course> courses = FXCollections.observableArrayList();
		while(RegisterJDBC.result.next()){
			courses.add(new Course(RegisterJDBC.result.getString("CourseCode"), 
					RegisterJDBC.result.getString("CourseName"), 
					RegisterJDBC.result.getString("Description"), 
					RegisterJDBC.result.getString("Semester"),
					RegisterJDBC.result.getString("Room"), 
					RegisterJDBC.result.getString("StartDate"), 
					RegisterJDBC.result.getString("EndDate"), 
					RegisterJDBC.result.getString("Days"), 
					RegisterJDBC.result.getString("Time"), 
					Double.parseDouble(RegisterJDBC.result.getString("Units")), 
					RegisterJDBC.result.getString("InstructorFirstName"), 
					RegisterJDBC.result.getString("InstructorLastName"), 
					RegisterJDBC.result.getString("Department"), 
					RegisterJDBC.result.getString("RequiredCourse")));
			System.out.println(courses.size() + " Rows has been found");
		}
		return courses;
	}
}
