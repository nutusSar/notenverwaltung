package logic;

import dataclasses.Components;
import gui.GCreateStudent;

public class CreateStudent {
	public static void clickCreate(Components components) {
		EnableDisable.disable(components);
		new GCreateStudent(components);
	}
	
	public static int clickOk(String inputSt, String inputCl) {
		if (inputSt.isEmpty() && inputCl.isEmpty()) {
			return(3);
		}
		if (inputSt.isEmpty() || inputSt.contains(";") || inputSt.contains("+")) {
			return(1);
		}
		if (inputCl.isEmpty()) {
			return(2);
		}
		
		return(DataMapper.createStudent(inputSt, inputCl));
	}
}
