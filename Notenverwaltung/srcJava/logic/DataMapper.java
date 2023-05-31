package logic;

import dataclasses.Model;
import dataclasses.SClass;

public class DataMapper {
	
	private static Model model = new Model();

	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		DataMapper.model = model;
	}
	
	public static boolean createClass(String name) {
		if (model.getClasses().containsKey(name)){
			return(false);
		}
		SClass sclass = new SClass();
		sclass.setName(name);
		sclass.setId(name);
		model.getClasses().put(name, sclass);
		return(true);
	}
}
