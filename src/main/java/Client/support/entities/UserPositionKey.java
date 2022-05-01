package Client.support.entities;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserPositionKey implements Serializable {
    @Column(name = "position_id")
    Long positionId;

    @Column(name = "user_id")
    Long userId;    
}
