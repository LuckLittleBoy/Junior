package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToOracle
{
	private String Driver = "oracle.jdbc.driver.OracleDriver";
	private String Con = "jdbc:oracle:thin:@127.0.0.1:1521:shujuku";
	private String UserName = "SYSTEM";
	private String Password = "meng19950628";
	private Connection con = null;

	public ConnectToOracle()
	{
		try
		{
			Class.forName(Driver);
			con = DriverManager.getConnection(Con, UserName, Password);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Connection GetConnection() throws SQLException
	{
		if(con == null)
		{
			con = DriverManager.getConnection(Con, UserName, Password);
		}
		return con;
	}
}
