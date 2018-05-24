/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Rating;
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
public class RatingDao {

    @PersistenceContext
    private EntityManager em;

    public List<Rating> getAll() {
        List<Rating> ratings = em.createNamedQuery("Rating.getAll").getResultList();
        return ratings;
    }

    public void save(Rating rating) {
        em.persist(rating);
    }

    public void update(Rating rating) {
        em.merge(rating);
    }

    public Rating find(long id) {
        Query query = em.createNamedQuery("Rating.find");
        return (Rating) query.setParameter("id", id).getSingleResult();
    }
}
