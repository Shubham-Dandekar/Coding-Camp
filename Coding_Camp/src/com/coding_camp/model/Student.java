package com.coding_camp.model;

public class Student {
	private int rollNo;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private String gender;
	private String dateOfBirth;
	private String address;
	private int contactNo;
	private String email;
	private String password;
	
	public Student(int rollNo, String firstName, String lastName, String fatherName, String motherName, String gender,
			String dateOfBirth, String address, int contactNo, String email, String password) {
		super();
		this.rollNo = rollNo;
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

	public int getRoll() {
		return rollNo;
	}

	public void setRoll(int roll) {
		this.rollNo = roll;
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

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
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
		return "Student [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", fatherName="
				+ fatherName + ", motherName=" + motherName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", password=" + password
				+ "]";
	}
	
}
