package progetto_veterinario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userRegister frame = new userRegister();
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
	public userRegister() {
		setTitle("Registrazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userLabel.setBounds(28, 56, 110, 34);
		contentPane.add(userLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLabel.setBounds(28, 166, 110, 40);
		contentPane.add(passwordLabel);
		
		JCheckBox aggiungiAnimali = new JCheckBox("Vuoi inserire subito animali?");
		aggiungiAnimali.setBounds(17, 259, 188, 23);
		contentPane.add(aggiungiAnimali);
		
		textField = new JTextField();
		textField.setBounds(188, 56, 297, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 165, 297, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton registrati = new JButton("Registrati");
		registrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		registrati.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registrati.setBounds(205, 339, 372, 57);
		contentPane.add(registrati);
	}
}
