package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import dataclasses.Model;
import dataclasses.SClass;
import dataclasses.Student;
import dataclasses.Subject;

public class Loader {
	
	private static Model model = new Model();
	private static ArrayList<File> classes = new ArrayList<File>();
	private static ArrayList<File> modules = new ArrayList<File>();

	//starts the loading process and gets all directories
	public static boolean load(File selectedDirectory) {
		File classesDirectory = new File(selectedDirectory, "/Classes");
		File modulesDirectory = new File(selectedDirectory, "/Modules");
				
		//gets all classes
		if (classesDirectory.exists()) {
			Collections.addAll(classes, classesDirectory.listFiles());
			System.out.println(classes);
		}
		else {
			//TODO Error GUI
			System.out.println("TODO Error GUI");
			return(false);
		}
		
		//gets all Modules
		if (modulesDirectory.exists()) {
			Collections.addAll(modules, modulesDirectory.listFiles());
			System.out.println(modules);
		}
		else {
			//TODO Error GUI
			System.out.println("TODO Error GUI");
			return(false);
		}
		
		for (File module : modules) {
			loadModule(module);
		}		
		for(File sclass : classes) {
			loadClass(sclass);
		}
		
		DataMapper.setModel(model);
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
			model.getStudents().put(id, newStudent);
			model.getClasses().get(clID).getStudents().add(newStudent);
			loadSubjects(id, student);
		}
	}
	
	//load all subjects and grades into student
	public static void loadSubjects(String stID, File student){
		try (FileReader fileReader = new FileReader(student);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
			        System.out.println(line);
			    }
			}
		
		catch (FileNotFoundException e) {
			// handle FileNotFoundExceptions here
		} catch (IOException e) {
			// handle any other IOExceptions here
		}
	}
}
