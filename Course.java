package Register;
/*
 * Course class, use for table view, store data in SQL
 */
public class Course {
	String courseCode;
	String courseName;
	String description;
	String semester;
	String room;
	String startDate;
	String endDate;
	String days;
	String time;
	String requiredCourse;
	double units;
	String instructorFirstName;
	String instructorLastName;
	String department;
	
	public Course() {

	}

	public Course(String courseCode, String courseName, String description, String semester, String room,
			String startDate, String endDate, String time, String days, double units, String instructorFirstName, 
			String instructorLastName, String department, String requiredCourse) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.description = description;
		this.semester = semester;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
		this.time = time;
		this.days = days;
		this.units = units;
		this.instructorFirstName = instructorFirstName;
		this.instructorLastName = instructorLastName;
		this.department = department;
		this.requiredCourse = requiredCourse;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public double getUnits() {
		return units;
	}
	public void setUnits(double units) {
		this.units = units;
	}
	public String getInstructorFirstName() {
		return instructorFirstName;
	}
	public void setInstructorFirstName(String instructorFirstName) {
		this.instructorFirstName = instructorFirstName;
	}
	public String getInstructorLastName() {
		return instructorLastName;
	}
	public void setInstructorLastName(String instructorLastName) {
		this.instructorLastName = instructorLastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRequiredCourse() {
		return requiredCourse;
	}
	public void setRequiredCourse(String requiredCourse){
		this.requiredCourse = requiredCourse;
	}
	
}
