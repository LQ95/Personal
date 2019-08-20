//takes eevery file in the directory and renames it in order,with added filenames
//has a basic UI too
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
public class FileRenamer{
	private static Implementation Ren;
	public static void main(String[] args)
	{
		Ren= new Implementation();
		JFrame Window1=new JFrame("A little silly Mass File Renamer");
		JButton Confirm=new JButton("Confirm");
		Window1.setSize(640,480);
		Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window1.setVisible(true);
		Confirm.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
				{
					Ren.rename();
				}
			}
		);
		Container windowContainer=Window1.getContentPane();
		windowContainer.setLayout(new GridLayout(2,2));
		windowContainer.add(Confirm);
	}
	

}

class Implementation {
	public void rename(String BaseForRenaming){
	 //retrieve current working directory
		File WorkingDir= new File(System.getProperty("user.dir"));
		File ToBeOrdered[] =WorkingDir.listFiles();
		int size=ToBeOrdered.length;
		int StrLen=BaseForRenaming.length()
		StringBuilder NewFilename=new StringBuilder(BaseForRenaming);
		for(int i=0;i<size;i++)
		{
			NewFilename.insert(strLen,i);
			ToReOrdered[i].renameTo(new File());
		}
	}
}
