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
import logic.CreateStudent;
import logic.EnableDisable;

public class GCreateStudent {
	
	private JButton okButton; 
	private JLabel labelSt;
	private JLabel labelCl;
	private JTextField textFieldSt;
	private JTextField textFieldCl;
	private Font font = new Font("Arial", Font.PLAIN, 11);
	private JLabel labelInputSt;
	private JLabel labelInputCl;
	
	public GCreateStudent(Components components) {
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
					switch(CreateStudent.clickOk(textFieldSt.getText(), textFieldCl.getText())) {
						case 0:
							frame.dispose();
							break;
						case 1:
							labelInputSt.setText("This name isnt available in this class.");
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
		
		
		textFieldSt = new JTextField();
		textFieldSt.setBounds(40, 67, 300, 20);
		frame.getContentPane().add(textFieldSt);
		textFieldSt.setColumns(10);
		
		labelSt = new JLabel("Name of the new student:");
		labelSt.setFont(font);
		labelSt.setBounds(40, 10, 300, 28);
		frame.getContentPane().add(labelSt);
		
		labelInputSt = new JLabel();
		labelInputSt.setFont(font);
		labelInputSt.setForeground(Color.RED);
		labelInputSt.setBounds(40, 47, 300, 14);
		frame.getContentPane().add(labelInputSt);
		
		
		
		
		textFieldCl = new JTextField();
		textFieldCl.setBounds(40, 164, 300, 20);
		frame.getContentPane().add(textFieldCl);
		textFieldCl.setColumns(10);
		
		labelCl = new JLabel("Name of the students class:");
		labelCl.setFont(font);
		labelCl.setBounds(40, 107, 300, 28);
		frame.getContentPane().add(labelCl);
		
		labelInputCl = new JLabel();
		labelInputCl.setFont(font);
		labelInputCl.setForeground(Color.RED);
		labelInputCl.setBounds(40, 144, 300, 14);
		frame.getContentPane().add(labelInputCl);
	}
}