package progetto_veterinario;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class tabellaPrenotazione extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public tabellaPrenotazione() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setTitle("Prenotazioni");

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Connessione al database
        String url = "jdbc:mysql://localhost:3306/veterinario";
        String username = "root";
        String password = "root";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prenotazione"); // corrected SQL query

            // Creazione della tabella
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

            conn.close(); // Chiusura della connessione al database
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                tabellaAnimali frame = new tabellaAnimali();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
