package logic;
import dataclasses.Components;

public class EditButton {
	
	
	public static void logic(String cell, Components components) {
		String id = components.getHiddenTextfields().get(cell).getText();
		String stID = components.getHiddenTextfields().get("10").getText();
		
		boolean gr = false;
		if (!stID.isEmpty()) {
			gr = !stID.substring(0, 2).equals("GR");
		}
		else {
			gr = true;
		}
		if (!id.isEmpty() && gr) {
			if (id.matches("([Ss])([Cc])(.*)")) {
				components.getSearchField().setText("ic" + components.getVisibleTextfields().get(cell).getText());
				id = "IC" + id.substring(2);
				SearchField.clickOk(components, id, false);
				return;
			}
			if (id.matches("([Ss])([Tt])(.*)")) {
				components.getSearchField().setText("it" + components.getVisibleTextfields().get(cell).getText());
				id = "IT" + id.substring(2);
				SearchField.clickOk(components, id, false);
				return;
			}
			if (id.matches("([Ss])([Uu])(.*)") && components.getHiddenTextfields().get("10").getText().isEmpty()) {
				components.getSearchField().setText("iu" + components.getVisibleTextfields().get(cell).getText());
				id = "IU" + id.substring(2);
				SearchField.clickOk(components, id, false);
				return;
			}
			//String stID = components.getHiddenTextfields().get("10").getText();
			String stsbgrID = "GR"+ stID + "+" + id;
			if (!stID.isEmpty()) {
				components.getSearchField().setText(stsbgrID);
				SearchField.clickOk(components, stsbgrID, false);
				return;
			}
		}
		if (!stID.isEmpty() && stID.matches("([Ss])([Tt])(.*)")) {
			AddSubject.clickEdit(components, cell, stID);
			return;
		}
		if (!stID.isEmpty() && stID.matches("([Gg])([Rr])(.*)") && id.isEmpty()) {
			AddGrade.clickEdit(components, cell, stID);
			return;
		}
		//components.getVisibleTextfields().get(cell).setText(id);
	}

}
