package polytech.cinema_server.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.sql.Date;

@Entity
@JsonSerialize(as = Actor.class)
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "number", length = 4)
    private Integer number;

    @Basic
    @Column(nullable = false, name = "last_name", length = 20)
    private String lastName;

    @Basic
    @Column(name = "first_name", columnDefinition = "varchar(20) DEFAULT NULL")
    private String firstName;

    @Basic
    @Column(name = "birthday_date", columnDefinition = "date DEFAULT NULL")
    private Date birthdayDate;

    @Basic
    @Column(name = "deathday_date", columnDefinition = "date DEFAULT NULL")
    private Date deathdayDate;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Date getDeathdayDate() {
        return deathdayDate;
    }

    public void setDeathdayDate(Date deathdayDate) {
        this.deathdayDate = deathdayDate;
    }
}