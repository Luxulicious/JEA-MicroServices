/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import com.google.gson.GsonBuilder;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
        return Response.ok(gson.create().toJson(ratingService.find(id))).build();
    }
}
