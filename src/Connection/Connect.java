package Connection;
import java.sql.*;
public class Connect {
private static Connection con;

private Connect() {}

static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection(
			      "jdbc:oracle:thin:@localhost:1521:ORCL","system","maryam");
		 
		 System.out.println("bien");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println("data not found");
	}
}

public static Connection getConnection() {
	return con;
}
}

