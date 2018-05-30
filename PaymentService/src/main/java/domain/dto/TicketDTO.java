/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.dto;

import domain.Ticket;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tomt
 */
public class TicketDTO {
    public long id;
    public String movieTitle;
    public Date startTime;
    public Date endTime;
    public List<Integer> seatNumbers;
    public String ownerName;

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.movieTitle = ticket.getMovieTitle();
        this.startTime = ticket.getStartTime();
        this.endTime = ticket.getEndTime();
        this.seatNumbers = ticket.getSeatNumbers();
        this.ownerName = ticket.getOwner().getName();
    }
    
    
}
