package logic;

import javax.swing.JButton;

import dataclasses.Components;
import gui.GDelete;

public class DeleteButton {	

	
	public static void logic(String cell, Components components) {
		
		//Actual logic
		if (!components.getHiddenTextfields().get(cell).getText().isEmpty()) {
			for (JButton button: components.getButtons()) {
				button.setEnabled(false);
			}
			new GDelete(components, cell);
		}
	}
}
