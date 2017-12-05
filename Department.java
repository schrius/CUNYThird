package Register;

public class Department {
	String departmentName;
	int staff;
	
	Department() {
		this.departmentName = "";
		this.staff = 0;
	}
	Department(String departmentName, int staff) {
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

}
