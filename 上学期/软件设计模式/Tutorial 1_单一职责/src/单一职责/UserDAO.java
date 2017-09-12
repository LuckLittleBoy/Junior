package 单一职责;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserDAO
{
	DBUtil db;
	Statement stmt = null;
	public UserDAO(DBUtil db)
	{
		this.db = db;
		try {
			stmt = this.db.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public int executeUpdate(String s)
	{
		int result = 0;
		try
		{
			result = stmt.executeUpdate(s);
		}
		catch (Exception e)
		{
			System.out.println("执行更新错误！");
		}
		return result;
	}
	
	public boolean findUser(String userName,String userPassword)
	{
		ResultSet rs = null;
		String s = "select * from UserLogin";
		try
		{
			rs = stmt.executeQuery(s);
		} 
		catch (Exception e)
		{
			System.out.println("执行查询错误！");
		}
		try {
			if(rs.next())
			{
				if(rs.getString(1).equals(userName) && rs.getString(2).equals(userPassword))
				{
					JOptionPane.showMessageDialog(null, "登录成功","登录提示", JOptionPane.INFORMATION_MESSAGE); 
				}
				else
				{
					JOptionPane.showMessageDialog(null, "密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			JOptionPane.showMessageDialog(null, "该用户未注册", "错误提示", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public ResultSet executeQuery(String s)
	{
		ResultSet rs = null;
		try
		{
			rs = stmt.executeQuery(s);
		} 
		catch (Exception e)
		{
			System.out.println("执行查询错误！");
		}
		return rs;
	}

	public void close()
	{
		try
		{
			stmt.close();
			db.getConnection().close();;
		}
		catch (Exception e)
		{
		}
	}
}

