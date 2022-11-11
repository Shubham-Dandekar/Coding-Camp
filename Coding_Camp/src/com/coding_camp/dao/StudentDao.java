package com.coding_camp.dao;

import java.util.List;

import com.coding_camp.exceptions.CourseException;
import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Student;
import com.coding_camp.model.StudentCourseDTO;

public interface StudentDao {
	
	public String registerStudent(Student student) throws StudentException;	
	
	public String showStudentDetails(int rollNo) throws StudentException, CourseException;
	
	public String deleteStudent(int rollNo) throws StudentException;
	
	public String changeStudentFirstName(String firstName) throws StudentException;

	public String changeStudentLastName(String lastName) throws StudentException;
	
	public String changeStudentFatherName(String fatherName) throws StudentException;
	
	public String changeStudentMotherName(String motherName) throws StudentException;
	
	public String changeStudentGender(String gender) throws StudentException;
	
	public String changeStudentDateOfBirth(String dateOfBirth) throws StudentException;
	
	public String changeStudentPassword(String password) throws StudentException;
	
	public String changeStudentAddress(String address) throws StudentException;
	
	public String changeStudentContactNo(String contactNo) throws StudentException;
	
	public String registerStudentCourse(int rollNo) throws StudentException, CourseException;
	
	public String removeStudentCourse(int rollNo) throws StudentException, CourseException;
	
	public List<StudentCourseDTO> getAllStudentByAddress(String address) throws StudentException;
}