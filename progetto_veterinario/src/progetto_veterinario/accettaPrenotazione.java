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

public class accettaPrenotazione extends JFrame {

	private JPanel contentPane;
	private JTextField idPrenotazione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accettaPrenotazione frame = new accettaPrenotazione();
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
	public accettaPrenotazione() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JButton deleteButton = new JButton("Accetta");
		deleteButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Connessione conn=new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
		        conn.startConn();
		        gestioneDb myGestore = new gestioneDb(conn.getConnessione());
		        int id=Integer.parseInt(idPrenotazione.getText());
		        myGestore.accettaPrenotazione(id);
		        gestione.refreshTabellaPrenotazioni();
		
		    }
		});
		JButton indietroButton = new JButton("Home");
        indietroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
              if(gestione.loggato.getAdmin()) {
            	  gestione.setmenuAdminVisible();
              }else {
            	  gestione.setPrincipaleUserVisible();
              }
              gestione.setEliminaPrenotazioneNotVisible();
              gestione.setTabellaPrenotazioniNotVisible();
              gestione.setAccettaPrenotazioneNotVisible();
            }
        });
        indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        indietroButton.setBounds(147, 146, 128, 31);
        contentPane.add(indietroButton);
        
		contentPane.setLayout(null);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteButton.setBounds(147, 68, 128, 31);
		contentPane.add(deleteButton);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("idPrenotazione da accettare");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 21, 205, 36);
		contentPane.add(lblNewLabel);
		
		idPrenotazione = new JTextField();
		idPrenotazione.setBounds(204, 22, 220, 39);
		contentPane.add(idPrenotazione);
		idPrenotazione.setColumns(10);
	}
}