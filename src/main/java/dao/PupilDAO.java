package dao;

import entity.Pupil;

import java.util.List;

/**
 * Created by 1 on 25.08.2017.
 */
public interface PupilDAO
{
    void add(Pupil pupil);

    void delete(Pupil pupil);

    void deletByID(int id);

    void update(Pupil pupil);

    Pupil getById(int id);

    List<Pupil> getAll();
}
