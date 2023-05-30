package maskGen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dataclasses.Components;
import logic.CreateClass;
import logic.DeleteButton;
import logic.EditButton;

public class MaskGenerator {
	private Components components;
	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private HashMap<String, JTextField> visibleTextfields = new HashMap<>();
	private HashMap<String, JButton> rowButtons = new HashMap<>();
	private HashMap<String, JTextField> hiddenTextfields = new HashMap<>();
	private JButton[] pageButtons = new JButton[3];
	private JMenuBar menuBar;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public Components getComponents() {
		return components;
	}
	public void setComponents(Components components) {
		this.components = components;
	}


	public MaskGenerator(boolean pageButtons) { 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//Style Settings
		Font font = new Font("Arial", Font.PLAIN, 11);
		int startposx = 225, startposy = 100;
		//Alingmants
		int n = 1, q = 0;
		//Adding visible Textfield
		for (int x = 0; x < 3; x++) {
			for(int y = 0; y < 13; y++) {
				textField = new JTextField();
				textField.setFont(font);
		        textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setEditable(false);
				textField.setBounds(startposx + 25*x*n - q, startposy + 25*y, 25*n, 25);
				contentPane.add(textField);
				textField.setColumns(10);
				visibleTextfields.put(String.valueOf(x) + String.valueOf(y), textField);
				}
				n = 5;
				q = 100;
			}
		String text = "Del";
		for (int x = 3; x < 5; x++) {
			textField = new JTextField(text);
			textField.setFont(font);
	        textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setEditable(false);
			textField.setBounds(startposx + 25*x*n - q, startposy, 25, 25);
			contentPane.add(textField);
			textField.setColumns(10);
			visibleTextfields.put(String.valueOf(x) + "0", textField);
			q += 100;
			text = "Edi";
		}
		
		
		
		//Adding invisible Textfields
		for(int y = 0; y < 13; y++) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(0, 0, 125, 25);
			textField.setColumns(10);
			hiddenTextfields.put("1" + String.valueOf(y), textField);
		}
		
		//Adding Buttons
		Icon icon = new ImageIcon("Icons/icons8-trash-24.png");
		for(int x = 0; x < 2; x++) {
			for(int y = 0; y < 12; y++) {
				final int index = y;
				final String yKey = String.valueOf(y + 1);
				button = new JButton(icon);
				button.setBounds(startposx + 275 + 25*x, startposy + 25 + 25*y, 25, 25);
				if (x == 0) {
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							DeleteButton.logic("1" + yKey, components);
						}
					});
				}
				else {
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							EditButton.logic("1" + yKey, components);
						}
					});
				}
				contentPane.add(button);
				rowButtons.put(String.valueOf(x) + String.valueOf(y), button);
				buttons.add(button);
			}
			icon = new ImageIcon("Icons/icons8-edit-24.png");
		}
		
		//Adding PageButtons
		
			button = new JButton(new ImageIcon("Icons/icons8-previous-page-page-24.png"));
			button.setBounds(500, 450, 25, 25);
			button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	            }
	        });
			button.setVisible(pageButtons);
			contentPane.add(button);
			this.pageButtons[0] = button;
			buttons.add(button);
			
			button = new JButton(new ImageIcon("Icons/icons8-next-page-24.png"));
			button.setBounds(525, 450, 25, 25);
			button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                //Return
	            	
	            }
	        });
			button.setVisible(pageButtons);
			contentPane.add(button);
			this.pageButtons[1] = button;
			buttons.add(button);

		
		//Adding a MenuBar
		JMenuBar menuBar = new JMenuBar();
		// Create some menus and menu items
		JMenu fileMenu = new JMenu("File");
	    JMenuItem newMenuItem = new JMenuItem("New");
	    JMenuItem openMenuItem = new JMenuItem("Open");
	    JMenuItem saveMenuItem = new JMenuItem("Save");
	    fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        
        menuBar.add(fileMenu);

	    JMenu create = new JMenu("Create");
	    JMenuItem ClassMenuItem = new JMenuItem("Class");
	    JMenuItem StudentMenuItem = new JMenuItem("Student");
	    JMenuItem SubjectMenuItem = new JMenuItem("Subject");
	    ClassMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateClass.logic(components);
			}
		});
        create.add(ClassMenuItem);
        create.add(StudentMenuItem);
        create.add(SubjectMenuItem);
	    
        menuBar.add(create);
        
        //Putting all information into a DTO
		components = new Components(contentPane, visibleTextfields, rowButtons, hiddenTextfields, this.pageButtons, buttons, menuBar);
	
	}

}
