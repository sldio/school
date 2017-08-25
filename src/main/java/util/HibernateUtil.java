package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 1 on 23.08.2017.
 */
public class HibernateUtil
{
    private static final SessionFactory sessionfactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        SessionFactory sessionFactory = null;
        try
        {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex)
        {
            System.out.println("can`t make sessionFactory");
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionfactory()
    {
        return sessionfactory;
    }
    public static void shutdownSessionFactory()
    {
        getSessionfactory().close();
    }
}
