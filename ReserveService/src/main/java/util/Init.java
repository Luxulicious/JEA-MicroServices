/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.ReservationDAO;
import domain.Screening;
import domain.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
@Startup
@Singleton
public class Init {

    @Inject
    ReservationDAO reservationDAO;

    @PostConstruct
    public void init() {
        Screening screeningA = new Screening();
        screeningA.setEndTime(new Date(2018, 9, 12, 23, 50));
        screeningA.setStartTime(new Date(2018, 9, 12, 21, 15));
        screeningA.setMovieTitle("Tom²... in space!");
        screeningA.setPrice(12.99);
        reservationDAO.createScreening(screeningA);
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            seats.add(new Seat(screeningA, false, null, false, i));
        }
        screeningA.setSeats(seats);
        reservationDAO.updateScreening(screeningA);
    }
}
