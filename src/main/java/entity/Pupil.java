package entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Created by 1 on 21.08.2017.
 */
@Entity
@Proxy(lazy=false)
@Table(name="PUPIL")
public class Pupil extends Human
{
    public Pupil()
    {
        super();
    }

}
