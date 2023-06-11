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
			if(components.getHiddenTextfields().get("10").getText().matches("([Gg])([Rr])(.*)")) {
				DataMapper.deleteGrade(components.getHiddenTextfields().get("10").getText(),Integer.valueOf(components.getHiddenTextfields().get(cell).getText()));
			}
			if(components.getHiddenTextfields().get("10").getText().matches("([Ss])([Tt])(.*)")) {
				String stID = components.getHiddenTextfields().get("10").getText();
				String sbID = components.getHiddenTextfields().get(cell).getText();
				String stsbID = "GR" + stID + "+" + sbID;
				DataMapper.deleteSubject(stsbID);
			}
			if (components.getHiddenTextfields().get("10").getText().isEmpty() &&  components.getHiddenTextfields().get(cell).getText().matches("([Ss])([Tt])(.*)")) {
				DataMapper.deleteStudent(components.getHiddenTextfields().get(cell).getText());
			}
			if (components.getHiddenTextfields().get("10").getText().isEmpty() &&  components.getHiddenTextfields().get(cell).getText().matches("([Ss])([Cc])(.*)")) {
				DataMapper.deleteClass(components.getHiddenTextfields().get(cell).getText());
			}
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

