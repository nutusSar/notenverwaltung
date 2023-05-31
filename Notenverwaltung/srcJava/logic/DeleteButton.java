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
			String y = cell.split("")[1];
			components.getVisibleTextfields().get(cell).setText("");
			components.getVisibleTextfields().get("0" + y).setText("");
			components.getVisibleTextfields().get("2" + y).setText("");
			components.getHiddenTextfields().get(cell).setText("");
			//Deleting of actual Object is missing 
			return(true);
		}
		return(false);
	}
}

