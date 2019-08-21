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
		//declarations
		Ren= new Implementation();
		JFrame Window1=new JFrame("A little silly Mass File Renamer");
		JTextField TField=new JTextField("Enter directory here...",20);
		JButton Confirm=new JButton("Confirm");
		JButton Browse=new JButton("Browse");
		JFileChooser ChooseDialog= new JFileChooser();
		//Settings
		ChooseDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Confirm.setBounds(20,30,50,30);
		Window1.setSize(640,480);
		Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window1.setVisible(true);
		//Action Listeners
		Confirm.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
				{
					Ren.rename(TField.getText());
				}
			}
		);
		Browse.addActionListener(
		new ActionListener(){
			File SelectedDirectory;
		public void actionPerformed(ActionEvent e)
				{
					ChooseDialog.showOpenDialog(Window1);
					SelectedDirectory=ChooseDialog.getSelectedFile();
					TField.setText(SelectedDirectory.getPath());
				}
			}
			
		);
		//everything is put inside the window
		Container windowContainer=Window1.getContentPane();
		windowContainer.setLayout(new GridLayout(5,2,23,40));
		windowContainer.add(TField);
		windowContainer.add(Browse);
		windowContainer.add(Confirm);
	}
	

}

class Implementation {
	public void rename(String BaseForRenaming){
	 //retrieve current working directory
		File WorkingDir= new File(System.getProperty("user.dir"));
		File ToBeOrdered[] =WorkingDir.listFiles();
		int size=ToBeOrdered.length;
		int strLen=BaseForRenaming.length();
		StringBuilder NewFilename=new StringBuilder(BaseForRenaming);
		for(int i=0;i<size;i++)
		{
			NewFilename.insert(strLen,i);
			ToBeOrdered[i].renameTo(new File(NewFilename.toString()));
		}
	}
}
