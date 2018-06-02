package service;

import dao.ReservationDAO;
import domain.Screening;
import domain.Seat;
import java.util.*;
import javax.ejb.Stateless;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
@Stateless
public class ReservationService {

    @Inject
    private ReservationDAO reservationDAO;

    public List<Screening> getAllScreenings() {
        return reservationDAO.getAllScreenings();
    }

    public void reserve(Long screeningId, List<Integer> seatNumbers, String reservedBy) throws Exception {
        checkAvailableScreening(screeningId);
        checkAvailableSeats(screeningId, seatNumbers);
        reservationDAO.reserve(screeningId, seatNumbers, reservedBy);
    }

    public void markAsPayed(Long screeningId, List<Integer> seatNumbers) throws Exception {
        checkBeforePayment(screeningId, seatNumbers);
        reservationDAO.markAsPayed(screeningId, seatNumbers);
    }

    //<editor-fold defaultstate="collapsed" desc="Validation">
    private void checkAvailableScreening(Long screeningId) throws Exception {
        Screening screening = reservationDAO.getScreening(screeningId);
        checkNonExistingScreening(screening);
    }

    private void checkNonExistingScreening(Screening screening) throws Exception {
        if (screening == null) {
            throw new Exception("NonExistantScreeningException");
        }
    }

    private void checkBeforePayment(Long screeningId, List<Integer> seatNumbers) throws Exception {
        List<Seat> seats = reservationDAO.getScreeningSeats(screeningId);
        checkAnySeats(seats);
        checkDuplicateSeats(seatNumbers);
        checkNonExistantSeats(seatNumbers, seats);
    }

    private void checkAvailableSeats(Long screeningId, List<Integer> seatNumbers) throws Exception {
        List<Seat> seats = reservationDAO.getScreeningSeats(screeningId);
        checkAnySeats(seats);
        checkDuplicateSeats(seatNumbers);
        checkNonExistantSeats(seatNumbers, seats);
        checkOccupiedSeats(seatNumbers, screeningId);

    }

    private void checkOccupiedSeats(List<Integer> seatNumbers, Long screeningId) throws Exception {
        List<Seat> seats = reservationDAO.getScreeningSeats(screeningId);
        //Check for occupied seats
        List<Seat> occupiedSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isReserved()) {
                for (Integer seatNumber : seatNumbers) {
                    if (seat.getSeatNumber() == seatNumber) {
                        occupiedSeats.add(seat);
                    }
                }
            }
        }
        if (occupiedSeats.size() > 0) {
            String msg = "OccupiedSeatsException => ";
            for (Seat occupiedSeat : occupiedSeats) {
                msg += " " + occupiedSeat.getSeatNumber() + " ";
            }
            throw new Exception(msg);
        }
    }

    private void checkNonExistantSeats(List<Integer> seatNumbers, List<Seat> seats) throws Exception {
        //Check for non-existant seats
        List<Integer> nonExistantSeatNumbers = new ArrayList<>();
        for (int seatNumber : seatNumbers) {
            boolean exists = false;
            for (Seat seat : seats) {
                if (seat.getSeatNumber() == seatNumber) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                nonExistantSeatNumbers.add(seatNumber);
            }
        }
        if (nonExistantSeatNumbers.size() > 0) {
            String msg = "NonExistantSeatsException => ";
            for (Integer nonExistantSeatNumber : nonExistantSeatNumbers) {
                msg += " " + nonExistantSeatNumber + " ";
            }
            throw new Exception(msg);
        }
    }

    private void checkDuplicateSeats(List<Integer> seatNumbers) throws Exception {
        //Check for duplicate seats
        Set<Integer> set = new HashSet<>(seatNumbers);
        if (set.size() < seatNumbers.size()) {
            throw new Exception("DuplicateSeatException");
        }
    }

    private void checkAnySeats(List<Seat> seats) throws Exception {
        //Check if there are seats
        if (seats == null) {
            throw new Exception("NonExistantSeatsException");
        } else if (seats.size() <= 0) {
            throw new Exception("NonExistantSeatsException");
        }
    }
    //</editor-fold>
}
