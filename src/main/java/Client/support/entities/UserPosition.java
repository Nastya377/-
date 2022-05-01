package Client.support.entities;
import javax.persistence.*;

import java.time.LocalDateTime;
import Client.PositionEntity;
import Client.UserEntity;
@Entity
@Table (name = "user_positons")
public class UserPosition {
    @EmbeddedId 
    UserPositionKey id;

    @ManyToOne
    @MapsId("positionId")
    @JoinColumn(name = "positon_id")
    PositionEntity position;

    
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserEntity user;


    @Column(name = "begin_work")
    LocalDateTime beginWorkedAt;
    
    @Basic
    @Column(name = "pay_bid", columnDefinition="Decimal(2,2)")
    double bid;    
}
