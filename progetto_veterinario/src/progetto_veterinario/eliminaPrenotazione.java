package progetto_veterinario;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class eliminaPrenotazione extends JFrame {

	private JPanel contentPane;
	private JTextField idPrenotazione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eliminaPrenotazione frame = new eliminaPrenotazione();
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
	public eliminaPrenotazione() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JButton deleteButton = new JButton("Elimina");
		deleteButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Connessione conn=new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
		        conn.startConn();
		        gestioneDb myGestore = new gestioneDb(conn.getConnessione());
		        int id=Integer.parseInt(idPrenotazione.getText());
		        myGestore.annullaPrenotazione(id);
		        gestione.refreshTabellaPrenotazioni();
		
		    }
		});
		contentPane.setLayout(null);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteButton.setBounds(142, 95, 128, 31);
		contentPane.add(deleteButton);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("idPrenotazione da eliminare");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 21, 205, 36);
		contentPane.add(lblNewLabel);
		
		idPrenotazione = new JTextField();
		idPrenotazione.setBounds(204, 22, 220, 39);
		contentPane.add(idPrenotazione);
		idPrenotazione.setColumns(10);
	}
}

