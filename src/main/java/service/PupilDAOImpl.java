package service;

import dao.PupilDAO;
import entity.Human;
import entity.Pupil;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import util.SessionUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 1 on 25.08.2017.
 */
public class PupilDAOImpl extends SessionUtil implements PupilDAO
{
    @Override
    public void add(Pupil pupil)
    {
        openTransactionSession();
        Session session = getSession();
        session.save(pupil);
        closeTransactionSession();
    }

    @Override
    public void delete(Pupil pupil)
    {
        openTransactionSession();
        Session session = getSession();
        session.delete(pupil);
        closeTransactionSession();
    }

    @Override
    public void deletByID(int id)
    {
        openTransactionSession();
        Session session = getSession();
        Pupil pupil = (Pupil) session.load(Pupil.class, new Integer(id));
        session.delete(pupil);
        closeTransactionSession();
    }

    @Override
    public void update(Pupil pupil)
    {
        openTransactionSession();
        Session session = getSession();
        session.update(pupil);
        closeTransactionSession();
    }

    @Override
    public Pupil getById(int id)
    {
        openTransactionSession();
        Session session = getSession();
        Pupil pupil = (Pupil)session.load(Pupil.class, new Integer(id));
        closeTransactionSession();
        return pupil;
    }

    @Override
    public List<Pupil> getAll()
    {
        openTransactionSession();
        Session session = getSession();
        List<Pupil> list = new LinkedList<>();
        list = session.createCriteria(Pupil.class).addOrder(Order.asc("serName")).list();
        closeTransactionSession();
        return list;
    }
}
