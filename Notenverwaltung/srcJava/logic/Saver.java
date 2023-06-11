package logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dataclasses.Grade;
import dataclasses.Model;
import dataclasses.SClass;
import dataclasses.Student;
import dataclasses.Subject;

public class Saver {

	private static Model model;
	
	public static boolean save() {
		model = DataMapper.getModel();
		File selectedDirectory = DataMapper.getDirectory();
		File classesDirectory = new File(selectedDirectory, "/Classes");
		File modulesDirectory = new File(selectedDirectory, "/Modules");
		
		if (!classesDirectory.exists()) {
		    classesDirectory.mkdirs();
		}
		
		if (!modulesDirectory.exists()) {
			modulesDirectory.mkdirs();
		}
		
		ArrayList<SClass> sclasses = new ArrayList<SClass>();
		sclasses.addAll(model.getClasses().values());
		for(SClass sclass : sclasses) {
			String name = sclass.getName();
			File classDir = new File(classesDirectory, "/" + name);
			if (!classDir.exists()) {
				classDir.mkdirs();
			}
			ArrayList<Student> students = sclass.getStudents();
			for (Student student : students) {
				saveStudent(classDir, student);
			}
			
		}
		ArrayList<Subject> modules = new ArrayList<Subject>();
		modules.addAll(model.getSubjects().values());
		for (Subject module : modules) {
			saveModule(modulesDirectory, module);
		}
		return(true);
	}


	public static void saveStudent(File classDir, Student student) {
		File studentFile = new File(classDir, "/" + student.getName() + ".txt");
		try (FileWriter fileWriter = new FileWriter(studentFile, false)) {
			String content = "";
			ArrayList<Subject> subjects = model.getS2s().getStudent2Subjects().get(student.getId());
			if (subjects == null) {
				return;
			}
			for (Subject subject : subjects) {
				String stsbId = "GR" + student.getId() + "+" + subject.getId();
				content += subject.getName().toUpperCase() + ";";
				ArrayList<Grade> grades = model.getS2s().getStSb2Grades().get(stsbId);
				for (Grade grade : grades) {
					content += String.valueOf(grade.getGrade()) + ":";
					content += String.valueOf(grade.getWeight()) + ";";
				}
				content = content.substring(0, content.length() -1) + "\n";
			}
		    fileWriter.write(content);
		} catch (IOException e) {
		    // handle any IOExceptions here
		}
	}
	
	public static void saveModule(File modulesDirectory, Subject module) {
		File moduleDir = new File(modulesDirectory, "/" + module.getName());
		if (!moduleDir.exists()) {
			moduleDir.mkdirs();
		}
	}
	
}
