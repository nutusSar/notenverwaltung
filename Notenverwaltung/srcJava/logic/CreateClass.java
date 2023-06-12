package logic;

import dataclasses.Components;
import gui.GCreateClass;

/**GUI Logic
 * 
 * @author nutusSar
 *
 *Maps GUI action create class to the model action create class and vice versa
 */
public class CreateClass {

	public static void clickCreate(Components components) {
		EnableDisable.disable(components);
		new GCreateClass(components);
	}
	
	public static boolean clickOk(String input) {
		if (input.isEmpty()) {
			return(false);
		}
		return(DataMapper.createClass(input));
	}
}
