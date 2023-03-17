import java.util.Scanner;
import java.sql.Connection;

public class mainProve {
    public static void main(String[] args) {
        boolean uscita = false;
        Connessione myConnessione = new Connessione("jdbc:mysql://localhost:3306/veterinario", "root", "root");
        myConnessione.startConn();
        String username;
        Utente loggato = null;
        do {
            if (loggato == null) {
                switch (scanInt("Inserisci \n1:Iscriverti \n2:login")) {
                    case 1:
                        if (scanInt("Vuoi iscriverti come admin? 1:si 0:no") == 1) {
                            username = scanString("Inserisci username");
                            myConnessione.aggiungiUtente(username, scanString("Inserisici password"),
                                    scanString("Inserisici password admin"));
                        } else {
                            username = scanString("Inserisci username");
                            myConnessione.aggiungiUtente(username, scanString("Inserisici password"), " ");
                        }
                        if (scanInt("Vuoi inserire animali? 1:si 0:no") == 1) {
                            myConnessione.aggiungiAnimale(scanString("Inserisci nome animale"),
                                    scanString("Inserisci razza"), scanInt("Inserisci anno di nascita"), username);
                        }
                        break;

                    case 2:
                        loggato = myConnessione.login(scanString("Inserisci nome utente"),
                                scanString("Inserisci password"));

                        break;
                    case 3:
                        uscita = true;
                        break;
                    default:
                        System.out.println("Inserimento errato");
                }
            }else if (loggato != null) {
                if (loggato.getAdmin()) {
                    switch(scanInt("Inserisci \n1:Gestione prenotazioni\n2:Gestione animali\n3:gestione Utenti\n4:exit")){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            loggato=null;
                            break;
                    }
                }else{
                    switch(scanInt("Inserisci \n1:Aggiungi animale\n2:Aggiungi prenotazione\n3:annulla prenotazione\n4:elimina animale\n5:exit")){
                        case 1:
                            myConnessione.aggiungiAnimale(scanString("Inserisci nome"), scanString("Inserisci razza"), scanInt("Inserisci anno di nascita"),loggato.getUsername() );
                            break;
                        case 2:
                           myConnessione.stampaAnimali(loggato.getUsername());
                           myConnessione.aggiungiPrenotazione(loggato.getUsername(),scanString("Inserisci data AAAA-MM-GG"),scanInt("Inserisci id animale"),scanString("Inserisci una descrizione della problematic del animale"));
                           break;
                        case 3:
                            myConnessione.stampaPrenotazione(loggato.getUsername());
                            
                            break;
                        case 4:
                        case 5:
                            loggato=null;
                            break;
                    }
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
