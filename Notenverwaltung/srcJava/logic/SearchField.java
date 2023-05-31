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
		
		if (input.matches("([Ss])([Cc])(.*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Class");
			components.getVisibleTextfields().get("20").setText("Average");
			if (input.matches("([Ss][Cc])")) {
				String result = DataMapper.allClasses();
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				for (int y = 0; y < (cells.length) / 4; y++) {
					for (int x = 0; x < 3; x++) {
						components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
					}
					components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
				}
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
