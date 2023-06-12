package logic;

/**generates ids -> student, subject/module, class
 * 
 * @author nutusSar
 *
 */
public class IDGenerater {
	
	public static String idClass(String name) {
		return("SC" + name.toUpperCase());
	}

	public static String idStudent(String inputSt) {
		return("ST" + inputSt.toUpperCase());
	}

	public static String idSubject(String name) {
		return("SU" + name.toUpperCase());
	}
}
