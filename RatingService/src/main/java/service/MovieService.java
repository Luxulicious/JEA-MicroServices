/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MovieDao;
import domain.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Tomt
 */
@Stateless
public class MovieService {
    @Inject
    private MovieDao movieDao;
    
    public List<Movie> getAll(){
        return movieDao.getAll();
    }
    
    public Movie find(String title){
        return movieDao.find(title);
    }
}
