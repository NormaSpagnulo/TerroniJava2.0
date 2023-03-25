package progetto_veterinario;

public class gestione {
	public static login myLogin =new login();
	public static PrincipaleUser myPU;
	public static userRegister myRegister=new userRegister();
	public static PrincipaleAdmin myAdmin = new PrincipaleAdmin();
	public static tabellaUtenti myTabUt=new tabellaUtenti();
	public static selezioneIdUtente mySelezione=new selezioneIdUtente();
	public static Utente loggato;
	public static InserisciUtente adminUtente= new InserisciUtente();
	public static tabellaAnimali myAnimal=new tabellaAnimali();
	public static eliminaAnimale myElimina=new eliminaAnimale();
	public static registraAnimale myAggAnimale=new registraAnimale();
	public static tabellaPrenotazione myPrenotazioni=new tabellaPrenotazione(); 
	public static eliminaPrenotazione myEliminaPrenotazione=new eliminaPrenotazione();
	public static accettaPrenotazione myAccettaPrenotazione= new accettaPrenotazione();
	public static prenotazioniUtente myPrenotazioniUtente=new prenotazioniUtente();
	public static aggiungiPrenotazione myAggPrenotazione=new aggiungiPrenotazione();
	public static AnimaliPerUtente myAnimaliUtente = new AnimaliPerUtente();
	
	public static void setAggiungiPrenotazioniNotVisible( ) {
		myAggPrenotazione.setVisible(false);
	}
	public static void setAggiungiPrenotazioniVisible() {
		
		myAggPrenotazione.setVisible(true);
	}
	public static void refreshTabellaAnimaliUtente() {
		myAnimaliUtente.dispose();
		myAnimaliUtente = new AnimaliPerUtente();
		gestione.setAnimaliUtenteVisible();
	}
	public static void refreshTabellaTabellaAnimaliUtenteNonVisualizzare() {
		myAnimaliUtente.dispose();
		myAnimaliUtente = new AnimaliPerUtente();
	}
	public static void setAnimaliUtenteNotVisible( ) {
		myAnimaliUtente.setVisible(false);
	}
	public static void setAnimaliUtenteVisible() {
		myAnimaliUtente.setVisible(true);
	}
	public static void setLoginNotVisible( ) {
		myLogin.setVisible(false);
	}
	public static void setLoginVisible() {
		
		myLogin.setVisible(true);
	}
	public static void setPrincipaleUserVisible() {
		myPU=new PrincipaleUser();
		myPU.setVisible(true);
	}
	public static void setPrincipaleUserNotVisible() {
		myPU.setVisible(false);
	}
	public static void setRegisterVisible() {
		myRegister.setVisible(true);
	}
	public static void setRegisterNotVisible() {
		myRegister.setVisible(false);
	}
	public static void setMenuAdminNotVisible( ) {
		myAdmin.setVisible(false);
	}
	public static void setmenuAdminVisible() {
		
		myAdmin.setVisible(true);
	}
	public static void setTabellaUtentiNotVisible( ) {
		myTabUt.setVisible(false);
	}
	public static void setTabellaUtentiVisible() {
		myTabUt.setVisible(true);
	}
	public static void setSelezioneNomeNotVisible( ) {
		mySelezione.setVisible(false);
	}
	public static void setSelezioneVisible() {
		
		mySelezione.setVisible(true);
	}
	public static void refreshTabellaUtenti() {
		myTabUt.dispose();
		myTabUt = new tabellaUtenti();
		gestione.setTabellaUtentiVisible();
	}
	public static void refreshTabellaUtentiNonVisualizzare() {
		myTabUt.dispose();
		myTabUt = new tabellaUtenti();
	}
	public static void setLoggato(Utente user) {
		loggato= user;
	}
	public static void setInserisciUtenteNotVisible( ) {
		adminUtente.setVisible(false);
	}
	public static void setInserisciUtenteVisible() {
		
		adminUtente.setVisible(true);
	}
	public static void setTabellaAnimaliNotVisible( ) {
		myAnimal.setVisible(false);
	}
	public static void setTabellaAnimaliVisible() {
		
		myAnimal.setVisible(true);
	}
	public static void refreshTabellaAnimale() {
		myAnimal.dispose();
		myAnimal = new tabellaAnimali();
		gestione.setTabellaAnimaliVisible();
	}
	public static void refreshTabellaAnimaliNonVisualizzare() {
		myAnimal.dispose();
		myAnimal = new tabellaAnimali();
	}
	public static void setEliminaAnimaliNotVisible( ) {
		myElimina.setVisible(false);
	}
	public static void setEliminaAnimaliVisible() {
		
		myElimina.setVisible(true);
	}
	public static void setAggiungiAnimaliNotVisible( ) {
		myAggAnimale.setVisible(false);
	}
	public static void setAggiungiAnimaliVisible() {
		
		myAggAnimale.setVisible(true);
	}
	public static void setTabellaPrenotazioniNotVisible( ) {
		myPrenotazioni.setVisible(false);
	}
	public static void setTabellaPrenotazioniVisible() {
		
		myPrenotazioni.setVisible(true);
	}

	public static void refreshTabellaPrenotazioni() {
		myPrenotazioni.dispose();
		myPrenotazioni = new tabellaPrenotazione();
		gestione.setTabellaPrenotazioniVisible();
	}
	public static void refreshTabellaPrenotazioniNonVisualizzare() {
		myPrenotazioni.dispose();
		myPrenotazioni = new tabellaPrenotazione();
	}
	public static void setEliminaPrenotazioneNotVisible( ) {
		myEliminaPrenotazione.setVisible(false);
	}
	public static void setEliminaPrenotazioneiVisible() {
		
		myEliminaPrenotazione.setVisible(true);
	}
	public static void setAccettaPrenotazioneNotVisible( ) {
		myAccettaPrenotazione.setVisible(false);
	}
	public static void setAccettaPrenotazioneiVisible() {
		
		myAccettaPrenotazione.setVisible(true);
	}
	public static void refreshTabellaPrenotazioniUtente() {
		myPrenotazioniUtente.dispose();
		myPrenotazioniUtente = new prenotazioniUtente();
		gestione.setPrenotazioneUtenteVisible();
	}
	public static void refreshTabellaPrenotazioniUtenteNonVisualizzare() {
		myPrenotazioniUtente.dispose();
		myPrenotazioniUtente = new prenotazioniUtente();
	}
	public static void setPrenotazioneUtenteNotVisible( ) {
		myPrenotazioniUtente.setVisible(false);
	}
	public static void setPrenotazioneUtenteVisible() {
		
		myPrenotazioniUtente.setVisible(true);
	}
	public static Utente getLoggato() {
		return loggato;
	}

}
