package 单一职责;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainClass {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass window = new MainClass();
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainClass() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		LoginForm loginform=new LoginForm(frame);
		loginform.SetLoginForm();
	}

}


