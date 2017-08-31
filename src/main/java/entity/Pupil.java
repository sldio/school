package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 1 on 21.08.2017.
 */
@Entity
public class Pupil extends Human
{
    public Pupil()
    {
        super();
    }

    @Column(name = "email")
    private String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
