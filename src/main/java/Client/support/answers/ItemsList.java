package Client.support.answers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import Client.UserEntity;

public class ItemsList {
    private List<User> users = new ArrayList<>();
    private boolean status;
    ///--------------------------------------------------------------

    
        public ItemsList () {
            this.status = true;
        }

        public ItemsList (Boolean bool) {
            this.status = bool;
        }
    
    ///--------------------------------------------------------------
        public void setStatus (boolean bool) {
            this.status = bool;
        } 
        public boolean getStatus () {return status;}
    ///--------------------------------------------------------------
        public void addSomEntity (UserEntity U) {
            User us = new User();
            us.Fname = U.getFirstName();
            us.Sname = U.getSecondName();
            us.Tname = U.getThirdName();
            us.id = U.getid();
            us.stat = U.getStatus();
            us.usName = U.getusername();  
            users.add(us);
        }
        public void convertUserEntity (ArrayList<UserEntity> userList) {
            userList.forEach((n) -> this.addSomEntity(n));
        }
        public List<User> getUsers() {
            return users;
        }
    ///--------------------------------------------------------------   
    private class User {
        public String Fname;
        public String Sname;
        public String Tname;
        public Long id;
        public int stat;
        public String usName;
    }
    ///--------------------------------------------------------------
    
}