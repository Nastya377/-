package Client.repos;
import Client.UserEntity;
import Client.support.entities.SalarysEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SalaryTable extends CrudRepository<SalarysEntity, Long>{
    List<SalarysEntity> findById(long rowId);

    //*select last 12 rows*/
    @Query(value = "SELECT * FROM salary.salarys sal WHERE sal.type_act = '1' ORDER BY sal.id DESC LIMIT 12", nativeQuery = true)
    List<UserEntity> selectLastSalarys(String username,String password);

}
