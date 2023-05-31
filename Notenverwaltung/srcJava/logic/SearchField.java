package logic;

import javax.swing.JTextField;

import dataclasses.Components;

public class SearchField {

	public static void clickOk(Components components, String input) {
		int i = 0;
		for (JTextField textField : components.getVisibleTextfields().values()) {
			textField.setText("");
		}
		for (JTextField textField : components.getHiddenTextfields().values()) {
			textField.setText("");
		}
		components.getVisibleTextfields().get("30").setText("Del");
		components.getVisibleTextfields().get("40").setText("Edi");
		
		if (input.matches("([Ss])([Cc])([\\w\\s]*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Class");
			components.getVisibleTextfields().get("20").setText("Average");
			if (input.matches("([Ss][Cc])")) {
				String result = DataMapper.allClasses();
			}
			else{
				String result = DataMapper.searchClass(input.toUpperCase());
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				components.getVisibleTextfields().get("01").setText("1");
				components.getVisibleTextfields().get("11").setText(cells[0]);
				components.getVisibleTextfields().get("21").setText(cells[1]);
				components.getHiddenTextfields().get("11").setText(cells[2]);
			}
		}

	}
}
