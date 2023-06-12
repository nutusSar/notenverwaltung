package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataclasses.Components;
import logic.DeleteButton;
import logic.EnableDisable;

/**GUI for deleting one entry in the table
 * 
 * @author nutusSar
 *
 */
public class GDelete {
	
	private JButton okButton; 
	private JLabel label;
	private JTextField textField;
	private Font font = new Font("Arial", Font.PLAIN, 11);
	private JLabel labelInput;
	
	public GDelete(Components components, String cell) {
		JFrame frame = new JFrame() {
			 @Override
	            public void dispose() {
				 	EnableDisable.enable(components);
	                super.dispose();
	            }
		};
		frame.setBounds(300, 250, 400, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Attention");
		frame.setVisible(true);
		okButton = new JButton("OK");
		okButton.setFont(font);
		okButton.setBounds(325, 235, 50, 20);
		okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String entry = textField.getText();
					 if (DeleteButton.clickOk(components, cell, entry)) {
						 frame.dispose();
					 }
					 else {
						 labelInput.setText("Your input doesnt match.");
						 textField.requestFocusInWindow();
					 }
				}
			});
		
		frame.getContentPane().add(okButton);
		
		textField = new JTextField();
		textField.setBounds(40, 147, 300, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		String deleteMessage = "Warning! You are about to delete a " + components.getVisibleTextfields().get("10").getText() + ". If you are sure, \nplease enter: \" IWantToDelete_" + components.getVisibleTextfields().get(cell).getText() +"\"";
		deleteMessage = "<html>" + deleteMessage.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>").replace("\"", "<i>").replace("\"", "</i>") + "</html>";
		label = new JLabel(deleteMessage);
		label.setFont(font);
		label.setBounds(40, 90, 300, 28);
		frame.getContentPane().add(label);
		
		labelInput = new JLabel();
		labelInput.setFont(font);
		labelInput.setForeground(Color.RED);
		labelInput.setBounds(40, 130, 300, 14);
		frame.getContentPane().add(labelInput);

	
	}
}
