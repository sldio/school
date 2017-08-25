package domain;

import entity.Human;
import entity.Pupil;
import entity.Teacher;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repositories.PupilRepository;
import repositories.TeacherRepository;
import service.PupilDAOImpl;
import service.TeacherDAOImpl;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 23.08.2017.
 */
public class Domain
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");

        PupilRepository pupilRepository = context.getBean(PupilRepository.class);
        TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);

        Pupil pupil = new Pupil();
        pupil.setFirstName("nameDAO");
        pupil.setSerName("sernameDAO");
        pupil.setPosition("pupil");
        pupil.setAge(10);
        pupil.setBirthDate(LocalDate.now());
        pupilRepository.saveAndFlush(pupil);
        List<Pupil> list = pupilRepository.findAll();

        System.out.println("****************************************************");
        for (Pupil currentPupil: list)
        {
            System.out.println(currentPupil);
        }

        System.out.println("****************************************************");
        System.out.println(pupilRepository.getOne(3));
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
        //System.out.println(t.toString());
        //HibernateUtil.shutdownSessionFactory();
    }
}
