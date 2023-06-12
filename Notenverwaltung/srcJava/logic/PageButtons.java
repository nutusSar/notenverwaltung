package logic;

import dataclasses.Components;

/**GUI Logic 
 * 
 * @author nutusSar
 *
 *Maps GUI action page navigation to the model action page navigation and vice versa 
 */
public class PageButtons {

	public static void previous(Components components) {
		DataMapper.setIndex(DataMapper.getIndex() -12);
		SearchField.clickOk(components, components.getSearchField().getText(), false);
	}
	
	public static void next(Components components) {
		DataMapper.setIndex(DataMapper.getIndex() +12);
		SearchField.clickOk(components, components.getSearchField().getText(), false);
	}
}
