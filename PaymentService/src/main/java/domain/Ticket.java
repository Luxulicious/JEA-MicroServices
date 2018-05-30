/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Tomt
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Ticket.getAll", query = "SELECT t FROM Ticket t"),
@NamedQuery(name = "Ticket.find", query = "SELECT t FROM Ticket t WHERE t.id = :id")
})
public class Ticket {
    @Id
    private long id;
    private String movieTitle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime;
    private List<Integer> seatNumbers;
    @ManyToOne
    private User owner;

    public Ticket() {
    }

    public Ticket(long id, String movieTitle, Date startTime, Date endTime, List<Integer> seatNumbers, User owner) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seatNumbers = seatNumbers;
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

}
