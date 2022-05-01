package Client;

//import created repos
import Client.repos.*;
import Client.support.answers.Answer;
import Client.support.answers.ItemsList;
import Client.support.entities.SalarysEntity;
import Client.support.ErrorEntity;
import Client.support.MainPageTransferOut;
import Client.mainBroker.Finder;


import org.apache.tomcat.util.buf.UEncoder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.text.Position;

@RestController
@Controller
public class MainController{

  

    /**if active more usefull log*/
    private final static boolean DEBUG_MODE = true;

    //connect MySQL repos
    @Autowired
    private UsersTable usersTable;

    @Autowired
    private ErrorTable errorTable;

    @Autowired
    private SalaryTable salaryTable;

    @Autowired
    private WorkTable WorkTabl;

    @Autowired
    private PositionTable posTabl;

    @Autowired
    private UsPosTable UPTabl;

    



    

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
    /** error handler for log some simple errors
     * @param Nosave - exclude save activity in bd
    */
    private void errorCoresponde (String name, String code, String info,boolean Nosave) {
        if (info == null) {info = "un waited error";}
        if (Nosave == false) {Nosave = true;}
        System.out.println(name+ "\n"+info+"\n#"+code);

        if (Nosave) {
            ErrorEntity erro = new ErrorEntity(name, code, info);
            errorTable.save(erro);
        }
    }   
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //main code
    //return first page
    @GetMapping
    public String greeting( String name, Model model) {
        return "greeting";
    }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "api/search", method = RequestMethod.GET)
    public ItemsList dd() {
        Finder findMe = new Finder("4","unValidated");
        findMe.conectTables(usersTable);
        ItemsList items = findMe.search();
        return items;
    }

    //when create new user
    @RequestMapping(value = "api/api", method = RequestMethod.GET)
    public Answer makeRegistrationa() {
        long i = 1;
        Optional <UserEntity> u = usersTable.findById(i);
        boolean a = false;
        if (u.isPresent()) {
            UserEntity user = u.get();
            SalarysEntity salary = new SalarysEntity();
            salary.setDateSalary(10, 2021);
            salary.setincome(200);
            salary.setoutcome(10);
            salary.setcollected(500);
            a =  user.addSalaryRow(salary);
            salaryTable.save(salary);
            System.out.println(a);
            
            System.out.println(user.GetListSalarys().size());

        }else{
            UserEntity us = new UserEntity();
            us.setpassword("456");
            us.setusername("456");
            usersTable.save(us);
            a = true;
        }
       return new Answer(Boolean.toString(a));
        }

    @RequestMapping(value = "api/examples/echo", method = RequestMethod.POST)
    @ResponseBody //@RequestBody String data
    public Answer makePostEcho(@RequestBody String data) {
        JSONObject root = new JSONObject(data);
        System.out.println(root.get("gf"));
        return new Answer("agagag");
    }


// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
///login nd register client   
    @RequestMapping(value = "api/register", method = RequestMethod.POST)
    @ResponseBody //@RequestBody String data
    public MainPageTransferOut apiRegister(@RequestBody String data) {
        //convert json string to user entity
        JSONObject root = new JSONObject(data);
        String username = root.get("username").toString();
        //checkout pass nd log 
        if (username.length() < 3) {
            if (DEBUG_MODE) errorCoresponde("ShortName", "456", "In create new acc name so short", false);
            return new MainPageTransferOut("1500");
        }
        String password = root.get("password").toString();
        if (username.length() < 3) {
            if (DEBUG_MODE) errorCoresponde("ShortPassword", "456", "In create new acc pass so short", false);
            return new MainPageTransferOut("1500");
        }
        UserEntity user = new UserEntity();
        user.setusername(username);
        user.setpassword(password);

        //find user on BD
        ArrayList<UserEntity> users = new ArrayList<>(usersTable.findByUsername(user.getusername()));
        if (users.size() == 0){//all ok
            usersTable.save(user);
    
            MainPageTransferOut registeredUser = new MainPageTransferOut(user);
            registeredUser.setFtm();
            
            System.out.println("user: " + user.getusername() + "  added!\npassword: "+ user.getpassword());
            return registeredUser;

        }else{
            errorCoresponde("Wrong","1010","User is already exist  "+user.getusername(),DEBUG_MODE);
            MainPageTransferOut error = new MainPageTransferOut("1000");
            return error;
        }
    }
    
    //when user login into sys
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    @ResponseBody //@RequestBody String data
    public MainPageTransferOut apiLogin(@RequestBody String data) {
        JSONObject root = new JSONObject(data);
        String username = root.get("username").toString();
        if (username.length() < 3) {
            if (DEBUG_MODE) errorCoresponde("ShortName", "455", "In login new acc name so short", false);
            return new MainPageTransferOut("1500");
        }
        String password = root.get("password").toString();
        if (password.length() < 3) {
            if (DEBUG_MODE) errorCoresponde("ShortPassword", "4557", "In login new acc pass so short", false);
            return new MainPageTransferOut("1500");
        }

        UserEntity user = new UserEntity();
        user.setusername(username);
        user.setpassword(password);
        
        ArrayList<UserEntity> users = new ArrayList<>(usersTable.findByLogpass(user.getusername(),user.getpassword()));
        if (users.size() == 1){
            if (DEBUG_MODE) System.out.println("user: " + user.getusername() + "logged in");
            
            
            UserEntity us = users.get(0);
            return new MainPageTransferOut(us);
    
        }else if (users.size() > 1){//bad
            errorCoresponde("Wrong","1111","So many itterable users !   " + user.getusername(),false);
            return new MainPageTransferOut("1111");
    
        }else{//just check input
            if (DEBUG_MODE) errorCoresponde("No Have user","1010","This user is not exist   "+ user.getusername(),false);
            return new MainPageTransferOut("1010");
        }
           
    }
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
//user send some settings:
    @RequestMapping(value = "api/updateuser/manually", method = RequestMethod.POST)
    @ResponseBody //@RequestBody String data
    public Answer apiSettings(@RequestBody String data) {
    try {
        JSONObject root = new JSONObject(data);
        
        String username = root.get("username").toString();
        String password = root.get("password").toString();
        
        UserEntity user = new UserEntity();
        user.setusername(username);
        user.setpassword(password);
        
        ArrayList<UserEntity> users = new ArrayList<>(usersTable.findByUsername(user.getusername()));
        if (users.size() >= 1){
            UserEntity us = users.get(0);
            
            //base save string
            Boolean isChanged = false;
            //check password 
            String Hashed = us.hashPassword();
            if (!password.equals(Hashed)) {
                errorCoresponde("IncorrectHash", "101", "check password failed", false);
                return new Answer("101");
            }
            
            //setNames
            String FNmame = root.get("firstName").toString();
            if (FNmame.length() > 2 && !FNmame.equals(us.getFirstName())) {
                isChanged = true;
                us.setFirstName(FNmame);
            }
            String SNmame = root.get("secName").toString();
            if (SNmame.length() > 2 && !SNmame.equals(us.getSecondName())) {
                isChanged = true;
                us.setSecondName(SNmame);
            }
            String TNmame = root.get("thirdName").toString();
            if (TNmame.length() > 2 && !TNmame.equals(us.getThirdName())) {
                isChanged = true;
                us.setThirdName(TNmame);
            }

            //set email nd work
            String email = root.get("email").toString();
            if (email.length() > 4 && !email.equals(us.getEmail())){
                us.setEmail(email);
                isChanged = true;
            }
            String addres = root.get("addres").toString();
            if (addres.length() > 4 && !addres.equals(us.getadres())){
                us.setadres(addres);
                isChanged = true;
            }

            String phone = root.get("phone").toString();
            if (phone.length() > 6 && !phone.equals(us.getphone())){
                us.setphone(phone);
                isChanged = true;
            }
            //TODO: card is alone obkect?)
            /**
            String card = root.get("card").toString();
            if (phone.length() > 7 && phone == us.getphone()){
                us.setphone(phone);
                isChanged = true;
            } */
            /**positions is realy need be a string? maybe store organization, structure, position etc */
            /** 
                String posit = root.get("position").toString();
                if (posit.length() > 3 && posit == us.getPosition()){
                    us.setPosition(posit);
                    isChanged = true;
                }

            
                workAddres: "",
                card: "",
            */

            if (isChanged) usersTable.save(us);                   
            return new Answer("200");
        }else{
            return new Answer("101");
        }
    } catch (Exception e) {
        System.out.println(e.toString());
        return new Answer("101");
    }
        
       
}
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private class UserExeption extends Exception{
        public String name;
        UserExeption (String err){
            name = err;
        }
    }
// -----------------------------------------------------------------------------------------------
    private UserEntity UserHaveAcess (JSONObject root) throws UserExeption  {
        try {    
            String username = root.get("username").toString();
            String HashedPassword = root.get("password").toString();
            ArrayList<UserEntity> users = new ArrayList<>(usersTable.findByUsername(username));

            if (users.size() > 0){
                UserEntity user = users.get(0);
                if (!HashedPassword.equals(user.hashPassword())) {
                   throw new UserExeption("IncorrectHash");
                }
                return user;
            } else { throw new UserExeption("No this user");}        
        } catch (Exception e) {
            throw new UserExeption("Wrong JSON");            
        }
    }
// -----------------------------------------------------------------------------------------------
//user send some search
    @RequestMapping(value = "api/find/{typeSearch}", method = RequestMethod.POST)
    @ResponseBody //@RequestBody String data
    public ItemsList ApiSearch(@PathVariable String typeSearch, @RequestBody String data) {
        try {
            JSONObject root = new JSONObject(data);
            String search = root.get("search").toString();
            if (search.length() > 3) {return new ItemsList(false);}

            try {
                UserEntity user = UserHaveAcess(root);
                int UserWho = user.getTypeAcc();
                if (UserWho == 0) return new ItemsList(false);
                Finder findMe = new Finder(search, typeSearch);
                findMe.conectTables(usersTable);
                ItemsList items = findMe.search();
                return items;
                
            } catch (UserExeption e) {
                if (DEBUG_MODE) {
                    errorCoresponde("ERROR", "0099", e.name, false);}
                return new ItemsList(false);
            }
        } catch (Exception e) {
            return new ItemsList(false);
        }
    }
}
