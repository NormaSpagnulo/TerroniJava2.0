package progetto_veterinario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class selezioneIdUtente extends JFrame {

	private JPanel contentPane;
	private JTextField usernameInserito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selezioneIdUtente frame = new selezioneIdUtente();
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
	public selezioneIdUtente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameInserito = new JTextField();
		usernameInserito.setBounds(218, 11, 146, 34);
		contentPane.add(usernameInserito);
		usernameInserito.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("inserisci name per eliminare");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 16, 212, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Elimina");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 Connessione conn=new Connessione("jdbc:mysql://localhost:3306/veterinario","root","root");
				 conn.startConn();
				 
				 gestioneDb myGestore =new gestioneDb(conn.getConnessione());
				 myGestore.eliminaUtente(usernameInserito.getText());
				 gestione.refreshTabellaUtenti();
				 usernameInserito.setText("");
				 
			}
		});
		btnNewButton.setBounds(93, 56, 155, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestione.setSelezioneNomeNotVisible();
				gestione.setTabellaUtentiNotVisible();
				gestione.setmenuAdminVisible();
				gestione.setInserisciUtenteNotVisible();
			}
		});
		btnHome.setBounds(93, 100, 155, 23);
		contentPane.add(btnHome);
	}
}
