package u1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


public class MyFirstJavaApplicationWindowWhichWillBeAwesome {

	private JFrame frame;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstJavaApplicationWindowWhichWillBeAwesome window = new MyFirstJavaApplicationWindowWhichWillBeAwesome();
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
	public MyFirstJavaApplicationWindowWhichWillBeAwesome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFeedback = new JLabel("Feedback");
		lblFeedback.setBounds(177, 6, 87, 23);
		lblFeedback.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		frame.getContentPane().add(lblFeedback);
		
		final JTextPane txtpnFeedback = new JTextPane();
		txtpnFeedback.setBounds(177, 98, 240, 80);
		frame.getContentPane().add(txtpnFeedback);
		
		txtName = new JTextField();
		txtName.setBounds(177, 58, 240, 28);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblYourName = new JLabel("Your name");
		lblYourName.setBounds(57, 64, 108, 16);
		frame.getContentPane().add(lblYourName);
		
		JLabel lblYourFeedback = new JLabel("Your Feedback");
		lblYourFeedback.setBounds(57, 98, 108, 16);
		frame.getContentPane().add(lblYourFeedback);
		
		final JComboBox cmbRating = new JComboBox();
		cmbRating.setModel(new DefaultComboBoxModel(new String[] {"Excellent", "Awesome", "Fantastic", "superfragilisticexpialadocious"}));
		cmbRating.setBounds(177, 190, 240, 27);
		frame.getContentPane().add(cmbRating);
		
		JLabel lblYourRating = new JLabel("Your rating");
		lblYourRating.setBounds(57, 194, 108, 16);
		frame.getContentPane().add(lblYourRating);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(300, 243, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JButton btnSendFeedback = new JButton("Send feedback");
		btnSendFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Name " + txtName.getText());
				System.out.println("Feedback " + txtpnFeedback.getText());
				System.out.println("Rating " + cmbRating.getSelectedItem().toString());
			}
		});
		btnSendFeedback.setBounds(177, 243, 117, 29);
		frame.getContentPane().add(btnSendFeedback);
	}
}
