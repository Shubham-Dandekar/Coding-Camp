package com.coding_camp.usecases;

import java.sql.Connection;
import java.sql.SQLException;

import com.coding_camp.utility.DBUtil;

public class Demo {

	public static void main(String[] args) {
		
		try (Connection conn = DBUtil.provideConnection()){
			System.out.println("Connected...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
