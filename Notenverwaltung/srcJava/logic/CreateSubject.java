package logic;

import dataclasses.Components;
import gui.GCreateSubject;

public class CreateSubject {
	
	public static void clickCreate(Components components) {
		EnableDisable.disable(components);
		new GCreateSubject(components);
		
	}

	public static boolean clickOk(String input) {
		if (input.isEmpty()) {
			return(false);
		}
		return(DataMapper.createSubject(input));
	}

}
