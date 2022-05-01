package Client.repos;

import Client.UserEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersTable extends CrudRepository<UserEntity, Long>{
       
       List<UserEntity> findByUsername(String username);

       
       @Query(value = "SELECT * FROM Users us WHERE us.status=?1", nativeQuery = true)
       List<UserEntity> findByStatus(int status);
       @Query(value = "SELECT * FROM Users us WHERE us.status = 0", nativeQuery = true)
       List<UserEntity> findByBeginerStatus();

       @Query(value = "SELECT * FROM salary.users us where us.username Like ?1% OR us.first_name LIKE ?1% OR us.second_name like ?1% OR us.third_name like ?1%  LIMIT 10;", nativeQuery = true)
       List<UserEntity> searchUser(String search);       
       
       @Query(value = "SELECT * FROM Users us WHERE us.username=?1 AND us.password=?2", nativeQuery = true)
       List<UserEntity> findByLogpass(String username,String password);



       
       /**
       @Modifying
       @Query("update salary.users  set email = :email where user_id = :id")
       void updateEmail(@Param(value = "id") long id, @Param(value = "email") String email);
       
       @Modifying
       @Query("update salary.users set first_name = :name where user_id = :id")
       void updateFirstName(@Param(value = "id") long id, @Param(value = "name") String name);
       @Modifying
       @Query("update salary.users set second_name = :name where user_id = :id")
       void updateSecName(@Param(value = "id") long id, @Param(value = "name") String name);
       @Modifying
       @Query("update salary.users set third_name = :name where user_id = :id")
       void updateThirdName(@Param(value = "id") long id, @Param(value = "name") String name);
       */

}
