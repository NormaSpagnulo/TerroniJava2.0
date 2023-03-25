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
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class InserisciUtente extends JFrame {
	static Connessione conn=new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
	private JPanel contentPane;
	private JTextField fildUsername;
	private JTextField fildPassword;
	static gestioneDb myGestore;
	static login myLogin=new login();
	static userRegister frame2;
	private JTextField passAdmin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new userRegister();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InserisciUtente() {
		
		setTitle("Inserisci Utente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userLabel.setBounds(28, 56, 110, 34);
		contentPane.add(userLabel);
		
		final JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLabel.setBounds(28, 166, 110, 40);
		
		passAdmin = new JTextField();
		
		
		final JCheckBox admin = new JCheckBox("Hai una password Admin?");
		admin.setBounds(17, 259, 188, 23);
		contentPane.add(admin);
		admin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				passAdmin.setBounds(251, 253, 297, 34);
				contentPane.add(passAdmin);
				boolean attivaFild=admin.isSelected();
				passAdmin.setColumns(10);
				passAdmin.setEnabled(attivaFild);
				if(!attivaFild) {
					passAdmin.setText("");
				}
				
			}
		});
		fildUsername = new JTextField();
		fildUsername.setBounds(251, 59, 297, 34);
		contentPane.add(fildUsername);
		fildUsername.setColumns(10);
		
		fildPassword = new JTextField();
		fildPassword.setBounds(251, 165, 297, 34);
		contentPane.add(fildPassword);
		fildPassword.setColumns(10);
		
		JButton registrati = new JButton("Inserisci");
		registrati.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				conn.startConn();
				myGestore = new gestioneDb(conn.getConnessione());
				myGestore.aggiungiUtente(fildUsername.getText(),fildPassword.getText(),"");
				gestione.refreshTabellaUtenti();
				fildUsername.setText("");
				fildPassword.setText("");
				
			}
		});
		registrati.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registrati.setBounds(205, 339, 372, 57);
		contentPane.add(registrati);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(28, 162, 92, 34);
		contentPane.add(lblNewLabel);
		
		
	}
}
