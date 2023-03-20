import java.util.Scanner;
import java.sql.Connection;

public class mainProve {
    public static void main(String[] args) {
        boolean uscita = false;
        Connessione myConnessione = new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
        myConnessione.startConn();
        String username;
        Utente loggato = null;
        int temp;
        gestioneDb myGestiore = new gestioneDb(myConnessione.getConnessione());
        do {
            if (loggato == null) {
                switch (scanInt("Inserisci \n1:Iscriverti \n2:login")) {
                    case 1:
                        if (scanInt("Vuoi iscriverti come admin? 1:si 0:no") == 1) {
                            username = scanString("Inserisci username");
                            myGestiore.aggiungiUtente(username, scanString("Inserisici password"),
                                    scanString("Inserisici password admin"));
                        } else {
                            username = scanString("Inserisci username");
                            myGestiore.aggiungiUtente(username, scanString("Inserisici password"), " ");
                        }
                        if (scanInt("Vuoi inserire animali? 1:si 0:no") == 1) {
                            myGestiore.aggiungiAnimale(scanString("Inserisci nome animale"),
                                    scanString("Inserisci razza"), scanInt("Inserisci anno di nascita"), username);
                        }
                        break;

                    case 2:
                        loggato = myGestiore.login(scanString("Inserisci nome utente"),
                                scanString("Inserisci password"));

                        break;
                    case 3:
                        uscita = true;
                        break;
                    default:
                        System.out.println("Inserimento errato");
                }
            } else if (loggato != null) {
                System.out.println(loggato.getAdmin());
                if (loggato.getAdmin() == true) {
                    loggato=menu.menuAdmin(myGestiore, loggato);
                } else {
                    loggato=menu.menuUtente(myGestiore, loggato);
                }
            }

        } while (uscita != true);
    }

    static int scanInt(String testo) {
        try {
            Scanner myScan = new Scanner(System.in);
            System.out.println(testo);
            return myScan.nextInt();
        } catch (Exception e) {
            System.out.println("qualcosa è andato storto");
            return 4000;
        }

    }

    static String scanString(String testo) {
        try {
            Scanner myScan = new Scanner(System.in);
            System.out.println(testo);
            return myScan.nextLine();
        } catch (Exception e) {
            System.out.println("qualcosa è andato storto");
            return null;
        }

    }
}
