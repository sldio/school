package domain;

import configuration.ContextConfiguration;
import configuration.JpaConfig;
import entity.Pupil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import repositories.PupilRepository;
import repositories.TeacherRepository;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by 1 on 23.08.2017.
 */
@Import(ContextConfiguration.class)
public class Domain
{
    public static void main(String[] args)
    {

        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("applicationContent.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContent.xml");

        PupilRepository pupilRepository = ctx.getBean(PupilRepository.class);
        TeacherRepository teacherRepository = ctx.getBean(TeacherRepository.class);

        Pupil pupil = new Pupil();
        pupil.setFirstName("nameDAO");
        pupil.setSerName("sernameDAO");
        pupil.setPosition("pupil");
        pupil.setAge(10);
        pupil.setBirthDate(LocalDate.now());
        pupilRepository.saveAndFlush(pupil);
        List<Pupil> list = pupilRepository.findAll();

        System.out.println("****************************************************");
        for (Pupil currentPupil : list)
        {
            System.out.println(currentPupil);
        }

        System.out.println("****************************************************");
        System.out.println(pupilRepository.getOne(3L));
        /*Teacher teacher = new Teacher();
        teacher.setFirstName("teacherFirstDAO2");
        teacher.setBirthDate(LocalDate.now());
        teacher.setSerName("teadherSerDAO2");
        teacher.setPosition("teacher");
        teacherDAOimpl.add(teacher);*/

        /*list = teacherDAOimpl.getAll();

        for (Human human:list)
        {
            System.out.println(human.toString());
        }*/

        //Pupil p = pupilDAOimpl.getById(8);
        //Teacher t = (Teacher)teacherDAOimpl.getById(3);
        //System.out.println(p.toString());
        //System.out.println(t.toString());*/
        HibernateUtil.shutdownSessionFactory();
    }
}
