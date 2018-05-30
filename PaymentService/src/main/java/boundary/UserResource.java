/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import com.google.gson.GsonBuilder;
import domain.User;
import domain.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.UserService;
import service.exceptions.InvalidEmailException;
import service.exceptions.InvalidNameException;
import service.exceptions.NonExistingTicketException;

/**
 *
 * @author Tomt
 */
@Path("users")
@Stateless
public class UserResource {

    @Inject
    private UserService userService;
    private final GsonBuilder gson = new GsonBuilder().serializeNulls();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{email}")
    public Response getUser(@PathParam("email") String email) {
        return Response.ok(gson.create().toJson(new UserDTO(userService.find(email)))).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<UserDTO> users = new ArrayList<>();
        for(int i=0; i < userService.getAll().size(); i++){
            users.add(new UserDTO(userService.getAll().get(i)));
        }
        return Response.ok(gson.create().toJson(users)).build();
    }
    
    @GET
    @Path("mail/{email}/{name}/{id}")
    public Response sendEmail(@PathParam("email")String email, @PathParam("name")String name, @PathParam("id") long id){
        try {
            userService.sendEmail(email, name, id);
        } catch (InvalidEmailException | InvalidNameException | NonExistingTicketException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.create().toJson(ex.getMessage())).build();
        }
        return Response.ok(gson.create().toJson("Email sent.")).build();
    }
}
