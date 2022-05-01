package Client.support;
import Client.*;

public class MainPageTransferOut {
    //-------
    private String wrong = "0";
    public String getError() {
        return wrong;
    }
    public void setError (String er) {
        this.wrong = er;
    }
    //-------


    //-------
    private boolean firsttime = false;
    //**setup user logged first time on sys */
    public void setFtm () {
        firsttime = true;
    }
    public boolean getFtm () {
        return firsttime;
    }
    //-------


    //-------
    private String username;
    public String getUsername (){
        return username;
    }
    public void setUsername (String name){
        this.username = name;
    }


    //-------
    private String password;
    public void setPass (String pass) {
        this.password = pass;
    }
    public String getPassword () {
        return this.password;
    }
    //-------

    //-------
    public String firstname;
    public String secondname;

    
    //-------
    private String ustype;
    public void setUserType (String ut) {
        this.ustype = ut;
    }
    public String getUserType () {
        return this.ustype;
    }
    //-------



//--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//definit
    public MainPageTransferOut (String names,String hashed) {
        this.username = names;
        this.password = hashed;
        this.wrong = "1";//all ok lets begin
    }

    public MainPageTransferOut(UserEntity user){
        this.username = user.getusername();
        this.password = user.hashPassword();
        this.wrong = "1";//all ok lets begin
        
    }
    /**wrong answer */
    public MainPageTransferOut (String eror) {
        this.wrong = eror;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------

}
