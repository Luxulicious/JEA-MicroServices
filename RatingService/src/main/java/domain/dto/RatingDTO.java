/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.dto;

import domain.Rating;
import domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomt
 */
public class RatingDTO {
    public String movieTitle;
    public int currentRating;
    public List<UserDTO> ratedBy = new ArrayList<>();

    public RatingDTO(Rating rating) {
        this.movieTitle = rating.getMovie().getTitle();
        this.currentRating = rating.getCurrentRank();
        for (User u: rating.getRatedBy()){
            this.ratedBy.add(new UserDTO(u));
        }
    }
}
