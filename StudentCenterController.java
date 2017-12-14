package Register;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/*
 * student center controller handle all student input, such as
 * search/add course, make pay payment.
 * 
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


public class StudentCenterController implements Initializable{
	Student student;
	@FXML
	private Button paymentButton;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private TextField searchField;
	@FXML
	private BorderPane borderPane;
	
	@FXML
	private TableView<? extends TableEntry> table;
	
	@FXML
	private Label owe;
	@FXML
	private Label dueNow;
	@FXML
	private Label furtureDue;
	@FXML
	private Label status;
	@FXML
	private Label GPA;
	@FXML
	private Label units;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			student = new Student(RegisterJDBC.result.getString("StudentID"), 
					RegisterJDBC.result.getString("FirstName"),
					RegisterJDBC.result.getString("LastNAME"), 
					RegisterJDBC.result.getString("Email"),
					RegisterJDBC.result.getString("Address"),
					RegisterJDBC.result.getString("City"), 
					RegisterJDBC.result.getString("State"),
					RegisterJDBC.result.getString("ZipCode"), 
					RegisterJDBC.result.getString("SSN"),
					RegisterJDBC.result.getString("DOB"), 
					RegisterJDBC.result.getString("Major"),
					RegisterJDBC.result.getString("Gender"),
					Double.parseDouble(RegisterJDBC.result.getString("GPA")),
					Double.parseDouble(RegisterJDBC.result.getString("FurtureTuition")),
					Double.parseDouble(RegisterJDBC.result.getString("DueTuition")),
					Double.parseDouble(RegisterJDBC.result.getString("TotalUnits")),
					Double.parseDouble(RegisterJDBC.result.getString("CurrentUnits")),
					RegisterJDBC.result.getString("Password"));
			owe.setText(Double.toString(student.getFurtureTuition() + student.getDueTuition()));
			dueNow.setText(Double.toString(student.getDueTuition()));
			furtureDue.setText(Double.toString(student.getFurtureTuition()));
			GPA.setText(Double.toString(student.getGPA()));
			units.setText(Double.toString(student.getTotalUnits()));
			if(student.getTotalUnits() > 90) {
				 status.setText("Senior");
			}else if(student.getTotalUnits() > 60) {
				 status.setText("Junior");
			}else if(student.getTotalUnits() > 30) {
				 status.setText("Sophomore");
			}else status.setText("FreshMan");
			
			dueNow.textProperty().bind(Bindings.convert(student.getDue()));
			furtureDue.textProperty().bind(Bindings.convert(student.getFurtureDue()));
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void searchListener() throws SQLException{
		String search = searchField.getText();
		String sql;
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
		
		TableColumn<Course, String> instructorColumn = new TableColumn<>("Instructor");
		instructorColumn.setMinWidth(100);
		instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));
		
		TableColumn<Course, String> descriptionColumn = new TableColumn<>("Description");
		descriptionColumn.setMinWidth(100);
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		
		TableColumn<Course, Double> courseUnitsColumn = new TableColumn<>("Units");
		courseUnitsColumn.setMinWidth(100);
		courseUnitsColumn.setCellValueFactory(new PropertyValueFactory<>("units"));
		
		TableView<Course> courseTable = new TableView<>();
		courseTable.setItems(getCourse());
		courseTable.getColumns().addAll(courseCodeColumn, CourseNameColumn, semesterColumn, roomColumn,
				departmentColumn, startDateColumn, endDateColumn, daysColumn, timeColumn,
				requiredCourseColumn, instructorColumn, descriptionColumn, courseUnitsColumn);
		this.table = courseTable;
		borderPane.setCenter(courseTable);
		System.out.println("Search student..");
	}
	
	public void paymentListener(){
		new MakePayment().pay(student);
		if(MakePayment.complete) owe.setText(Double.toString(student.getDueTuition()+student.getFurtureTuition()));
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
					RegisterJDBC.result.getString("Instructor"), 
					RegisterJDBC.result.getString("Department"), 
					RegisterJDBC.result.getString("RequiredCourse")));
			System.out.println(courses.size() + " Rows has been found");
		}
		System.out.println(courses.size() + " Rows has been found");
		return courses;
	}

}
