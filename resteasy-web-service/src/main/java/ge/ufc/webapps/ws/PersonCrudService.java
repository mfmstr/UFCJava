package ge.ufc.webapps.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ge.ufc.webapps.model.Person;
import ge.ufc.webapps.model.Persons;

@Path("/persons")
public interface PersonCrudService {

    @GET
    @Path("/getperson")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response personById(@QueryParam("id") String id);

    @GET
    @Path("/listpersons")
    @Produces({ "application/json", "application/xml" })
    Persons listPersons();

    @POST
    @Path("/addperson")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response addPerson(Person p);

    @PUT
    @Path("/updateperson")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response updatePerson(Person p);

    @DELETE
    @Path("/deleteperson")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response deletePerson(@QueryParam("id") String id);
}
