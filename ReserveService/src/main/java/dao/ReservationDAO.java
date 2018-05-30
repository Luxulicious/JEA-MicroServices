/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Screening;
import domain.Seat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
@Stateless
public class ReservationDAO {

    @PersistenceContext
    EntityManager em;

    public void createScreening(Screening screening) {
        em.persist(screening);
    }

    public void updateScreening(Screening screeningA) {
        em.merge(screeningA);
    }

    public Screening getScreening(Long screeningId) {
        return em.find(Screening.class, screeningId);
    }

    public List<Seat> getScreeningSeats(Long screeningId) {
        Screening screening = em.find(Screening.class, screeningId);
        return screening.getSeats();
    }

    public void markAsPayed(Long screeningId, List<Integer> seatNumbers) {
        Screening screening = em.find(Screening.class, screeningId);
        List<Seat> seats = screening.getSeats();
        for (int i = 0; i < seats.size(); i++) {
            for (int j = 0; j < seatNumbers.size(); j++) {
                if (seats.get(i).getSeatNumber() == seatNumbers.get(j)) {
                    seats.get(i).setPayed(true);
                }
            }
        }
        screening.setSeats(seats);
        em.merge(screening);
    }

    public void reserve(Long screeningId, List<Integer> seatNumbers, String reservedBy) {
        Screening screening = em.find(Screening.class, screeningId);
        List<Seat> seats = screening.getSeats();
        for (int i = 0; i < seats.size(); i++) {
            for (int j = 0; j < seatNumbers.size(); j++) {
                if (seats.get(i).getSeatNumber() == seatNumbers.get(j)) {
                    seats.get(i).setReserved(true);
                    seats.get(i).setReservedBy(reservedBy);
                }
            }
        }
        screening.setSeats(seats);
        em.merge(screening);
    }

}
