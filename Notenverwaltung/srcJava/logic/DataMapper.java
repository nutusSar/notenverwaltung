package logic;

import dataclasses.Grade;
import dataclasses.Model;
import dataclasses.SClass;
import dataclasses.Student;
import dataclasses.Subject;

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
		String stID = IDGenerater.idStudent(inputSt);
		if (!model.getClasses().containsKey(id)) {
			return(2);
		}
		if (model.getStudents().containsKey(stID)) {
			return(1);
		}
		Student newStudent = new Student();
		newStudent.setName(inputSt);
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
		if (!search.equals("ic")) {
			search = "ic";
			index = 0;
		}
		if (index < 0) {
			index = 0;
		}
		ArrayList<Student> students = model.getClasses().get(id).getStudents();
		Collections.sort(students);
		if (index > students.size()) {
			return(null);
		}
		String result = "";
		for (int i = index, ii = 0; i < students.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + searchStudent(students.get(i).getId());
		}
		return result;
		
	}
	
	public static String StudentsInSubject(String id) {
		if (!model.getSubjects().containsKey(id)) {
			return(null);
		}
		if (!search.equals("iu")) {
			search = "iu";
			index = 0;
		}
		if (index < 0) {
			index = 0;
		}
		ArrayList<Student> students = model.getS2s().getSubject2Students().get(id);
		if (students == null) {
			return(null);
		}
		if (students.isEmpty()) {
			return(null);
		}
		Collections.sort(students);
		if (index > students.size()) {
			return(null);
		}
		String result = "";
		for (int i = index, ii = 0; i < students.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + searchStudent(students.get(i).getId());
		}
		return result;
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
	
	
	//Subject
	public static boolean createSubject(String name) {
		String id = IDGenerater.idSubject(name);
		if (model.getSubjects().containsKey(id)){
			return(false);
		}
		Subject subject = new Subject();
		subject.setName(name);
		subject.setId(id);
		model.getSubjects().put(id, subject);
		return(true);
	}
	
	public static int addSubject(String name, String id) {
		String sbID = IDGenerater.idSubject(name);
		if (!model.getSubjects().containsKey(sbID)) {
			return(1);
		}
		if (!model.getStudents().containsKey(id)) {
			return(2);
		}
		if (model.getS2s().getStudent2Subjects().containsKey(id)) {
			ArrayList<Subject> subjects = model.getS2s().getStudent2Subjects().get(id);
			if (subjects.size() > 11){
				return(3);
			}
			for (Subject subject : subjects) {
				if (subject.getId().equals(sbID)) {
					return(3);
				}
			}
			subjects.add(model.getSubjects().get(sbID));
		}
		else {
			ArrayList<Subject> subjects = new ArrayList<Subject>();
			subjects.add(model.getSubjects().get(sbID));
			model.getS2s().getStudent2Subjects().put(id, subjects);
			
		}
		
		if (model.getS2s().getSubject2Students().containsKey(sbID)) {
			model.getS2s().getSubject2Students().get(sbID).add(model.getStudents().get(id));
		}
		else {
			ArrayList<Student> students = new ArrayList<Student>();
			students.add(model.getStudents().get(id));
			model.getS2s().getSubject2Students().put(sbID, students);
		}
		return(0);
	}
	
	public static String searchSubject(String id) {
		if (!model.getSubjects().containsKey(id)) {
			return(null);
		}
		Subject subject = model.getSubjects().get(id);
		return(subject.getName() + ";" + subject.getAverage() + ";"+ subject.getId()) + ";";
	}
	
	public static String SubjectsInStudent(String id) {
		if (!model.getStudents().containsKey(id)) {
			return(null);
		}
		if (!search.equals("it")) {
			search = "it";
			index = 0;
		}
		if (index < 0) {
			index = 0;
		}
		ArrayList<Subject> subjects = model.getS2s().getStudent2Subjects().get(id);
		if (subjects == null) {
			return(id);
		}
		Collections.sort(subjects);
		if (index > subjects.size()) {
			return(null);
		}
		String result = "";
		for (int i = index, ii = 0; i < subjects.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + searchSubject(subjects.get(i).getId());
		}
		return (id + ";" + result);
	}
	
	public static String allSubjects() {
		if (!search.equals("su")) {
			search = "su";
			index = 0;
		}
		if (index < 0) {
			index = 0;
		}
		ArrayList<String> keys = new ArrayList<>();
		keys.addAll(model.getSubjects().keySet());
		Collections.sort(keys);
		if (index > keys.size()) {
			return(null);
		}
		String result = "";
		for (int i = index, ii = 0; i < keys.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + searchSubject(keys.get(i));
		}
		return result;
	}
	
	//Grade
	public static boolean addGrade(String id) {
		//TODO
		return(false);
	}
	
	public static String gradesInSubject(String id) {
		if (!model.getS2s().getStSb2Grades().containsKey(id)) {
			return(null);
		}
		if (!search.equals("tu")) {
			search = "tu";
			index = 0;
		}
		if (index < 0) {
			index = 0;
		}
		ArrayList<Grade> grades = model.getS2s().getStSb2Grades().get(id);
		if (grades == null) {
			return(id);
		}
		if (index > grades.size()) {
			return(null);
		}
		String result = "";
		for (int i = index, ii = 0; i < grades.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + grades.get(i).getWeight() + ";" + grades.get(i).getGrade() + String.valueOf(i);
		}
		return (id + ";" + result);
	}
}
