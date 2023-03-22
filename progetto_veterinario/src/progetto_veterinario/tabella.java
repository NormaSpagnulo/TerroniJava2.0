package progetto_veterinario;
public class tabella{
	Vector<String> row = new Vector<String>();
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
                DatabaseTable frame = new DatabaseTable();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
}
