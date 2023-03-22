package progetto_veterinario;

public class gestione {
	public static login myLogin =new login();
	public static PrincipaleUser myPU;
	public static userRegister myRegister=new userRegister();
	public static PrincipaleAdmin myAdmin = new PrincipaleAdmin();
	public static void setLoginNotVisible( ) {
		myLogin.setVisible(false);
	}
	public static void setLoginVisible() {
		
		myLogin.setVisible(true);
	}
	public static void setPrincipaleUserVisible(String username) {
		myPU=new PrincipaleUser(username);
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
}
