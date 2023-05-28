package maskGen;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class test_Deleted_soon extends JFrame {

	private JPanel contentPane;
	private HashMap<String, JTextField> subjectView = new HashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test_Deleted_soon frame = new test_Deleted_soon();
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
	public test_Deleted_soon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		MaskGenerator mask = new MaskGenerator();
		mask.maskgen(true);
		setContentPane(mask.getContentPane());
		contentPane.setLayout(null);
		subjectView = mask.getSubjectView();
		subjectView.get("00").setText("NR");
		subjectView.get("10").setText("Grade");
		subjectView.get("20").setText("Weight");

		
	}

}
