package logic;

import java.io.File;

import javax.swing.JFileChooser;

/**GUI to pick the directory
 * 
 * @author nutusSar
 *
 */
public class Open {

	
	public static boolean open() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File("C:\\"));
		fileChooser.setDialogTitle("Select a directory");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION ) {
		   File selectedFile = fileChooser.getSelectedFile();
		   System.out.println(selectedFile);
		   DataMapper.setDirectory(selectedFile);
		   Loader.load(selectedFile);
		   return(true);
		}
		return(false);
	}
}
