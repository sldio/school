package repositories;

import entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by 1 on 25.08.2017.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>
{
    @Query(value = "SELECT * FROM humans.teacher WHERE firstName = ?1 AND serName = ?2", nativeQuery = true)
    Teacher findByFirstNameAndSerName(String firstName, String serName);

    Teacher findByserName(String serName);
}
