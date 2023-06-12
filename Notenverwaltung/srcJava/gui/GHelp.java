package gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**GUI for the search commands help
 * 
 * @author nutusSar
 *
 */
public class GHelp {
	private Font font = new Font("Arial", Font.PLAIN, 11);

	private JLabel label;
	
	public GHelp() {
		JFrame frame = new JFrame();
		frame.setBounds(300, 250, 400, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Search Commands");
		frame.setVisible(true);
		
		String[] commands = {"All Classes: sc", "All Students: st", "All Modules: su", "Specific Class: sc<ClassName;", "Specific Student: st<StudentName;", "Specific Module: su<ModuleName;"};
		
		for(int i = 0; i < commands.length; i++) {
			String command = "<html>" + commands[i].replaceAll("<", "<i>").replaceAll(";", "</i>") + "</html>"; 
			label = new JLabel(command);
			label.setFont(font);
			label.setBounds(40, 20 + i*25, 300, 20);
			frame.getContentPane().add(label);
		}
		
	}
}
