package logic;

import dataclasses.Components;

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
