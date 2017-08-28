package repositories;

import entity.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 1 on 25.08.2017.
 */
@Repository
public interface PupilRepository extends JpaRepository<Pupil, Long>
{
    @Query("SELECT p from Pupil p where p.email=:email")
    Pupil findByEmail(final @Param("email") String email);
}
