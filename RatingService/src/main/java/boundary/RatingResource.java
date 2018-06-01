/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import com.google.gson.GsonBuilder;
import dao.exceptions.NonExistingRatingException;
import dao.exceptions.NonExistingUserException;
import domain.Rating;
import domain.dto.NewRatingDTO;
import domain.dto.RatingDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.RatingService;

/**
 *
 * @author Tomt
 */
@Path("ratings")
@Stateless
public class RatingResource {
    @Inject
    private RatingService ratingService;
    private final GsonBuilder gson = new GsonBuilder().serializeNulls();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getRating(@PathParam("id")long id){
        return Response.ok(gson.create().toJson(new RatingDTO(ratingService.find(id)))).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRatings(){
        List<RatingDTO> ratings = new ArrayList<>();
        for(Rating r : ratingService.getAll()){
            ratings.add(new RatingDTO(r));
        }
        return Response.ok(gson.create().toJson(ratings)).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("like")
    public Response likeMovie(NewRatingDTO newRatingDTO){
        try{
            ratingService.likeMovie(newRatingDTO.movieTitle, newRatingDTO.email);
        } catch (NonExistingRatingException | NonExistingUserException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.create().toJson(ex.getMessage())).build();
        }
        return Response.ok(gson.create().toJson("Movie rated")).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("dislike")
    public Response dislikeMovie(NewRatingDTO newRatingDTO){
        try{
            ratingService.dislikeMovie(newRatingDTO.movieTitle, newRatingDTO.email);
        } catch (NonExistingRatingException | NonExistingUserException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.create().toJson(ex.getMessage())).build();
        }
        return Response.ok(gson.create().toJson("Movie rated")).build();
    }
}
