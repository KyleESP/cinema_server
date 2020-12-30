package polytech.cinema_server.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@JsonSerialize(as = Movie.class)
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id", length = 4)
    private Integer id;

    @Basic
    @Column(nullable = false, name = "title", length = 30)
    private String title;

    @Basic
    @Column(nullable = false, name = "duration", length = 3)
    private Integer duration;

    @Basic
    @Column(nullable = false, name = "release_date")
    private Date releaseDate;

    @Basic
    @Column(nullable = false, name = "budget", length = 8)
    private Integer budget;

    @Basic
    @Column(nullable = false, name = "revenue_amount", length = 8)
    private Integer revenueAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Director director;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(Integer revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}