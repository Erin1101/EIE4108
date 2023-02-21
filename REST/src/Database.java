import java.util.Hashtable;

import javax.ws.rs.Path;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/mark")
public class Database {
	private Hashtable<String, Integer> table = new Hashtable<String, Integer>();

	public String addRecord() {
// Add a record using id as key and mark as value
		return null;
	}

	public String getMark() {
// Retrieve a record using id as key
		return null;
	}

	public String updateRecord() {
// Update a record using id as key and mark as value
		return null;
	}
}
