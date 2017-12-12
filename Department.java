package Register;
/*
 * Department for all course, majors.
 * It served as foreign key for majors, course and instructor in the database.
 */
public class Department {
	public static enum depart{ACCOUNTING, BUSINESS, FINANCE} 
	//final static String DEPTNO[] = {"ACCT01"};
	final static String DEPTNAME[] = {"Accouting"};
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

}
