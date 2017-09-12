package 单例模式;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4E3B\u7A97\u4F53");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("\u5B50\u7A97\u4F53");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MuilForm childform1,childform2;
				childform1 = MuilForm.getInstance();
				childform2 = MuilForm.getInstance();
				childform1.setTitle("子窗体");
				childform2.setTitle("子窗体");
				childform1.setVisible(true);
				childform2.setVisible(true);
				childform1.setBounds(550, 100, 450, 300);
				childform2.setBounds(550, 100, 450, 300);
				System.out.println("是否是同一个子窗口：" + (childform1 == childform2));
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
	}

}
