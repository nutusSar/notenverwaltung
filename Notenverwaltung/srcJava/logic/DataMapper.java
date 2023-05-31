package logic;

import dataclasses.Model;
import dataclasses.SClass;
import java.util.ArrayList;
import java.util.Collections;

public class DataMapper {
	
	private static Model model = new Model();
	private static int index = 0;
	private static String search = "";

	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		DataMapper.model = model;
	}
	public static int getIndex() {
		return index;
	}
	public static void setIndex(int index) {
		DataMapper.index = index;
	}
	public static String getSearch() {
		return search;
	}
	public static void setSearch(String search) {
		DataMapper.search = search;
	}
	
	
	public static boolean createClass(String name) {
		String id = IDGenerater.idClass(name);
		if (model.getClasses().containsKey(id)){
			return(false);
		}
		SClass sclass = new SClass();
		sclass.setName(name);
		sclass.setId(id);
		model.getClasses().put(id, sclass);
		return(true);
	}
	
	public static String searchClass(String id) {
		if (!model.getClasses().containsKey(id)) {
			return(null);
		}
		SClass sclass = model.getClasses().get(id);
		return(sclass.getName() + ";"+ sclass.getAverage() + ";"+ sclass.getId());
	}
	
	public static String allClasses() {
		if (!search.equals("sc")) {
			search = "sc";
			index = 0;
		}
		ArrayList<String> keys = new ArrayList<>();
		keys.addAll(model.getClasses().keySet());
		Collections.sort(keys);
		return null;
	}
}
