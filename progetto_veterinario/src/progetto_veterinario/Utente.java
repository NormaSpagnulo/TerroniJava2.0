package progetto_veterinario;
import java.util.ArrayList;
public class Utente{
    private String username;
    private String password;
    private boolean admin=false;
    public Utente(String username,String password,String passAdmin){
        if(passAdmin.equals("ciaoAdmin")){
            admin=true;
        }else{
            admin=false;
        }
        this.username=username;
        this.password=password;
    }
    public Utente(String username,boolean admin){
        this.admin=admin;
        this.username=username;
        
    }
    public boolean getAdmin(){
        return admin;
    }
    public String getUsername(){
        return username;
    }
}