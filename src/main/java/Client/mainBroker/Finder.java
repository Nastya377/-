package Client.mainBroker;

import java.util.ArrayList;

import Client.UserEntity;
import Client.repos.UsersTable;
import Client.support.answers.ItemsList;

public class Finder {
    private UsersTable userTable;
    private String searchItem;
    private String searchMethod;

    public Finder (String item,String method){
        this.searchItem = item;
        this.searchMethod = method;
        
    }
    public void conectTables (UsersTable ut) {
        this.userTable = ut;
    }
    
    public ItemsList search () {
        switch (this.searchMethod) {
            case "user":
                return this.SearchUsers();
            case "unValidated":
                return this.SelectUncheckedUsers();
            
            default:
                return new ItemsList(false);
        }
    } 
    

    private ItemsList SearchUsers (){
        ItemsList items = new ItemsList(false);
        ArrayList<UserEntity> users = new ArrayList<>(userTable.searchUser(this.searchItem));
        if (users.size() == 0) return items; 
        items.convertUserEntity(users);
        items.setStatus(true);
        return items;
    }

    private ItemsList SelectUncheckedUsers (){
        ItemsList items = new ItemsList(false);
        ArrayList<UserEntity> users = new ArrayList<>(userTable.findByBeginerStatus());
        if (users.size() == 0) return items; 
        users.forEach((n) -> items.addSomEntity(n));
        items.setStatus(true);
        return items;
    }
}
