package progetto_veterinario;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AnimaliPerUtente extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public AnimaliPerUtente() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setTitle("Animali");

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Connessione al database
        String url = "jdbc:mysql://localhost:3306/veterinario";
        String username = "root";
        String password = "root";
        try {
        	Connessione conn=new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
        	conn.startConn();
        	PreparedStatement stmt = conn.getConnessione().prepareStatement(
        			"select nome,tipo,idAnimale,annoNascita from utente,animale where padrone=username AND padrone= ? ;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        	String nome;
        	if(gestione.loggato!=null) {
        		nome=gestione.getLoggato().getUsername();
        	}else {
        		nome="";
        	}
            stmt.setString(1, nome);
            // Creazione della tabella
            ResultSet rs =stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            Vector< String > columnNames = new Vector< String >();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(rsmd.getColumnName(i));
            }
            
Vector< Vector <String>> data = new Vector<Vector<String>>();
            while (rs.next()) {
                Vector < String > row = new Vector< String >();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            table = new JTable(data, columnNames);

            // Aggiunta della tabella alla finestra
            JScrollPane scrollPane = new JScrollPane(table);
            contentPane.add(scrollPane, BorderLayout.CENTER);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	AnimaliPerUtente frame = new AnimaliPerUtente();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}