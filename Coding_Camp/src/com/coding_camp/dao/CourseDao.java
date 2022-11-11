package com.coding_camp.dao;

import java.util.List;

import com.coding_camp.exceptions.CourseException;
import com.coding_camp.model.Course;
import com.coding_camp.model.StudentCourseDTO;

public interface CourseDao {
	public String changeCourseName(String course) throws CourseException;
	
	public String changeCourseFee(String fee) throws CourseException;
	
	public String changeCourseDuration(String duration) throws CourseException;
	
	public String addCourse(Course course) throws CourseException;
	
	public String deleteCourse(String course) throws CourseException;
	
	public List<StudentCourseDTO> getAllStudentByCourseName(String course) throws CourseException;
}
