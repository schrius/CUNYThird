package Register;
/*
 * Department for all course, majors.
 * It served as foreign key for majors, course and instructor in the database.
 */
public class Department {
	final String[] department = {"Accounting", "Anthropology", "Art", "Business Management", "Biology", "Chemistry",
			"Comp Info Science", "Economics", "English", "History", "Mathematics", "Philosophy", "Physics", 
	"Psychology", "Sociology"}; 
	String departmentNumber;
	String departmentName;
	int staff;
	
	Department() {
		this.departmentNumber = "";
		this.departmentName = "";
		this.staff = 0;
	}
	Department(String departmentNumber, String departmentName, int staff) {
		this.departmentNumber = departmentName;
		this.departmentName = departmentName;
		this.staff = staff;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public int getStaff() {
		return staff;
	}
	public void setStaff(int staff) {
		this.staff = staff;
	}
	public String getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public String[] getDepartment() {
		return department;
	}

}
