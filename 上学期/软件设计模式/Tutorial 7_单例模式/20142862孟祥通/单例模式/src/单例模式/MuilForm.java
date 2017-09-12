package µ¥ÀýÄ£Ê½;

import javax.swing.JFrame;

public class MuilForm extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MuilForm instance = null;
	
	private MuilForm()
	{
		
	}
	
	public static MuilForm getInstance()
	{
		if(instance == null)
		{
			instance = new MuilForm();
		}
		else
		{
			
		}
		
		return instance;
	}
}
