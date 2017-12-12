package Register;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Course class, use for table view, store data in SQL
 */
public class Course implements TableEntry{
	StringProperty courseCode = new SimpleStringProperty();
	StringProperty courseName = new SimpleStringProperty();
	StringProperty description = new SimpleStringProperty();
	StringProperty semester = new SimpleStringProperty();
	StringProperty room = new SimpleStringProperty();
	StringProperty startDate = new SimpleStringProperty();
	StringProperty endDate = new SimpleStringProperty();
	StringProperty days = new SimpleStringProperty();
	StringProperty time = new SimpleStringProperty();
	StringProperty requiredCourse = new SimpleStringProperty();
	DoubleProperty units = new SimpleDoubleProperty();
	StringProperty instructor = new SimpleStringProperty();
	StringProperty department = new SimpleStringProperty();
	
	public Course() {

	}

	public Course(String courseCode, String courseName, String description, String semester, String room,
			String startDate, String endDate, String time, String days, double units, String instructor,
			String department, String requiredCourse) {
		super();
		this.courseCode.set(courseCode);
		this.courseName.set(courseName);
		this.description.set(description);
		this.semester.set(semester);
		this.room.set(room);
		this.startDate.set(startDate);
		this.endDate.set(endDate);
		this.time.set(time);
		this.days.set(days);
		this.units.set(units);
		this.instructor.set(instructor);
		this.department.set(department);
		this.requiredCourse.set(requiredCourse);
	}
	public String getCourseCode() {
		return courseCode.get();
	}
	public void setCourseCode(String courseCode) {
		this.courseCode.set(courseCode);
	}
	public String getCourseName() {
		return courseName.get();
	}
	public void setCourseName(String courseName) {
		this.courseName.set(courseName);
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}
	public String getSemester() {
		return semester.get();
	}
	public void setSemester(String semester) {
		this.semester.set(semester);
	}
	public String getRoom() {
		return room.get();
	}
	public void setRoom(String room) {
		this.room.set(room);
	}
	public String getStartDate() {
		return startDate.get();
	}
	public void setStartDate(String startDate) {
		this.startDate.set(startDate);
	}
	public String getEndDate() {
		return endDate.get();
	}
	public void setEndDate(String endDate) {
		this.endDate.set(endDate);
	}
	public String getTime() {
		return time.get();
	}
	public void setTime(String time) {
		this.time.set(time);
	}
	public String getDays() {
		return days.get();
	}

	public void setDays(String days) {
		this.days.set(days);
	}

	public double getUnits() {
		return units.get();
	}
	public void setUnits(double units) {
		this.units.set(units);
	}
	public String getInstructor() {
		return instructor.get();
	}
	public void setInstructor(String instructor) {
		this.instructor.set(instructor);
	}

	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department.set(department);
	}
	public String getRequiredCourse() {
		return requiredCourse.get();
	}
	public void setRequiredCourse(String requiredCourse){
		this.requiredCourse.set(requiredCourse);
	}
}
