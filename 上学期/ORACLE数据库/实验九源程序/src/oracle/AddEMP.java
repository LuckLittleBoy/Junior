package oracle;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class AddEMP extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 429875240737530874L;
	JPanel top,bottom,left;
	JLabel EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO;
	JTextField empno,ename,job,mgr,hiredate,sal,comm,deptno;
	JButton save,cancel;
	Statement stmt;

	public AddEMP(Statement stmt,JFrame owner,String title,boolean modal)    // 构造函数
	{ 
		super(owner,title,modal);
		this.stmt = stmt;
		
		// 创建组件
		EMPNO = new JLabel("EMPNO",JLabel.CENTER);
		ENAME = new JLabel("ENAME",JLabel.CENTER);
		JOB = new JLabel("JOB",JLabel.CENTER);
		MGR = new JLabel("MGR",JLabel.CENTER);
		HIREDATE = new JLabel("HIREDATE",JLabel.CENTER);
		SAL = new JLabel("SAL",JLabel.CENTER);
		COMM = new JLabel("COMM",JLabel.CENTER);
		DEPTNO = new JLabel("DEPTMO",JLabel.CENTER);
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
		ename = new JTextField(25);
		job = new JTextField(25);
		mgr = new JTextField(25);
		hiredate = new JTextField(25);
		sal = new JTextField(25);
		comm = new JTextField(25);
		deptno = new JTextField(25);
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
			String SQL = "Insert Into user_20142862.EMP Values(" + empno.getText() + ",'" + ename.getText() + "','" + job.getText() + "'," + mgr.getText()
					 + ",to_timestamp('" + hiredate.getText() + "','yyyy-mm--dd hh24:mi:ss.ff')," + sal.getText() + "," + comm.getText() + "," + deptno.getText() + ")";
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