package Client;
import javax.persistence.*;
import Client.support.entities.UserPosition;
import java.util.Set;

@Entity
@Table(name = "positions", schema = "salary")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    Long id;
    
    @OneToMany(mappedBy = "position")
    Set <UserPosition> worker;
        
    @ManyToMany(mappedBy = "workPos")
    Set <WorkEntity> positionWorks;

    @Basic
    @Column(name = "title")
    String positionTitle;
    
    @Basic
    @Column(name = "type_of_pay", columnDefinition="TINYINT default '0'")
    int payType;

    @Basic
    @Column(name = "standart_pay", columnDefinition="Decimal(50,2)  default '0.00'")
    double pay;
}    

