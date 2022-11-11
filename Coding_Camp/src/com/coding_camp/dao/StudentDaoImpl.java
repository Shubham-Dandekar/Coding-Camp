package com.coding_camp.dao;

import java.util.List;

import com.coding_camp.exceptions.CourseException;
import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Student;
import com.coding_camp.model.StudentCourseDTO;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String registerStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showStudentDetails(int rollNo) throws StudentException, CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(int rollNo) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentFirstName(String firstName) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentLastName(String lastName) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentFatherName(String fatherName) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentMotherName(String motherName) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentGender(String gender) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentDateOfBirth(String dateOfBirth) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentPassword(String password) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentAddress(String address) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStudentContactNo(String contactNo) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerStudentCourse(int rollNo) throws StudentException, CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeStudentCourse(int rollNo) throws StudentException, CourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCourseDTO> getAllStudentByAddress(String address) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
