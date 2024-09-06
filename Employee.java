package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Shazia");
		Statement stmt = con.createStatement();
   System.out.println("hello");
   String sql="SELECT * FROM employee";
   ResultSet rows=stmt.executeQuery(sql);
   }

}
