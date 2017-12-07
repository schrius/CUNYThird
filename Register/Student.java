package Register;

public class Student {
	String studentId;
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zipCode;
	String socialSecurityNumber;
	String DateOfBirth;
	String Major;
	String gender;
	String password;
	double GPA;
	double furtureTuition;
	double dueTuition;
	double totalUnits;
	double currentUnit;
	public Student() {
		
	}
	public Student(String id, String firstName, String lastName, String address, String city,
			String state, String zipCode, String socialSecurityNumber,
			String DOB, String Major, String gender, double GPA, double furtureTuition,
			double dueTuition, double totalUnits, double currentUnit, String password){
		this.studentId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.socialSecurityNumber = socialSecurityNumber;
		this.DateOfBirth = DOB;
		this.Major = Major;
		this.gender = gender;
		this.GPA = GPA;
		this.furtureTuition = furtureTuition;
		this.dueTuition = dueTuition;
		this.totalUnits = totalUnits;
		this.currentUnit = currentUnit;
		this.password = password;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasttName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) {
		Major = major;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	public double getFurtureTuition() {
		return furtureTuition;
	}
	public void setFurtureTuition(double furtureTuition) {
		this.furtureTuition = furtureTuition;
	}
	public double getDueTuition() {
		return dueTuition;
	}
	public void setDueTuition(double dueTuition) {
		this.dueTuition = dueTuition;
	}
	public double getTotalUnits() {
		return totalUnits;
	}
	public void setTotalUnits(double totalUnits) {
		this.totalUnits = totalUnits;
	}
	public double getCurrentUnit() {
		return currentUnit;
	}
	public void setCurrentUnit(double currentUnit) {
		this.currentUnit = currentUnit;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	
}
