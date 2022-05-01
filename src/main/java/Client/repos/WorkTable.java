package Client.repos;
import Client.WorkEntity;
import org.springframework.data.repository.CrudRepository;

public interface WorkTable extends CrudRepository<WorkEntity, Long>{
     
}
