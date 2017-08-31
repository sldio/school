import controller.PupilController;
import entity.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import repositories.PupilRepository;

/**
 * Created by 1 on 31.08.2017.
 */

@SpringBootApplication
public class MainForSpring implements CommandLineRunner
{
    @Autowired
    PupilRepository pupilRepository;

    public static void main(String [] args)
    {
        SpringApplication.run(MainForSpring.class,args);
    }

    @Override
    public void run(String... strings) throws Exception
    {
        Pupil pupil = new Pupil();
        pupil = pupilRepository.getOne(1L);
        System.out.println(pupil);
    }
}
