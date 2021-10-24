import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		/*Connection url
		"jdbc:mysql://"+host+":"+port+"/databasename";
		"jdbc:mysql://"+localhost+":"+3306+"/June_2021";
		*/
		
		String host="localhost";
		String port="3306";
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/June_2021", "root", "vairaj");
		
		Statement s=con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from EmpInfo where name='Ganesh'");
		
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("location"));
		}
			

	}

}
