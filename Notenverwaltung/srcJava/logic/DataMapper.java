package logic;

import dataclasses.Model;
import dataclasses.SClass;
import dataclasses.Student;

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
		return(sclass.getName() + ";" + sclass.getAverage() + ";"+ sclass.getId()) + ";";
	}
	
	public static String allClasses() {
		if (!search.equals("sc")) {
			search = "sc";
			index = 0;
		}
		if (index < 0) {
			index = 0;
		}
		ArrayList<String> keys = new ArrayList<>();
		keys.addAll(model.getClasses().keySet());
		Collections.sort(keys);
		if (index > keys.size()) {
			return(null);
		}
		String result = "";
		for (int i = index, ii = 0; i < keys.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + searchClass(keys.get(i));
		}
		return result;
	}
	
	public static int createStudent(String inputSt, String inputCl) {
		String id = IDGenerater.idClass(inputCl);
		if (!model.getClasses().containsKey(id)) {
			return(2);
		}
		SClass sclass = model.getClasses().get(id);
		ArrayList<Student> students = sclass.getStudents();
		if (!students.isEmpty()) {
			for (Student student : students) {
				if (student.getName().equals(inputSt)) {
					return(1);
				}
			}
		}
		Student newStudent = new Student();
		newStudent.setName(inputSt);
		//ID needs to be implemnted
		newStudent.setId(0);
		sclass.getStudents().add(newStudent);
		return 0;
	}
}
