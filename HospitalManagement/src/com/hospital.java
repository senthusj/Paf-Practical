package com;

import java.sql.*;

public class hospital {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public String getHospitalDetails() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error dtabase don't have any data.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Hospital Code</th><th>Hospital Name</th><th>Chief Doctor</th><th>Type</th><th>Phone</th><th>Address</th><th>Description</th></tr>";
			String query = "select * from hospitaldetails";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String HID = rs.getString("HID");
				String hCode = rs.getString("hCode");
				String hName = rs.getString("hName");
				String cDoc = rs.getString("cDoc");
				String type = rs.getString("type");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String desc = rs.getString("desc");

				// Add into the html table

				output += "<tr><td><input id='hidHospitalIDUpdate' name='hidHospitalIDUpdate' type='hidden' value='" + HID + "'>" + hCode + "</td>";
				output += "<td>" + hName + "</td>";
				output += "<td>" + cDoc + "</td>";
				output += "<td>" + type + "</td>";
				output += "<td>" + phone + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + desc + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-hid='"+HID+"'></td></tr>";
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Hospital.";
			System.err.println(e.getMessage());
		}
		return output;
	}	
	public String addHospitalDetails(String hCode, String hName, String cDoc, String type, String phone, String address, String desc) {
		
		String output = "";
		try{
			Connection con = connect();
			
			if (con == null){
					return "Error while connecting to the database for inserting."; 
				}
	
			// create a prepared statement
			String query = " insert into hospitaldetails (`hCode`,`hName`,`cDoc`,`type`,`phone`,`address`,`desc`)" + " values (?,?,?, ?, ?, ?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setString(1, hCode);
			preparedStmt.setString(2, hName);
			preparedStmt.setString(3, cDoc);
			preparedStmt.setString(4, type);
			preparedStmt.setString(5, phone);
			preparedStmt.setString(6, address);
			preparedStmt.setString(7, desc);
	
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newHospitals = getHospitalDetails();
			output = "{\"status\":\"success\", \"data\": \"" +newHospitals + "\"}";
			
			
		}catch (Exception e){
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the hospital details.\"}";
					System.err.println(e.getMessage());
			}
		return output;
	}	
public String updateHospital(String HID,String hCode, String hName, String cDoc, String type, String phone, String address, String desc){
		
		String output = "";
		try{
			Connection con =connect();
			if (con == null){
				return "Error while connecting to the database for updating.";
			}
		// create a prepared statement
		String query = "UPDATE hospitaldetails SET `hCode`=?, `hName`=?, `cDoc`=?, `type`=?, `phone`=?, `address`=?, `desc`=? WHERE `HID`=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		
		preparedStmt.setString(1, hCode);
		preparedStmt.setString(2, hName);
		preparedStmt.setString(3, cDoc);
		preparedStmt.setString(4, type);
		preparedStmt.setString(5, phone);
		preparedStmt.setString(6, address);
		preparedStmt.setString(7, desc);
		
		preparedStmt.setInt(8, Integer.parseInt(HID));
		// execute the statement
		preparedStmt.execute();
		con.close();
		String newHospitals = getHospitalDetails();
		output = "{\"status\":\"success\", \"data\": \"" +newHospitals + "\"}";
	}catch (Exception e){
		output = "{\"status\":\"error\", \"data\":\"Error while updating the hospital.\"}";
				System.err.println(e.getMessage());

	
	}
		return output;

	}
public String deleteHospital(String HID) {
	String output = "";
	try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
		// create a prepared statement
		String query = "delete from hospitaldetails where HID=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, Integer.parseInt(HID));
		// execute the statement
		preparedStmt.execute();
		con.close();
		String newHospitals = getHospitalDetails();
		output = "{\"status\":\"success\", \"data\": \"" +newHospitals + "\"}";
		
	} catch (Exception e) {
		output = "{\"status\":\"error\", \"data\":\"Error while deleting the hospital.\"}";
				System.err.println(e.getMessage());
	}
	return output;
}

}