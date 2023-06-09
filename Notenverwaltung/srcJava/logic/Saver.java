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

/**Saves the entire model to the memory by overwriting if an old model already exits or by creating a new one
 * 
 * @author nutusSar
 *
 */
public class Saver {

	private static Model model;
	
	/** starts the saving process
	 * 
	 * @return true if saving was successful
	 */
	public static boolean save() {
		model = DataMapper.getModel();
		File selectedDirectory = DataMapper.getDirectory();
		File classesDirectory = new File(selectedDirectory, "/Classes");
		File modulesDirectory = new File(selectedDirectory, "/Modules");
		
		if (classesDirectory.exists()) {
		    deleteDirectory(classesDirectory);
		   
		}
		classesDirectory.mkdirs();
		
		if (modulesDirectory.exists()) {
			deleteDirectory(modulesDirectory);
		}
		modulesDirectory.mkdirs();

		
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


	public static void deleteDirectory(File directory) {
		if (directory.isDirectory()) {
	        File[] files = directory.listFiles();
	        if (files != null) {
	            for (File file : files) {
	                deleteDirectory(file);
	            }
	        }
	    }
	    directory.delete();
	}
	
	/** saves all students
	 * 
	 * @param classDir dir of the students class
	 * @param student to save
	 */
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
		}
	}
	
	/**saves all modules
	 * 
	 * @param modulesDirectory path of the dir
	 * @param module to save
	 */
	public static void saveModule(File modulesDirectory, Subject module) {
		File moduleDir = new File(modulesDirectory, "/" + module.getName());
		if (!moduleDir.exists()) {
			moduleDir.mkdirs();
		}
	}
	
}
