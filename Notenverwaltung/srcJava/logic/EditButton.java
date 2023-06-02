package logic;
import dataclasses.Components;

public class EditButton {
	
	
	public static void logic(String cell, Components components) {
		String id = components.getHiddenTextfields().get(cell).getText();
		if (!id.isEmpty()) {
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
			String stID = components.getHiddenTextfields().get("10").getText();
			String stsbgrID = "GR"+ stID + "+" + id;
			if (!stID.isEmpty()) {
				components.getSearchField().setText(stsbgrID);
				SearchField.clickOk(components, stsbgrID, false);
			}
		}
		id = components.getHiddenTextfields().get("10").getText();
		if (!id.isEmpty() && id.matches("([Ss])([Tt])(.*)")) {
			AddSubject.clickEdit(components, cell, id);
		}
		if (!id.isEmpty() && id.matches("([Gg])([Rr])(.*)")) {
			AddGrade.clickEdit(components, cell, id);
		}
		//components.getVisibleTextfields().get(cell).setText(id);
	}

}
