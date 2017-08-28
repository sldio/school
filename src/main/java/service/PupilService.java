package service;

import entity.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PupilRepository;

import java.util.List;

/**
 * Created by 1 on 28.08.2017.
 */
@Service
public class PupilService
{
    private PupilRepository pupilRepository;

    @Autowired
    public PupilService(final PupilRepository pupilRepository)
    {
        this.pupilRepository = pupilRepository;
    }

    public Pupil findOne(final Long pupilId)
    {
        return pupilRepository.findOne(pupilId);
    }

    public List<Pupil> findAll()
    {
        return pupilRepository.findAll();
    }
    public Pupil findByEmail(final String email){
        return pupilRepository.findByEmail(email);
    }
}
