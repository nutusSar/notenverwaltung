package logic;

import dataclasses.Components;
import gui.GAddSubject;

public class AddSubject {
	
	public static void clickEdit(Components components, String cell, String id) {
		if (!components.getHiddenTextfields().get(cell).getText().isEmpty()) {
			EnableDisable.disable(components);
			new GAddSubject(components, cell);
		}
	}

	public static int clickOk(Components components, String input, String id) {
		if (input.isEmpty()) {
			return(1);
		}
		if (id.isEmpty()) {
			return(2);
		}
		return(DataMapper.addSubject(input, id));
	}

}
