package com.coding_camp.dao;

import java.util.List;

import com.coding_camp.exceptions.CourseException;
import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Course;
import com.coding_camp.model.Student;


public interface CourseDao {
	
	public List<Integer> getCourseId() throws CourseException;
	
	public List<Course> getCourses() throws CourseException;
	
	public String changeCourseName(String oldCourseName, String newCourseName) throws CourseException;
	
	public String changeCourseFee(int fee, String courseName) throws CourseException;
	
	public String changeCourseDuration(String duration, String courseName) throws CourseException;
	
	public String addCourse(Course course) throws CourseException;
	
	public String deleteCourse(String courseName) throws CourseException;
	
	public List<Student> getAllStudentByCourseName(String course) throws StudentException;
}
