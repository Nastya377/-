package Client;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;

@Entity
@Table(name = "works", schema = "salary")
public class WorkEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    public void setId (Long id){
        this.id = id;
    }
    public Long getId (){return id;}
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------    
        //для пользователя
        @ManyToMany(mappedBy = "workSpace")
        Set <UserEntity> user = new HashSet<>();
        public Set<UserEntity> getWorkers () {return user;}
        public void setWorkers (Set<UserEntity> us) {
            this.user = us;
        }
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    //для должности
        @ManyToMany
        @JoinTable(
            name = "worked_positions", 
            joinColumns = @JoinColumn(name = "works_id"), 
            inverseJoinColumns = @JoinColumn(name = "poss_id"))
        private Set <PositionEntity> workPos = new HashSet<>();
        public Set<PositionEntity> getPositions () {return workPos;}
        public void setPosition(Set<PositionEntity> WP)  {
            this.workPos = WP;
        }
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    @Basic
    @Column(name = "name")
    private String workName;
    
    public void setPosTitle (String title){
        this.workName = title;
    }
    public String getPosTitle (){return workName;}
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    @Basic
    @Column(name = "work_addres", columnDefinition="VARCHAR(60)")
    private String addres;
    public void setWorkAddres (String tp){
        this.addres = tp;
    }
    public String getWorkAddres () {return addres;}
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    ///--------------------------------------------------------------
    


    
    ///---------------------------------------------------------------------------------------
    ///---------------------------------------------------------------------------------------
    ///---------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkEntity that = (WorkEntity) o;
        return  Objects.equals(id, that.id) 
        && Objects.equals(workName, that.workName)
        && Objects.equals(addres, that.addres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addres, id, workName);
    }

}    
