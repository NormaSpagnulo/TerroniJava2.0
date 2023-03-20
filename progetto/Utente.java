import java.util.ArrayList;

public class Utente {
    //dichiarate variabili
    private String username;
    private String password;
    private boolean admin = false;
    
    //creato il costruttore
    public Utente(String username, String password, String passAdmin) {
        if (passAdmin.equals("ciaoAdmin")) {
            admin = true;
        } else {
            admin = false;
        }
        this.username = username;
        this.password = password;
    }

    public Utente(String username, Boolean admin) {
        this.admin = admin;
        this.username = username;

    }

    public boolean getAdmin() {
        return admin;
    }

    public String getUsername() {
        return username;
    }
}
