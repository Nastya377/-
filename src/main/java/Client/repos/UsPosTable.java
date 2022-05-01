package Client.repos;
import Client.support.entities.UserPosition;

import org.springframework.data.repository.CrudRepository;

public interface UsPosTable extends CrudRepository<UserPosition, Long>{
     
}
