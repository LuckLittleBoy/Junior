package oracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EMP
{

	private JFrame frame;
	private JTable table = new JTable();
	ConnectToOracle CTO = new ConnectToOracle();
	Connection con = CTO.GetConnection();
	Statement stmt = con.createStatement();
	protected DefaultTableModel defaultModel;
	protected JScrollPane scrollPane;
	
	private String sql="select * from user_20142862.EMP";

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					EMP window = new EMP();
					window.frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public EMP() throws SQLException
	{
		initialize();
		Fresh(sql);
	}

	private void initialize() throws SQLException
	{
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(350,150,560,370);
		frame.getContentPane().setLayout(null);
	}
	private void Fresh(String sql)
	{
		if(defaultModel != null)
		{
			frame.getContentPane().remove(scrollPane);
		}
		
		String SQL = sql;
		ResultSet rs = null;
		try
		{
			rs = stmt.executeQuery(SQL);
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		Vector<String> Head = new Vector<String>();
		Vector<Vector<String>> Body = new Vector<Vector<String>>();
		try
		{
			ResultSetMetaData MetaData = rs.getMetaData();
			for(int i = 1;i <= MetaData.getColumnCount();i++)
			{
				Head.add(MetaData.getColumnName(i));
			}
			while(rs.next())
			{
				Vector<String> Line = new Vector<String>();
				for(int i = 1;i <= MetaData.getColumnCount();i++)
				{
				    Line.add(rs.getString(i));
				}
			    Body.add(Line);
			}
		}
		catch (SQLException e2)
		{
			e2.printStackTrace();
		}
		defaultModel = new DefaultTableModel(Body,Head);
		table = new JTable(defaultModel);
		table.setCellSelectionEnabled(true);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20,84,512,237);
		scrollPane.setEnabled(true);
		frame.getContentPane().add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 552, 27);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4EBA\u5458\u64CD\u4F5C");
		menuBar.add(mnNewMenu);
		
		JButton AddBtn = new JButton("\u65B0\u589E");
		mnNewMenu.add(AddBtn);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		mnNewMenu.add(btnNewButton);
		
		JButton UpdateBtn = new JButton("\u4FEE\u6539");
		mnNewMenu.add(UpdateBtn);
		
		JTextField textField;
		textField = new JTextField();
		textField.setBounds(312, 42, 133, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u5185\u5BB9\uFF1A");
		lblNewLabel.setBounds(190, 44, 114, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton SelBtn = new JButton("\u67E5\u8BE2");
		SelBtn.setBounds(463, 42, 69, 23);
		frame.getContentPane().add(SelBtn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EMPNO", "ENAME", "JOB", "MGR", "HIREDATE", "SAL", "COMM", "DEPTNO"}));
		comboBox.setBounds(100, 42, 70, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u67E5\u8BE2\u6761\u4EF6\uFF1A");
		lblNewLabel_1.setBounds(20, 44, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		SelBtn.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame,"请输入要查询的内容");
					return;
				}
				
				else
				{
					String SQL = "Select * From user_20142862.EMP Where " + comboBox.getSelectedItem()+ " = " + textField.getText();
					Fresh(SQL);
				}
			}
		});
		UpdateBtn.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(table.getSelectedRow() == -1 || table == null)
				{
					JOptionPane.showMessageDialog(frame,"请先选择一行数据");
					return;
				}
				else
				{
					String num = table.getValueAt(table.getSelectedRow(),0).toString();
					try
					{
						new UpdateEMP(stmt,num,frame,"修改员工信息",true);
						Fresh(sql);
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(table.getSelectedRow() == -1 || table == null)
				{
					JOptionPane.showMessageDialog(frame, "请先选择一行数据");
					return;
				}
				else
				{
					String num = table.getValueAt(table.getSelectedRow(),0).toString();
					try
					{
						String SQL = "Delete From user_20142862.EMP Where EMPNO = " + num;
						stmt.executeUpdate(SQL);
						JOptionPane.showMessageDialog(frame, "删除成功");
						Fresh(sql);
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		AddBtn.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				new AddEMP(stmt,frame,"添加新员工",true);
				Fresh(sql);
			}
		});
	}
}

