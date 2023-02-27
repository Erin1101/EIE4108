import java.util.Hashtable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/mark")
public class Database {
	private Hashtable<String, Integer> table = new Hashtable<String, Integer>();

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addRecord(@FormParam("id") String id, @FormParam("mark") int mark) {
		// Add a record using id as key and mark as value
		table.put(id, mark);
		return "Record added successfully";
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMark(@PathParam("id") String id) {
		// Retrieve a record using id as key
		Integer mark = table.get(id);
		if (mark == null) {
			return "Record not found";
		} else {
			return Integer.toString(mark);
		}
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateRecord(@FormParam("id") String id, @FormParam("mark") int mark) {
		// Update a record using id as key and mark as value
		if (table.containsKey(id)) {
			table.put(id, mark);
			return "Record updated successfully";
		} else {
			return "Record not found";
		}
	}
