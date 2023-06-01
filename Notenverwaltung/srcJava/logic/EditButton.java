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
		}
		id = components.getHiddenTextfields().get("10").getText();
		if (!id.isEmpty()) {
			System.out.println(id);
			AddSubject.clickEdit(components, cell, id);
		}
		components.getVisibleTextfields().get(cell).setText(id);
	}

}
