package com.coding_camp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coding_camp.exceptions.CourseException;
import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Course;
import com.coding_camp.model.Student;
import com.coding_camp.utility.DBUtil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public String changeCourseName(String oldCourseName, String newCourseName) throws CourseException {
		String message = oldCourseName + " not updated";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Course_Name=? where Course_Name=?");
			ps.setString(1, oldCourseName);
			ps.setString(2, newCourseName);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = oldCourseName + " has been changed to " + newCourseName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeCourseFee(int fee, String courseName) throws CourseException {
		String message = courseName + "'s fee not updated";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Course_Fee=? where Course_Name=?");
			ps.setInt(1, fee);
			ps.setString(2, courseName);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = courseName + "'s fee has been changed to " + fee;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeCourseDuration(String duration, String courseName) throws CourseException {
		String message = courseName + "'s duration not updated";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Course_Duration=? where Course_Name=?");
			ps.setString(1, duration);
			ps.setString(2, courseName);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = courseName + "'s duration has been changed to " + duration;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String addCourse(Course course) throws CourseException {
		String message = "Fail to add new course into Coading Camp";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into courses (Course_Name, "
					+ "Course_Fee, Course_Duration) values (?,?,?)");
			
			ps.setString(1, course.getName());
			ps.setInt(2, course.getFee());
			ps.setString(3, course.getDuration());
			
			int x = ps.executeUpdate();
			
			if (x > 0) message = course.getName() + " added successfully into Coding Camp";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String deleteCourse(String courseName) throws CourseException {
		String message = courseName + " does not exists";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE from courses where Course_Name=?");
			ps.setString(1, courseName);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = courseName + " has been deleted successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@SuppressWarnings("null")
	@Override
	public List<Student> getAllStudentByCourseName(String courseName) throws StudentException {
		List<Student> students = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from students where Name=?");
			
			ps.setString(1, courseName);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Student student = null;
				
				student.setStudentCode(rs.getInt("Student_Code"));
				student.setFirstName(rs.getString("First_Name"));
				student.setLastName(rs.getString("Last_Name"));
				student.setFatherName(rs.getString("Father_Name"));
				student.setMotherName(rs.getString("Mother_Name"));
				student.setGender(rs.getString("Gender"));
				student.setDateOfBirth(rs.getString("Date_Of_Birth"));
				student.setAddress(rs.getString("Address"));
				student.setContactNo(rs.getString("Contact_No"));
				student.setEmail(rs.getString("Email"));
				
				students.add(student);
			} 	
				
			if (students.size() == 0) {
				throw new StudentException("No student enrolled in " + courseName);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return students;
	}

	@Override
	public List<Integer> getCourseId() throws CourseException {
		List<Integer> courses = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select Course_Id from courses");
			
			ResultSet rs = ps.executeQuery();
			
			courses = new ArrayList<>();
			while (rs.next()) {
				courses.add(rs.getInt("Course_Id"));
			}
			
			if (courses.size() == 0) {
				throw new CourseException("No course available in coding camp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courses;
	}

	@Override
	public List<Course> getCourses() throws CourseException {
		List<Course> courses = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from courses");
			
			ResultSet rs = ps.executeQuery();
			
			courses = new ArrayList<>();
			while (rs.next()) {
				Course course = new Course(rs.getInt("Course_Id"), rs.getString("Course_Name"), 
						rs.getInt("Course_Fee"), (rs.getString("Course_Duration") + " days"));
				
				courses.add(course);
			}
			
			if (courses.size() == 0) {
				throw new CourseException("No course available in coding camp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return courses;
	}

}
