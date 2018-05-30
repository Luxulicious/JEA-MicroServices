/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.TicketDao;
import dao.UserDao;
import domain.Ticket;
import domain.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Tomt
 */
@Startup
@Singleton
public class init {

    @Inject
    private UserDao userDao;
    @Inject
    private TicketDao ticketDao;

    @PostConstruct
    public void init() {
        User user1 = new User("tomr@gmail.com", "Tom Roelofs", new ArrayList());
        User user2 = new User("rtom@email.com", "Tom Ruijs", new ArrayList());
        User user3 = new User("fred@hotmail.com", "Fred Thread", new ArrayList());
        
        Ticket ticket1 = new Ticket("The Shawshank Redemption", new Date(), new Date(), new ArrayList(), user1);
        Ticket ticket2 = new Ticket("Avengers: Infinity War", new Date(), new Date(), new ArrayList(), user2);
        Ticket ticket3 = new Ticket("Fight Club", new Date(), new Date(), new ArrayList(), user3);

//        user1.getTickets().add(ticket1);
//        user2.getTickets().add(ticket2);
//        user3.getTickets().add(ticket3);
        
        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
        
        ticketDao.save(ticket1);
        ticketDao.save(ticket2);
        ticketDao.save(ticket3);
    }
}
