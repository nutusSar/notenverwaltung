package logic;

import javax.swing.JButton;

import dataclasses.Components;

/**Enable, disable all buttons 
 * 
 * @author nutusSar
 *
 */
public class EnableDisable {

	public static void enable(Components components) {
		for (JButton button: components.getButtons()) {
			button.setEnabled(true);
		}
		for (int i = 0; i < components.getMenuBar().getMenuCount(); i++) {
			components.getMenuBar().getMenu(i).setEnabled(true);
		}
	}
	
	public static void disable(Components components) {
		for (JButton button: components.getButtons()) {
			button.setEnabled(false);
		}
		for (int i = 0; i < components.getMenuBar().getMenuCount(); i++) {
			components.getMenuBar().getMenu(i).setEnabled(false);
		}
	}
}
