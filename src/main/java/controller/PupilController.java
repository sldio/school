package controller;

import entity.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import repositories.PupilRepository;

/**
 * Created by 1 on 31.08.2017.
 */
@Controller
public class PupilController
{

    @Autowired
    private PupilRepository pupilRepository;

    public Pupil getPupilByID(long id)
    {
        Pupil pupil = new Pupil();
        pupil = pupilRepository.getOne(id);
        return pupil;
    }
}
