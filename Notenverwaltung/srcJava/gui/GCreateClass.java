package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataclasses.Components;
import logic.DeleteOk;

public class GCreateClass {
	
	private JButton okButton; 
	private JLabel label;
	private JTextField textField;
	private Font font = new Font("Arial", Font.PLAIN, 11);
	
	public GCreateClass(Components components) {
		JFrame frame = new JFrame() {
			 @Override
	            public void dispose() {
				 	for(JButton button : components.getButtons()) {
				 		button.setEnabled(true);
				 	}
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
					System.out.println("Missing Action");
					 
				}
			});
		
		frame.getContentPane().add(okButton);
		
		textField = new JTextField();
		textField.setBounds(40, 147, 300, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}





/*package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GCreateClass {
	JTextField textField;
	
	public GCreateClass() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		JPanel contentPane = new JPanel();
		contentPane.setBounds(100, 100, 800, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		textField = new JTextField();
		textField.setBounds(600, 500, 100, 20);
		contentPane.add(textField);
	}
}*/

