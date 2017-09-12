package oracle;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class UpdateEMP extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 429875240737530874L;
	JPanel top,bottom,left;
	JLabel EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO;
	JTextField empno,ename,job,mgr,hiredate,sal,comm,deptno;
	JButton save,cancel;
	Statement stmt;

	public UpdateEMP(Statement stmt,String num,JFrame owner,String title,boolean modal) throws SQLException    // 构造函数
	{ 
		super(owner,title,modal);
		this.stmt = stmt;
		String SQL = "Select * From user_20142862.EMP Where EMPNO = " + num;
		ResultSet rs = stmt.executeQuery(SQL);
		rs.next();
		
		// 创建组件
		EMPNO = new JLabel("EMPNO",JLabel.CENTER);
		ENAME = new JLabel("ENAME",JLabel.CENTER);
		JOB = new JLabel("JOB",JLabel.CENTER);
		MGR = new JLabel("MGR",JLabel.CENTER);
		HIREDATE = new JLabel("HIREDATE",JLabel.CENTER);
		SAL = new JLabel("SAL",JLabel.CENTER);
		COMM = new JLabel("COMM",JLabel.CENTER);
		DEPTNO = new JLabel("DEPTNO",JLabel.CENTER);
		top = new JPanel(new GridLayout(8,1));
		top.add(EMPNO);
		top.add(ENAME);
		top.add(JOB);
		top.add(MGR);
		top.add(HIREDATE);
		top.add(SAL);
		top.add(COMM);
		top.add(DEPTNO);
		
		empno = new JTextField(25);
		empno.setText(num);
		empno.setEditable(false);
		ename = new JTextField(25);
		ename.setText(rs.getString(2));
		job = new JTextField(25);
		job.setText(rs.getString(3));
		mgr = new JTextField(25);
		mgr.setText(rs.getString(4));
		hiredate = new JTextField(25);
		hiredate.setText(rs.getString(5));
		sal = new JTextField(25);
		sal.setText(rs.getString(6));
		comm = new JTextField(25);
		comm.setText(rs.getString(7));
		deptno = new JTextField(25);
		deptno.setText(rs.getString(8));
		left = new JPanel(new GridLayout(8,1));
		left.add(empno);
		left.add(ename);
		left.add(job);
		left.add(mgr);
		left.add(hiredate);
		left.add(sal);
		left.add(comm);
		left.add(deptno);

		bottom = new JPanel();
		save = new JButton("保存");
		cancel = new JButton("取消");
		save.addActionListener(this);
		cancel.addActionListener(this);
		bottom.add(save);
		bottom.add(cancel);

		this.add(top,BorderLayout.CENTER);
		this.add(left,BorderLayout.EAST);
		this.add(bottom,BorderLayout.SOUTH);

		// 设置窗体属性
		this.setSize(400,300);
		this.setLocation(400,250);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == save)
		{
			String SQL = "Update user_20142862.EMP Set ENAME = '" + ename.getText() + "',JOB = '" + job.getText() + "',MGR = " + mgr.getText()
			+ ",HIREDATE = to_timestamp('" + hiredate.getText() + "','yyyy-mm--dd hh24:mi:ss.ff'),SAL = " + sal.getText() + ",COMM = " + comm.getText()
			+ ",DEPTNO = " + deptno.getText() + " Where EMPNO = " + empno.getText() + "";
			try
			{
				stmt.executeUpdate(SQL);
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			this.dispose();
		}
		if(e.getSource()==cancel)
		{
			this.dispose();
		}
	}

}