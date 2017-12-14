package Register;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Student class for student field
 */
public class Student implements TableEntry{
	
	StringProperty studentId = new SimpleStringProperty();
	StringProperty firstName = new SimpleStringProperty();
	StringProperty lastName = new SimpleStringProperty();
	StringProperty email = new SimpleStringProperty();
	StringProperty address = new SimpleStringProperty();
	StringProperty city = new SimpleStringProperty();
	StringProperty state = new SimpleStringProperty();
	StringProperty zipCode = new SimpleStringProperty();
	StringProperty socialSecurityNumber = new SimpleStringProperty();
	StringProperty DateOfBirth = new SimpleStringProperty();
	StringProperty Major = new SimpleStringProperty();
	StringProperty gender = new SimpleStringProperty();
	StringProperty password = new SimpleStringProperty();
	DoubleProperty GPA = new SimpleDoubleProperty();
	DoubleProperty furtureTuition = new SimpleDoubleProperty();
	DoubleProperty dueTuition = new SimpleDoubleProperty();
	DoubleProperty totalUnits = new SimpleDoubleProperty();
	DoubleProperty currentUnit = new SimpleDoubleProperty();
	public Student(StringProperty studentId, StringProperty firstName, StringProperty lastName, StringProperty email, StringProperty address,
			StringProperty city, StringProperty state, StringProperty zipCode, StringProperty socialSecurityNumber,
			StringProperty dateOfBirth, StringProperty major, StringProperty gender, StringProperty password,
			DoubleProperty gPA, DoubleProperty furtureTuition, DoubleProperty dueTuition, DoubleProperty totalUnits,
			DoubleProperty currentUnit) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.socialSecurityNumber = socialSecurityNumber;
		DateOfBirth = dateOfBirth;
		Major = major;
		this.gender = gender;
		this.password = password;
		GPA = gPA;
		this.furtureTuition = furtureTuition;
		this.dueTuition = dueTuition;
		this.totalUnits = totalUnits;
		this.currentUnit = currentUnit;
	}
	public Student(String id, String firstName, String lastName, String email, String address, String city,
			String state, String zipCode, String socialSecurityNumber,
			String DOB, String Major, String gender, double GPA, double furtureTuition,
			double dueTuition, double totalUnits, double currentUnit, String password){
		this.studentId.set(id);
		this.firstName.set(firstName);
		this.lastName.set(lastName);
		this.email.set(email);
		this.address.set(address);
		this.city.set(city);
		this.state.set(state);
		this.zipCode.set(zipCode);
		this.socialSecurityNumber.set(socialSecurityNumber);
		this.DateOfBirth.set(DOB);
		this.Major.set(Major);
		this.gender.set(gender);
		this.GPA.set(GPA);
		this.furtureTuition.set(furtureTuition);
		this.dueTuition.set(dueTuition);
		this.totalUnits.set(totalUnits);
		this.currentUnit.set(currentUnit);
		this.password.set(password);
	}
	public String getStudentId() {
		return studentId.get();
	}
	public void setStudentId(String studentId) {
		this.studentId.set(studentId);;
	}
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	public String getLastName() {
		return lastName.get();
	}
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public String getAddress() {
		return address.get();
	}
	public void setAddress(String address) {
		this.address.set(address);
	}
	public String getCity() {
		return city.get();
	}
	public void setCity(String city) {
		this.city.set(city);
	}
	public String getState() {
		return state.get();
	}
	public void setState(String state) {
		this.state.set(state);
	}
	public String getZipCode() {
		return zipCode.get();
	}
	public void setZipCode(String zipCode) {
		this.zipCode.set(zipCode);
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber.get();
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber.set(socialSecurityNumber);
	}
	public String getDateOfBirth() {
		return DateOfBirth.get();
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth.set(dateOfBirth);
	}
	public String getMajor() {
		return Major.get();
	}
	public void setMajor(String major) {
		this.Major.set(major);
	}
	public String getGender() {
		return gender.get();
	}
	public void setGender(String gender) {
		this.gender.set(gender);
	}
	public double getGPA() {
		return GPA.get();
	}
	public void setGPA(double GPA) {
		this.GPA.set(GPA);
	}
	public double getFurtureTuition() {
		return furtureTuition.get();
	}
	public void setFurtureTuition(double furtureTuition) {
		this.furtureTuition.set(furtureTuition);
	}
	public double getDueTuition() {
		return dueTuition.get();
	}
	public void setDueTuition(double dueTuition) {
		this.dueTuition.set(dueTuition);
	}
	public double getTotalUnits() {
		return totalUnits.get();
	}
	public void setTotalUnits(double totalUnits) {
		this.totalUnits.set(totalUnits);
	}
	public double getCurrentUnit() {
		return currentUnit.get();
	}
	public void setCurrentUnit(double currentUnit) {
		this.currentUnit.set(currentUnit);
	}
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password.set(password);
	}
// these method are used for binding with label in real time.
	public DoubleProperty getDue() {
		return dueTuition;
	}
	public DoubleProperty getFurtureDue() {
		return furtureTuition;
	}
}

