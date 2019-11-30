 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextArea;

public class ChatroomGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatroomGUI frame = new ChatroomGUI();
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
	public ChatroomGUI() {
		setTitle("Chatroom Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2125);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		splitPane.setLeftComponent(btnNewButton);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.2);
		
		JButton btnNewButton_1 = new JButton("Leave Chatroom");
		
		JLabel lblSignedInAs = new JLabel("Signed in as : ");
		
		JLabel lblNewLabel_1 = new JLabel("Test Name");
		
		JButton btnArchiveChat = new JButton("Archive Chat");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSignedInAs)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addGap(409)
							.addComponent(btnArchiveChat, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(splitPane_1, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
						.addComponent(splitPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSignedInAs)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(btnArchiveChat))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_2);
		
		JTextPane txtpnTest_1 = new JTextPane();
		txtpnTest_1.setText("test");
		scrollPane_2.setViewportView(txtpnTest_1);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setRightComponent(scrollPane);
		
		JTextPane txtpnTest = new JTextPane();
		txtpnTest.setText("Current Conversation\r\n");
		scrollPane.setViewportView(txtpnTest);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JLabel lblNewLabel = new JLabel("Current Users");
		splitPane_2.setLeftComponent(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_2.setRightComponent(scrollPane_1);
		
		JTextArea txtrTest = new JTextArea();
		txtrTest.setText("test");
		scrollPane_1.setViewportView(txtrTest);
		contentPane.setLayout(gl_contentPane);
	}
}
