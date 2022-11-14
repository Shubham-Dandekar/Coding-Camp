package com.coding_camp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coding_camp.exceptions.AdminException;
import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Administrator;
import com.coding_camp.model.Course;
import com.coding_camp.model.StudentCourseDTO;
import com.coding_camp.utility.DBUtil;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public String registerAdmin(Administrator administrator) throws AdminException {
		String message = "Fail to register student into Coading Camp";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into administrators (First_Name, "
					+ "Last_Name, Father_Name, Mother_Name, Gender, Date_Of_Birth, Address, "
					+ "Contact_No, Email, Password) values (?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, administrator.getFirstName());
			ps.setString(2, administrator.getLastName());
			ps.setString(3, administrator.getFatherName());
			ps.setString(4, administrator.getMotherName());
			ps.setString(5, administrator.getGender());
			ps.setString(6, administrator.getDateOfBirth());
			ps.setString(7, administrator.getAddress());
			ps.setString(8, administrator.getContactNo());
			ps.setString(9, administrator.getEmail());
			ps.setString(10, administrator.getPassword());
			
			int x = ps.executeUpdate();
			
			if (x > 0) message = administrator.getFirstName() + " registered successfully into Coding Camp as administrator";
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String changeAdminFirstName(String firstName, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators First_Name=? where Admin_Code=?");
			ps.setString(1, firstName);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's first name has been changed to " + firstName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeAdminLastName(String lastName, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Last_Name=? where Admin_Code=?");
			ps.setString(1, lastName);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's last name has been changed to " + lastName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeAdminFatherName(String fatherName, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Father_Name=? where Admin_Code=?");
			ps.setString(1, fatherName);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's father name has been changed to " + fatherName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeAdminMotherName(String motherName, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Mother_Name=? where Admin_Code=?");
			ps.setString(1, motherName);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's mother name has been changed to " + motherName;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeAdminGender(String gender, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Gender=? where Admin_Code=?");
			ps.setString(1, gender);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's gender has been changed to " + gender;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeAdminDateOfBirth(String dateOfBirth, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Date_Of_Birth=? where Admin_Code=?");
			ps.setString(1, dateOfBirth);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's date of birth has been changed to " + dateOfBirth;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}
	
	@Override
	public String getAdminPassword(int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select Password from administrators where Admin_Code=?");
			ps.setInt(1, adminCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				message = "Your password:" + rs.getString("Password");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}	

	@Override
	public String changeAdminPassword(String password, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Password=? where Admin_Code=?");
			ps.setString(1, password);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's password has been changed to " + adminCode;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeAdminAddress(String address, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Address=? where Admin_Code=?");
			ps.setString(1, address);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's address has been changed to " + address;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String changeAdminContactNo(String contactNo, int adminCode) throws AdminException {
		String message = "No admin exists with admin code: " + adminCode;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE administrators Contact_No=? where Admin_Code=?");
			ps.setString(1, contactNo);
			ps.setInt(2, adminCode);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Admin's contact no has been changed to " + contactNo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public int AdminLogIn(String email, String password) throws AdminException {
		int adminCode = -1;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select Admin_Code from administrators where Email=? "
					+ "AND Password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				adminCode = rs.getInt("Admin_Code");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return adminCode;
	}

	@Override
	public String getAdminFirstName(int adminCode) throws AdminException {
		String message = "Admin not found";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select First_Name from administrators where Admin_Code=?");
			ps.setInt(1, adminCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				message = rs.getString("First_Name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Administrator showAdminDetails(int adminCode) throws AdminException {
		
		Administrator admin = new Administrator();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select First_Name, Last_Name, Father_Name, "
					+ "Mother_Name, Gender, Date_Of_Birth, Address, Contact_No, Email from administrators "
					+ "where Admin_Code=?");
			
			ps.setInt(1, adminCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				admin.setAdminCode(adminCode);
				admin.setFirstName(rs.getString("First_Name"));
				admin.setLastName(rs.getString("Last_Name"));
				admin.setFatherName(rs.getString("Father_Name"));
				admin.setMotherName(rs.getString("Mother_Name"));
				admin.setGender(rs.getString("Gender"));
				admin.setDateOfBirth(rs.getString("Date_Of_Birth"));
				admin.setAddress(rs.getString("Address"));
				admin.setContactNo(rs.getString("Contact_No"));
				admin.setEmail(rs.getString("Email"));
			} else {
				throw new AdminException("Admin not found");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}
}
