package com.coding_camp.dao;

import com.coding_camp.exceptions.StudentException;
import com.coding_camp.model.Administrator;

public interface AdministratorDao {
	
	public String registerAdmin(Administrator adminstartor) throws StudentException;
	
	public String changeAdminFirstName(String firstName) throws StudentException;

	public String changeAdminLastName(String lastName) throws StudentException;
	
	public String changeAdminFatherName(String fatherName) throws StudentException;
	
	public String changeAdminMotherName(String motherName) throws StudentException;
	
	public String changeAdminGender(String gender) throws StudentException;
	
	public String changeAdminDateOfBirth(String dateOfBirth) throws StudentException;
	
	public String changeAdminPassword(String password) throws StudentException;
	
	public String changeAdminAddress(String address) throws StudentException;
	
	public String changeAdminContactNo(String contactNo) throws StudentException;
}
