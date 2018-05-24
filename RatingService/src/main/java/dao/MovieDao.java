/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Movie;
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
public class MovieDao {

    @PersistenceContext
    private EntityManager em;
    
    public List<Movie> getAll(){
        List<Movie> movies = em.createNamedQuery("Movie.getAll").getResultList();
        return movies;
    }
    
    public void save(Movie movie){
        em.persist(movie);
    }
    
    public void update(Movie movie){
        em.merge(movie);
    }
    
    public Movie find(String title){
        Query query = em.createNamedQuery("Movie.find");
        return (Movie) query.setParameter("title", title).getSingleResult();
    }
}
