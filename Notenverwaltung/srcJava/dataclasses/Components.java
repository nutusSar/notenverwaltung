package dataclasses;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**all components that the maskGenerator generated will be stored here for later manipulation 
 * 
 * @author nutusSar
 *
 */
public class Components {
	private JPanel contentPane;
	private HashMap<String, JTextField> visibleTextfields = new HashMap<>();
	private HashMap<String, JButton> rowButtons = new HashMap<>();
	private HashMap<String, JTextField> hiddenTextfields = new HashMap<>();
	private JTextField searchField;
	private JButton[] pageButtons = new JButton[3];
	private JMenuBar menuBar;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JButton okButton;

	
	
	public Components(JPanel contentPane, HashMap<String, JTextField> subjectView,
			HashMap<String, JButton> subjectButtons, HashMap<String, JTextField> hiddenTextfields, JTextField searchField, JButton[] pageButtons, ArrayList<JButton> buttons, JMenuBar menuBar, JButton okButton) {
		this.contentPane = contentPane;
		this.visibleTextfields = subjectView;
		this.rowButtons = subjectButtons;
		this.hiddenTextfields = hiddenTextfields;
		this.searchField = searchField;
		this.pageButtons = pageButtons;
		this.buttons = buttons;
		this.menuBar = menuBar;
		this.okButton = okButton;
	}



	public JPanel getContentPane() {
		return contentPane;
	}
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	public HashMap<String, JTextField> getVisibleTextfields() {
		return visibleTextfields;
	}
	public void setVisibleTextfields(HashMap<String, JTextField> visibleTextfields) {
		this.visibleTextfields = visibleTextfields;
	}
	public HashMap<String, JButton> getRowButtons() {
		return rowButtons;
	}
	public void setRowButtons(HashMap<String, JButton> rowButtons) {
		this.rowButtons = rowButtons;
	}
	public HashMap<String, JTextField> getHiddenTextfields() {
		return hiddenTextfields;
	}
	public void setHiddenTextfields(HashMap<String, JTextField> hiddenTextfields) {
		this.hiddenTextfields = hiddenTextfields;
	}
	public JTextField getSearchField() {
		return searchField;
	}
	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}
	public JButton[] getPageButtons() {
		return pageButtons;
	}
	public void setPageButtons(JButton[] pageButtons) {
		this.pageButtons = pageButtons;
	}
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	public void setButtons(ArrayList<JButton> buttons) {
		this.buttons = buttons;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}
	
	
}
