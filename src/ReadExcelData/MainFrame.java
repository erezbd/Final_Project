package ReadExcelData;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Button;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JPanel;



public class MainFrame {

	private JFrame frame;
	private JTextField parsing;
	private JTextField academic;
	private JTextField courseCodeChanges;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_6;
	private JPanel panel_7;
	String parsingPath , academicPath , codePath;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {

	//	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	//	}
	//	});
	//}

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
				parsing.setText(fileName1);
				parsingPath = fileName1;
						
			}
		});
		btnNewButton.setBounds(323, 13, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		panel_7 = new JPanel();
		panel_7.setBounds(323, 51, 97, 25);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnAttach = new JButton("Attach2");
		btnAttach.setBounds(0, 0, 97, 25);
		panel_7.add(btnAttach);
		btnAttach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chosser = new JFileChooser();
				chosser.showOpenDialog(null);
				File f2 =  chosser.getSelectedFile();
				String fileName2 = f2.getAbsolutePath();
				academic.setText(fileName2);
				academicPath = fileName2;
			}
		});
		
		panel_6 = new JPanel();
		panel_6.setBounds(323, 89, 97, 25);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnAttach_1 = new JButton("Attach3");
		btnAttach_1.setBounds(0, 0, 97, 25);
		panel_6.add(btnAttach_1);
		btnAttach_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chosser = new JFileChooser();
				chosser.showOpenDialog(null);
				File f3 =  chosser.getSelectedFile();
				String fileName3 = f3.getAbsolutePath();
				courseCodeChanges.setText(fileName3);
				codePath = fileName3;
			}
		});
		
		panel_4 = new JPanel();
		panel_4.setBounds(345, 231, 75, 44);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		Button button_3 = new Button("Run");
		button_3.setBounds(0, 0, 75, 44);
		panel_4.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Do you like to run the progrem?");
				readFromFile read = new readFromFile();
				read.parsingFileRead(parsingPath);
				read.academic(academicPath);
				read.chack();
				read.unionKorss(codePath);
				read.unionCodeCheck();
				read.color();
				JOptionPane.showMessageDialog(frame, "success!");
				

			}
		});
		panel = new JPanel();
		panel.setBounds(12, 14, 294, 22);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		parsing = new JTextField();
		parsing.setBounds(0, 0, 294, 22);
		panel.add(parsing);
		parsing.setText("\u05D4\u05DB\u05E0\u05E1 \u05E7\u05D5\u05D1\u05E5 \u05E8\u05D9\u05DB\u05D5\u05D6 \u05D1\u05E7\u05E9\u05D5\u05EA \u05D7\u05E8\u05D9\u05D2\u05D5\u05EA \u05DC\u05E7\u05D5\u05E8\u05E1\u05D9\u05DD ");
		parsing.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBounds(12, 52, 294, 22);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		academic = new JTextField();
		academic.setBounds(0, 0, 294, 22);
		panel_1.add(academic);
		academic.setText("\u05D4\u05DB\u05E0\u05E1 \u05E7\u05D5\u05D1\u05E5 \u05D0\u05D7\u05E8\u05D0\u05D9\u05D9\u05DD \u05D0\u05E7\u05D3\u05DE\u05D9\u05D9\u05DD");
		academic.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBounds(12, 90, 294, 22);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		courseCodeChanges = new JTextField();
		courseCodeChanges.setBounds(0, 0, 294, 22);
		panel_2.add(courseCodeChanges);
		courseCodeChanges.setText("\u05D4\u05DB\u05E0\u05E1 \u05E7\u05D5\u05D1\u05E5 \u05E8\u05D9\u05DB\u05D5\u05D6 \u05E9\u05D9\u05E0\u05D5\u05D9\u05D9 \u05E7\u05D5\u05D3 \u05E7\u05D5\u05E8\u05E1\u05D9\u05DD");
		courseCodeChanges.setColumns(10);
	}
	
	public JTextField getParsing() {
		return parsing;
	}

	public void setParsing(JTextField parsing) {
		this.parsing = parsing;
	}

	public JTextField getAcademic() {
		return academic;
	}

	public void setAcademic(JTextField academic) {
		this.academic = academic;
	}

	public JTextField getCourseCodeChanges() {
		return courseCodeChanges;
	}

	public void setCourseCodeChanges(JTextField courseCodeChanges) {
		this.courseCodeChanges = courseCodeChanges;
	}



	
}
