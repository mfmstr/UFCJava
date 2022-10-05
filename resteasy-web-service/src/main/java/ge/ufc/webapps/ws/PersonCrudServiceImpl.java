package ge.ufc.webapps.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ge.ufc.webapps.model.Person;
import ge.ufc.webapps.model.Persons;

public class PersonCrudServiceImpl implements PersonCrudService {

    private Map<String, Person> inventory = new HashMap<>();

    public PersonCrudServiceImpl() {
        inventory.put("1", new Person("1", "Giorgi", "Kharebava", 25));
        inventory.put("2", new Person("2", "Cotne", "Aburjania", 25));
        inventory.put("3", new Person("3", "Levan", "Nacvlishvili", 25));
        inventory.put("4", new Person("4", "Giorgi", "Kacadze", 25));
        inventory.put("5", new Person("5", "Saba", "Artkmeladze", 25));
        inventory.put("6", new Person("6", "Kotiko", "Cxadadze", 20));
    }

    @Override
    public Response personById(String id) {
        if (inventory.containsKey(id)) {
            return Response.status(Status.OK).entity(inventory.get(id)).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @Override
    public Persons listPersons() {
        Persons ps = new Persons();
        ps.setPersons(inventory.values().stream().collect(Collectors.toCollection(ArrayList::new)));

        return ps;
    }

    @Override
    public Response addPerson(Person p) {
        if (null != inventory.get(p.getId())) {
            return Response.status(Response.Status.CONFLICT).entity("Person is Already in the database.").build();
        }

        inventory.put(p.getId(), p);

        Persons ps = new Persons();
        ps.setPersons(inventory.values().stream().collect(Collectors.toCollection(ArrayList::new)));

        return Response.status(Response.Status.CREATED).entity(ps).build();
    }

    @Override
    public Response updatePerson(Person p) {
        if (null == inventory.get(p.getId())) {
            return Response.status(Response.Status.NOT_FOUND).entity("Person is not in the database.\nUnable to Update")
                    .build();
        }

        inventory.put(p.getId(), p);

        Persons ps = new Persons();
        ps.setPersons(inventory.values().stream().collect(Collectors.toCollection(ArrayList::new)));

        return Response.status(Response.Status.OK).entity(ps).build();
    }

    @Override
    public Response deletePerson(@QueryParam("id") String id) {
        if (null == inventory.get(id)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Person is not in the database.\nUnable to Delete")
                    .build();
        }

        inventory.remove(id);

        Persons ps = new Persons();
        ps.setPersons(inventory.values().stream().collect(Collectors.toCollection(ArrayList::new)));

        return Response.status(Response.Status.OK).entity(ps).build();
    }

}
