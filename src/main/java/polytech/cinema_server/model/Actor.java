package polytech.cinema_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@JsonSerialize(as = Actor.class)
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id", length = 4)
    private Integer id;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy="actor", orphanRemoval = true)
    private Set<Figure> figures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @JsonIgnoreProperties(value = { "actor" })
    public Set<Figure> getFigures() {
        return figures;
    }

    public void setFigures(Set<Figure> figures) {
        this.figures = figures;
    }
}