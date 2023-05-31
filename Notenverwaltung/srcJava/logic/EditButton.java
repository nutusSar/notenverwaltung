package logic;
import dataclasses.Components;

public class EditButton {
	
	
	public static void logic(String cell, Components components) {
		String text = components.getHiddenTextfields().get(cell).getText();
		components.getVisibleTextfields().get(cell).setText(text);
	}

}
