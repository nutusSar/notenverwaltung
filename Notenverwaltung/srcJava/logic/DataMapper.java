package logic;

import dataclasses.Grade;
import dataclasses.Model;
import dataclasses.SClass;
import dataclasses.Student;
import dataclasses.Subject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**Core/Heart, stores the newest model of the school and does all data manipulation 
 * 
 * @author nutusSar
 *
 * manipulates the complete model and returns values (strings of data spaced by ";") if needed
 */
public class DataMapper {
	
	private static Model model = new Model();
	private static int index = 0;
	private static String search = "";
	private static File directory;

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
	public static File getDirectory() {
		return directory;
	}
	public static void setDirectory(File directory) {
		DataMapper.directory = directory;
	}
	
	/**creating a class
	 * 
	 * @param name class name
	 * @return true if succeeded 
	 */
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
	
	/** search for a specific class
	 * 
	 * @param id classID
	 * @return the searched class or null
	 */
	public static String searchClass(String id) {
		if (!model.getClasses().containsKey(id)) {
			return(null);
		}
		SClass sclass = model.getClasses().get(id);
		return(sclass.getName() + ";" + sclass.getAverage() + ";"+ sclass.getId()) + ";";
	}
	
	/** search for all classes
	 * 
	 * @return all classes in a sorted order, 12 per page
	 */
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
	
	
	/** create a student
	 * 
	 * @param inputSt student name
	 * @param inputCl class name
	 * @return an integer that gets checked in the GUI by a switch 
	 * 
	 * checks if the class exists and if the student name is free
	 */
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
	
	/**search for a specific student
	 * 
	 * @param id student id
	 * @return the specific student or null
	 */
	public static String searchStudent(String id) {
		if (!model.getStudents().containsKey(id)) {
			return(null);
		}
		Student student = model.getStudents().get(id);
		return(student.getName() + ";" + student.getAverage() + ";"+ student.getId()) + ";";
	}
	
	/**searches all students in one specific class
	 * 
	 * @param id class id
	 * @return all students in one specific class, 12 per page
	 */
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
	
	/**searches all students that have one specific module
	 * 
	 * @param id module id
	 * @return all students that have one specific module, 12 per page
	 */
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
	
	/**search for all students
	 * 
	 * @return all students of the school, 12 per page
	 */
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
	/**create a "subject" module
	 * 
	 * @param name module name
	 * @return true if the module was created
	 */
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
	
	/**add one subject to one specific student
	 * 
	 * @param name of the module
	 * @param id student id
	 * @return an integer that gets processed by the gui 
	 * 
	 * checks if the student has less than 12 subjects
	 * checks if the subject exists as a module
	 * checks if the student already has the subject
	 */
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
	
	/**search for one specific module
	 * 
	 * @param id module id
	 * @return the specific module
	 */
	public static String searchSubject(String id) {
		if (!model.getSubjects().containsKey(id)) {
			return(null);
		}
		Subject subject = model.getSubjects().get(id);
		return(subject.getName() + ";" + subject.getAverage() + ";"+ subject.getId()) + ";";
	}
	
	/**search for all subjects in a student
	 * 
	 * @param id student id
	 * @return all subjects added to the student
	 */
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
	
	/**search for all modules
	 * 
	 * @return all modules of the school
	 */
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
	/** add a grade for a specific subject for a specific student
	 * 
	 * @param id student <-> subject id
	 * @param input1 grade in mss points
	 * @param input2 weight in times counted
	 * @return an integer that gets processed by the GUI
	 * 
	 * checks if the grade is a actual grade
	 */
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
	
	/**searches all grades in one specific subject
	 * 
	 * @param id student <-> subject id
	 * @return all grades for that specific subject
	 */
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
	
	/**Calculates all possible averages (if a grade is added)
	 * 
	 * @param id student <-> subject id
	 * 
	 * calculates average for one subject -> for one student -> for one class -> for one module
	 */
	public static void average(String id) {
		String ids[] = id.split("\\+");
		ids[0] = ids[0].substring(2);
		
		//average of one subject in one student
		ArrayList<Grade> grades  = model.getS2s().getStSb2Grades().get(id);
		double average = -1.0;
		double sum = 0;
		double count = 0;
		if (!grades.isEmpty()) {
			
			for (Grade grade : grades) {
				sum += grade.getGrade() * grade.getWeight();
				count += grade.getWeight();
			}
			average = Math.round((sum / count)*100.0) / 100.0;
			
		}
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
		if (count != 0) {
			average = Math.round((sum / count)*100.0) / 100.0;
		}
		model.getStudents().get(ids[0]).setAverage(average);
		
		//total Average class
		String scId = model.getStudents().get(ids[0]).getSclass();
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
		if (count != 0) {
			average = Math.round((sum / count)*100.0) / 100.0;
		}
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
		if (count != 0) {
			average = Math.round((sum / count)*100.0) / 100.0;
		}
		model.getSubjects().get(ids[1]).setAverage(average);
	}
	
	/**starts the process of calculating all averages after a loading- or deleting action
	 *  
	 */
	public static void initAverage() {
		ArrayList<String> studentKeys = new ArrayList<String>();
		studentKeys.addAll(model.getStudents().keySet());
		for (String studentKey : studentKeys) {
			ArrayList<Subject> subjects = model.getS2s().getStudent2Subjects().get(studentKey);
			if (subjects != null) {
				for (Subject subject : subjects) {
					String stsbID = "GR" + studentKey + "+" + subject.getId();
					average(stsbID);
				}
			}	
		}		
	}
	
	/**deletes one grade 
	 * 
	 * @param stsbID student <-> subject id
	 * @param iGrade index of the grade
	 */
	public static void deleteGrade(String stsbID, int iGrade) {
		if (!model.getS2s().getStSb2Grades().containsKey(stsbID)) {
			return;
		}
		model.getS2s().getStSb2Grades().get(stsbID).remove(iGrade);
	}
	
	/**deletes one subject and all its grades
	 * 
	 * @param stsbID student <-> subject id
	 */
	public static void deleteSubject(String stsbID) {
		if (!model.getS2s().getStSb2Grades().containsKey(stsbID)) {
			return;
		}
		String ids[] = stsbID.split("\\+");
		ids[0] = ids[0].substring(2);
		model.getS2s().getStSb2Average().remove(stsbID);
		if (model.getS2s().getStSb2Grades() != null) {
			model.getS2s().getStSb2Grades().remove(stsbID);
		}
		Subject subject = model.getSubjects().get(ids[1]);
		model.getS2s().getStudent2Subjects().get(ids[0]).remove(subject);
		
		Student student = model.getStudents().get(ids[0]);
		model.getS2s().getSubject2Students().get(ids[1]).remove(student);		
	}
	
	/**deletes one student and all their connections
	 * 
	 * @param stID student id
	 */
	public static void deleteStudent(String stID) {
		if (!model.getStudents().containsKey(stID)) {
			return;
		}
		ArrayList<Subject> subjects = new ArrayList<Subject>(model.getS2s().getStudent2Subjects().get(stID));
		for(Subject subject : subjects) {
			String stsbID = "GR" + stID + "+" + subject.getId();
			deleteSubject(stsbID);
		}
		Student student = model.getStudents().get(stID);
		String scID = student.getSclass();
		model.getClasses().get(scID).getStudents().remove(student);
		model.getStudents().remove(stID);
	}
	
	/**deletes one class and all its connections
	 * 
	 * @param scID school class id
	 */
	public static void deleteClass(String scID) {
		if (!model.getClasses().containsKey(scID)) {
			return;
		}
		ArrayList<Student> students = new ArrayList<Student>(model.getClasses().get(scID).getStudents());
		for (Student student : students) {
			deleteStudent(student.getId());
		}
		model.getClasses().remove(scID);
	}
	
	/**deletes a entire module and all its connections
	 * 
	 * @param sbID module id
	 */
	public static void deleteModule(String sbID) {
		if (!model.getSubjects().containsKey(sbID)) {
			return;
		}
		ArrayList<Student> students = new ArrayList<Student>(model.getS2s().getSubject2Students().get(sbID));
		for (Student student : students) {
			String stsbID = "GR" + student.getId() + "+" + sbID;
			deleteSubject(stsbID);
		}
		model.getSubjects().remove(sbID);
	}
	
}
