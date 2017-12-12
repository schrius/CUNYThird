package Register;
/*
 * instructor class, data about the instructors. InstructorID is a foreign key for courses.
*/

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Instructor implements TableEntry{
	private StringProperty instructorID = new SimpleStringProperty();
	private StringProperty  firstName = new SimpleStringProperty();;
	private StringProperty  lastName = new SimpleStringProperty();;
	private StringProperty  department = new SimpleStringProperty();;
	private StringProperty  office = new SimpleStringProperty();;
	private StringProperty  phone = new SimpleStringProperty();;
	private StringProperty  hireDate = new SimpleStringProperty();;
	private DoubleProperty  salary = new SimpleDoubleProperty();;
	public Instructor(StringProperty instructorID, StringProperty firstName, StringProperty lastName,
			StringProperty department, StringProperty office, StringProperty phone, StringProperty hireDate,
			DoubleProperty salary) {
		super();
		this.instructorID = instructorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.office = office;
		this.phone = phone;
		this.hireDate = hireDate;
		this.salary = salary;
	}
	public Instructor(String instructorID, String firstName, String lastName, String department, String office,
			String phone, String hireDate, double salary) {
		this.instructorID.set(instructorID);
		this.firstName.set(firstName);
		this.lastName.set(lastName);
		this.department.set(department);
		this.office.set(office);
		this.phone.set(phone);
		this.hireDate.set(hireDate);
		this.salary.set(salary);
	}
	public String getInstructorID() {
		return instructorID.get();
	}
	public void setInstructorID(String instructorID) {
		this.instructorID.set(instructorID);
	}
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);;
	}
	public String getLastName() {
		return lastName.get();
	}
	public void setLastName(String lastName) {
		this.lastName.set(lastName);;
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department.set(department);;
	}
	public String getOffice() {
		return office.get();
	}
	public void setOffice(String office) {
		this.office.set(office);
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public String getHireDate() {
		return hireDate.get();
	}
	public void setHireDate(String hireDate) {
		this.hireDate.set(hireDate);;
	}
	public double getSalary() {
		return salary.get();
	}
	public void setSalary(double salary) {
		this.salary.set(salary);;
	}
}