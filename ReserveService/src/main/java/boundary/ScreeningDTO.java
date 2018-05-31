/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import domain.Screening;
import domain.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
public class ScreeningDTO {

    public Long id;
    public String movieTitle;
    public Date startTime;
    public Date endTime;
    public double price;
    public List<SeatDTO> seats;

    public ScreeningDTO() {
    }

    public ScreeningDTO(Screening screening) {
        this.id = screening.getId();
        this.movieTitle = screening.getMovieTitle();
        this.startTime = screening.getStartTime();
        this.endTime = screening.getEndTime();
        this.price = screening.getPrice();
        this.seats = new ArrayList<>();
        for (Seat seat : screening.getSeats()) {
            seats.add(new SeatDTO(seat));
        }
    }

}
