package logic;


import javax.swing.JTextField;

import dataclasses.Components;
/**GUI Logic 
 * 
 * @author nutusSar
 *
 *Maps GUI action search object(s) to the model search object(s) object and vice versa 
 */
public class SearchField {

	public static void clickOk(Components components, String input, boolean reset) {
		if (reset) {
			DataMapper.setIndex(0);
		}
		int i = 0;
		for (JTextField textField : components.getVisibleTextfields().values()) {
			textField.setText("");
		}
		for (JTextField textField : components.getHiddenTextfields().values()) {
			textField.setText("");
		}
		components.getVisibleTextfields().get("30").setText("Del");
		components.getVisibleTextfields().get("40").setText("Edi");
		
		//Class Search
		if (input.matches("([Ss])([Cc])(.*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Class");
			components.getVisibleTextfields().get("20").setText("Average");
			if (input.matches("([Ss][Cc])")) {
				String result = DataMapper.allClasses();
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				for (int y = 0; y < (cells.length) / 4; y++) {
					for (int x = 0; x < 3; x++) {
						components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
					}
					components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
				}
			}
			else{
				String result = DataMapper.searchClass(input.toUpperCase());
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				components.getVisibleTextfields().get("01").setText("1");
				components.getVisibleTextfields().get("11").setText(cells[0]);
				components.getVisibleTextfields().get("21").setText(cells[1]);
				components.getHiddenTextfields().get("11").setText(cells[2]);
			}
		}
		
		//StudentSearch
		if (input.matches("([Ss])([Tt])(.*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Student");
			components.getVisibleTextfields().get("20").setText("Average");
			if (input.matches("([Ss][Tt])")) {
				String result = DataMapper.allStudents();
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				for (int y = 0; y < (cells.length) / 4; y++) {
					for (int x = 0; x < 3; x++) {
						components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
					}
					components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
				}
			}
			else{
				String result = DataMapper.searchStudent(input.toUpperCase());
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				components.getVisibleTextfields().get("01").setText("1");
				components.getVisibleTextfields().get("11").setText(cells[0]);
				components.getVisibleTextfields().get("21").setText(cells[1]);
				components.getHiddenTextfields().get("11").setText(cells[2]);
			}
				
		}
		
		//inClassSearch
		if (input.matches("([Ii])([Cc])(.*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Student");
			components.getVisibleTextfields().get("20").setText("Average");
			String result = DataMapper.StudentsInClass("SC" + input.substring(2).toUpperCase());
			if (result == null) {
				return;
			}
			String[] cells = result.split(";");
			for (int y = 0; y < (cells.length) / 4; y++) {
				for (int x = 0; x < 3; x++) {
					components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
				}
				components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
			}
		}
		
		//SubjectSearch
		if (input.matches("([Ss])([Uu])(.*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Subject");
			components.getVisibleTextfields().get("20").setText("Average");
			if (input.matches("([Ss][Uu])")) {
				String result = DataMapper.allSubjects();
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				for (int y = 0; y < (cells.length) / 4; y++) {
					for (int x = 0; x < 3; x++) {
						components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
					}
					components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
				}
			}
			else{
				String result = DataMapper.searchSubject(input.toUpperCase());
				if (result == null) {
					return;
				}
				String[] cells = result.split(";");
				components.getVisibleTextfields().get("01").setText("1");
				components.getVisibleTextfields().get("11").setText(cells[0]);
				components.getVisibleTextfields().get("21").setText(cells[1]);
				components.getHiddenTextfields().get("11").setText(cells[2]);
			}
				
		}
		//inStudentSearch
		if (input.matches("([Ii])([Tt])(.*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Subject");
			components.getVisibleTextfields().get("20").setText("Average");
			String result = DataMapper.SubjectsInStudent("ST" + input.substring(2).toUpperCase());
			if (result == null) {
				return;
			}
			String[] cellsE = result.split(";");
			components.getHiddenTextfields().get("10").setText(cellsE[0]);
			String[] cells = new String[cellsE.length - 1];
			System.arraycopy(cellsE, 1, cells, 0, cellsE.length - 1);
			for (int y = 0; y < (cells.length) / 4; y++) {
				for (int x = 0; x < 3; x++) {
					components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
				}
				components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
			}
		}
		
		//inSubjectSearch
		if (input.matches("([Ii])([Uu])(.*)")) {
			components.getVisibleTextfields().get("00").setText("NR");
			components.getVisibleTextfields().get("10").setText("Student");
			components.getVisibleTextfields().get("20").setText("Average");
			String result = DataMapper.StudentsInSubject("SU" + input.substring(2).toUpperCase());
			if (result == null) {
				return;
			}
			String[] cells = result.split(";");
			for (int y = 0; y < (cells.length) / 4; y++) {
				for (int x = 0; x < 3; x++) {
					components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
				}
				components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
			}
		}
		//GradesInSubject
		String[] stsbgr = input.split("\\+");
		if(stsbgr.length > 1) {
			if (stsbgr[0].substring(2).matches("([Ss])([Tt])(.*)") && stsbgr[1].matches("([Ss])([Uu])(.*)") ) {
				components.getVisibleTextfields().get("00").setText("NR");
				components.getVisibleTextfields().get("10").setText("Weight");
				components.getVisibleTextfields().get("20").setText("Grade");
				String result = DataMapper.gradesInSubject(String.join("+", stsbgr).toUpperCase());
				if (result == null) {
					return;
				}
				String[] cellsE = result.split(";");
				components.getHiddenTextfields().get("10").setText(cellsE[0]);
				String[] cells = new String[cellsE.length - 1];
				System.arraycopy(cellsE, 1, cells, 0, cellsE.length - 1);
				for (int y = 0; y < (cells.length) / 4; y++) {
					for (int x = 0; x < 3; x++) {
						components.getVisibleTextfields().get(String.valueOf(x) + String.valueOf(y + 1)).setText(cells[y * 4 + x]);
					}
					components.getHiddenTextfields().get("1" + String.valueOf(y +1)).setText(cells[((y+1)*4) -1]);
				}
			}
		}
	}
}

