package logic;

import dataclasses.Components;

public class DeleteButton {	

	
	public static void logic(String cell, Components components) {
		components.getSubjectView().get(cell).setText("");
	}
}
