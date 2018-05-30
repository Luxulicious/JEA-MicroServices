/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Ticket;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tomt
 */
@Stateless
public class TicketDao {
    @PersistenceContext
    private EntityManager em;
    
    public List<Ticket> getAll() {
        List<Ticket> tickets = em.createNamedQuery("Ticket.getAll").getResultList();
        return tickets;
    }

    public void save(Ticket ticket) {
        em.persist(ticket);
    }

    public void update(Ticket ticket) {
        em.merge(ticket);
    }

    public Ticket find(long id) {
        Query query = em.createNamedQuery("Ticket.find");
        return (Ticket) query.setParameter("id", id).getSingleResult();
    }
}
