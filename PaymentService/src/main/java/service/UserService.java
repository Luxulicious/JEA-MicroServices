/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import domain.Ticket;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import service.exceptions.InvalidEmailException;
import service.exceptions.InvalidNameException;
import service.exceptions.NonExistingTicketException;

/**
 *
 * @author Tomt
 */
@Stateless
public class UserService {
    @Inject
    private UserDao userDao;
    
    @Inject
    private TicketService ticketService;
    
    public List<User> getAll(){
        return userDao.getAll();
    }
    
    public User find(String email){
        return userDao.find(email);
    }
    
    public void sendEmail(String email, String name, long id) throws InvalidEmailException, InvalidNameException, NonExistingTicketException{
        if(email == null || email.isEmpty()){
            throw new InvalidEmailException("Invalid email.");
        }
        if(name == null || name.isEmpty()){
            throw new InvalidNameException("Invalid name.");
        }
        Ticket ticket = ticketService.find(id);
        if(ticket == null){
            throw new NonExistingTicketException("Ticket was not found.");
        }
        
        userDao.sendEmail(email, name, ticket);
    }
}
