package polytech.cinema_server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import polytech.cinema_server.validator.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@JsonSerialize(as = User.class)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Integer id;

    @Basic
    @Column(nullable = false, unique = true, name = "email")
    @Email(message = "Email should be valid.")
    private String email;

    @Basic
    @Column(nullable = false, name = "password")
    @ValidPassword
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}