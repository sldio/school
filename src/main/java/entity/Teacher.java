package entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 1 on 21.08.2017.
 */

@Entity
@Proxy(lazy=false)
@Table(name="TEACHER")
public class Teacher extends Human
{
    public Teacher()
    {
        super();
    }


}
