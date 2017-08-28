import entity.Pupil;
import service.PupilDAOImpl;
import service.TeacherDAOImpl;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by 1 on 23.08.2017.
 */
public class MainForHibernate
{
    public static void main(String[] args)
    {
        PupilDAOImpl pupilDAOimpl = new PupilDAOImpl();
        TeacherDAOImpl teacherDAOimpl = new TeacherDAOImpl();

        Pupil pupil = new Pupil();
        pupil.setFirstName("nameDAO1");
        pupil.setSerName("sernameDAO1");
        pupil.setPosition("pupil");
        pupil.setAge(110);
        pupil.setBirthDate(LocalDate.now());
        pupilDAOimpl.add(pupil);

        List<Pupil> list = pupilDAOimpl.getAll();
        for (Pupil pupil1:list)
        {
            System.out.println(pupil1);
        }

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

        Pupil p = pupilDAOimpl.getById(1);
        //Teacher t = (Teacher)teacherDAOimpl.getById(3);
        System.out.println("-----------------------------------------------------------");
        System.out.println(p);
        //System.out.println(t.toString());
        HibernateUtil.shutdownSessionFactory();
    }
}
