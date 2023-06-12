package logic;

import dataclasses.Components;
import gui.GAddGrade;

/**GUI Logic 
 * 
 * @author nutusSar
 *
 *Maps GUI action add grade to the model action add Grade and vice versa 
 */
public class AddGrade {

	public static void clickEdit(Components components, String cell, String id) {
		if (components.getHiddenTextfields().get(cell).getText().isEmpty()) {
			EnableDisable.disable(components);
			new GAddGrade(components, cell);
		}
		
	}

	public static int clickOk(Components components, String grade, String weight) {
		if (grade.isEmpty()) {
			return(1);
		}
		if (weight.isEmpty()) {
			return(2);
		}
		if (!grade.matches("(\\d*)") || !weight.matches("(\\d*)")) {
			return(3);
		}
		String id = components.getHiddenTextfields().get("10").getText();
		//SearchField.clickOk(components, id, false);
		return(DataMapper.addGrade(id, grade, weight));
	}

}
