/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
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
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        List<User> users = em.createNamedQuery("User.getAll").getResultList();
        return users;
    }

    public void save(User user) {
        em.persist(user);
    }

    public void update(User user) {
        em.merge(user);
    }

    public User find(String email) {
        Query query = em.createNamedQuery("User.find");
        return (User) query.setParameter("email", email).getSingleResult();
    }
    
    public void sendEmail(String email, String name){
        
    }
}
