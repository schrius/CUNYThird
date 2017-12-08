package Register;
/*
 * instructor class, data about the instructors. InstructorID is a foreign key for courses.
 */
public class Instructor {
	String instructorId;
	String firstName;
	String lastName;
	String department;
	String office;
	String phone;
	String hireDate;
	double salary;
	
	public Instructor(){
		
	}

	public Instructor(String instructorId, String firstName, String lastName, String department, String office,
			String phone, String hireDate, double salary) {
		super();
		this.instructorId = instructorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.office = office;
		this.phone = phone;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}	
}
