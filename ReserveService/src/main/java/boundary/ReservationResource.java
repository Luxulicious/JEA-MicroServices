/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import com.google.gson.GsonBuilder;
import domain.Screening;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.ReservationService;

/**
 *
 * @author Tomt
 */
@Path("reservations")
@Stateless
public class ReservationResource {

    @Inject
    private ReservationService reservationService;
    private final GsonBuilder gson = new GsonBuilder().serializeNulls();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("reserve")
    public Response reserve(ReservationDTO reservationDTO) {
        try {
            reservationService.reserve(reservationDTO.screeningId, reservationDTO.seatNumbers, reservationDTO.reservedBy);
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.create().toJson(ex.getMessage())).build();
        }
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("markAsPayed")
    public Response markAsPayed(ReservationDTO reservationDTO) {
        try {
            reservationService.markAsPayed(reservationDTO.screeningId, reservationDTO.seatNumbers);
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.create().toJson(ex.getMessage())).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllScreenings")
    public Response getAllScreenings() {
        List<ScreeningDTO> entity = new ArrayList<>();
        List<Screening> screenings = reservationService.getAllScreenings();
        for (Screening screening : screenings) {
            entity.add(new ScreeningDTO(screening));
        }
        return Response.ok(gson.create().toJson(entity)).build();
    }
}
