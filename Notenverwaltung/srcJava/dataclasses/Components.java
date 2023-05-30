package dataclasses;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Components {
	private JPanel contentPane;
	private HashMap<String, JTextField> subjectView = new HashMap<>();
	private HashMap<String, JButton> subjectButtons = new HashMap<>();
	private JTextField[] hiddenTextfields = new JTextField[13];
	private JButton[] pageButtons = new JButton[3];
	
	
	public Components(JPanel contentPane, HashMap<String, JTextField> subjectView,
			HashMap<String, JButton> subjectButtons, JTextField[] hiddenTextfields, JButton[] pageButtons) {
		this.contentPane = contentPane;
		this.subjectView = subjectView;
		this.subjectButtons = subjectButtons;
		this.hiddenTextfields = hiddenTextfields;
		this.pageButtons = pageButtons;
	}	
	
	public JPanel getContentPane() {
		return contentPane;
	}
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	public HashMap<String, JTextField> getSubjectView() {
		return subjectView;
	}
	public void setSubjectView(HashMap<String, JTextField> subjectView) {
		this.subjectView = subjectView;
	}
	public HashMap<String, JButton> getSubjectButtons() {
		return subjectButtons;
	}
	public void setSubjectButtons(HashMap<String, JButton> subjectButtons) {
		this.subjectButtons = subjectButtons;
	}
	public JTextField[] getHiddenTextfields() {
		return hiddenTextfields;
	}
	public void setHiddenTextfields(JTextField[] hiddenTextfields) {
		this.hiddenTextfields = hiddenTextfields;
	}
	public JButton[] getPageButtons() {
		return pageButtons;
	}
	public void setPageButtons(JButton[] pageButtons) {
		this.pageButtons = pageButtons;
	}
	
}
