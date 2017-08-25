package service;

import entity.Human;
import dao.HumanDAO;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import util.HibernateUtil;
import util.SessionUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 1 on 23.08.2017.
 */

public class HumanDAOImpl extends SessionUtil implements HumanDAO
{

    @Override
    public void add(Human human)
    {
        openTransactionSession();
        Session session = getSession();
        session.save(human);
        closeTransactionSession();
    }

    @Override
    public void delete(Human human)
    {
        openTransactionSession();
        Session session = getSession();
        session.delete(human);
        closeTransactionSession();
    }

    @Override
    public void deletByID(int id)
    {
        openTransactionSession();
        Session session = getSession();
        Human human = (Human) session.load(Human.class, new Integer(id));
        session.delete(human);
        closeTransactionSession();
    }

    @Override
    public void update(Human human)
    {
        openTransactionSession();
        Session session = getSession();
        session.update(human);
        closeTransactionSession();
    }

    @Override
    public Human getById(int id)
    {
        openTransactionSession();
        Session session = getSession();
        Human human = (Human)session.load(Human.class, new Integer(id));
        closeTransactionSession();
        return human;
    }

    @Override
    public List<Human> getAll()
    {
        openTransactionSession();
        Session session = getSession();
        List<Human> list = new LinkedList<>();
        list = session.createCriteria(Human.class).addOrder(Order.asc("serName")).list();
        closeTransactionSession();
        return list;
    }
}
