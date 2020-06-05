package demo.entities;

import javax.persistence.*;
import java.util.Date;

// TODO пример отображения наследования InheritanceType.SINGLE_TABLE
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Performer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    protected Date birthDate;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
