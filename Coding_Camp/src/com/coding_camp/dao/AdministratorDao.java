package com.coding_camp.dao;

import com.coding_camp.exceptions.AdminException;
import com.coding_camp.model.Administrator;

public interface AdministratorDao {
	
	public String registerAdmin(Administrator adminstartor) throws AdminException;
	
	public String changeAdminFirstName(String firstName, int adminCode) throws AdminException;

	public String changeAdminLastName(String lastName, int adminCode) throws AdminException;
	
	public String changeAdminFatherName(String fatherName, int adminCode) throws AdminException;
	
	public String changeAdminMotherName(String motherName, int adminCode) throws AdminException;
	
	public String changeAdminGender(String gender, int adminCode) throws AdminException;
	
	public String changeAdminDateOfBirth(String dateOfBirth, int adminCode) throws AdminException;
	
	public String getAdminPassword(int adminCode) throws AdminException;
	
	public String changeAdminPassword(String password, int adminCode) throws AdminException;
	
	public String changeAdminAddress(String address, int adminCode) throws AdminException;
	
	public String changeAdminContactNo(String contactNo, int adminCode) throws AdminException;
	
	public int AdminLogIn(String email, String password) throws AdminException;
	
	public String getAdminFirstName(int studentCode) throws AdminException;
	
	public Administrator showAdminDetails(int adminCode) throws AdminException;
}
