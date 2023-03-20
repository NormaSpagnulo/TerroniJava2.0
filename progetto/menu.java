import java.util.Scanner;

public class menu {
    static Utente menuAdmin(gestioneDb myGestiore, Utente loggato) {
        int temp;
        boolean uscita = false;
        do {
            switch (scanInt(
                    "Inserisci \n1:Gestione prenotazioni\n2:Gestione animali\n3:gestione Utenti\n4:exit")) {
                case 1:
                    temp = scanInt("Inserisci 1:accetta prenotazioni 2:elimina prenotazioni");
                    if (temp == 1) {
                        myGestiore.prenotazioniNonAccettati();
                        myGestiore.accettaPrenotazione(scanInt("inserisci id prenotaizone"));
                    } else if (temp == 0) {
                        myGestiore.stampaPrenotazione();
                        myGestiore.annullaPrenotazione(scanInt("Inserisci numero prenotazione da eliminare"));
                    }
                    break;
                case 2:
                    temp = scanInt("Inserisci 1:inserisci animale 2:elimina animale");
                    if (temp == 1) {
                        myGestiore.aggiungiAnimale(scanString("inserisci nome animale"),
                                scanString("inserisci razza"), scanInt("inserisci anno di nascita"),
                                scanString("Inserisci username utente"));
                    } else if (temp == 2) {
                        myGestiore.stampaAnimali();
                        myGestiore.eliminaAnimale(scanInt("Inserisci id animale"));
                    }
                    break;
                case 3:
                    temp = scanInt("Inserisci 1:rendi utente admin 2:elimina utente");
                    if (temp == 1) {
                        myGestiore.rendiAdmin(scanString("Inserisci username"));

                    } else if (temp == 2) {
                        myGestiore.stampaUtenti();
                        myGestiore.eliminaUtente(scanString("Inserisci username"));
                    }
                case 4:
                    return null;

            }
        } while (uscita != true);
        return null;
    }

    static Utente menuUtente(gestioneDb myGestiore,Utente loggato) {
        switch (scanInt(
                "Inserisci \n1:Aggiungi animale\n2:Aggiungi prenotazione\n3:annulla prenotazione\n4:elimina animale\n5:exit")) {
            case 1:
                myGestiore.aggiungiAnimale(scanString("Inserisci nome"), scanString("Inserisci razza"),
                        scanInt("Inserisci anno di nascita"), loggato.getUsername());
                break;
            case 2:
                myGestiore.stampaAnimaliUtente(loggato.getUsername());
                myGestiore.aggiungiPrenotazione(loggato.getUsername(),
                        scanString("Inserisci data AAAA-MM-GG"), scanInt("Inserisci id animale"),
                        scanString("Inserisci una descrizione della problematic del animale"));
                break;
            case 3:
                myGestiore.stampaPrenotazioneUtente(loggato.getUsername());
                myGestiore.annullaPrenotazione(scanInt("Inserisci il numero prenotazione da eliminare"));
                break;
            case 4:
                myGestiore.stampaAnimaliUtente(loggato.getUsername());
                myGestiore.eliminaAnimale(scanInt("inserisci condice animale"));
                break;
            case 5:
                return null;
        }
        return null;
    }
    static Utente menuIniziale(gestioneDb myGestiore,Utente loggato){
        String username;
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
                case 2:
                    loggato = myGestiore.login(scanString("Inserisci nome utente"),
                            scanString("Inserisci password"));
                        return loggato;

                case 3:
                    return null;
                    
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
