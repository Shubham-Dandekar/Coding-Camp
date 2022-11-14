package com.coding_camp.model;

public class Student {
	private int studentCode;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private String gender;
	private String dateOfBirth;
	private String address;
	private String contactNo;
	private String email;
	private String password;
	
	public Student(int studentCode, String firstName, String lastName, String fatherName, String motherName, String gender,
			String dateOfBirth, String address, String contactNo, String email, String password) {
		super();
		this.studentCode = studentCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}

	public Student(String firstName, String lastName, String fatherName, String motherName, String gender,
			String dateOfBirth, String address, String contactNo, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}

	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", password="
				+ password + "]";
	}	
}
