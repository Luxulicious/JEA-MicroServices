/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Screening;
import domain.Seat;
import java.util.List;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
public class ReservationDAO {

    public Screening getScreening(Long screeningId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Seat> getScreeningSeats(Long screeningId, List<Integer> seatNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void markAsPayed(Long screeningId, List<Integer> seatNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void reserve(Long screeningId, List<Integer> seatNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
