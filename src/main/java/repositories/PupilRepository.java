package repositories;

import entity.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 1 on 25.08.2017.
 */
@Repository
public interface PupilRepository extends JpaRepository<Pupil, Integer>
{
}
