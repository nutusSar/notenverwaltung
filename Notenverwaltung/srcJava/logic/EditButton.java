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
		}
		components.getVisibleTextfields().get(cell).setText(id);
	}

}
