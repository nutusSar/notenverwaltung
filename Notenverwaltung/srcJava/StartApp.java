import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataclasses.Components;
import logic.Open;
import maskGen.MaskGenerator;

public class StartApp extends JFrame{
	
	private JPanel contentPane;
	private static Components components;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(Open.open()) {		   
		   MaskGenerator mask = new MaskGenerator(true);
			components = mask.getComponents();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						StartApp frame = new StartApp(mask);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
	}
	public StartApp(MaskGenerator mask) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(100, 100, 800, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(components.getContentPane());
		contentPane.setLayout(null);
		setJMenuBar(components.getMenuBar());
		}

}
