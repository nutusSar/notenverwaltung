package logic;

import dataclasses.Grade;
import dataclasses.Model;
import dataclasses.SClass;
import dataclasses.Student;
import dataclasses.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DataMapper {
	
	private static Model model = new Model();
	private static int index = 0;
	private static String search = "";

	public static Model getModel() {
		return model;
	}
	public static void setModel(Model model) {
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
		newStudent.setSclass(id);
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
		String stsugrID = "GR" + id + "+" + sbID;
		ArrayList<Grade> grades= new ArrayList<Grade>();
		model.getS2s().getStSb2Grades().put(stsugrID, grades);
		model.getS2s().getStSb2Average().put(stsugrID, -1.0);
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
			return(id); //modiefied maybe should stay null?
		}
		String result = "";
		
		
		Subject subject;
		double average = -1;
		String stsbID;
		for (int i = index, ii = 0; i < subjects.size() && ii < 12; i++, ii++) {
			subject = subjects.get(i);
			stsbID = "GR" + id + "+" + subject.getId();
			average = model.getS2s().getStSb2Average().get(stsbID);
			result += String.valueOf(i + 1) + ";" + subject.getName() + ";" + average + ";"+ subject.getId() + ";";
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
	public static int addGrade(String id, String input1, String input2) {
		int gr = Integer.valueOf(input1);
		int we = Integer.valueOf(input2);
		if (gr > 15) {
			return(4);
		}
		if(!model.getS2s().getStSb2Grades().containsKey(id)) {
			return(4);
		}
		Grade grade = new Grade();
		grade.setGrade(gr);
		grade.setWeight(we);
		model.getS2s().getStSb2Grades().get(id).add(grade);
		average(id);
		return(0);
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
			return(id); 
		}
		String result = "";
		for (int i = index, ii = 0; i < grades.size() && ii < 12; i++, ii++) {
			result += String.valueOf(i + 1) + ";" + grades.get(i).getWeight() + ";" + grades.get(i).getGrade() + ";" + String.valueOf(i) + ";";
		}
		return (id + ";" + result);
	}
	
	public static void average(String id) {
		String ids[] = id.split("\\+");
		ids[0] = ids[0].substring(2);
		
		//average of one subject in one student
		ArrayList<Grade> grades  = model.getS2s().getStSb2Grades().get(id);
		double sum = 0;
		double count = 0;
		for (Grade grade : grades) {
			sum += grade.getGrade() * grade.getWeight();
			count += grade.getWeight();
		}
		double average = sum / count;
		model.getS2s().getStSb2Average().put(id, average);
		
		//total average student
		ArrayList<Subject> subjects = model.getS2s().getStudent2Subjects().get(ids[0]);
		sum = 0;
		count = 0;
		double av;
		for (Subject subject : subjects) {
			av = model.getS2s().getStSb2Average().get("GR" + ids[0] + "+" + subject.getId());
			if (av != -1) {
				sum += av;
				count++;
			}			
		}
		average = sum / count;
		model.getStudents().get(ids[0]).setAverage(average);
		
		//total Average class
		System.out.println(ids[0]);
		String scId = model.getStudents().get(ids[0]).getSclass();
		System.out.println(scId);
		ArrayList<Student> students = model.getClasses().get(scId).getStudents();
		sum = 0;
		count = 0;
		for(Student student : students) {
			av = student.getAverage();
			if (av != -1) {
				sum += av;
				count++;
			}
		}
		average = sum / count;
		model.getClasses().get(scId).setAverage(average);
		
		//total average of one module
		ArrayList<Student> studentsModule = model.getS2s().getSubject2Students().get(ids[1]);
		sum = 0;
		count = 0;
		for(Student student : studentsModule) {
			av = student.getAverage();
			if (av != -1) {
				sum += av;
				count++;
			}
		}
		average = sum / count;
		model.getSubjects().get(ids[1]).setAverage(average);
	}
	
}
