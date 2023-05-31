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
		if (model.getStudents().containsKey(id)) {
			return(1);
		}
		Student newStudent = new Student();
		newStudent.setName(inputSt);
		String stID = IDGenerater.idStudent(inputSt);
		newStudent.setId(stID);
		model.getClasses().get(id).getStudents().add(newStudent);
		model.getStudents().put(stID, newStudent);
		return 0;
	}
	
	public static String searchStudent(String id) {
		if (!model.getStudents().containsKey(id)) {
			return(null);
		}
		Student student = model.getStudents().get(id);
		return(student.getName() + ";" + student.getAverage() + ";"+ student.getId()) + ";";
	}
	
	public static String StudentsInClass(String id) {
		if (!model.getClasses().containsKey(id)) {
			return(null);
		}
		ArrayList<Student> students = model.getClasses().get(id).getStudents();
		Collections.sort(students);
		
	}
	
	public static String allStudents() {
		if (!search.equals("st")) {
			search = "st";
			index = 0;
		}
		if (index < 0) {
			index = 0;
		}
		ArrayList<String> keys = new ArrayList<>();
		keys.addAll(model.getStudents().keySet());
		Collections.sort(keys);
		if (index > keys.size()) {
			return(null);
		}
		String result = "";
		for (int i = index, ii = 0; i < keys.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + searchStudent(keys.get(i));
		}
		return result;
	}
	
}
