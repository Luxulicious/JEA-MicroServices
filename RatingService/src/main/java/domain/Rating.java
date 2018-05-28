/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Tomt
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Rating.getAll", query = "SELECT r FROM Rating r"),
    @NamedQuery(name = "Rating.find", query = "SELECT r FROM Rating r WHERE r.id = :id"),
    @NamedQuery(name = "Rating.findByMovie", query = "SELECT r FROM Rating r WHERE r.movie.title = :title")
})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Movie movie;
    @ManyToMany
    private List<User> ratedBy;
    private int currentRank;

    public Rating() {
    }

    public Rating(long id, Movie movie, List<User> ratedBy, int currentRank) {
        this.id = id;
        this.movie = movie;
        this.ratedBy = ratedBy;
        this.currentRank = currentRank;
    }
    
    public Rating(Movie movie, List<User> ratedBy, int currentRank) {
        this.movie = movie;
        this.ratedBy = ratedBy;
        this.currentRank = currentRank;
    }
    
    public Rating(List<User> ratedBy, int currentRank) {
        this.ratedBy = ratedBy;
        this.currentRank = currentRank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<User> getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(List<User> ratedBy) {
        this.ratedBy = ratedBy;
    }

    public int getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(int currentRank) {
        this.currentRank = currentRank;
    }

}
