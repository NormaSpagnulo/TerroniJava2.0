package progetto_veterinario;
import java.sql.Connection;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {
	Connessione conn=new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
	public gestioneDb myGestore;
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	public PrincipaleUser menuUtente;
	static login frame;
	public userRegister registrazione;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new login();
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
	public login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 105, 163, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 208, 146, 33);
		contentPane.add(lblNewLabel_1);
		
		textUsername = new JTextField();
		textUsername.setBounds(199, 105, 264, 29);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Bookshelf Symbol 7", Font.BOLD, 11));
		textPassword.setColumns(10);
		textPassword.setBounds(199, 217, 264, 29);
		contentPane.add(textPassword);
		
		final JLabel labelAccesso = new JLabel("Accesso:");
		labelAccesso.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelAccesso.setBounds(26, 291, 323, 44);
		contentPane.add(labelAccesso);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.startConn();
				myGestore=new gestioneDb(conn.getConnessione());
				String userInserito = textUsername.getText();
				String passInserita = textPassword.getText();			
				Utente myLoggato=myGestore.login(userInserito,passInserita);
				textPassword.setText("");
				textUsername.setText("");
				gestione.setLoggato(myLoggato);
				if(myLoggato!=null) {
					if(myLoggato.getAdmin()) {
						gestione.setmenuAdminVisible();
					}else {
						gestione.setPrincipaleUserVisible();
					}
					gestione.setLoginNotVisible();
					
				}else {
					labelAccesso.setText("ACCESSO NEGATO");
				}
				
			}
		});
		btnNewButton.setBounds(199, 337, 209, 50);
		contentPane.add(btnNewButton);
		
		JButton userReg = new JButton("Registrati");
		userReg.setBounds(262, 421, 91, 29);
		contentPane.add(userReg);
		userReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestione.setRegisterVisible();
				gestione.setLoginNotVisible();
			}
		});
		
	}
}