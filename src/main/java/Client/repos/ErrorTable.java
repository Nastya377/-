package Client.repos;

import Client.support.ErrorEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ErrorTable extends CrudRepository<ErrorEntity, Long>{
    List<ErrorEntity> findByCode(String code);
    
    List<ErrorEntity> findByErrorId(Long errorId);
    
    @Query
    (value = "SELECT * FROM salary.error_collector ORDER BY error_collector.error_id DESC LIMIT 10;", nativeQuery = true)
    List<ErrorEntity> getLast ();
}