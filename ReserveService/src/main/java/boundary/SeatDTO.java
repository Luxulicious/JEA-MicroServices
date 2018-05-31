/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import domain.Screening;
import domain.Seat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
public class SeatDTO {

    public long seatId;
    public boolean reserved;
    public String reservedBy;
    public boolean payed;
    public int seatNumber;

    public SeatDTO() {
    }

    SeatDTO(Seat seat) {
        this.seatId = seat.getSeatId();
        this.reserved = seat.isReserved();
        this.reservedBy = seat.getReservedBy();
        this.payed = seat.isPayed();
        this.seatNumber = seat.getSeatNumber();
    }
}
