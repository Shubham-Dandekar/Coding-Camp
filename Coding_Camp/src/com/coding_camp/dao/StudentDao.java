package com.coding_camp.dao;

import java.util.List;

import com.coding_camp.exceptions.CourseException;
import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Student;
import com.coding_camp.model.StudentCourseDTO;

public interface StudentDao {
	
	public String registerStudent(Student student) throws StudentException;	
	
	public StudentCourseDTO showStudentDetails(int studentCode) throws StudentException, CourseException;
	
	public String deleteStudent(int studentCode) throws StudentException;
	
	public int studentLogIn(String email, String password) throws StudentException;
	
	public String getStudentFirstName(int studentCode) throws StudentException;
	
	public String changeStudentFirstName(String firstName, int studentCode) throws StudentException;

	public String changeStudentLastName(String lastName, int studentCode) throws StudentException;
	
	public String changeStudentFatherName(String fatherName, int studentCode) throws StudentException;
	
	public String changeStudentMotherName(String motherName, int studentCode) throws StudentException;
	
	public String changeStudentGender(String gender, int studentCode) throws StudentException;
	
	public String changeStudentDateOfBirth(String dateOfBirth, int studentCode) throws StudentException;
	
	public String getStudentPassword(int studentCode) throws StudentException;
	
	public String changeStudentPassword(String password, int studentCode) throws StudentException;
	
	public String changeStudentAddress(String address, int studentCode) throws StudentException;
	
	public String changeStudentContactNo(String contactNo, int studentCode) throws StudentException;
	
	public String registerStudentNewCourse(int studentCode, int courseId) throws StudentException, CourseException;
	
	public String removeStudentFromCourse(int studentCode, String courseName) throws StudentException, CourseException;
	
	public List<Student> getAllStudentByAddress(String address) throws StudentException;
}