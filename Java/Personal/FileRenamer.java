//takes eevery file in the directory and renames it in order,with added filenames
//has a basic UI too
import java.awt.*;
import javax.swing.*;
import java.io.File;
public class FileRenamer{
	public static void main(String[] args)
	{
		JFrame Window1=new JFrame();
		Window1.setSize(640,480);
		Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window1.setVisible(true);
	}
	
	class LocalActionListener implements ActionListener
	{
		void actionPerformed(ActionEvent e)
		{
			
		}
	}
}

class Implementation {
	public void rename(){
	 //retrieve current working directory
		File WorkingDir= new File(System.getProperty("user.dir"));
		File ToBeOrdered[] =WorkingDir.listFiles();
	}
}
