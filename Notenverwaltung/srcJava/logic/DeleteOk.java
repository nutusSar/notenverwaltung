package logic;

import dataclasses.Components;

public class DeleteOk {
	
	public static boolean logic(Components components, String cell) {
		components.getSubjectView().get(cell).setText("");
		components.getHiddenTextfields().get(cell).setText("");
		return(true);
	}

}
