package swing_tutorial;

import java.sql.*;

public class Databases {

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_management", "root",
					"7545");
//here is database name, root is user name and password  
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from inventory");
			while (rs.next())
				System.out.println(
						rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}