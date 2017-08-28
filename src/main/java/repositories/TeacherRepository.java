package repositories;

import entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 1 on 25.08.2017.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>
{
    @Query("SELECT t from Teacher t where t.firstName=:firstName AND t.serName=:serName")
    Teacher findByFirstNameAndSerName(final @Param("firstName") String firstName, final @Param("serName") String serName);

    Teacher findByserName(String serName);
}
