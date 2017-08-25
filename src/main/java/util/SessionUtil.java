package util;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by 1 on 25.08.2017.
 */
public class SessionUtil
{
    private Session session;
    private Transaction transaction;

    public Session getSession()
    {
        return session;
    }

    public Transaction getTransaction()
    {
        return transaction;
    }

    public Session openSession()
    {
        return HibernateUtil.getSessionfactory().openSession();
    }

    public Session openTransactionSession()
    {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession()
    {
        session.close();
    }

    public void closeTransactionSession()
    {
        transaction.commit();
        closeSession();
    }
}
