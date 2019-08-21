//takes eevery file in the directory and renames it in order,with added filenames
//has a basic UI too
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
public class FileRenamer{
	private static Implementation Ren;
	public static void main(String[] args) throws Exception
	{
		//declarations
		Ren= new Implementation();
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFrame Window1=new JFrame("A little silly Mass File Renamer");
		JTextField TField=new JTextField("Enter directory here...",20);
		JTextField NameField=new JTextField("Enter new filename here...",20);
		JButton Confirm=new JButton("Confirm");
		JButton Browse=new JButton("Browse");
		JFileChooser ChooseDialog= new JFileChooser();
		//Setup
		ChooseDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Confirm.setBounds(20,30,50,30);
		Window1.setSize(640,480);
		Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window1.setVisible(true);
		//Action Listeners
		Confirm.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
				{
					Ren.rename(TField.getText(),NameField.getText());
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
		windowContainer.add(NameField);
		windowContainer.add(Confirm);
	}
	

}

class Implementation {
	public void rename(String SelectedDir,String BaseFilename){
	 //retrieve current working directory
		File WorkingDir= new File(SelectedDir);
		File ToBeOrdered[] =WorkingDir.listFiles();
		int size=ToBeOrdered.length;
		int strLen=BaseFilename.length();
		StringBuilder NewFilename=new StringBuilder(BaseFilename);
		for(int i=0;i<size;i++)
		{
			NewFilename.insert(strLen,i);
			ToBeOrdered[i].renameTo(new File(SelectedDir,NewFilename.toString()+getExtension(ToBeOrdered[i].getName())));
			NewFilename.delete(strLen, NewFilename.capacity());
		}
	}
	
	String getExtension(String s)
	{
		String ext=null;
		int i=s.lastIndexOf('.');
		if(i>0 && i<s.length()-1)
		{
			ext=s.substring(i).toLowerCase();
		}
		return ext;
	}
}
