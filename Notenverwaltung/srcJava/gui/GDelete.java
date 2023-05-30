package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dataclasses.Components;
import logic.DeleteButton;
import logic.DeleteOk;


public class GDelete {
	
	private JButton okButton; 
	
	public GDelete(Components components, String cell) {
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
		frame.setLayout(null);
		frame.setVisible(true);
		okButton = new JButton("OK");
		okButton.setFont(new Font("Arial", Font.PLAIN, 11));
		okButton.setBounds(325, 235, 50, 20);
		okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					 if (DeleteOk.logic(components, cell)) {
						 frame.dispose();
					 }
				}
			});
		
		frame.add(okButton);

	
	}

}
