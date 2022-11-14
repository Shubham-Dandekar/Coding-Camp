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
import com.coding_camp.model.StudentCourseDTO;
import com.coding_camp.utility.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String registerStudent(Student student) throws StudentException {
		
		String message = "Fail to register student into Coading Camp";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into students (First_Name, "
					+ "Last_Name, Father_Name, Mother_Name, Gender, Date_Of_Birth, Address, "
					+ "Contact_No, Email, Password) values (?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getFatherName());
			ps.setString(4, student.getMotherName());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getDateOfBirth());
			ps.setString(7, student.getAddress());
			ps.setString(8, student.getContactNo());
			ps.setString(9, student.getEmail());
			ps.setString(10, student.getPassword());
			
			int x = ps.executeUpdate();
			
			if (x > 0) message = student.getFirstName() + " registered successfully into Coding Camp";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@SuppressWarnings("null")
	@Override
	public StudentCourseDTO showStudentDetails(int studentCode) throws StudentException, CourseException {
		StudentCourseDTO studentDTO = new StudentCourseDTO();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name, Father_Name, "
					+ "Mother_Name, Gender, Date_Of_Birth, Address, Contact_No, Email from students "
					+ "where Student_Code=?");
			
			ps.setInt(1, studentCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				studentDTO.setStudentCode(studentCode);
				studentDTO.setFirstName(rs.getString("First_Name"));
				studentDTO.setLastName(rs.getString("Last_Name"));
				studentDTO.setFatherName(rs.getString("Father_Name"));
				studentDTO.setMotherName(rs.getString("Mother_Name"));
				studentDTO.setGender(rs.getString("Gender"));
				studentDTO.setDateOfBirth(rs.getString("Date_Of_Birth"));
				studentDTO.setAddress(rs.getString("Address"));
				studentDTO.setContactNo(rs.getString("Contact_No"));
				studentDTO.setEmail(rs.getString("Email"));
			} else {
				throw new StudentException("No student enrolled with student code: " + studentCode);
			}
			
			ps = conn.prepareStatement("select c.Course_Id, c.Course_Name, c.Course_Fee, c.Course_Duration "
					+ "from students s INNER JOIN courses c INNER JOIN student_courses sc ON s.Student_Code="
					+ "sc.Student_Code AND c.Course_Id=sc.Course_Id AND s.Student_Code=?");
			
			ps.setInt(1, studentCode);
			
			rs = ps.executeQuery();
			
			List<Course> courses = new ArrayList<>();
			
			while (rs.next()) {
				Course course = new Course(rs.getInt("Course_Id"), rs.getString("Course_Name"), 
						rs.getInt("Course_Fee"), (rs.getString("Course_Duration") + " days"));
				
				courses.add(course);
			}
			
			studentDTO.setCourses(courses);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studentDTO;
	}

	@Override
	public String deleteStudent(int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE from students where Student_Code=?");
			ps.setInt(1, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student enrolled with student code: " + studentCode + " has been deleted successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentFirstName(String firstName, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET First_Name=? where Student_Code=?");
			ps.setString(1, firstName);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's first name has been changed to " + firstName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentLastName(String lastName, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Last_Name=? where Student_Code=?");
			ps.setString(1, lastName);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's last name has been changed to " + lastName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentFatherName(String fatherName, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Father_Name=? where Student_Code=?");
			ps.setString(1, fatherName);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's father name has been changed to " + fatherName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentMotherName(String motherName, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Mother_Name=? where Student_Code=?");
			ps.setString(1, motherName);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's mother name has been changed to " + motherName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentGender(String gender, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Gender=? where Student_Code=?");
			ps.setString(1, gender);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's gender has been changed to " + gender;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentDateOfBirth(String dateOfBirth, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Date_Of_Birth=? where Student_Code=?");
			ps.setString(1, dateOfBirth);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's date of birth has been changed to " + dateOfBirth;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}
	
	@Override
	public String getStudentPassword(int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select Password from students where Student_Code=?");
			ps.setInt(1, studentCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				message = "Your password: " + rs.getString("Password") + "\n";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String changeStudentPassword(String password, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Password=? where Student_Code=?");
			ps.setString(1, password);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's password has been changed to " + password;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentAddress(String address, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Address=? where Student_Code=?");
			ps.setString(1, address);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's address has been changed to " + address;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeStudentContactNo(String contactNo, int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE students SET Contact_No=? where Student_Code=?");
			ps.setString(1, contactNo);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student's contact no has been changed to " + contactNo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String registerStudentNewCourse(int studentCode, int courseId) throws StudentException, CourseException {
		String message = "Student with student code: " + studentCode + " is not enrolled with course ID: " + courseId;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into student_courses values(?, ?)");
			ps.setInt(1, courseId);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student with student code: " + studentCode + " has been enrolled to course ID: " + courseId;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String removeStudentFromCourse(int studentCode, String courseName) throws StudentException, CourseException {
		String message = "Student with student code: " + studentCode + " is not enrolled with " + courseName;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE from student_courses where Course_Name=? AND Student_Code=?");
			ps.setString(1, courseName);
			ps.setInt(2, studentCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Student with student code: " + studentCode + " has been deleted successfully from " + courseName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@SuppressWarnings("null")
	@Override
	public List<Student> getAllStudentByAddress(String address) throws StudentException {
		List<Student> students = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from students where Address=?");
			
			ps.setString(1, address);
			
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
				throw new StudentException("No student enrolled from: " + address);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return students;
	}

	@Override
	public int studentLogIn(String email, String password) throws StudentException {
		int studentCode = -1;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select Student_Code from students where Email=? "
					+ "AND Password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				studentCode = rs.getInt("Student_Code");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentCode;
	}

	@Override
	public String getStudentFirstName(int studentCode) throws StudentException {
		String message = "No student enrolled with student code: " + studentCode;;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select First_Name from students where Student_Code=?");
			ps.setInt(1, studentCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				message = rs.getString("First_Name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
}
