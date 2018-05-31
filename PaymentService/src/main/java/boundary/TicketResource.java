/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import com.google.gson.GsonBuilder;
import domain.dto.TicketDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.TicketService;

/**
 *
 * @author Tomt
 */
@Path("tickets")
@Stateless
public class TicketResource {

    @Inject
    private TicketService ticketService;
    private final GsonBuilder gson = new GsonBuilder().serializeNulls();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<TicketDTO> tickets = new ArrayList<>();
        for (int i = 0; i < ticketService.getAll().size(); i++) {
            tickets.add(new TicketDTO(ticketService.getAll().get(i)));
        }
        return Response.ok(gson.create().toJson(tickets)).build();
    }
}
