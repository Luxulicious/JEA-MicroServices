/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Tomt
 */
@Entity
public class Rating {
    @Id
    private long id;
    private Movie movie;
    private List<User> ratedBy;
    private int currentRank;

    public Rating(long id, Movie movie, List<User> ratedBy, int currentRank) {
        this.id = id;
        this.movie = movie;
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
