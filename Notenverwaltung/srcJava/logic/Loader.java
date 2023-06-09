package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import dataclasses.Grade;
import dataclasses.Model;
import dataclasses.SClass;
import dataclasses.Student;
import dataclasses.Subject;

/**loads an entire new model from memory and passes it into the DataMapper
 * 
 * advantage after init load no connection between model and memory
 * 
 * @author nutusSar
 *
 */
public class Loader {
	
	private static Model model = new Model();
	private static ArrayList<File> classes = new ArrayList<File>();
	private static ArrayList<File> modules = new ArrayList<File>();

	//starts the loading process and gets all directories
	public static boolean load(File selectedDirectory) {
		File classesDirectory = new File(selectedDirectory, "/Classes");
		File modulesDirectory = new File(selectedDirectory, "/Modules");
		
		//resetting
		model = new Model();
		classes = new ArrayList<File>();
		modules = new ArrayList<File>();
		//gets all classes
		if (classesDirectory.exists()) {
			Collections.addAll(classes, classesDirectory.listFiles());
		}
		else {
			return(false);
		}
		
		//gets all Modules
		if (modulesDirectory.exists()) {
			Collections.addAll(modules, modulesDirectory.listFiles());
		}
		else {
			return(false);
		}
		
		for (File module : modules) {
			loadModule(module);
		}		
		for(File sclass : classes) {
			loadClass(sclass);
		}
		
		DataMapper.setModel(model);
		DataMapper.initAverage();
		return(true);
	}
	
	
	//loads all modules
	public static void loadModule(File module) {
		String name = module.getName();
		String id = "SU" + name.toUpperCase();
		if (!model.getSubjects().containsKey(id)) {
			Subject subject = new Subject();
			subject.setName(name);
			subject.setId(id);
			model.getSubjects().put(id, subject);
			ArrayList<Student> students = new ArrayList<Student>();
			model.getS2s().getSubject2Students().put(id, students);
		}
	}
	
	//loads all classes 
	public static void loadClass(File sclass) {
		String name = sclass.getName();
		String id = "SC" + name.toUpperCase();
		if (!model.getClasses().containsKey(id)) {
			SClass newSClass = new SClass();
			newSClass.setName(name);
			newSClass.setId(id);			
			model.getClasses().put(id, newSClass);
			
			File[] students = sclass.listFiles();
			for (File student : students) {
				loadStudent(id, student);
			}
		}
	}
	
	//loads all students
	public static void loadStudent(String clID, File student) {
		String name = student.getName();
		name = name.substring(0, name.length() - 4);
		String id = "ST" + name.toUpperCase();
		if (!model.getStudents().containsKey(id)) {
			Student newStudent = new Student();
			newStudent.setName(name);
			newStudent.setId(id);
			newStudent.setSclass(clID);
			newStudent.setAverage(-1.0);
			model.getStudents().put(id, newStudent);
			model.getClasses().get(clID).getStudents().add(newStudent);
			loadSubjects(id, student);
		}
	}
	
	//load all subjects and grades into student
	public static void loadSubjects(String stID, File student){
		FileReader fileReader = null;
		ArrayList<String> lines = new ArrayList<String>();
		try{
			fileReader = new FileReader(student);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}	
		}
		catch (FileNotFoundException e) {
		} 
		catch (IOException e) {
		}
		finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} 
				catch (IOException e) {
				}
			}
		}
		for (int i = 0; i < lines.size() && i < 12; i++) {
			String[] content = lines.get(i).split(";");
			String name = content[0];
			String id = "SU" + name;
			if (model.getSubjects().containsKey(id)) {
				if (model.getS2s().getStudent2Subjects().containsKey(stID)) {
					ArrayList<Subject> subjects = model.getS2s().getStudent2Subjects().get(stID);
					for (Subject subject : subjects) {
						if (subject.getId() == id) {
							return;
						}
					}
				}
				else {
					ArrayList<Subject> subjects = new ArrayList<Subject>();
					model.getS2s().getStudent2Subjects().put(stID, subjects);
				}
				model.getS2s().getStudent2Subjects().get(stID).add(model.getSubjects().get(id));
				model.getS2s().getSubject2Students().get(id).add(model.getStudents().get(stID));
				
				String stsbID = "GR" + stID + "+" + id;
				ArrayList<Grade> grades = new ArrayList<Grade>();
				model.getS2s().getStSb2Grades().put(stsbID, grades);
				model.getS2s().getStSb2Average().put(stsbID, -1.0);
				
				for (int gradeCounter = 1; gradeCounter < content.length; gradeCounter++ ) {
					Grade grade = new Grade();
					grade.setGrade(Double.valueOf(content[gradeCounter].split(":")[0]));
					grade.setWeight(Double.valueOf(content[gradeCounter].split(":")[1]));
					model.getS2s().getStSb2Grades().get(stsbID).add(grade);
				}
			}
		}
	}
}
