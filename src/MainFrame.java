import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.TextField;
import java.awt.Button;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Component;



public class MainFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Attach1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chosser = new JFileChooser();
				chosser.showOpenDialog(null);
				File f1 =  chosser.getSelectedFile();
				String fileName1 = f1.getAbsolutePath();
				textField.setText(fileName1);
						
			}
		});
		btnNewButton.setBounds(323, 13, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAttach = new JButton("Attach2");
		btnAttach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chosser = new JFileChooser();
				chosser.showOpenDialog(null);
				File f2 =  chosser.getSelectedFile();
				String fileName2 = f2.getAbsolutePath();
				textField_1.setText(fileName2);
			}
		});
		btnAttach.setBounds(323, 51, 97, 25);
		frame.getContentPane().add(btnAttach);
		
		JButton btnAttach_1 = new JButton("Attach3");
		btnAttach_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chosser = new JFileChooser();
				chosser.showOpenDialog(null);
				File f3 =  chosser.getSelectedFile();
				String fileName3 = f3.getAbsolutePath();
				textField_2.setText(fileName3);
			}
		});
		btnAttach_1.setBounds(323, 89, 97, 25);
		frame.getContentPane().add(btnAttach_1);
		
		JButton btnAttach_2 = new JButton("Attach4");
		btnAttach_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chosser = new JFileChooser();
				chosser.showOpenDialog(null);
				File f4 =  chosser.getSelectedFile();
				String fileName4 = f4.getAbsolutePath();
				textField_3.setText(fileName4);
			}
		});
		btnAttach_2.setBounds(323, 127, 97, 25);
		frame.getContentPane().add(btnAttach_2);
		
		Button button_3 = new Button("Run");
		button_3.setBounds(345, 231, 75, 44);
		frame.getContentPane().add(button_3);
		
		textField = new JTextField();
		textField.setBounds(12, 14, 294, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 52, 294, 22);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 90, 294, 22);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(12, 128, 294, 22);
		frame.getContentPane().add(textField_3);
	}
}
