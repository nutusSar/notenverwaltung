package logic;


import dataclasses.Components;
import gui.GDelete;

public class DeleteButton {	

	
	public static void clickDelete(String cell, Components components) {
		
		//Actual logic
		if (!components.getHiddenTextfields().get(cell).getText().isEmpty()) {
			EnableDisable.disable(components);
			new GDelete(components, cell);
		}
	}
	
	public static boolean clickOk(Components components, String cell, String entry) {
		if (entry.equals("IWantToDelete_" + components.getVisibleTextfields().get(cell).getText())) {
			components.getVisibleTextfields().get(cell).setText("");
			components.getHiddenTextfields().get(cell).setText("");
			//Deleting of actual Object is missing 
			return(true);
		}
		return(false);
	}
}

