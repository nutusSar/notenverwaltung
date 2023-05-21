package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;


public class Anmeldemaske extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anmeldemaske frame = new Anmeldemaske();
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
	public Anmeldemaske() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Benutzer:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(350, 250, 100, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Arial", Font.BOLD, 11));
		lblPasswort.setBounds(350, 290, 100, 20);
		contentPane.add(lblPasswort);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 11));
		passwordField.setBounds(450, 290, 100, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setBounds(450, 250, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(400, 330, 100, 20);
		contentPane.add(btnNewButton);
	}
	
}
