package logic;

import dataclasses.Components;

public class DeleteOk {
	
	public static boolean logic(Components components, String cell, String entry) {
		if (entry.equals("IWantToDelete_" + components.getSubjectView().get(cell).getText())) {
			components.getSubjectView().get(cell).setText("");
			components.getHiddenTextfields().get(cell).setText("");
			//Deleting of actual Object is missing 
			return(true);
		}
		return(false);
	}

}
