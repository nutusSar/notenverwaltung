package dataclasses;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Components {
	private JPanel contentPane;
	private HashMap<String, JTextField> subjectView = new HashMap<>();
	private HashMap<String, JButton> subjectButtons = new HashMap<>();
	private HashMap<String, JTextField> hiddenTextfields = new HashMap<>();
	private JButton[] pageButtons = new JButton[3];
	private JMenuBar menuBar;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();

	
	
	public Components(JPanel contentPane, HashMap<String, JTextField> subjectView,
			HashMap<String, JButton> subjectButtons, HashMap<String, JTextField> hiddenTextfields, JButton[] pageButtons, ArrayList<JButton> buttons, JMenuBar menuBar) {
		this.contentPane = contentPane;
		this.subjectView = subjectView;
		this.subjectButtons = subjectButtons;
		this.hiddenTextfields = hiddenTextfields;
		this.pageButtons = pageButtons;
		this.buttons = buttons;
		this.menuBar = menuBar;
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
	public HashMap<String, JTextField> getHiddenTextfields() {
		return hiddenTextfields;
	}
	public void setHiddenTextfields(HashMap<String, JTextField> hiddenTextfields) {
		this.hiddenTextfields = hiddenTextfields;
	}
	public JButton[] getPageButtons() {
		return pageButtons;
	}
	public void setPageButtons(JButton[] pageButtons) {
		this.pageButtons = pageButtons;
	}
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	public void setButtons(ArrayList<JButton> buttons) {
		this.buttons = buttons;
	}
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	
}
