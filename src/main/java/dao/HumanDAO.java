package dao;

import entity.Human;

import java.util.List;

/**
 * Created by 1 on 23.08.2017.
 */
public interface HumanDAO
{
    void add(Human human);
    void delete(Human human);
    void deletByID(int id);
    void update(Human human);
    Human getById(int id);
    List<Human> getAll();
}
