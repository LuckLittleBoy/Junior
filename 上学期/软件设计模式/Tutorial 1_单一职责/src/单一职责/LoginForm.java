package 单一职责;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginForm {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public LoginForm(JFrame frame)
	{	
		this.frame=frame;
	}
	public void SetLoginForm()
	{
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(95, 63, 54, 15);
		frame.getContentPane().add(lblNewLabel);
			
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(95, 106, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(159, 60, 145, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 103, 145, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
			
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setBounds(122, 168, 65, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBUtil dbUtil = new DBUtil();
				UserDAO userDAO = new UserDAO(dbUtil);
				String userName = textField.getText();
				String userPassword = textField_1.getText();
				userDAO.findUser(userName, userPassword);
			}
		});
		frame.getContentPane().add(btnNewButton);
			
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(247, 168, 65, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnNewButton_1);	
	}

}
