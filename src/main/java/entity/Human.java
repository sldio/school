package entity;


import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by 1 on 21.08.2017.
 */
@MappedSuperclass
public abstract class Human
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "serName", nullable = false)
    private String serName;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "age")
    private int age;

    public Human()
    {
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

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

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
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

    @Override
    public String toString()
    {
        String rez = "id " + id + " name - " + firstName + " sername - " + serName + " birthdate - " + birthDate + " position - " + position;
        return rez;
    }
}
