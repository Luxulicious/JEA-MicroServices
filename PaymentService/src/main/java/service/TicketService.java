/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TicketDao;
import domain.Ticket;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Tomt
 */
@Stateless
public class TicketService {
    @Inject
    private TicketDao ticketDao;
    
    public List<Ticket> getAll(){
        return ticketDao.getAll();
    }
    
    public Ticket find(long id){
        return ticketDao.find(id);
    }
}
