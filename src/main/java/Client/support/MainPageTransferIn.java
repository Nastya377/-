
package Client.support;
import javax.persistence.*;

@Entity
public class MainPageTransferIn {

    //-----------------------------------------------------
    private String username;
    private String password; 

    public String getUsername (){
        return username;
    }

    public void setUsername (String name){
        this.username = name;
    }

   public boolean paswPassed (String psw) {
        if (this.password == psw) return true;
        return false;
    }


    private String act = "empt";
        
    public void setAction (String actio) {
        this.act = actio;
    }

    /**return page answer to server*/
    public String action(){
        return act;
    }
    //------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------
    //definit 
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------


}








