package progetto_veterinario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipaleAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipaleAdmin frame = new PrincipaleAdmin();
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
	public PrincipaleAdmin() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton prenota = new JButton("gestione Prenotazione");
		prenota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		prenota.setBounds(61, 55, 265, 66);
		contentPane.add(prenota);
		
		JButton viewUtentiAdmin = new JButton("gestione Utenti");
		viewUtentiAdmin.setBounds(61, 199, 265, 66);
		contentPane.add(viewUtentiAdmin);
		
		JButton viewAnimali = new JButton("gestione Animali");
		viewAnimali.setBounds(61, 332, 265, 66);
		contentPane.add(viewAnimali);
	}

}
