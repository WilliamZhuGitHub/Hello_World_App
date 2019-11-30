import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HomePageGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageGUI frame = new HomePageGUI();
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
	public HomePageGUI() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		splitPane.setBounds(5, 5, 704, 385);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(350, 5, 1, 1);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWelcomeToHelloworld = new JLabel("Welcome To HelloWorld Chat Application", SwingConstants.CENTER);
		lblWelcomeToHelloworld.setBounds(10, 11, 253, 14);
		panel.add(lblWelcomeToHelloworld);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(253, 11, 123, 14);
		panel.add(lblNewLabel_1);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		splitPane_1.setLeftComponent(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(366, 75, 243, 39);
		panel_1.add(panel_3);
		
		JLabel label = new JLabel("Start a Chatroom", SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(0, 0, 243, 37);
		panel_3.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 54, 274, 271);
		panel_1.add(scrollPane);
		
		JTextArea txtrText = new JTextArea();
		txtrText.setText("text \r\ntext\r\ntext\r\n");
		scrollPane.setViewportView(txtrText);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(33, 20, 274, 23);
		panel_1.add(panel_4);
		
		JLabel label_1 = new JLabel("Current Chatrooms", SwingConstants.CENTER);
		label_1.setBounds(0, 0, 275, 23);
		panel_4.add(label_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setForeground(Color.WHITE);
		panel_5.setBackground(Color.WHITE);
		splitPane_1.setRightComponent(panel_5);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setText("Enter a name...");
		textField_1.setColumns(10);
		textField_1.setBounds(60, 199, 237, 23);
		panel_5.add(textField_1);
		
		JButton btnNewButton = new JButton("Start a room");
		btnNewButton.setBounds(73, 82, 207, 57);
		panel_5.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Get Random User");
		btnNewButton_1.setBounds(88, 304, 186, 23);
		panel_5.add(btnNewButton_1);
	}
}
