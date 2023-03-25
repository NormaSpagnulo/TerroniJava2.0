package progetto_veterinario;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class aggiungiPrenotazione extends JFrame {

    Connessione conn = new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
    public gestioneDb myGestore;
    private JPanel contentPane;
    private JTextField textIdAnimale;
    private JTextField textGiorno;
    public PrincipaleUser menuUtente;
    static aggiungiPrenotazione frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new aggiungiPrenotazione();
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
    public aggiungiPrenotazione() {
        setTitle("Prenotazione");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 374);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel idAnimaleLabel = new JLabel("ID Animale");
        idAnimaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        idAnimaleLabel.setBounds(26, 66, 163, 33);
        contentPane.add(idAnimaleLabel);

        JLabel giornoLabel = new JLabel("Giorno (AAAA-MM-GG)");
        giornoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        giornoLabel.setBounds(26, 109, 216, 33);
        contentPane.add(giornoLabel);
        
        JLabel motivoLabel = new JLabel("Motivo Visita");
        motivoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        motivoLabel.setBounds(26, 152, 163, 33);
        contentPane.add(motivoLabel);


        textIdAnimale = new JTextField();
        textIdAnimale.setBounds(199, 66, 235, 33);
        contentPane.add(textIdAnimale);
        textIdAnimale.setColumns(10);

        textGiorno = new JTextField();
        textGiorno.setColumns(10);
        textGiorno.setBounds(252, 109, 182, 33);
        contentPane.add(textGiorno);

        JTextField textMotivo = new JTextField();
        textMotivo.setColumns(10);
        textMotivo.setBounds(199, 152, 235, 33);
        contentPane.add(textMotivo);
        
        JButton btnPrenota = new JButton("Prenota");
        btnPrenota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	conn.startConn();
            	myGestore = new gestioneDb(conn.getConnessione());
                
                int idAnimale = Integer.parseInt(textIdAnimale.getText());
                String giorno = textGiorno.getText();
                String motivo=  textMotivo.getText();
                myGestore.aggiungiPrenotazione(gestione.loggato.getUsername(),giorno,idAnimale, motivo);
                gestione.refreshTabellaPrenotazioniUtente();
            }
        });
        JButton indietroButton = new JButton("HOME");
        indietroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
              if(gestione.loggato.getAdmin()) {
            	  gestione.setmenuAdminVisible();
              }else {
            	  gestione.setPrincipaleUserVisible();
              }
              gestione.setAggiungiPrenotazioniNotVisible();
              gestione.setPrenotazioneUtenteNotVisible();
            }
        });
        indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        indietroButton.setBounds(209, 259, 135, 33);
        contentPane.add(indietroButton);
        btnPrenota.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnPrenota.setBounds(209, 196, 135, 33);
        contentPane.add(btnPrenota);
    }
}
