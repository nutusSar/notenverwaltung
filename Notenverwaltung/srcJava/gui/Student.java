package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private ArrayList<JTextField> subjectView = new ArrayList<>();
	private ArrayList<JButton> subjectButtons = new ArrayList<>();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Adding Textfields
		int n = 1, q = 0, startpos = 100;
		String fields[] = {"NR", "Subject", "Average", "Del", "Edi"};
		String text;
		for(int x = 0; x < 3; x++) {
			text = fields[x];
			for(int y = 0; y < 13; y++) {
			textField = new JTextField(text);
			textField.setEditable(false);
			textField.setBounds(startpos + 25*x*n - q, startpos + 25*y, 25*n, 25);
			contentPane.add(textField);
			textField.setColumns(10);
			subjectView.add(textField);
			text="";
			}
			n = 5;
			q = 100;
		}
		for (int i = 3; i < 5; i++) {
			textField = new JTextField(fields[i]);
			textField.setEditable(false);
			textField.setBounds(startpos + 25*i*n - q, startpos, 25, 25);
			contentPane.add(textField);
			textField.setColumns(10);
			subjectView.add(textField);
			q += 100;
		}
		
		//Adding Buttons
		Icon icon = new ImageIcon("Icons/icons8-trash-24.png");
		for(int x = 0; x < 2; x++) {
			for(int y = 0; y < 12; y++) {
				button = new JButton(icon);
				button.setBounds(startpos + 275 + 25*x, startpos + 25 + 25*y, 25, 25);
				contentPane.add(button);
				subjectButtons.add(button);
			}
			icon = new ImageIcon("Icons/icons8-edit-24.png");
		}
		
	}
}
