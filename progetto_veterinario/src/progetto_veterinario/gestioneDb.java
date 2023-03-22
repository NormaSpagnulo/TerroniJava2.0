package progetto_veterinario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
public class gestioneDb {
    Connection conn;
    
    public gestioneDb(Connection conn){
        this.conn=conn;

    }
    public void rendiAdmin(String username){
        try {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utente", ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_UPDATABLE);
        ResultSet resSet = stmt.executeQuery();
        while(resSet.next()){
        
        if(resSet.getString(1).equals(username)){
            resSet.updateBoolean(3,true);
            resSet.updateRow();
        }
        }
        }catch(Exception e){
        }
        
    }
    public void eliminaUtente(String username){
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utente", ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while(resSet.next()){
            
            if(resSet.getString(1).equals(username)){
                resSet.deleteRow();
            }
            }
            }catch(Exception e){
            }
    }
    public Utente login(String username, String password) {
    	
        try {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinario", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utente", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                if (username.equalsIgnoreCase(resSet.getString(1)) && (password.equals(resSet.getString(2)))) {
                    System.out.println(resSet.getBoolean(3));
                    Utente temp = new Utente(username, resSet.getBoolean(3));
                    System.out.println("login eseguito con successo");
                    return temp;
                }
            }
            return null;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
    public void stampaUtenti(){
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM utente;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                System.out.println("Nome:" + resSet.getString(1) + "   admin: " + resSet.getBoolean(3));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    public void stampaAnimaliUtente(String nome) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "Select nome,idAnimale from animale,utente Where animale.utente=utente.username && animale.utente=?;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, nome);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                System.out.println("Nome:" + resSet.getString(1) + "   ID: " + resSet.getInt(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stampaAnimali() {
        try {
            PreparedStatement stmt = conn.prepareStatement("Select * FROM animale;",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                System.out.println("Nome:" + resSet.getString(1) + "   ID: " + resSet.getInt(3)+"   razza:   "+resSet.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void annullaPrenotazione(int idPrenotazione) {
        try {
            PreparedStatement stmt = conn.prepareStatement("Select * from prenotazione",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                if (idPrenotazione == resSet.getInt(5)) {
                    resSet.deleteRow();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stampaPrenotazioneUtente(String nome) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "select prenotazione.idPrenotazione, animale.nome, prenotazione.dataPrenotazione from utente,prenotazione,animale where prenotazione.utente=utente.username &&utente.username=animale.utente AND utente.username = ?;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, nome);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                System.out.println("Numero Prenotazione:" + resSet.getInt(1) + "   Nome Animale: " + resSet.getString(2)
                        + "   dataPrenotazione: " + resSet.getDate(3));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminaAnimale(int idAnimale) {
        try {

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM prenotazione WHERE idAnimale = ? ;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, idAnimale);
            stmt.execute();
            stmt = conn.prepareStatement("SELECT * FROM animale", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                if (idAnimale == resSet.getInt(3)) {
                    resSet.deleteRow();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prenotazioniNonAccettati() {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "select prenotazione.utente , prenotazione.dataPrenotazione , animale.tipo , prenotazione.idPrenotazione FROM prenotazione,animale WHERE prenotazione.idAnimale=animale.idAnimale AND isAccepted=false;",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                System.out.println("Utente:" + resSet.getString(1) + "   Data Prenotazione: " + resSet.getDate(2)
                        + "   tipo animale: " + resSet.getString(3) + "  id Prenotazione" + resSet.getInt(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void accettaPrenotazione(int idPrenotazione) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prenotazione",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                if (idPrenotazione == resSet.getInt(5)) {
                    resSet.updateBoolean(6, true);
                    resSet.updateRow();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stampaPrenotazione() {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prenotazione ",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            while (resSet.next()) {
                System.out.println("Nome Utente Prenotazione:" + resSet.getString(1) + "   Data prenotazione: "+ resSet.getDate(2) + "   Accettata?: " + resSet.getBoolean(6)+"   numero prenotazione:   "+resSet.getInt(5));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void aggiungiAnimale(String name, String tipo, int annoNascita, String username) {

        boolean controllo = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM animale", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();
            resSet.afterLast();
            resSet.previous();
            int idAnimaleUltimo = resSet.getInt(3);
            resSet.moveToInsertRow();
            resSet.updateInt(3, idAnimaleUltimo + 1);
            resSet.updateString(1, name);
            resSet.updateString(2, tipo);

            resSet.updateInt(4, annoNascita);
            resSet.updateString(5, username);
            resSet.insertRow();
            resSet.moveToCurrentRow();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // metodo aggiunta utente all inteno database
    public void aggiungiUtente(String username, String password, String passwordAdmin) {

        boolean controllo = true, admin = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utente", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();

            while (resSet.next()) {
                if (username.equals(resSet.getString(1))) {
                    controllo = false;
                    break;
                }

            }
            if (passwordAdmin.equals("ciaoAdmin")) {
                admin = true;
            }
            if (controllo == true) {
                resSet.moveToInsertRow();
                resSet.updateString(1, username);
                resSet.updateString(2, password);
                resSet.updateBoolean(3, admin);
                resSet.insertRow();
                resSet.moveToCurrentRow();

            } else {
                System.out.println("Gia presente nel database");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void aggiungiPrenotazione(String username, String dataPrenotazione, int idAnimale, String diagnosiAnimale) {

        boolean controllo = true, admin = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prenotazione",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resSet = stmt.executeQuery();

            resSet.afterLast();
            resSet.previous();
            int idPrenotazione = resSet.getInt(5);
            resSet.moveToInsertRow();
            resSet.updateInt(5, idPrenotazione + 1);
            resSet.updateString(1, username);
            resSet.updateString(2, dataPrenotazione);
            resSet.updateInt(3, idAnimale);
            resSet.updateString(4, diagnosiAnimale);

            resSet.updateBoolean(6, false);
            resSet.insertRow();
            resSet.moveToCurrentRow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
