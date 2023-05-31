package logic;

import javax.swing.JTextField;

import dataclasses.Components;

public class SearchField {

	public static void clickOk(Components components) {
		for (JTextField textField : components.getVisibleTextfields().values()) {
			textField.setText("");
		}
	}
}
