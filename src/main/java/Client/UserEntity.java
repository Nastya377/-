package Client;
import javax.persistence.*;

import Client.support.entities.SalarysEntity;
import Client.support.entities.UserPosition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

@Entity
@Table(name = "users", schema = "salary")
public class UserEntity {
    //static data of user
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    Long id;
    
    //для профессии 
    @OneToMany(mappedBy = "user")
    Set<UserPosition> userPositions;
    
    //для места работы
    @ManyToMany
    @JoinTable(
        name = "users_work",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "work_id"))
    Set<WorkEntity> workSpace = new HashSet<>();

    private String username;
    private String password;
    
    //names
    private String firstName;
    private String secondName;
    private String thirdName;

    //other data
    private String email;
    @Basic
    @Column(name = "adres")
    private String adres;
    @Basic
    @Column(name = "phone")
    private String phone;
//    private Card card = new Card();
    
    /**set lvl acess to account */
    
    @Column(name = "type_acc", columnDefinition="TINYINT default '0'")
    private int typeAcc;

  
    @OneToMany(mappedBy = "user_salary", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<SalarysEntity> salarys = new ArrayList<> ();
    /**default */
    //work with id
    
    public Long getid () {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    
    
    @Column(name = "accounttype")
    public int getTypeAcc () {
        return typeAcc;
    }

    public void setTypeAcc(int typeAcc) {
        this.typeAcc = typeAcc;
    }
    



    //login of user
    @Basic
    @Column(name = "username")
    public String getusername() {
        return username;
    }
    
    public void setusername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "firstName")
    public void setFirstName (String fname) {
        this.firstName = fname;
    }

    public String getFirstName () {
        return firstName;
    }

    @Basic
    @Column(name = "secondName")
    public void setSecondName (String fname) {
        this.secondName = fname;
    }

    public String getphone () {return phone;}   
    public void setphone(String in) {
        this.phone = in;
    }

    public String getadres () {return adres;}   
    public void setadres(String in) {
        this.adres = in;
    }

    public String getSecondName () {
        return secondName;
    }

    @Basic
    @Column(name = "thirdName")
    public void setThirdName (String fname) {
        this.thirdName = fname;
    }

    public String getThirdName () {
        return thirdName;
    }

    public boolean validEmail (String email) {
        Pattern rfc2822 = Pattern.compile(
        "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");

        if (!rfc2822.matcher(email).matches()) {
            return false;
        }
        return true;
    }
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    
    @Basic
    @Column(name = "email")
    public void setEmail (String fname) {
        if (validEmail(fname)) this.email = fname;
    }

    public String getEmail () {
        return email;
    }
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    
    @Basic
    @Column(name = "status", columnDefinition="TINYINT default '0'")
    private int status;
    public void setStatus (int tp){
        this.status = tp;
    }
    public int getStatus () {return status;}
    

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return  Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    /**
     * check password on null
     * @return
     */
    public boolean NvPas (){
        return password == null;
    }
    /**
     * check login on null
     * @return
     */
    public boolean NvLog (){
        return username == null;
    }
    /**return hashed string for 
    default use - resolve to mainpage answer class*/
    
    public String hashPassword () {
        /**00
        try {
            String hashStr = this.username + this.password;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(hashStr.getBytes());
            byte[] digest = md.digest();
            return digest.toString();    
        } catch (Exception e) {
            System.err.println("I'm sorry, but SHA-256 is not a valid message digest algorithm");
            return "error";
        } */
        int hashed = Objects.hash(username, password);
        return Integer.toString(hashed);
        
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean addSalaryRow (SalarysEntity salary) {
        salarys.add(salary);
        salary.setSalaryRow(this);
        return true;
    }
    public boolean removeSalaryRow (SalarysEntity salary) {
        salarys.remove(salary);
        salary.setSalaryRow(null);
        return true;
    } 
    public List<SalarysEntity> GetListSalarys() {
        return salarys;
    }
}
