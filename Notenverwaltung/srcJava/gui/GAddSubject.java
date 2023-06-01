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
import logic.AddSubject;
import logic.CreateStudent;
import logic.CreateSubject;
import logic.EnableDisable;

public class GAddSubject {
	
	private JButton okButton; 
	private JLabel label;
	private JTextField textField;
	private Font font = new Font("Arial", Font.PLAIN, 11);
	private JLabel labelInput;
	
	public GAddSubject(Components components) {
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
		frame.setTitle("Create Subject");
		frame.setVisible(true);
		okButton = new JButton("OK");
		okButton.setFont(font);
		okButton.setBounds(325, 235, 50, 20);
		okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					switch(AddSubject.clickOk(components, null)) {
					case 0:
						frame.dispose();
						break;
					case 1:
						labelInputSt.setText("This name isnt available.");
						labelInputCl.setText("");
						textFieldSt.requestFocusInWindow();
						break;
					case 2:
						labelInputSt.setText("");
						labelInputCl.setText("This class doesnt exist.");
						textFieldCl.requestFocusInWindow();
						break;
					case 3:
						labelInputSt.setText("This name isnt available.");
						labelInputCl.setText("This class doesnt exist.");
						textFieldSt.requestFocusInWindow();
						break;
				}
				}
			});
		
		frame.getContentPane().add(okButton);
		label = new JLabel("Name of the new Subject:");
		
		textField = new JTextField();
		textField.setBounds(40, 127, 300, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label.setFont(font);
		label.setBounds(40, 70, 300, 28);
		frame.getContentPane().add(label);
		
		labelInput = new JLabel();
		labelInput.setFont(font);
		labelInput.setForeground(Color.RED);
		labelInput.setBounds(40, 107, 300, 14);
		frame.getContentPane().add(labelInput);
	}
}