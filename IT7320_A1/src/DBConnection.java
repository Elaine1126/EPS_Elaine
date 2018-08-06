import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) {
		String dbUrl = "jdbc:mysql://localhost:3306/user_login";
		String user = "root";
		String password = "";
		
		try {
			
			Connection myConn = DriverManager.getConnection(dbUrl, user, password);
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from timesheet");
			while(myRs.next()) {
				System.out.println(myRs.getString("Username")+ " "+myRs.getString("Password") );
			}
			
			myStmt.close();
			myConn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
