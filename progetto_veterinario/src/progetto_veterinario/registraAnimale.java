package progetto_veterinario;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class registraAnimale extends JFrame {

    Connessione conn = new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
    public gestioneDb myGestore;
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textTipo;
    private JTextField textId;
    private JTextField textAnno;
    public PrincipaleUser menuUtente;
    static registraAnimale frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new registraAnimale();
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
    public registraAnimale() {
        setTitle("Registrazione");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nomeAnim = new JLabel("nome");
        nomeAnim.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nomeAnim.setBounds(26, 66, 163, 33);
        contentPane.add(nomeAnim);

        JLabel tipoAnim = new JLabel("tipo");
        tipoAnim.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tipoAnim.setBounds(26, 109, 146, 33);
        contentPane.add(tipoAnim);

        JLabel utenteA = new JLabel("Utente");
        utenteA.setFont(new Font("Tahoma", Font.PLAIN, 18));
        utenteA.setBounds(26, 152, 146, 33);
        contentPane.add(utenteA);

        JLabel annoNasci = new JLabel("annoNascita");
        annoNasci.setFont(new Font("Tahoma", Font.PLAIN, 18));
        annoNasci.setBounds(26, 195, 146, 33);
        contentPane.add(annoNasci);

        textName = new JTextField();
        textName.setBounds(199, 70, 264, 29);
        contentPane.add(textName);
        textName.setColumns(10);

        textTipo = new JTextField();
        textTipo.setBounds(199, 113, 264, 29);
        contentPane.add(textTipo);

        textId = new JTextField();
        textId.setColumns(10);
        textId.setBounds(199, 156, 264, 29);
        contentPane.add(textId);

        textAnno = new JTextField();
        textAnno.setColumns(10);
        textAnno.setBounds(199, 199, 264, 29);
        contentPane.add(textAnno);

        JButton registraButton = new JButton("REGISTRA");
        registraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String nomeAnim = textName.getText();
                String tipoAnim = textTipo.getText();
                int idAnno=Integer.parseInt(textAnno.getText());
                conn.startConn();
                myGestore = new gestioneDb(conn.getConnessione());
                myGestore.aggiungiAnimale(nomeAnim, tipoAnim, idAnno,textId.getText());
                gestione.refreshTabellaAnimale();
                
                
            }
        });
        registraButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        registraButton.setBounds(150, 288, 250, 60);
        contentPane.add(registraButton);

        JButton indietroButton = new JButton("TORNA AL MENU' HOME");
        indietroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
              if(gestione.loggato.getAdmin()) {
            	  gestione.setmenuAdminVisible();
              }else {
            	  gestione.setPrincipaleUserVisible();
              }
              gestione.setEliminaAnimaliNotVisible();
              gestione.setTabellaAnimaliNotVisible();
              gestione.setTabellaUtentiNotVisible();
              gestione.setAggiungiAnimaliNotVisible();
            }
        });
        indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        indietroButton.setBounds(150, 363, 250, 60);
        contentPane.add(indietroButton);
    }
}