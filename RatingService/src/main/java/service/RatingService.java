/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RatingDao;
import dao.exceptions.NonExistingRatingException;
import dao.exceptions.NonExistingUserException;
import domain.Rating;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Tomt
 */
@Stateless
public class RatingService {
    @Inject
    private RatingDao ratingDao;
    
    @Inject
    private UserService userService;
    
    public List<Rating> getAll(){
        return ratingDao.getAll();
    }
    
    public Rating find(long id){
        return ratingDao.find(id);
    }
    
    public Rating findByMovie(String title){
        return ratingDao.findByMovie(title);
    }
    
    public void likeMovie(String movieTitle, String email) throws NonExistingRatingException, NonExistingUserException{
        Rating rating = ratingDao.findByMovie(movieTitle);
        if (rating == null){
            throw new NonExistingRatingException("Rating does not exist.");
        }
        
        User user = userService.find(email);
        
        if (user == null){
            throw new NonExistingUserException("User does not exist.");
        }
        ratingDao.likeMovie(rating, user);
    }
    
    public void dislikeMovie(String movieTitle, String email) throws NonExistingRatingException, NonExistingUserException{
        Rating rating = ratingDao.findByMovie(movieTitle);
        if (rating == null){
            throw new NonExistingRatingException("Rating does not exist.");
        }
        
        User user = userService.find(email);
        
        if (user == null){
            throw new NonExistingUserException("User does not exist.");
        }
        ratingDao.dislikeMovie(rating, user);
    }
}
