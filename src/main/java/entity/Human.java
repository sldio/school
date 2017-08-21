package entity;

import java.sql.Timestamp;

/**
 * Created by 1 on 21.08.2017.
 */
public abstract class Human
{
    private String firstName;
    private String serName;
    private Timestamp birthDate;
    private String position;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSerName()
    {
        return serName;
    }

    public void setSerName(String serName)
    {
        this.serName = serName;
    }

    public Timestamp getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String toString()
    {
        String rez = "name - " + firstName + " sername - " + serName + " birthdate - " + birthDate + " position - " + position;
        return rez;
    }
}
