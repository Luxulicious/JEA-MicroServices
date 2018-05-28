/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.MovieDao;
import dao.RatingDao;
import dao.UserDao;
import domain.Movie;
import domain.Rating;
import domain.User;
import java.util.ArrayList;
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
    private MovieDao movieDao;

    @Inject
    private RatingDao ratingDao;

    @Inject
    private UserDao userDao;

    @PostConstruct
    public void init() {
        User user1 = new User("tomr@gmail.com", "Tom Roelofs", new ArrayList());
        User user2 = new User("rtom@email.com", "Tom Ruijs", new ArrayList());
        User user3 = new User("fred@hotmail.com","Fred Thread", new ArrayList());
        
        Rating rating1 = new Rating(new ArrayList(), 1010);
        Rating rating2 = new Rating(new ArrayList(), 1000);
        Rating rating3 = new Rating(new ArrayList(), 50);
        
        Movie movie1 = new Movie("The Shawshank Redemption", rating1);
        Movie movie2 = new Movie("Avengers: Infinity War", rating2);
        Movie movie3 = new Movie("Fight Club", rating3);
        
        rating1.setMovie(movie1);
        rating2.setMovie(movie2);
        rating3.setMovie(movie3);
        
        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
        
        ratingDao.save(rating1);
        ratingDao.save(rating2);
        ratingDao.save(rating3);
        
        movieDao.save(movie1);
        movieDao.save(movie2);
        movieDao.save(movie3);
        
        ratingDao.likeMovie(rating1, user1);
        ratingDao.likeMovie(rating2, user2);
        ratingDao.likeMovie(rating3, user3);
    }
}
