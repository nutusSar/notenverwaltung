package logic;
import dataclasses.Components;

public class EditButton {
	
	
	public static void logic(String cell, Components components) {
		components.getHiddenTextfields().get(cell).setText(cell);
		components.getSubjectView().get(cell).setText(cell);
	}

}
