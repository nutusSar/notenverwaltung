package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import dataclasses.Model;

public class Loader {
	
	private Model model = new Model();
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
		return(true);
	}
	
	
	//loads all modules
	
	
	//loads all classes 
	public static void loadClass(File sclass) {
		String id = sclass.getName();
		if (id.substring(0, 2).equals("")) {
			
		}
	}
}
