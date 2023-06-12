package logic;

import dataclasses.Components;
import gui.GCreateSubject;

/**GUI Logic
 * 
 * @author nutusSar
 *
 *Maps GUI action create module to the model action create module and vice versa
 */
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
