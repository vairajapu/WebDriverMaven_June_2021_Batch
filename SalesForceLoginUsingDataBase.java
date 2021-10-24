import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForceLoginUsingDataBase {

	public static void main(String[] args) throws SQLException {
		String host="localhost";
		String port="3306";
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Sales_Force_Login", "root", "vairaj");
		
		Statement s=con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from Login_Details where fname='vaishali'");
		
		while(rs.next())
		{
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\LatestChromeDriverExe\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/?locale=in");
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			
			driver.findElement(By.name("username")).sendKeys(rs.getString("username"));
			
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
			
			driver.findElement(By.name("Login")).click();
			
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
		}
		

	}

}
