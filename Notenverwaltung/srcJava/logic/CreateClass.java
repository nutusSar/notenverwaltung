package logic;
import javax.swing.JButton;

import dataclasses.Components;
import gui.GCreateClass;

public class CreateClass {

	public static void logic(Components components) {
		for (JButton button: components.getButtons()) {
			button.setEnabled(false);
		}
		new GCreateClass(components);
	}
}
