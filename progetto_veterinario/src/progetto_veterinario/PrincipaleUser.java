package progetto_veterinario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PrincipaleUser extends JFrame {
	public JLabel userLabel = new JLabel(username);
	private JPanel contentPane;
	static String username;
	static login login;
	static PrincipaleUser frame;
	static GestioniPrenotazioniUser gPrenotazioni;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PrincipaleUser(username);
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
	public PrincipaleUser(final String username) {
		this.username=username;
		setTitle("Menu Utente");
		userLabel.setText(username);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestione Animali");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(40, 126, 280, 67);
		contentPane.add(btnNewButton);
		
		JButton gestionePrenotazioniUser = new JButton("Gestione prenotazioni");
		gestionePrenotazioniUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gPrenotazioni=new GestioniPrenotazioniUser(username);
			}
		});
		gestionePrenotazioniUser.setBounds(40, 48, 280, 67);
		contentPane.add(gestionePrenotazioniUser);
		
		JButton logOut = new JButton("Log-Out");
		logOut.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login=new login();
				login.show();
			}
		});
		logOut.setBounds(135, 413, 89, 23);
		contentPane.add(logOut);
		
		
		userLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 23));
		userLabel.setBounds(10, 372, 342, 30);
		contentPane.add(userLabel);
	}
}
